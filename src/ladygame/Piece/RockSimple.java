package ladygame;

import boardgame.Board;

public class RockSimple extends LadyPiece{
    public RockSimple(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString(){
        return "0";
    }
}
