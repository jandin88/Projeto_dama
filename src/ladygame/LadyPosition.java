package ladygame;

import boardgame.Position;
import boardgame.exception.BordGamesExeception;

public class LadyPosition {
    private char colunm;
    private int row;

    public LadyPosition(char colunm, int row){
        if(colunm<'a'||colunm>'h'||row<1 ||row>8){
             throw new BordGamesExeception("Error instantiating, values rows a1 and h8 "+colunm+", "+row);
        }
        this.colunm=colunm;
        this.row=row;
    }
    protected Position toPosition(){
        return new Position(8-row,colunm-'a');
    }
    public String toString(){
        return ""+colunm+row;
    }

}
