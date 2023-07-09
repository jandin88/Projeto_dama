package app;

import ladygame.Color;
import ladygame.LadyPiece;
import ladygame.LadyPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ui {

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    public static LadyPosition readLadyPosition(Scanner sc){
        try {
            String s=sc.nextLine();
            char colunm=s.charAt(0);
            Integer row=Integer.parseInt(s.substring(1));
            return new LadyPosition(colunm,row);
        }catch(RuntimeException e){
            throw new InputMismatchException("Error reading board position, valid value a1 to h8");
        }
    }

    public static void printBoard(LadyPiece[][] ladyPieces){
        for(int i=0;i<ladyPieces.length;i++){
            System.out.print(8-i);
            for (int j=0;j<ladyPieces[i].length;j++){
                System.out.print(" ");
                printPiece(ladyPieces[i][j],i,j,false);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    public static void printBoard(LadyPiece[][] ladyPieces,boolean[][] possibleMoves){
        for(int i=0;i<ladyPieces.length;i++){
            System.out.print(8-i);
            for (int j=0;j<ladyPieces[i].length;j++){
                System.out.print(" ");
                printPiece(ladyPieces[i][j],i,j,possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    private static void printPiece(LadyPiece piece,int row,int column,boolean possibleMoves){

        if(possibleMoves){
            System.out.print(ANSI_BLUE_BACKGROUND);
        }

        if(piece==null){
            checkdWhiteHouse(row,column);
        }else {
            if (Color.WHITE == piece.getColor()) {
                System.out.print(piece);
            } else {
                System.out.print(ANSI_WHITE+piece+ANSI_RESET);
            }
        }

    }
    private static void checkdWhiteHouse(int row,int column){
        if((row+column)%2!=0){
            System.out.print(ANSI_WHITE_BACKGROUND+"-"+ANSI_RESET);
        }else {
            System.out.print("-");
        }
    }

}
