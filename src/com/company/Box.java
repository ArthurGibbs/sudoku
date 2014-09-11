package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box {
  private Cell[][] cells = new Cell[3][3];
  private List<Integer> options_ = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

  private int boxX_;
  private int boxY_;

  public Box(int boxX, int boxY) {
    boxX_ = boxX;
    boxY_ = boxY;
  }

  public void setCell(int x, int y, Cell cell) {
    cells[x][y] = cell;
  }

  public List<Integer> getOptions_() {
    return options_;
  }

  public Cell[][] getCells() {
    return cells;
  }

  public void removeOptionFromBox(int value) {
    options_.remove((Integer) value);
    for( int x=0; x<3; x++ )
      for( int y=0; y<3; y++ )
        cells[x][y].removePossibilities(value);
  }
}
