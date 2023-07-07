package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;
    
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces=new Piece[rows][columns];
    }

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
}
