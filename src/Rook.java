// Written by Logan Kinsella, kinse124
public class Rook {
    private int row;
    private int col;
    private boolean isBlack;

    public Rook(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // Check if the move is vertical or horizontal
        if (row == endRow || col == endCol) {
            // Check if the path is clear (no pieces between start and end)
            if (board.verifyVertical(this.row, this.col, endRow, endCol) || board.verifyHorizontal(this.row, this.col, endRow, endCol)) {
                // Check if the destination is empty or occupied by an opponent's piece
                Piece endPiece = board.getPiece(endRow, endCol);
                return endPiece == null || endPiece.getIsBlack() != isBlack;
            }
        }
        return false;
    }
}