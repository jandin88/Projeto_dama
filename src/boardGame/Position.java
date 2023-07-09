package boardgame;

public class Position {
    private int rows;
    private int columns;
    

    public Position(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }


    public void setValues(int rows,int columns){
        this.rows=rows;
        this.columns=columns;
    }


    public int getRows() {
        return rows;
    }
    
    public int getColumns() {
        return columns;
    }
    public String toString(){
        return rows+", "+columns;
    }
}
