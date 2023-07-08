package app;

import ladygame.Color;
import ladygame.LadyPiece;

public class Ui {

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void printBoard(LadyPiece[][] ladyPieces){
        for(int i=0;i<ladyPieces.length;i++){
            for (int j=0;j<ladyPieces[i].length;j++){
                System.out.print(" ");
                printPiece(ladyPieces[i][j]);
            }
            System.out.println();
        }
        System.out.println(" A B C D E F G H");
    }

    private static void printPiece(LadyPiece piece){

        if(piece==null){
            System.out.print("-");
        }else {
            if (Color.WHITE == piece.getColor()) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            } else {
                System.out.print(piece);
            }
        }

    }

}
