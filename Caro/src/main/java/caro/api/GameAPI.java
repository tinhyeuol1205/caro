package caro.api;

import caro.Model.Board;
import caro.Model.Game;
import caro.Model.Minimax;
import caro.Model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/game")
public class GameAPI {
    HttpSession session;
    Board board = new Board();
    Minimax AI = new Minimax(board);
    Game game = new Game(board,AI,1);
    int[] userMove = new int[2];
    @PostMapping("/move")
    public String userMove(@RequestParam("x") int x,@RequestParam("y") int y){
        userMove[0] = x;
        userMove[1] = y;
        game.getBoard().addMove(board,-1,x,y);
        return "user move "+x+" "+y;
    }
    @GetMapping("/move")
    public int[] aiMove(){
        if(game.getTurn()==1){
            game.getBoard().addMove(board,1,10,10);
            game.setTurn(0);
            int[] move = {10,10};
            return move;
        }
        int[] bestMove = game.getBestMove();
        game.getBoard().addMove(board,1,bestMove[0],bestMove[1]);
        return bestMove;
    }
    @GetMapping("/check")
    public String check(){
        if(game.checkWinner()==1) return "AI win";
        if(game.checkWinner()==-1) return "User win";
        if(game.getBoard().isFull()) return "Draw";
        return "Game isn't over";
    }
}
