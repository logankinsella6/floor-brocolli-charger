// Written by Logan Kinsella, kinse124
import java.util.Scanner;

public class Game {
    int count = 0;

    public static void main(String[] args){
        String input = "";
        Board board = new Board();
        System.out.println(board.toString());
        Scanner s = new Scanner(System.in);
        while (board.isGameOver() == false) {
            System.out.println("It is currently white's turn to play");
            System.out.println("What is your move? (format: [start row] [start column] [end row] [end column]");
            input = s.nextLine();
            if (input.equals("exit")){
                break;
            }
            if (input.equals("clear")){
                board.clear();
            }
            String[] coord = input.split(" ");
            int sr = Integer.parseInt(coord[0]);
            int sc = Integer.parseInt(coord[1]);
            int er = Integer.parseInt(coord[2]);
            int ec = Integer.parseInt(coord[3]);
            try{
                board.movePiece(sr,sc,er,ec);
                System.out.println(board.toString());
            } catch (NumberFormatException e) {
                System.out.println("invalid move");
            }
        }

    }
}
