package ladygame;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import boardgame.exception.BordGamesExeception;
import ladygame.Piece.RockSimple;

public class LadyTable {
    private int turn;
    private final Board board;
    private Color currentPlayer;

    public LadyTable() {
        this.board=new Board(8, 8);
        this.turn = 1;
        this.currentPlayer=Color.WHITE;
        initialGame();
    }
    public boolean[][]possibleMoves(LadyPosition sourcePosition){
        Position position=sourcePosition.toPosition();
        validadeSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public LadyPiece perform(LadyPosition sourcePosition, LadyPosition targetPosition){
        Position source=sourcePosition.toPosition();
        Position target=targetPosition.toPosition();
        validadeSourcePosition(source);
        validateTargetPosition(source,target);
        Piece capturedPiece=makeMove(source,target);
        return (LadyPiece) capturedPiece;
    }
    private Piece makeMove(Position source, Position target){
        Piece p= board.removePiece(source);
        Piece capturedPiece=board.removePiece(target);
        board.placePiece(p,target);
        return capturedPiece;
    }

    private void validadeSourcePosition(Position position){
        if(!board.thereIsPiece(position)){
            throw new BordGamesExeception("source position invalid");
        }
        if(!board.piece(position).isThereAnyPossibleMoves()){
            throw  new BordGamesExeception("there is impossible movement in piece");
        }
    }
    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMoves(target)){
            throw new BordGamesExeception("the chosen piece can't move to target position");
        }
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
    private void placeNewPiece(char columns, int rows, LadyPiece piece){
        board.placePiece(piece,new LadyPosition(columns,rows).toPosition());
    }

    public void initialGame(){
        for(int i=1;i<=board.getRows();i++){
            for(int j=0;j<board.getColumns();j++){
                if((i+j)%2==0){
                    if(i<=3){
                        placeNewPiece((char) ('a'+j),i,new RockSimple(board,Color.WHITE));
                    }
                    if(i>5){
                        placeNewPiece((char) ('a'+j),i,new RockSimple(board,Color.BLACK));
                    }
                }
            }
        }
    }


}
