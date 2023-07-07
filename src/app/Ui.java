package app;

import ladygame.LadyPiece;

public class Ui {
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
            System.out.print(piece);
        }

    }


}
