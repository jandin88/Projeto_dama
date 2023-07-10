package ladygame.Piece;

import boardgame.Board;
import boardgame.Position;
import ladygame.Color;
import ladygame.LadyPiece;

public class RockSimple extends LadyPiece {
    public RockSimple(Board board, Color color) {
        super(board, color);
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][]mat=new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p=new Position(0,0);
        if(getColor()==Color.WHITE){
            //white sobe o tabuleiro
            //left
            p.setValues(position.getRows()-1,position.getColumns()-1);
            if(getBoard().positionExist(p)&&!getBoard().thereIsPiece(p)){
                mat[p.getRows()][p.getColumns()]=true;
            }
            if(getBoard().positionExist(p)&&isThereOpponentPiece(p)){
                mat[p.getRows()-1][p.getColumns()-1]=true;
            }
            //Right
            p.setValues(position.getRows()-1,position.getColumns()+1);
            if(getBoard().positionExist(p)&& !getBoard().thereIsPiece(p)){
                mat[p.getRows()][p.getColumns()]=true;
            }
            if(getBoard().positionExist(p)&& isThereOpponentPiece(p)){
                mat[p.getRows()-1][p.getColumns()+1]=true;
            }

        }else {
            //os black desce o tabuleiro

            //left
            p.setValues(position.getRows()+1,position.getColumns()-1);
            if(getBoard().positionExist(p)&& !getBoard().thereIsPiece(p)){
                mat[p.getRows()][p.getColumns()]=true;
            }
            if(getBoard().positionExist(p)&& isThereOpponentPiece(p)){
                mat[p.getRows()+1][p.getColumns()-1]=true;
            }
            //Right
            p.setValues(position.getRows()+1,position.getColumns()+1);
            if(getBoard().positionExist(p)&& !getBoard().thereIsPiece(p)){
                mat[p.getRows()][p.getColumns()]=true;
            }
            if(getBoard().positionExist(p)&& isThereOpponentPiece(p)){
                mat[p.getRows()+1][p.getColumns()+1]=true;
            }
        }
        return mat;
    }
    @Override
    public String toString(){
        return "0";
    }
}
