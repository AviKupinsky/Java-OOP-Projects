import java.util.Scanner;

public class Player {
    public static final int SIZE = 4;

    /**
     *
     * @param board
     * @param mark
     */
    public void playTurn (Board board, Mark mark){
        Scanner scan = new Scanner(System.in);
        System.out.println("give you're first coordinates");
        int rowCoordinate = scan.nextInt()- 1;
        while (!checkingNumber(rowCoordinate)){
            rowCoordinate = scan.nextInt()- 1;
        }
        System.out.println("give you're second coordinates");
        int colCoordinate = scan.nextInt() - 1;
        while (!checkingNumber(colCoordinate)){
            colCoordinate = scan.nextInt()- 1;
        }
        if(!board.putMark(mark,rowCoordinate, colCoordinate)){
            playTurn(board,mark);
        }
    }

    /**\
     *
     *
     * @param Coordinate
     * @return
     */
    private boolean checkingNumber(int Coordinate){
        if(Coordinate >= SIZE || Coordinate < 0){
            System.out.println("you can only give coordination between 1-4, please try again");
            return false;
        }
        return true;
    }
}
