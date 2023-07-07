package ladygame;

import boardgame.Board;
import boardgame.Piece;

public class LadyPiece extends Piece{
    private Color color;

    
    public LadyPiece(Board board,Color color) {
        super(board);
        this.color= color;
    }


    public Color getColor() {
        return color;
    }
    

}