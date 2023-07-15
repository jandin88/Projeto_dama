package ladygame;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import boardgame.exception.BordGamesExeception;
import ladygame.Piece.DamaMoves;
import ladygame.Piece.RockSimple;

public class LadyTable {
    private int turn;
    private final Board board;
    private Color currentPlayer;

    private int countPieceBlack=0;
    private int countPieceWhite=0;

    public int getCountPieceBlack() {
        return countPieceBlack;
    }

    public int getCountPieceWhite() {
        return countPieceWhite;
    }


    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public LadyTable() {
        this.board=new Board(8, 8);
        this.turn = 1;
        this.currentPlayer=Color.WHITE;
        initialGame();
    }
    public boolean[][] possibleMoves(LadyPosition sourcePosition){
        Position position=sourcePosition.toPosition();
        validadeSourcePosition(position);
        return board.piece(position).possibleMoves();
    }
    private void nextTurn(){
        turn++;
        currentPlayer=(currentPlayer==Color.WHITE)?Color.BLACK:Color.WHITE;
    }

    public void perform(LadyPosition sourcePosition, LadyPosition targetPosition){
        Position source=sourcePosition.toPosition();
        Position target=targetPosition.toPosition();
        validadeSourcePosition(source);
        validateTargetPosition(source,target);
        makeMove(source,target);
        LadyPiece movedPiece= (LadyPiece) board.piece(target);
        promotionRockInDama(movedPiece,target);
        nextTurn();
    }
    private void makeMove(Position source, Position target){
        Piece p= board.removePiece(source);
        capturedPiece(p,source,target);
    }

    private void validadeSourcePosition(Position position){
        if(!board.thereIsPiece(position)){
            throw new BordGamesExeception("source position invalid");
        }
        if (currentPlayer != ((LadyPiece) board.piece(position)).getColor()) {
            throw new BordGamesExeception("The chosen piece is not yours");
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
                    if(i<4){
                        placeNewPiece((char) ('a'+j),i,new RockSimple(board,Color.WHITE));
                        countPieceWhite++;
                    }if(i>5){
                        placeNewPiece((char) ('a'+j),i,new RockSimple(board,Color.BLACK));
                        countPieceBlack++;
                    }
                }
            }
        }
    }
    private void capturedPiece(Piece p,Position source, Position target){

        Piece capturdPiece = null;
        if(p instanceof RockSimple) {
            int capturedRow = (source.getRows() + target.getRows()) / 2;
            int capturedColumn = (source.getColumns() + target.getColumns()) / 2;
            Position capturedPosition = new Position(capturedRow, capturedColumn);
            if (board.thereIsPiece(capturedPosition)) {
                capturdPiece=board.removePiece(capturedPosition);
            }
        }
        if(p instanceof DamaMoves){
            Position lastCaptured=((DamaMoves)p).getPieceCapturedDama();
            if (lastCaptured != null) {
                capturdPiece=board.removePiece(lastCaptured);
            }
        }
        if(capturdPiece!=null){
            if(((LadyPiece) capturdPiece).getColor()==Color.BLACK){countPieceBlack-=1;
                System.out.println(countPieceBlack);}
            else {
                countPieceWhite--;
                System.out.println(countPieceWhite);}
        }

        board.placePiece(p,target);

    }
    private void promotionRockInDama(LadyPiece movedPiece,Position target){
        if(movedPiece instanceof RockSimple){
            if(movedPiece.getColor()==Color.WHITE &&target.getRows()==0||movedPiece.getColor()==Color.BLACK &&target.getRows()==7){
                board.removePiece(target);
                placeNewPiece((char)('a'+ target.getColumns()),8-target.getRows(), new DamaMoves(board,currentPlayer));
            }
        }
    }


    public int getTurn() {
        return turn;
    }
}
