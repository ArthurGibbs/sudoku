package com.company;

public class Board {
  private Cell[][] cells = new Cell[9][9];
  private Box[][] boxes = new Box[3][3];
  private RowCol[] rows_ = new RowCol[9];
  private RowCol[] cols_ = new RowCol[9];

  public Board() {
      resetBoard();
  }

  private void resetBoard() {
    for( int x=0; x<3; x++ )
      for( int y=0; y<3; y++ )
        boxes[x][y] = new Box(x,y);

    for( int i=0; i<9; i++ ){
      rows_[i] = new RowCol();
      cols_[i] = new RowCol();
    }

    for( int x=0; x<9; x++ )
      for( int y=0; y<9; y++ ) {
        Cell cell = new Cell(x, y, this);
        cells[x][y] = cell;
        boxes[x/3][y/3].setCell(x % 3, y % 3, cell);
        rows_[y].setCell(x, cell);
        cols_[x].setCell(y, cell);
      }
  }

  public Cell[][] getCells(){
    return cells;
  }

  public Box[][] getBoxes() {
    return boxes;
  }

  public RowCol[] getRows() {
    return rows_;
  }

  public RowCol[] getCols() {
    return cols_;
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

  public void removePossibilityFromRow(int y, int value) {
    for ( int x=0; x<9; x++ ) {
      cells[x][y].removePossibilities(value);
    }
  }

  public void removePossibilityFromCol(int x, int value) {
    for ( int y=0; y<9; y++ ) {
      cells[x][y].removePossibilities(value);
    }
  }

  public void removePossibilityFromBox(int boxX, int boxY, int value) {
   boxes[boxX][boxY].removeOptionFromBox(value);
  }

  public void fromString(String expected) {
    String gridNumbers = expected.replaceAll("\\-\\-\\-\\-\\-\\-\\-\\|\\-\\-\\-\\-\\-\\-\\-\\|\\-\\-\\-\\-\\-\\-\\-\n","");
    gridNumbers = gridNumbers.replaceAll("\\| ","");

    String[] lines = gridNumbers.split("\n");
    resetBoard();
    int y = 0;
    for (String i: lines){
      String line = i.replaceAll("^ ","").replaceAll(" $","");
      for (int x = 0; x<9; x++){
        String value = String.valueOf(line.charAt(x * 2));
        if ( !value.equals(" ")) {
          cells[x][y].setValue(Integer.parseInt(value));
        }
      }
      y++;
    }
  }

  public boolean equals(Board other) {
    for( int x=0; x<9; x++ )
      for( int y=0; y<9; y++ ) {
        if (this.cells[x][y].getValue() != other.getCells()[x][y].getValue()) {
          return false;
        }
      }
    return true;
  }
}
