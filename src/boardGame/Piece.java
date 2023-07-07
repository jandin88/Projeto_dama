package boardgame;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    protected Position position;
    public Board board;

    private List<Piece> pieceWhite= new ArrayList<>();
    private List<Piece> pieceBlack= new ArrayList<>();

    public Piece(Board board) {
        this.position =null;
        this.board = board;
    }


    protected Board getBoard(){
        return board;
    }
    
}
