package Game_of_Generals.logic;

import Game_of_Generals.model.Board;
import Game_of_Generals.model.Cell;
import Game_of_Generals.model.Color;
import Game_of_Generals.model.Player;
import Game_of_Generals.model.piece.*;

import java.util.LinkedList;
import java.util.List;

public class BoardBuilder {

    public Board build() {

        Board board = new Board();

        List<Cell> cells = new LinkedList<>();
        List<Piece> pieces = new LinkedList<>();
        int constant = 144;

        //CELLS
        //First column
        Cell cell00 = new Cell(Color.BROWN, 0, 0);
        Cell cell01 = new Cell(Color.BROWN, 0, constant);
        Cell cell02 = new Cell(Color.BROWN, 0, 2 * constant);
        Cell cell03 = new Cell(Color.BROWN, 0, 3 * constant);
        Cell cell04 = new Cell(Color.BROWN, 0, 4 * constant);
        //Second column
        Cell cell10 = new Cell(Color.DARK_GREY, constant, 0);
        Cell cell11 = new Cell(Color.LIGHT_GREY, constant, constant);
        Cell cell12 = new Cell(Color.DARK_GREY, constant, 2 * constant);
        Cell cell13 = new Cell(Color.LIGHT_GREY, constant, 3 * constant);
        Cell cell14 = new Cell(Color.DARK_GREY, constant, 4 * constant);
        //Third column
        Cell cell20 = new Cell(Color.LIGHT_GREY, 2 * constant, 0);
        Cell cell21 = new Cell(Color.DARK_GREY, 2 * constant, constant);
        Cell cell22 = new Cell(Color.LIGHT_GREY, 2 * constant, 2 * constant);
        Cell cell23 = new Cell(Color.DARK_GREY, 2 * constant, 3 * constant);
        Cell cell24 = new Cell(Color.LIGHT_GREY, 2 * constant, 4 * constant);
        //Fourth column
        Cell cell30 = new Cell(Color.DARK_GREY, 3 * constant, 0);
        Cell cell31 = new Cell(Color.LIGHT_GREY, 3 * constant, constant);
        Cell cell32 = new Cell(Color.DARK_GREY, 3 * constant, 2 * constant);
        Cell cell33 = new Cell(Color.LIGHT_GREY, 3 * constant, 3 * constant);
        Cell cell34 = new Cell(Color.DARK_GREY, 3 * constant, 4 * constant);
        //Fifth column
        Cell cell40 = new Cell(Color.LIGHT_GREY, 4 * constant, 0);
        Cell cell41 = new Cell(Color.DARK_GREY, 4 * constant, constant);
        Cell cell42 = new Cell(Color.LIGHT_GREY, 4 * constant, 2 * constant);
        Cell cell43 = new Cell(Color.DARK_GREY, 4 * constant, 3 * constant);
        Cell cell44 = new Cell(Color.LIGHT_GREY, 4 * constant, 4 * constant);
        //Sixth column
        Cell cell50 = new Cell(Color.DARK_GREY, 5 * constant, 0);
        Cell cell51 = new Cell(Color.LIGHT_GREY, 5 * constant, constant);
        Cell cell52 = new Cell(Color.DARK_GREY, 5 * constant, 2 * constant);
        Cell cell53 = new Cell(Color.LIGHT_GREY, 5 * constant, 3 * constant);
        Cell cell54 = new Cell(Color.DARK_GREY, 5 * constant, 4 * constant);
        //Seventh column
        Cell cell60 = new Cell(Color.BROWN, 6 * constant, 0);
        Cell cell61 = new Cell(Color.BROWN, 6 * constant, constant);
        Cell cell62 = new Cell(Color.BROWN, 6 * constant, 2 * constant);
        Cell cell63 = new Cell(Color.BROWN, 6 * constant, 3 * constant);
        Cell cell64 = new Cell(Color.BROWN, 6 * constant, 4 * constant);


        //SET CELLS
        cells.add(cell00);
        cells.add(cell01);
        cells.add(cell02);
        cells.add(cell03);
        cells.add(cell04);

        cells.add(cell10);
        cells.add(cell11);
        cells.add(cell12);
        cells.add(cell13);
        cells.add(cell14);
        cells.add(cell20);
        cells.add(cell21);
        cells.add(cell22);
        cells.add(cell23);
        cells.add(cell24);
        cells.add(cell30);
        cells.add(cell31);
        cells.add(cell32);
        cells.add(cell33);
        cells.add(cell34);
        cells.add(cell40);
        cells.add(cell41);
        cells.add(cell42);
        cells.add(cell43);
        cells.add(cell44);
        cells.add(cell50);
        cells.add(cell51);
        cells.add(cell52);
        cells.add(cell53);
        cells.add(cell54);

        cells.add(cell60);
        cells.add(cell61);
        cells.add(cell62);
        cells.add(cell63);
        cells.add(cell64);


        //BLACK PIECES
        Player player1 = new Player(Player.PLAYER_BLACK);

        Piece kingBlack = new King(player1, Color.BLACK);
        kingBlack.setCurrentCell(cell50);
        cell50.setPiece(kingBlack);
        Piece goldenGeneralBlack = new GoldenGeneral(player1, Color.BLACK);
        goldenGeneralBlack.setCurrentCell(cell40);
        cell40.setPiece(goldenGeneralBlack);
        Piece silverGeneralBlack = new SilverGeneral(player1, Color.BLACK);
        silverGeneralBlack.setCurrentCell(cell30);
        cell30.setPiece(silverGeneralBlack);
        Piece bishopBlack = new Bishop(player1, Color.BLACK);
        bishopBlack.setCurrentCell(cell20);
        cell20.setPiece(bishopBlack);
        Piece lanceBlack = new Lance(player1, Color.BLACK);
        lanceBlack.setCurrentCell(cell10);
        cell10.setPiece(lanceBlack);
        Piece pawnBlack = new Pawn(player1, Color.BLACK);
        pawnBlack.setCurrentCell(cell51);
        cell51.setPiece(pawnBlack);

        List<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(kingBlack);
        blackPieces.add(goldenGeneralBlack);
        blackPieces.add(silverGeneralBlack);
        blackPieces.add(bishopBlack);
        blackPieces.add(lanceBlack);
        blackPieces.add(pawnBlack);

        player1.setPieces(blackPieces);


        //WHITE PIECES
        Player player2 = new Player(Player.PLAYER_WHITE);

        Piece kingWhite = new King(player2, Color.WHITE);
        kingWhite.setCurrentCell(cell14);
        cell14.setPiece(kingWhite);
        Piece goldenGeneralWhite = new GoldenGeneral(player2, Color.WHITE);
        goldenGeneralWhite.setCurrentCell(cell24);
        cell24.setPiece(goldenGeneralWhite);
        Piece silverGeneralWhite = new SilverGeneral(player2, Color.WHITE);
        silverGeneralWhite.setCurrentCell(cell34);
        cell34.setPiece(silverGeneralWhite);
        Piece bishopWhite = new Bishop(player2, Color.WHITE);
        bishopWhite.setCurrentCell(cell44);
        cell44.setPiece(bishopWhite);
        Piece lanceWhite = new Lance(player2, Color.WHITE);
        lanceWhite.setCurrentCell(cell54);
        cell54.setPiece(lanceWhite);
        Piece pawnWhite = new Pawn(player2, Color.WHITE);
        pawnWhite.setCurrentCell(cell13);
        cell13.setPiece(pawnWhite);

        List<Piece> whitePieces = new LinkedList<>();
        whitePieces.add(kingWhite);
        whitePieces.add(goldenGeneralWhite);
        whitePieces.add(silverGeneralWhite);
        whitePieces.add(bishopWhite);
        whitePieces.add(lanceWhite);
        whitePieces.add(pawnWhite);

        player2.setPieces(whitePieces);

        //SET RIVAL
        player1.setRival(player2);
        player2.setRival(player1);

        //SET PIECES
        pieces.addAll(blackPieces);
        pieces.addAll(whitePieces);

        //SET BOARD
        board.setCells(cells);
        board.setPieces(pieces);

        //SET PLAYERS
        board.setPlayer1(player1);
        board.setPlayer2(player2);

        return board;
    }

}
