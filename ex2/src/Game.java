

import java.util.Random;
public class Game {
    private Renderer renderer;
    private Player PlayerX;
    private Player PlayerY;
    private Board board;
    public Game(Player playerX, Player playerO, Renderer renderer){
        this.board = new Board();
        this.PlayerX = playerX;
        this.PlayerY = playerO;
        this.renderer = renderer;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        Player player1 = new Player();
        Player player2 = new Player();
        Renderer renderer = new Renderer();
        Game game = new Game(player1, player2, renderer);
        game.run();
    }

    /**
     *
     * @return
     */
    public Mark run(){
        renderer.renderBoard(board);
        Mark playerO = Mark.O, playerX = Mark.X;
        Random rnd = new Random();
        boolean check = rnd.nextBoolean();
        while (!board.gameEnded()){
            if(check){
                PlayerX.playTurn(board, playerX);
            }else {
                PlayerY.playTurn(board, playerO);
            }
            renderer.renderBoard(board);
            check = !check;
        }
        System.out.println("congratulation player " + board.getWinner() + " won");
        return board.getWinner();
    }

}
