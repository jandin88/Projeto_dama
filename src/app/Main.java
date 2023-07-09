package app;

import boardgame.exception.BordGamesExeception;
import ladygame.LadyPiece;
import ladygame.LadyPosition;
import ladygame.LadyTable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LadyTable ladyTable = new LadyTable();
        while (true) {

            try {
                Ui.printBoard(ladyTable.getPiece());
                System.out.println();
                System.out.print("Source: ");
                LadyPosition source = Ui.readLadyPosition(sc);
                boolean[][]possibleMoves=ladyTable.possibleMoves(source);
                Ui.printBoard(ladyTable.getPiece(),possibleMoves);

                System.out.print("Target: ");
                LadyPosition target = Ui.readLadyPosition(sc);


                LadyPiece capturedPiece = ladyTable.perform(source, target);
            }catch(BordGamesExeception e){
                System.out.println(e.getMessage()+ "\nPress enter");
                sc.nextLine();
            }

        }
    }
}