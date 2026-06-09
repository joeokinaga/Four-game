/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author okinagajoe
 */
public class PlayGame {
    private GameBoard board;
    private String currentPlayer;
    private int player1Score, player2Score;

    public PlayGame(int boardSize) {
        board = new GameBoard(boardSize);
        currentPlayer = "RED";
        player1Score = 0;
        player2Score = 0;
    }

    public void makeMove(int row, int col) {
        board.updateTiles(row, col, currentPlayer);
        int scoreIncrement = calculateScore(row, col);
        if (currentPlayer.equals("RED")) {
            player1Score += scoreIncrement;
        } else {
            player2Score += scoreIncrement;
        }
        if (board.isGameEnd()) {
            showWinner();
        } else {
            switchPlayer();
        }
    }

    private int calculateScore(int row, int col) {
        int score = 0;
        if (board.getTile(row, col).isMaxValue()) score++;
        // 他のタイルもチェックしてスコアを加算。
        return score;
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals("RED") ? "BLUE" : "RED";
    }

    private void showWinner() {
        String winner = player1Score > player2Score ? "Player 1 (Red)" : "Player 2 (Blue)";
        javax.swing.JOptionPane.showMessageDialog(null, winner + " wins!");
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public GameBoard getBoard() {
        return board;
    }
}

