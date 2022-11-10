import java.util.Random;
public class AIPlayer extends Player{
    public AIPlayer(char symbol, Board board, String name){
        super(symbol,board,name);
    }
    String sym = String.valueOf(this.symbol); // convert the char type symbol into a string for later comparison use
    //determines if there is a winning move for the AIPlayer himself/herself/itself
    public boolean selfinterest(Board board){
        // check all horizontal cases
        for (int i = 1; i < 6; i++){
			for (int j = 1; j < 5; j++){
				if ((board.getelem(i,j).equals(board.getelem(i,j+1))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) == sym + "|") && (board.getelem(i,j).equals((board.getelem(i,j+2))))) {
                    int index = j + 2;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index], j+3, sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i,j+1))) && (board.getelem(i,j) != " |") &&(board.getelem(i,j) == sym + "|") && (board.getelem(i,j).equals(board.getelem(i,j+3)))){
                    int index = j + 1;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index], j+2, sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i,j+2))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) == sym + "|") && (board.getelem(i,j).equals(board.getelem(i,j+3)))){
                    int index = j;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index], j+1, sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
                if ((board.getelem(i,j+1).equals(board.getelem(i,j+2))) && (board.getelem(i,j+1) != " |") && (board.getelem(i,j+1) == sym + "|") && (board.getelem(i,j+1).equals(board.getelem(i,j+3)))){
                    int index = j - 1;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
			}
		}
        // check all vertical cases
		for (int i = 1; i < 3; i++){
			for (int j = 1; j < 8; j++){
				if ((board.getelem(i+1,j).equals(board.getelem(i+2,j))) && (board.getelem(i+1,j) != " |") && (board.getelem(i+1,j) == sym + "|") && (board.getelem(i+1,j).equals(board.getelem(i+3,j)))){
                    int index = j - 1;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
			}
		}
        // check all diagonal cases
		for (int i = 1; i < 3; i++){
			for (int j = 1; j < 5; j++){
                if ((board.getelem(i,j).equals(board.getelem(i+1,j+1))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) == sym + "|") && (board.getelem(i,j).equals(board.getelem(i+2,j+2)))) {
                    int index = j + 2 ;
                    if (i+3 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j+3,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i+1,j+1))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) == sym + "|") && (board.getelem(i,j).equals(board.getelem(i+3,j+3)))){
                    int index = j + 1;
                    if (i+2 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j+2,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i+2,j+2))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) == sym + "|") && (board.getelem(i,j).equals(board.getelem(i+3,j+3)))){
                    int index = j ;
                    if (i+1 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j+1,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
                if ((board.getelem(i+1,j+1).equals(board.getelem(i+2,j+2))) && (board.getelem(i+1,j+1) != " |") && (board.getelem(i+1,j+1) == sym + "|") && (board.getelem(i+1,j+1).equals(board.getelem(i+3,j+3)))){
                    int index = j - 1;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j,sym) ;
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
			}
        }
        // check all off-diagonal cases
		for (int i = 1; i < 3; i++){
			for (int j = 7; j > 3; j--){
				if ((board.getelem(i,j).equals(board.getelem(i+1,j-1))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) == sym + "|") && (board.getelem(i,j).equals(board.getelem(i+2,j-2)))) {
                    int index = j - 4;
                    if (i+3 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j-3,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i+1,j-1))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) == sym + "|") && (board.getelem(i,j).equals(board.getelem(i+3,j-3)))){
                    int index = j - 3;
                    if (i+2 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j-2,sym) ;
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i+2,j-2))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) == sym + "|") && (board.getelem(i,j).equals(board.getelem(i+3,j-3)))){
                    int index = j - 2;
                    if (i+1 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j-1,sym) ;
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
                if ((board.getelem(i+1,j-1).equals(board.getelem(i+2,j-2))) && (board.getelem(i+1,j-1) != " |") && (board.getelem(i+1,j-1) == sym + "|") && (board.getelem(i+1,j-1).equals(board.getelem(i+3,j-3)))){
                    int index = j - 1;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
			}
		}
        return false;
    }
    //if there's no winning move for the AIPlayer, then determine if there is a blocking move to intervene the other player's winning move.
    public boolean blockother(Board board){
        // check all horizontal cases
        for (int i = 1; i < 6; i++){
			for (int j = 1; j < 5; j++){
				if ((board.getelem(i,j).equals(board.getelem(i,j+1))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) != sym + "|") && (board.getelem(i,j).equals((board.getelem(i,j+2))))) {
                    int index = j + 2;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index], j+3, sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i,j+1))) && (board.getelem(i,j) != " |") &&(board.getelem(i,j) != sym + "|") && (board.getelem(i,j).equals(board.getelem(i,j+3)))){
                    int index = j + 1;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index], j+2, sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i,j+2))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) != sym + "|") && (board.getelem(i,j).equals(board.getelem(i,j+3)))){
                    int index = j;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index], j+1, sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
                if ((board.getelem(i,j+1).equals(board.getelem(i,j+2))) && (board.getelem(i,j+1) != " |") && (board.getelem(i,j+1) != sym + "|") && (board.getelem(i,j+1).equals(board.getelem(i,j+3)))){
                    int index = j - 1;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
			}
		}
        // check all vertical cases
		for (int i = 1; i < 3; i++){
			for (int j = 1; j < 8; j++){
				if ((board.getelem(i+1,j).equals(board.getelem(i+2,j))) && (board.getelem(i+1,j) != " |") && (board.getelem(i+1,j) != sym + "|") && (board.getelem(i+1,j).equals(board.getelem(i+3,j)))){
                    int index = j - 1;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
			}
		}
        // check all diagonal cases
		for (int i = 1; i < 3; i++){
			for (int j = 1; j < 5; j++){
                if ((board.getelem(i,j).equals(board.getelem(i+1,j+1))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) != sym + "|") && (board.getelem(i,j).equals(board.getelem(i+2,j+2)))) {
                    int index = j + 2 ;
                    if (i+3 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j+3,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i+1,j+1))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) != sym + "|") && (board.getelem(i,j).equals(board.getelem(i+3,j+3)))){
                    int index = j + 1;
                    if (i+2 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j+2,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i+2,j+2))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) != sym + "|") && (board.getelem(i,j).equals(board.getelem(i+3,j+3)))){
                    int index = j ;
                    if (i+1 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j+1,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
                if ((board.getelem(i+1,j+1).equals(board.getelem(i+2,j+2))) && (board.getelem(i+1,j+1) != " |") && (board.getelem(i+1,j+1) != sym + "|") && (board.getelem(i+1,j+1).equals(board.getelem(i+3,j+3)))){
                    int index = j - 1;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j,sym) ;
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
			}
        }
        // check all off-diagonal cases
		for (int i = 1; i < 3; i++){
			for (int j = 7; j > 3; j--){
				if ((board.getelem(i,j).equals(board.getelem(i+1,j-1))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) != sym + "|") && (board.getelem(i,j).equals(board.getelem(i+2,j-2)))) {
                    int index = j - 4;
                    if (i+3 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j-3,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i+1,j-1))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) != sym + "|") && (board.getelem(i,j).equals(board.getelem(i+3,j-3)))){
                    int index = j - 3;
                    if (i+2 == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j-2,sym) ;
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
				if ((board.getelem(i,j).equals(board.getelem(i+2,j-2))) && (board.getelem(i,j) != " |") && (board.getelem(i,j) != sym + "|") && (board.getelem(i,j).equals(board.getelem(i+3,j-3)))){
                    int index = j - 2;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j-1,sym) ;
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
                if ((board.getelem(i+1,j-1).equals(board.getelem(i+2,j-2))) && (board.getelem(i+1,j-1) != " |") && (board.getelem(i+1,j-1) != sym + "|") && (board.getelem(i+1,j-1).equals(board.getelem(i+3,j-3)))){
                    int index = j - 1;
                    if (i == board.getrow()[index]){
                        board.setelem(board.getrow()[index],j,sym);
                        board.getrow()[index] -= 1;
                        return true;
                    }
                }
			}
		}
        return false;
    }

    public void makeMove(Board board){
        if (selfinterest(board)) return;
        else if (blockother(board)) return;
        else{
        int move = new Random().ints(1, 1, 8).findFirst().getAsInt();
        while (board.columnisfull(move)){
            move = new Random().ints(1, 1, 8).findFirst().getAsInt();
        }
        int index = move - 1;
        board.setelem(board.getrow()[index],move,sym) ;
        board.getrow()[index] -= 1 ;
        }
    }
    
}
