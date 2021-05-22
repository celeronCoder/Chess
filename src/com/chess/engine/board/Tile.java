package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
// TODO: Video 3 of the [series](https://www.youtube.com/playlist?list=PLOJzCFLZdG4zk5d-1_ah2B4kqZSeIlWtt)
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

// Tile class can't be instantiated but it's child classes can.
public abstract class Tile {
	// protected so that it can only be accessed by subClasses
	// final so that can only be declared once;
	protected final int  tileCoordinate;
	private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles();

	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

		for (int i = 0; i < 64; i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}

		return ImmutableMap.copyOf(emptyTileMap);
	}


	// constructor
	private Tile(int tileCoordinate) {
		this.tileCoordinate = tileCoordinate;
	}

	public static Tile createTile(final int tileCoordinate, final Piece piece) {
		return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES.get(tileCoordinate);
	}
	public abstract boolean isTileOccupied();
	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {
		EmptyTile(int coordinate) {
			super(coordinate);
		}

		@Override
		public boolean isTileOccupied() {
			return false;
		}

		@Override
		public Piece getPiece() {
			return null;
		}
	}

	public static final class OccupiedTile extends Tile {
		private final Piece pieceOnTile;

		OccupiedTile(int coordinate, Piece pieceOnTile) {
			super(coordinate);
			this.pieceOnTile = pieceOnTile;
		}

		@Override
		public boolean isTileOccupied() {
			return true;
		}

		@Override
		public Piece getPiece() {
			return this.pieceOnTile;
		}
	}
}
