package app;

import ladygame.LadyTable;

public class Main {
    public static void main(String[] args) {

        LadyTable ladyTable = new LadyTable();
        Ui.printBoard(ladyTable.getPiece());
    }
}