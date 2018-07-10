package edu.century.finalproject;

public class ConwayBoard extends Board {	

	public void rules() {
	;
	}
	
	public ConwayBoard(int width, int height) {
		super(width, height);
		init(this.board);
		
	}
	

	
	private void init(int [][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int cell = 0; cell < board[row].length; cell++) {
				board[row][cell] = 1;
			}
		}
			
	}

	
	public void intialize() {
		;
		
	}

	

}