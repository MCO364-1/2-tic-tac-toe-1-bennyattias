import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeModelTests {
    TicTacToeModel model = new TicTacToeModel();

    @org.junit.jupiter.api.Test
    void spotIsEmpty() {
        model.board[1][1] = TicTacToeModel.Players.X;

        boolean actual = model.spotIsEmpty(1,1);

        assertFalse(actual);
    }

    @Test
    void storeMove() {
        model.storeMove(1,1);

        TicTacToeModel.Players actual = model.board[1][1];

        assertTrue(actual.equals(TicTacToeModel.Players.X));
    }

    @Test
    void getCurrentPlayer() {
        model.board[1][1] = TicTacToeModel.Players.X;
        TicTacToeModel.Players actual = model.getCurrentPlayer();
        assertTrue(actual.equals(TicTacToeModel.Players.X));
    }

    @Test
    void changeCurrentPlayer() {
        model.changeCurrentPlayer();
        TicTacToeModel.Players actual = model.getCurrentPlayer();
        assertTrue(actual.equals(TicTacToeModel.Players.O));
    }

    @Test
    void isGameOver() {
        model.board[1][1] = TicTacToeModel.Players.X;
        model.board[0][0] = TicTacToeModel.Players.X;
        model.board[2][2] = TicTacToeModel.Players.X;
        boolean actual = model.isGameOver();
        assertTrue(actual);
    }

    @Test
    void isATie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                model.board[i][j] = TicTacToeModel.Players.X;
            }
        }
        model.board[0][0] = TicTacToeModel.Players.O;
        model.board[1][1] = TicTacToeModel.Players.O;
        model.board[2][0] = TicTacToeModel.Players.O;
        model.board[1][2] = TicTacToeModel.Players.O;

        boolean actual = model.isATie();
        assertTrue(actual);
    }

    @Test
    void newGame() {
        model.storeMove(1,1);
        model.storeMove(1,2);

        model.newGame();
        int actual = model.movesMade;
        assertTrue(actual==0);
    }
}