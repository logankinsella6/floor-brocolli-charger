// Written by Logan Kinsella, kinse124
public class Board {
    // Instance variables
    private Piece[][] board;


    // Constructor
    public Board() {
        this.board = new Piece[8][8];
    }


    // Accessor Methods
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }


    // Game functionality methods
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        Piece piece = board[startRow][startCol];
        if (piece.isMoveLegal(this, endRow, endCol)) {
            board[endRow][endCol] = board[startRow][startCol];
            board[startRow][startCol] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameOver() {
        int kingCount = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = getPiece(i, j);
                if (piece != null && piece.equals("King")) {
                    kingCount++;
                }
            }
        }
        if (kingCount < 2) {
            return true;
        } else {
            return  false;
        }
    }

    // Constructs a String that represents the Board object's 2D array.
    // Returns the fully constructed String.
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for(int i = 0; i < 8; i++){
            out.append(" ");
            out.append(i);
        }
        out.append('\n');
        for(int i = 0; i < board.length; i++) {
            out.append(i);
            out.append("|");
            for(int j = 0; j < board[0].length; j++) {
                out.append(board[i][j] == null ? "\u2001|" : board[i][j] + "|");
            }
            out.append("\n");
        }
        return out.toString();
    }

    public void clear() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                setPiece(i, j, null);
            }
        }
    }

    // Movement helper functions
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        //Check to see if 'start' and 'end' fall within the array's bounds.
        if (startRow < 0 || startRow >= 8 || startCol < 0 || startCol <= 8 || endRow < 0 || endRow >= 8 || endCol < 0 || endCol >= 8) {
            return false;
        }

        //Check to see if 'start' contains a Piece object
        Piece startPiece = getPiece(startRow, startCol);
        if (startPiece == null) {
            return false;
        }

        //Check to see if Player's color and color of 'start' Piece match
        if (startPiece.getIsBlack() != isBlack) {
            return false;
        }

        //Check to see if 'end' contains either no Piece or a Piece of the opposite color
        Piece endPiece = getPiece(endRow, endCol);
        if (endPiece != null || endPiece.getIsBlack() == isBlack) {
            return false;
        }

        //If all checks pass
        return true;
    }

    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        return false;
    }
}
