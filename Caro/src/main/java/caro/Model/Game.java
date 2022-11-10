package caro.Model;
public class Game {
    private Board board;
    private Minimax AI;
    private User user;
    private int turn = 0;
    private long time;
    private int depth = 3;
    private int winner = 0;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Minimax getAI() {
        return AI;
    }

    public void setAI(Minimax AI) {
        this.AI = AI;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public Game(Board board, Minimax AI, int turn) {
        this.board = board;
        this.AI = AI;
        this.turn = turn;
    }
    public int[] getBestMove(){
        return AI.getBestMove(depth,1,false);
    }
    public int checkWinner(){
        if(this.board.checkWin(1)) return 1;
        if(this.board.checkWin(-1)) return -1;
        return 0;
    }
}
