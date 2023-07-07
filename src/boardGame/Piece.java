package boardgame;

import ladygame.Color;


public class Piece {
    protected Position position;
    public Board board;
    private Color color;


    public Piece(Board board,Position position,Color color) {
        this.position =position;
        this.board = board;
        this.color=color;
    }

    public Piece(Board board) {
    }


    protected Board getBoard(){
        return board;
    }

    public String toString(){
        return "0";
    }
    
}
