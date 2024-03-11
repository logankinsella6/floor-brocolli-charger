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
        if (endPiece != null && endPiece.getIsBlack() == isBlack) {
            return false;
        }

        //If all checks pass
        return true;
    }

    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        //Calculate the absolute difference between row and column coordinates
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startCol - endCol);

        // Check to see if adjacent
        return ((rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1));
    }

    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        // Check if the move takes place on one row
        if (startRow != endRow) {
            return false;
        }

        // Determine the direction of movement (left or right)
        int direction = Integer.compare(endCol, startCol);

        // Iterate over spaces between 'start' and 'end'
        for (int col = startCol + direction; col != endCol; col += direction) {
            if (getPiece(startRow, col) != null) {
                return false; // A piece exists in between 'start' and 'end'
            }
        }

        return true; // All spaces between 'start' and 'end' are empty
    }

    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        // Check if the move takes place on one column
        if (startCol != endCol) {
            return false;
        }

        // Determine the direction of movement (up or down)
        int direction = Integer.compare(endRow, startRow);

        // Iterate over spaces between 'start' and 'end'
        for (int row = startRow + direction; row != endRow; row += direction) {
            if (getPiece(row, startCol) != null) {
                return false; // A piece exists in between 'start' and 'end'
            }
        }

        return true; // All spaces between 'start' and 'end' are empty
    }

    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        // Calculate the absolute differences between row and column coordinates
        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // Check if the move is diagonal (both row and column changes)
        if (rowDiff != colDiff) {
            return false;
        }

        // Determine the direction of movement (up-right, up-left, down-right, down-left)
        int rowDirection = Integer.compare(endRow, startRow);
        int colDirection = Integer.compare(endCol, startCol);

        // Iterate over spaces between 'start' and 'end'
        for (int i = 1; i < rowDiff; i++) {
            int row = startRow + i * rowDirection;
            int col = startCol + i * colDirection;
            if (getPiece(row, col) != null) {
                return false; // A piece exists in between 'start' and 'end'
            }
        }

        return true; // All spaces between 'start' and 'end' are empty
    }
}