// Written by Logan Kinsella, kinse124
public class Bishop {
    private int row;
    private int col;
    private boolean isBlack;

    public Bishop(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // Check if the move is diagonal
        if (Math.abs(row - endRow) == Math.abs(col - endCol)) {
            // Check if the path is clear
            if (board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
                // Check if the destination is empty or occupied by an opponent's piece
                Piece endPiece = board.getPiece(endRow, endCol);
                return endPiece == null || endPiece.getIsBlack() != isBlack;
            }
        }
        return false;
    }
}

