// Written by Logan Kinsella, kinse124
import java.util.Scanner;

public class Piece {
    private char character;
    private int row;
    private int col;
    private boolean isBlack;


    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }


    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }


    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }


    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {
        return isBlack;
    }


    /**
     * Handle promotion of a pawn.
     * @param row Current row of the pawn
     * @param isBlack Color of the pawn
     */
    public void promotePawn(int row, boolean isBlack) {
        // Check if the pawn has reached the opposite end of the board
        if ((isBlack && row == 0) || (!isBlack && row == 7)) {
            Scanner scanner = new Scanner(System.in);
            String pieceName;
            boolean validPiece = false;

            // Keep prompting the user until a valid piece name is entered
            while (!validPiece) {
                System.out.println("Your pawn can be promoted! Enter the name of the piece you want to promote it to (excluding king): ");
                pieceName = scanner.nextLine().toLowerCase();

                // Set the character of the piece based on the user input
                switch (pieceName) {
                    case "pawn":
                        character = isBlack ? '\u2659' : '\u265f';
                        validPiece = true;
                        break;
                    case "rook":
                        character = isBlack ? '\u2656' : '\u265c';
                        validPiece = true;
                        break;
                    case "knight":
                        character = isBlack ? '\u2658' : '\u265e';
                        validPiece = true;
                        break;
                    case "bishop":
                        character = isBlack ? '\u2657' : '\u265d';
                        validPiece = true;
                        break;
                    case "queen":
                        character = isBlack ? '\u2655' : '\u265b';
                        validPiece = true;
                        break;
                    default:
                        System.out.println("Invalid piece name. Please enter a valid piece name.");
                        break;
                }
            }
        }
    }


    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return String.valueOf(character);
    }
}
