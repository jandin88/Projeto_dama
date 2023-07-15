package app;

import boardgame.exception.BordGamesExeception;
import ladygame.LadyPosition;
import ladygame.LadyTable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LadyTable ladyTable = new LadyTable();
        do{
            try {
                Ui.clearScreen();
                Ui.printBoard(ladyTable.getPiece());
                System.out.println("\nTurn: "+ladyTable.getTurn());
                System.out.println("Player: "+ladyTable.getCurrentPlayer());
                System.out.print("Source: ");
                LadyPosition source = Ui.readLadyPosition(sc);
                boolean[][]possibleMoves=ladyTable.possibleMoves(source);
                Ui.printBoard(ladyTable.getPiece(),possibleMoves);

                System.out.print("Target: ");
                LadyPosition target = Ui.readLadyPosition(sc);
                ladyTable.perform(source, target);
            }catch(BordGamesExeception | InputMismatchException e){
                System.out.println(e.getMessage()+ "\nPress enter");
                sc.nextLine();
            }

        }while(ladyTable.getCountPieceBlack()!=0&&ladyTable.getCountPieceWhite()!=0);
        System.out.println(Ui.ANSI_YELLOW+"Winner "+ladyTable.getCurrentPlayer()+Ui.ANSI_RESET);
    }
}