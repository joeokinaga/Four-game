/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author okinagajoe
 */
public class GameBoard {
    private Tile[][] tiles;
    private int size;

    public GameBoard(int size) {
        this.size = size;
        tiles = new Tile[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j] = new Tile();
            }
        }
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public int getSize() {
        return size;
    }

    public void updateTiles(int row, int col, String playerColor) {
        incrementTile(row, col, playerColor);
        if (row > 0) incrementTile(row - 1, col, playerColor);
        if (row < size - 1) incrementTile(row + 1, col, playerColor);
        if (col > 0) incrementTile(row, col - 1, playerColor);
        if (col < size - 1) incrementTile(row, col + 1, playerColor);
    }

    private void incrementTile(int row, int col, String playerColor) {
        tiles[row][col].incrementValue(playerColor);
    }

    public boolean isGameEnd() {
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                if (!tile.isMaxValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
