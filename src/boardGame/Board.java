package boardgame;

import boardgame.exception.BordGamesExeception;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;
    
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces=new Piece[rows][columns];
    }
    public Board(){}

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int rows,int columns) {
        return pieces[rows][columns];
    }
    //sobrecarga
    public Piece piece(Position position){
        return pieces[position.getRows()][position.getColumns()];
    }

    //teste se a peça exite
    public boolean thereIsPiece(Position position){
        return piece(position)!=null;
    }

    public void placePiece(Piece piece,Position position){
        if(!thereIsPiece(position)){
            throw new BordGamesExeception("There is no part in position"+position);
        }
        pieces[position.getRows()][position.getColumns()]=piece;
        piece.position=position;
    }
}
