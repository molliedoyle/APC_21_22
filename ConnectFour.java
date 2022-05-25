public class ConnectFour implements BoardGame{

    private int[][] board; // game board for playing ConnectFour
    private int currentPlayer; // stores the current player's turn
    private Position[] winningPositions; //stores row+colum coordinates when someone wins
    private int winner; // stores which player wins (0 == draw)

    public ConnectFour() {
        newGame();
    }

    @Override
    public void newGame() {
        board = new int[6][7];
        /*for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }*/
        winningPositions = new Position[4];
        /*for(int i = 0; i < winningPositions.length; i++){
            System.out.print(winningPositions);*/
        currentPlayer = 1 + (int)(Math.random()*2);
        winner = -1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public boolean gameOver() {
        for(int r = 5; r >= 0; r--) {
            for(int c = 0; c <= 3; c++) {
                if (board[r][c] != 0 && board[r][c] == board[r][c + 1] && board[r][c + 1] == board[r][c + 2] && board[r][c + 2] == board[r][c + 3]) {
                    for(int i = 0; i < 4; i++)
                        winningPositions[i] = new Position(r,c+i);
                    //winningPositions[1] = new Position(r,c+1);
                    //winningPositions[2] = new Position(r,c+2);
                    //winningPositions[3] = new Position(r,c+3);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        for(int r = 5; r >= 3; r--) {
            for(int c = 0; c <= 6; c++) {
                if (board[r][c] != 0 && board[r][c] == board[r-1][c] && board[r-1][c] == board[r-2][c] && board[r-2][c] == board[r-3][c]) {
                    for(int i = 0; i < 4; i++)
                        winningPositions[i] = new Position(r-i, c);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        for(int r = 5; r >= 3; r--) {
            for(int c = 0; c <= 3; c++) {
                if (board[r][c] != 0 && board[r][c] == board[r-1][c+1] && board[r][c] == board[r-2][c+2] && board[r][c] == board[r-3][c+3]) {
                    for(int i = 0; i < 4; i++)
                        winningPositions[i] = new Position(r-i, c+i);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        for(int r = 2; r > 0; r--) {
            for(int c = 4; c < 6; c++) {
                if (board[r][c] != 0 && board[r][c] == board[r-1][c-1] && board[r][c]
                        == board[r-2][c-2] && board[r][c] == board[r-3][c-3]) {
                    for(int i = 0; i < 4; i++)
                        winningPositions[i] = new Position(r-i, c-i);
                    winner = board[r][c];
                    return true;
                }
            }
        }

        for(int r = 2; r > 0; r--) {
            for(int c = 3; c < 6; c++) {
                if (board[r][c] != 0 && board[r][c] == board[r+1][c-1] && board[r+1][c-1] == board[r+2][c-2] && board[r+2][c-2] == board[r+3][c-3]) {
                    for(int i = 0; i < 4; i++)
                        winningPositions[i] = new Position(r+i, c-i);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        for(int r = 5; r >= 3; r--) {
            for(int c = 3; c <= 6; c++) {
                if (board[r][c] != 0 && board[r][c] == board[r-1][c-1] &&
                        board[r][c] == board[r-2][c-2] && board[r][c] == board[r-3][c-3]) {
                    for(int i = 0; i < 4; i++)
                        winningPositions[i] = new Position(r-i, c-i);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        return false;
        //if(board[5][0] != 0 && board[5][0] == board[5][0] && board[5][1] == board[5][2] )
    }

    @Override
    public int getWinner() {
        return winner;
    }

    @Override
    public Position[] getWinningPositions() {
        return winningPositions;
    }

    @Override
    public boolean columnFull(int column) {

        for(int r = 0; r < board.length; r++){
            if(board[r][column] == 0)
                return false;}
        return true;
    }

    @Override
    public void play(int column) {
        if(!columnFull(column)) {
            for(int r = 5; r >= 0; r--) {
                if(board[r][column] == 0) {
                    board[r][column] = currentPlayer;
                    break;
                }
            }
        }
        currentPlayer = (currentPlayer ==1) ? 2 : 1;
    }

    @Override
    public int[][] getBoard() {
        return board;
    }
}
