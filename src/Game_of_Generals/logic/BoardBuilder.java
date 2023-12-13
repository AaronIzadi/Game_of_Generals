package logic;

import model.Board;
import model.Cell;
import model.Color;
import model.Player;
import model.piece.*;

import java.util.LinkedList;
import java.util.List;

public class BoardBuilder {

    public Board build() {

        Board board = new Board();

        List<Cell> cells = new LinkedList<>();
        List<Piece> pieces = new LinkedList<>();

        //CELLS
        Cell cell11 = new Cell(Color.DARK_GREY, 1, 1);
        Cell cell12 = new Cell(Color.LIGHT_GREY, 1, 2);
        Cell cell13 = new Cell(Color.DARK_GREY, 1, 3);
        Cell cell14 = new Cell(Color.LIGHT_GREY, 1, 4);
        Cell cell15 = new Cell(Color.DARK_GREY, 1, 5);
        Cell cell21 = new Cell(Color.LIGHT_GREY, 2, 1);
        Cell cell22 = new Cell(Color.DARK_GREY, 2, 2);
        Cell cell23 = new Cell(Color.LIGHT_GREY, 2, 3);
        Cell cell24 = new Cell(Color.DARK_GREY, 2, 4);
        Cell cell25 = new Cell(Color.LIGHT_GREY, 2, 5);
        Cell cell31 = new Cell(Color.DARK_GREY, 3, 1);
        Cell cell32 = new Cell(Color.LIGHT_GREY, 3, 2);
        Cell cell33 = new Cell(Color.DARK_GREY, 3, 3);
        Cell cell34 = new Cell(Color.LIGHT_GREY, 3, 4);
        Cell cell35 = new Cell(Color.DARK_GREY, 3, 5);
        Cell cell41 = new Cell(Color.LIGHT_GREY, 4, 1);
        Cell cell42 = new Cell(Color.DARK_GREY, 4, 2);
        Cell cell43 = new Cell(Color.LIGHT_GREY, 4, 3);
        Cell cell44 = new Cell(Color.DARK_GREY, 4, 4);
        Cell cell45 = new Cell(Color.LIGHT_GREY, 4, 5);
        Cell cell51 = new Cell(Color.DARK_GREY, 5, 1);
        Cell cell52 = new Cell(Color.LIGHT_GREY, 5, 2);
        Cell cell53 = new Cell(Color.DARK_GREY, 5, 3);
        Cell cell54 = new Cell(Color.LIGHT_GREY, 5, 4);
        Cell cell55 = new Cell(Color.DARK_GREY, 5, 5);
        Cell cell00 = new Cell(null, 0, 0);


        //SET CELLS
        cells.add(cell11);
        cells.add(cell21);
        cells.add(cell31);
        cells.add(cell41);
        cells.add(cell51);
        cells.add(cell12);
        cells.add(cell22);
        cells.add(cell32);
        cells.add(cell42);
        cells.add(cell52);
        cells.add(cell13);
        cells.add(cell23);
        cells.add(cell33);
        cells.add(cell43);
        cells.add(cell53);
        cells.add(cell14);
        cells.add(cell24);
        cells.add(cell34);
        cells.add(cell44);
        cells.add(cell54);
        cells.add(cell15);
        cells.add(cell25);
        cells.add(cell35);
        cells.add(cell45);
        cells.add(cell55);
        cells.add(cell00);


        //BLACK PIECES
        Player player1 = new Player(Player.PLAYER_BLACK);

        Piece kingBlack = new King(player1, Color.BLACK);
        kingBlack.setCurrentCell(cell55);
        Piece goldenGeneralBlack = new GoldenGeneral(player1, Color.BLACK);
        goldenGeneralBlack.setCurrentCell(cell45);
        Piece silverGeneralBlack = new SilverGeneral(player1, Color.BLACK);
        silverGeneralBlack.setCurrentCell(cell35);
        Piece bishopBlack = new Bishop(player1, Color.BLACK);
        bishopBlack.setCurrentCell(cell25);
        Piece lanceBlack = new Lance(player1, Color.BLACK);
        lanceBlack.setCurrentCell(cell15);
        Piece pawnBlack = new Pawn(player1, Color.BLACK);
        pawnBlack.setCurrentCell(cell54);

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
        kingWhite.setCurrentCell(cell11);
        Piece goldenGeneralWhite = new GoldenGeneral(player2, Color.WHITE);
        goldenGeneralWhite.setCurrentCell(cell21);
        Piece silverGeneralWhite = new SilverGeneral(player2, Color.WHITE);
        silverGeneralWhite.setCurrentCell(cell31);
        Piece bishopWhite = new Bishop(player2, Color.WHITE);
        bishopWhite.setCurrentCell(cell41);
        Piece lanceWhite = new Lance(player2, Color.WHITE);
        lanceWhite.setCurrentCell(cell51);
        Piece pawnWhite = new Pawn(player2, Color.WHITE);
        pawnWhite.setCurrentCell(cell12);

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
