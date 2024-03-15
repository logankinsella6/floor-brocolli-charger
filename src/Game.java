// Written by Logan Kinsella, kinse124 and Aaron Siddiky, siddi186
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int count = 0;
        String input = "";
        Board board = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", board);
        while (board.isGameOver()) {
            System.out.println(board.toString());
            Scanner s = new Scanner(System.in);
            if (count % 2 == 0) {
                System.out.println("It is currently white's turn to play");
                System.out.println("What is your move? (format: [start row] [start column] [end row] [end column]");
            } else {
                System.out.println("It is currently black's turn to play");
                System.out.println("What is your move? (format: [start row] [start column] [end row] [end column]");
            }
            input = s.nextLine();

            if (input.equals("exit")) {
                return;
            }
            if (input.equals("clear")) {
                board.clear();
            }
            String[] coord = input.split(" "); // parsing the input line from the user into sr (startRow), sc (startCol), er (endRow), ec (endCol)
            int sr = Integer.parseInt(coord[0]);
            int sc = Integer.parseInt(coord[1]);
            int er = Integer.parseInt(coord[2]);
            int ec = Integer.parseInt(coord[3]);



            if(board.movePiece(sr,sc,er,ec) == true){
                System.out.println(board);
                count++;
            }
            else{
                System.out.println("Invalid Move! Please try again");

            }
        }
        if (count % 2 == 0) { //we know that if the count%2 == 0, then Black has won the game
            System.out.println("Black has won the game!");
        } else { // and if count%2 =! 0, (which is this else statement) then White has won the game
            System.out.println("White has won the game!");
        }
    }
}

