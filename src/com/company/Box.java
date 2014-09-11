package com.company;

public class Box {
  private Cell[][] cells = new Cell[3][3];
  private int boxX_;
  private int boxY_;

  public Box(int boxX, int boxY) {
    boxX_ = boxX;
    boxY_ = boxY;
  }

  public void setCell(int x, int y, Cell cell) {
    cells[x][y] = cell;
  }

  public void removeOptionFromBox(int value) {
    for( int x=0; x<3; x++ )
      for( int y=0; y<3; y++ )
        cells[x][y].removeOption(value);
  }
}
