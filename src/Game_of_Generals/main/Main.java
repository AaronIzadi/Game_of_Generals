package Game_of_Generals.main;

import Game_of_Generals.logic.LogicalAgent;
import Game_of_Generals.model.Color;
import Game_of_Generals.model.piece.PieceType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LogicalAgent logicalAgent = new LogicalAgent();

        Scanner sc = new Scanner(System.in);

        int turn = 1;

        while (true) {

            String str = sc.next();

            if (str.equals("0")) {
                System.exit(0);
            }

            String startString = sc.next();
            String endString = sc.next();

            int start = Integer.parseInt(startString);
            int end = Integer.parseInt(endString);

            if (logicalAgent.checkForEndGame() != null) {
                return;
            }

            int start_x = start / 10;
            int start_y = start % 10;
            int end_x = end / 10;
            int end_y = end % 10;

            PieceType pieceType;
            String lowStr = str.toLowerCase();

            switch (lowStr) {
                case "p":
                    pieceType = PieceType.PAWN;
                    break;
                case "l":
                    pieceType = PieceType.LANCE;
                    break;
                case "k":
                    pieceType = PieceType.KING;
                    break;
                case "b":
                    pieceType = PieceType.BISHOP;
                    break;
                case "s":
                    pieceType = PieceType.SILVER_GENERAL;
                    break;
                case "g":
                    pieceType = PieceType.GOLDEN_GENERAL;
                    break;
                default:
                    pieceType = PieceType.NONE;
            }

            if ((start_x != end_x || start_y != end_y) && pieceType != PieceType.NONE) {

                if (turn % 2 == 1 && lowStr.equals(str)) {

                    if (logicalAgent.getPieceByCell(pieceType, Color.BLACK, start_x, start_y) != null && logicalAgent.getDestination(end_x, end_y) != null) {

                        if (logicalAgent.getPieceByCell(pieceType, Color.BLACK, start_x, start_y).isValidMove(logicalAgent.getDestination(end_x, end_y))) {
                            turn++;
                        }
                        logicalAgent.getPieceByCell(pieceType, Color.BLACK, start_x, start_y).moveTo(logicalAgent.getDestination(end_x, end_y));
                    }

                }

                if (turn % 2 == 0 && str.toUpperCase().equals(str)) {

                    if (logicalAgent.getPieceByCell(pieceType, Color.WHITE, start_x, start_y) != null && logicalAgent.getDestination(end_x, end_y) != null) {

                        if (logicalAgent.getPieceByCell(pieceType, Color.WHITE, start_x, start_y).isValidMove(logicalAgent.getDestination(end_x, end_y))) {
                            turn++;
                        }
                        logicalAgent.getPieceByCell(pieceType, Color.WHITE, start_x, start_y).moveTo(logicalAgent.getDestination(end_x, end_y));
                    }

                }
            }

            System.out.println(logicalAgent.getGameState().toString());
            logicalAgent.getGameState().hitToString();

            if (logicalAgent.checkForEndGame() != null) {
                System.out.println(logicalAgent.checkForEndGame());
            }

        }

    }
}
