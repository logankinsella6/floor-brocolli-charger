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
        return false;
    }
}