package com.chess.engine.board;

public class BoardUtils {
	private static boolean[] initColumn(int columnNumber) {
		final boolean[] column = new boolean[NUMBER_OF_TILES];
		do {
			column[columnNumber] = true;
			columnNumber += 8;
		} while (columnNumber<NUMBER_OF_TILES);
		return column;
	}

	public static final boolean[] FIRST_COLUMN = initColumn(0);
	public static final boolean[] SECOND_COLUMN = initColumn(1);
	public static final boolean[] SEVENTH_COLUMN = initColumn(6);
	public static final boolean[] EIGHTH_COLUMN = initColumn(7);

	// TODO define a method to initRow with Row number
	public static final boolean[] SECOND_ROW = null;
	public static final boolean[] SEVENTH_ROW = null;

	public static final int NUMBER_OF_TILES = 64;
	public static final int NUMBER_OF_TILES_IN_ROW = 8;

	private BoardUtils() throws RuntimeException {
		throw new RuntimeException("You can't instantiate it.");
	}

	public static boolean isValidTileCoordinate(int coordinate) {
		return coordinate >= 0 && coordinate < NUMBER_OF_TILES;
	}
}
