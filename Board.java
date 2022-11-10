public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private int row[] = {5,5,5,5,5,5,5}; // keeps track of each row in each column
    
	private String [][] b = new String[6][8];
	// generates a 2-D array board
	public Board() {
		String [][] a = new String[6][8];
		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j < NUM_OF_COLUMNS + 1; j++){
				if (j == 0)a[i][j] = "|";
				else a[i][j] = " |";}
		}
		b = a;
	}
	//getter/ setter methods
	public String getelem(int i, int j){
		return b[i][j];
	}

	public void setelem(int i, int j, String s){
		b[i][j] = s + "|";
	}

	public int[] getrow(){
		return row;
	}
	
	public void printBoard() {
		for (int i = 0; i <NUM_OF_ROW; i++){
			for (int j = 0; j <NUM_OF_COLUMNS + 1; j++){
				System.out.print(b[i][j]);
			}
			System.out.println("\n");
		}
	}

	public boolean columnisfull(int column){
		if ((b[0][column]) == " |") return false;
		else return true;

	}
	// check all 4 cases if there's a win: vertical, horizontal, diagonal, and off-diagonal
	public boolean containsWin() {
		for (int i = 1; i < NUM_OF_ROW; i++){
			for (int j = 1; j < 5; j++){
				if ((b[i][j].equals(b[i][j+1])) && (b[i][j].equals(b[i][j+2])) && (b[i][j].equals(b[i][j+3])) && (b[i][j] != " |")) return true;
			}
		}
		for (int i = 1; i < 3; i++){
			for (int j = 1; j < NUM_OF_COLUMNS + 1; j++){
				if ((b[i][j].equals(b[i+1][j])) && (b[i][j].equals(b[i+2][j])) && (b[i][j].equals(b[i+3][j])) && (b[i][j] != " |")) return true;
			}
		}
		for (int i = 1; i < 3; i++){
			for (int j = 1; j < 5; j++){
				if ((b[i][j].equals(b[i+1][j+1])) && (b[i][j].equals(b[i+2][j+2])) && (b[i][j].equals(b[i+3][j+3])) && (b[i][j] != " |")) return true;
			}
		}
		for (int i = 1; i < 3; i++){
			for (int j = 7; j > 3; j--){
				if ((b[i][j].equals(b[i+1][j-1])) && (b[i][j].equals(b[i+2][j-2])) && (b[i][j].equals(b[i+3][j-3])) && (b[i][j] != " |")) return true;
			}
		}
		return false;
	}
	// if the board is full and there's no one winning, it's a tie.
	public boolean isTie() {
		int counter = 0;
		for (int i = 1; i < NUM_OF_COLUMNS+1; i++){
			if (columnisfull(i)) counter++;
		}
		if ((counter == 7) && (containsWin() == false)) return true;
		return false;
	}
	// empty the board and reset
	public void reset() {
		String [][] a = new String[6][8];
		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j < NUM_OF_COLUMNS + 1; j++){
				if (j == 0)a[i][j] = "|";
				else a[i][j] = " |";}
		}
		b = a;
	}
	
}
