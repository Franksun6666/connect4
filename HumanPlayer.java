import java.util.Scanner;
public class HumanPlayer extends Player{
    public HumanPlayer(char symbol, Board board, String name){
        super(symbol,board,name);
    }
    Scanner Obj = new Scanner(System.in);
    @Override
    public void makeMove(Board board){
        System.out.println(this.name + ", Please input your move:");
        int move = Obj.nextInt();
        String s = String.valueOf(this.symbol);
        // prompt the user to re-input if the last input is not a valid move
        while (board.columnisfull(move)){
                System.out.println(this.name + ", Please input your move:");
                move = Obj.nextInt();
            }
        int index = move - 1;
        board.setelem(board.getrow()[index],move,s); // place the player's symbol in the designated position
        board.getrow()[index] -= 1 ; // row of the "move" column decreases by one
    }

}