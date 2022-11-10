package caro.Model;
public class Game {
    private Board board;
    private Minimax AI;
    private User user;
    private int turn = 0;
    private long time;
    private int winner = 0;

    public Game(Board board, Minimax AI, int turn) {
        this.board = board;
        this.AI = AI;
        this.user = user;
        this.turn = turn;
    }

    public void firstMoveAI(){
        board.addMove(board,1,10,10);
    }
}
