package ladygame.Piece;

import boardgame.Board;
import boardgame.Position;
import ladygame.Color;
import ladygame.LadyPiece;

public class DamaMoves extends LadyPiece {

    private Position pieceCapturedDama;
    public DamaMoves(Board board, Color color) {
        super(board, color);
    }

    public Position getPieceCapturedDama(){
        return pieceCapturedDama;
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat= new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p=new Position(0,0);

        p.setValues(position.getRows()+1,position.getColumns()+1);
        while(getBoard().positionExist(p)&& pieceCurrent(p)){
            if(!getBoard().thereIsPiece(p)) {
                mat[p.getRows()][p.getColumns()] = true;
            }
            if(isThereOpponentPiece(p)){
                if (getBoard().positionExist(p.getRows()+1, p.getColumns()+1)) {
                    if (!getBoard().thereIsPiece(p.getRows() + 1, p.getColumns() + 1)) {
                        mat[p.getRows()+1][p.getColumns()+1] = true;
                        Position position1=new Position(p.getRows(),p.getColumns());
                        pieceCapturedDama=position1;
                        System.out.println(position);
                    } else{
                        break;
                    }
                }
            }
            p.setValues(p.getRows()+1,p.getColumns()+1);
        }

        p.setValues(position.getRows()+1,position.getColumns()-1);
        while(getBoard().positionExist(p)&& pieceCurrent(p)){
            if(!getBoard().thereIsPiece(p)) {
                mat[p.getRows()][p.getColumns()] = true;
            }
            if(isThereOpponentPiece(p)) {
                if (getBoard().positionExist(p.getRows() + 1, p.getColumns() - 1)) {
                    if (!getBoard().thereIsPiece(p.getRows() + 1, p.getColumns() - 1)) {
                        mat[p.getRows()+1][p.getColumns()-1] = true;
                        pieceCapturedDama =position;
                        System.out.print(position);
                        System.out.print(position);
                    } else {
                        break;
                    }
                }
            }
            p.setValues(p.getRows()+1,p.getColumns()-1);
        }

        p.setValues(position.getRows()-1,position.getColumns()+1);
        while(getBoard().positionExist(p)&& pieceCurrent(p)){
            if(!getBoard().thereIsPiece(p)) {
                mat[p.getRows()][p.getColumns()] = true;
            }
            if(isThereOpponentPiece(p)) {
                if (getBoard().positionExist(p.getRows() - 1, p.getColumns() + 1)) {
                    if (!getBoard().thereIsPiece(p.getRows() - 1, p.getColumns() + 1)) {
                        mat[p.getRows()-1][p.getColumns()+1] = true;
                        pieceCapturedDama =position;
                        System.out.print(position);
                    } else {
                        break;
                    }
                }
            }
            p.setValues(p.getRows()-1,p.getColumns()+1);
        }

        p.setValues(position.getRows()-1,position.getColumns()-1);
        while(getBoard().positionExist(p)&& pieceCurrent(p)){

            if(!isThereOpponentPiece(p)) {
                mat[p.getRows()][p.getColumns()] = true;
            }
            else if(getBoard().positionExist(p.getRows()-1, p.getColumns()-1)){
                if(!getBoard().thereIsPiece(p.getRows()-1,p.getColumns()-1)){
                    mat[p.getRows()-1][p.getColumns()-1]=true;
                    pieceCapturedDama =position;
                    System.out.print(position);
                }
                else
                    break;
            }
            p.setValues(p.getRows()-1,p.getColumns()-1);
        }
        return mat;
    }

    @Override
    public String toString(){
        return "D";
    }
}
