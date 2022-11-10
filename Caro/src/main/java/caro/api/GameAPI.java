package caro.api;

import caro.Model.Board;
import caro.Model.Game;
import caro.Model.Minimax;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameAPI {
    Board board = new Board();
    Minimax AI = new Minimax(board);
    Game game = new Game(board,AI,1);
    @PostMapping("/move")
    public int[] receiveMove(@RequestParam("x") int x,@RequestParam("y") int y){
        int[] move = new int[2];
        move[0]=x;
        move[1]=y;
        return move;
    }
}
