package edu.century.finalproject;

public abstract class Board {
  private int height;
  private int width;
  int board[][];

  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    this.board = new int[height][width];
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public int[][] showBoard() {
    return this.board.clone();
  }

  public abstract void rules();


}
