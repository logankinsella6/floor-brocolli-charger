// Written by Logan Kinsella, kinse124 and Aaron Siddiky, siddi186
public class Knight {
    private int row;
    private int col;
    private boolean isBlack;

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // Check if the move is in the shape of an "L"
        int rowDiff = Math.abs(endRow - row);
        int colDiff = Math.abs(endCol - col);
        if ((rowDiff == 1 && colDiff == 2) || (rowDiff == 2 && colDiff == 1)) {
            // Check if the destination is empty or occupied by an opponent's piece
            Piece endPiece = board.getPiece(endRow, endCol);
            return endPiece == null || endPiece.getIsBlack() != isBlack;
        }
        return false;
    }
}
