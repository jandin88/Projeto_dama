package ladygame;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class LadyPiece extends Piece{
    private final Color color;

    
    public LadyPiece(Board board,Color color) {
        super(board);
        this.color= color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position){
        LadyPiece p=(LadyPiece) getBoard().piece(position);
        return p!=null && p.getColor()!=color;
    }
}