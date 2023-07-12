package ladygame.Piece;

import boardgame.Board;
import boardgame.Position;
import ladygame.Color;
import ladygame.LadyPiece;

public class DamaMoves extends LadyPiece {

    public DamaMoves(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat= new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p=new Position(0,0);

        p.setValues(getBoard().getRows()+1,getBoard().getColumns()+1);
        while(getBoard().positionExist(p)&&!getBoard().thereIsPiece(p)){
            mat[getBoard().getRows()][getBoard().getColumns()]=true;
            p.setValues(getBoard().getRows()+1,getBoard().getColumns()+1);

        }
        p.setValues(getBoard().getRows()-1,getBoard().getColumns()+1);
        while(getBoard().positionExist(p)&&!getBoard().thereIsPiece(p)){
            mat[getBoard().getRows()][getBoard().getColumns()]=true;
            p.setValues(getBoard().getRows()-1,getBoard().getColumns()+1);

        }
        p.setValues(getBoard().getRows()+1,getBoard().getColumns()-1);
        while(getBoard().positionExist(p)&&!getBoard().thereIsPiece(p)){
            mat[getBoard().getRows()][getBoard().getColumns()]=true;
            p.setValues(getBoard().getRows()+1,getBoard().getColumns()-1);

        }
        p.setValues(getBoard().getRows()-1,getBoard().getColumns()-1);
        while(getBoard().positionExist(p)&&!getBoard().thereIsPiece(p)){
            mat[getBoard().getRows()][getBoard().getColumns()]=true;
            p.setValues(getBoard().getRows()-1,getBoard().getColumns()-1);
        }

        return mat;
    }

    private boolean teste(Position p){
        return (getBoard().thereIsPiece(p)!=isThereOpponentPiece(p))?false:true;
    }

    @Override
    public String toString(){
        return "D";
    }
}
