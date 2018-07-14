package edu.century.finalproject;

import java.util.Random;

public class ConwayBoard extends Board {
	//Initializes the random generator
	private Random cell = new Random();

		
	public void rules() {
		;
	}
	
	public ConwayBoard(int x, int y) {
		super(x, y);
		
		randomGen();
	}
	
				
	
	
	private void randomGen() {
		for(int row = 0; row < board.length; row++) {
			for(int column = 0; column < board[row].length; column++) {
				board[row][column] = cell.nextInt(2);
			}
		}
		
		
	}
	
	
	private int[][] neighbors =  calculateNeighbors(0);	
	
	public int[][] getNeighbors(){
		return this.neighbors.clone();
	}
	
	//this runs through the neighbors and change the board on the size of the 
	public void runningTheRules() {
		for(int x = 0; x < getWidth(); x++) {
			for(int y = 0; y < getHeight(); y++) {
				this.board[x][y] = theFourRules(x, y, board[x][y]);
			}
		}
	}
	
	public int theFourRules(int x, int y, int value) {
		//compares how many neighbors there are for the cell in question to be alive or dead
		switch(neighbors[x][y]) {
			
		case 0:
		case 1:
			//this cell is dead
			value = 0;
			break;
		case 2:
			break;
		case 3:
			//this rule would create life.  evil laugth and lightning in the background
			if(value != 1) {
				value = 1;
			}
			break;
		default:
			value = 0;
			break;
		}
			return value;
		}
		

	
 /*
	int countNeighbors(int x, int y) {
		int homes = 0;
		
		//top of the array
		if(board [x+1][y+1] > 0) {
			homes++;
		}
		if (board [x][y+1] > 0) {
			homes++;
		}
		if (board [x-1][y+1] > 0) {
			homes++;
		}
		//middle of the  array
		if(board [x+1][y] > 0) {
			homes++;
		}
		if(board [x-1][y] > 0) {
			homes++;
		}
		
		//for the bottom of the array 
		if (board [x+1][y-1] > 0) {
			homes++;
		}
		if (board [x][y-1] > 0) {
			homes++;
		}
		if(board [x-1][y-1] > 0) {
			homes++;
		}
		
		return homes;
	}
	*/

		
	
	
	
}

