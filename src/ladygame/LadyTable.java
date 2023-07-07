package ladygame;

import boardgame.Board;
import boardgame.Position;

public class LadyTable {
    private int turn;
    private Board board;
    private Color currentPlayer;

    public LadyTable() {
        this.board=new Board(8, 8);
        this.turn = 1;
        this.currentPlayer=Color.WHITE;
        initialGame();
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

    public void initialGame(){
        for(int i=0;i<board.getRows();i++){
            for(int j=0;j<board.getColumns();j++){
                if((i+j)%2==0){
                    if(i<3){
                        board.placePiece(new LadyPiece(board,Color.WHITE),new Position(i,j));
                    }
                    if(i>=5){
                        board.placePiece(new LadyPiece(board,Color.BLACK),new Position(i,j));
                    }
                }
            }
        }
    }
}
