public class Board {

    public static final int SIZE = 4;
    public static final int WIN_STREAK = 3;
    private Mark winner = Mark.BLANK;
    private boolean gameEnded = false;
    private int boarSize;
    private Mark[][] board;

    /**
     *
     */
    public Board(){
        this.board = new Mark[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                this.board[row][col] = Mark.BLANK;
            }
        }
        this.boarSize = SIZE*SIZE;
    }

    /**
     *
     * @param mark
     * @param row
     * @param col
     * @return
     */
    public boolean putMark(Mark mark, int row, int col){
        if (!legalRequests(row,col)){
            return false;
        }
        if(this.board[row][col] != Mark.BLANK){
            return false;
        }
        this.board[row][col] = mark;
        this.boarSize--;
        if(gameStatus(row,col,this.board)){
            this.gameEnded =true;
            this.winner = this.board[row][col];
        }
        return true;
    }

    /**\
     *
     * @param row
     * @param col
     * @return
     */
    public Mark getMark(int row, int col){
        if (!legalRequests(row,col)){
            return Mark.BLANK;
        }
        return this.board[row][col];
    }

    /**
     *
     * @return
     */
    public boolean gameEnded(){
        if(this.boarSize == 0){
            this.gameEnded = true;
        }
        return this.gameEnded;
    }


    /**
     *
     * @return
     */
    public Mark getWinner(){
        return this.winner;
    }


    /**
     *
     * @param row
     * @param col
     * @param board
     * @return
     */
    private boolean gameStatus(int row, int col, Mark[][] board){
        for (int i = 1; i < WIN_STREAK; i++) {
            if(checkingBoard(row, col, 0, i, board)){
                if(i == WIN_STREAK - 1){
                    return true;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < WIN_STREAK; i++) {
            if(checkingBoard(row, col, 0, -i, board)){
                if(i == WIN_STREAK - 1){
                    return true;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < WIN_STREAK; i++) {
            if(checkingBoard(row, col, i, 0, board)){
                if(i == WIN_STREAK - 1){
                    return true;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < WIN_STREAK; i++) {
            if(checkingBoard(row, col, -i, 0, board)){
                if(i == WIN_STREAK - 1){
                    return true;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < WIN_STREAK; i++) {
            if(checkingBoard(row, col, i, i, board)){
                if(i == WIN_STREAK - 1){
                    return true;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < WIN_STREAK; i++) {
            if(checkingBoard(row, col, -i, i, board)){
                if(i == WIN_STREAK - 1){
                    return true;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < WIN_STREAK; i++) {
            if(checkingBoard(row, col, i, -i, board)){
                if(i == WIN_STREAK - 1){
                    return true;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < WIN_STREAK; i++) {
            if(checkingBoard(row, col, -i, -i, board)){
                if(i == WIN_STREAK - 1){
                    return true;
                }
            }else {
                break;
            }
        }
        return false;
    }


    /**
     *
     * @param row
     * @param col
     * @return
     */
    private boolean legalRequests(int row, int col){
        if (row >= SIZE || col >= SIZE || row < 0 || col < 0){
            return false;
        }
        return true;
    }


    /**
     *
     * @param row
     * @param col
     * @param addToRow
     * @param addToCol
     * @param board
     * @return
     */
    private boolean checkingBoard(int row, int col,int addToRow, int addToCol, Mark[][] board){
        return (legalRequests(row + addToRow, col + addToCol) && board[row][col]==board[row + addToRow][col + addToCol]);
    }


}
