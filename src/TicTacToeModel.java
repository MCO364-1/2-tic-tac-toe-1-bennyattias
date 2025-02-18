public class TicTacToeModel {
    enum Players {X, O, __}
    Players[][] board;
    Players[] currentPlayer;
    int movesMade;

    TicTacToeModel() {
        board = new Players[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Players.__;
            }
        }
        currentPlayer = new Players[1];
        currentPlayer[0] = Players.X;
    }

    public boolean spotIsEmpty(int row, int col) {
        return board[row][col] == Players.__;
    }

    public void storeMove(int row, int col) {
        movesMade++;
        board[row][col] = getCurrentPlayer();
    }

    public Players getCurrentPlayer() {
        return currentPlayer[0];
    }

    public void changeCurrentPlayer() {
        if (currentPlayer[0] == Players.X) {
            currentPlayer[0] = Players.O;
        }
        else {
            currentPlayer[0] = Players.X;
        }
    }

    public boolean isGameOver() {
        boolean gameOver = false;
        //checks for three consecutive values on rows, columns, and diagonals, and for a full board in case of a tie
        for (int i = 0; i < 3; i++) {
            if ( board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != Players.__||
                 board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != Players.__||
                 board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != Players.__||
                 board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != Players.__||
                 movesMade == 9) {
                gameOver = true;
            }
        }
        return gameOver;
        }

        public boolean isATie() {
        boolean isAtie = true;
        for (int i = 0; i < 3; i++) {
                if ( board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != Players.__||
                     board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != Players.__||
                     board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != Players.__||
                     board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != Players.__) {
                    isAtie = false;
                }
            }
            return isAtie;
        }

        public void newGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Players.__;
            }
        }
        movesMade = 0;
        currentPlayer[0] = Players.X;
        }
}

