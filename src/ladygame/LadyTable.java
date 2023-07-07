package ladygame;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

import java.util.ArrayList;
import java.util.List;

public class LadyTable {
    private int turn;
    private Board board;
    private Color currentPlayer;

    public LadyTable() {
        this.board=new Board(8, 8);
        this.turn = 1;
        this.currentPlayer=Color.WHITE;
    }

    public LadyPiece[][] getPiece(){
        LadyPiece[][] mat= new LadyPiece[board.getRows()][board.getColumns()];
        for(int i=0;i<board.getRows();i++){
            for(int j=0;j< board.getColumns();j++){
                mat[i][j]=(LadyPiece) board.piece(i,j);
            }
        }
        return mat;
    }
    private List<Piece> pieceWhite= new ArrayList<>();
    private List<Piece> pieceBlack= new ArrayList<>();
    public void initialGame(){
        for(int i=0;i< board.getRows();i++){
            for(int j=0;j< board.getColumns();j++){
                if(j%2==0){
                    pieceWhite.add("0")
                    if(board.getRows()<=3){

                        board.placePiece(new Piece(pieceWhite,new Position(i,j));
                    }
                }
            }
        }
    }
}
