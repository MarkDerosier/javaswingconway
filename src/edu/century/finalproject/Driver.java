package edu.century.finalproject;

public class Driver {

	public static void main(String[] args) {
		ConwayBoard board = new ConwayBoard(5,5);
		
		for(int[] row : board.showBoard()){
			for(int cell : row) {
				System.out.print(cell + "");
			}
		System.out.println();
		}
		
	}

}
