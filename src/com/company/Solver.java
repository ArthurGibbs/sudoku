package com.company;

public class Solver {
  private Board board_;

  public Board getBoard() {
    return board_;
  }

  public void setBoard(Board board) {
    board_ = board;
  }

  public Board solve(){
    boolean progress = true;
    while (progress == true) {
      progress = false;
      progress |= FinalOptionForCell();
      // final option for block/row/col( eg only place a 9 can go)
      // forward row col blocking(if the only place for a 7 can go in two places in a box but in the same row or coll you know it cant go in other cell in the row)
      // path finding
    }
    return board_;
  }

  private boolean FinalOptionForCell() {
    boolean progress = false;
    for (int y = 0; y < 9; y++) {
      for (int x = 0; x < 9; x++) {
        Cell target = board_.getCells()[x][y];
        if (target.getPossibilities().size() == 1) {
          target.setValue(target.getPossibilities().get(0));
          progress = true;
        }
      }
    }
    return progress;
  }
}
