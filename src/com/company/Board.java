package com.company;

public class Board {
  private Cell[][] cells = new Cell[9][9];
  private Box[][] boxes = new Box[3][3];

  public Board() {
    for( int x=0; x<3; x++ )
      for( int y=0; y<3; y++ )
        boxes[x][y] = new Box(x,y);

    for( int x=0; x<9; x++ )
      for( int y=0; y<9; y++ ) {
        Cell cell = new Cell(x, y, this);
        cells[x][y] = cell;
        boxes[x/3][y/3].setCell(x % 3, y % 3, cell);
      }
  }

  public Cell getCell(int x, int y) {
    return cells[x][y];
  }

  public void set(int x, int y, int value) {
    cells[x][y].setValue(value);
  }

  /**
   *   0 0 0 | 0 0 0 | 0 0 0
   *   0 0 0 | 0 0 0 | 0 0 0
   *   0 0 0 | 0 0 0 | 0 0 0
   *   ------|-------|------
   */
  public String getBoardString() {
    StringBuilder output = new StringBuilder();
    for( int y=0; y<9; y++ ) {
      for (int x = 0; x < 9; x++) {
        if (x == 3 || x == 6) {
          output.append(" |");
        }
        output.append(" ");
        String cellValue = getCellStringValue(y, x);
        output.append(cellValue);
      }
      output.append(" \n");
      if (y == 2 || y == 5) {
        output.append("-------|-------|-------\n");
      }
    }
    return output.toString();
  }

  private String getCellStringValue(int y, int x) {
    Integer value = cells[x][y].getValue();
    String cellValue = "";
    if (value != null) {
      cellValue = value.toString();
    } else {
      cellValue = " ";
    }
    return cellValue;
  }

  public void removeOptionFromRow(int y, int value) {
    for ( int x=0; x<9; x++ ) {
      cells[x][y].removeOption(value);
    }
  }

  public void removeOptionFromCol(int x, int value) {
    for ( int y=0; y<9; y++ ) {
      cells[x][y].removeOption(value);
    }
  }

  public void removeOptionFromBox(int boxX, int boxY, int value) {
   boxes[boxX][boxY].removeOptionFromBox(value);
  }
}
