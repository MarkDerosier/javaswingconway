package edu.century.finalproject;

public class Driver {
	
	public static void main(String[] args) {
		ConwayBoard board = new ConwayBoard(15,15);
		
		int [][] display = board.showBoard();
		
		//showing the incial board
		for(int[] row : board.showBoard()) {
			for(int cell : row) {
				System.out.print(display[row[cell]][cell]+" ");
			}
		System.out.println();
		}
		
		board.runningTheRules();
		display = board.getNeighbors();
		
		//try {
		//	Thread.sleep(1000);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		System.out.println("\nNeighbors");
		for(int[] row : board.showBoard()) {
			for(int cell : row) {
				System.out.print(display[row[cell]][cell]+" ");
			}
			System.out.println();
		}
		
		
		
		
		display = board.showBoard();
		System.out.println("\nApplying the rules");
		for(int[] row : board.showBoard()) {
			for(int cell : row) {
				System.out.print(display[row[cell]][cell]+" ");
			}
			System.out.println();
		}
	}

}
