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
        if(thereIsPiece(position)){
            throw new BordGamesExeception("There is no part in position "+position);
        }
        pieces[position.getRows()][position.getColumns()]=piece;
        piece.position=position;
    }
    public boolean positionExist(int row,int column ){
        return row>0&&row<rows&&column>=0&&column<columns;
    }
    public boolean positionExist(Position position){
        return positionExist(position.getRows(),position.getColumns());
    }
    public Piece removePiece(Position position){
        if(!positionExist(position)){
            throw new BordGamesExeception("Position not the board");
        }
        if(!thereIsPiece(position)){
            return  null;
        }
        Piece aux=piece(position);
        aux.position=null;
        pieces[position.getRows()][position.getColumns()]=null;

        return aux;
    }
}
