package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RowCol {
  private List<Integer> options_ = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
  private Cell[] cells = new Cell[9];

  public void setCell(int x, Cell cell) {
    cells[x] = cell;
  }
}
