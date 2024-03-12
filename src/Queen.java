// Written by Logan Kinsella, kinse124
public class Queen {
    private int row;
    private int col;
    private boolean isBlack;

    public Queen(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // Check if the move is horizontal, vertical, or diagonal
        if ((row == endRow || col == endCol) || Math.abs(row - endRow) == Math.abs(col - endCol)) {
            // Check if the path is clear
            if (verifyPath(board, endRow, endCol)) {
                // Check if the destination is empty or occupied by an opponent's piece
                Piece endPiece = board.getPiece(endRow, endCol);
                return endPiece == null || endPiece.getIsBlack() != isBlack;
            }
        }
        return false;
    }
}