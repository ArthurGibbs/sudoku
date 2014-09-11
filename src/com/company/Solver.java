package com.company;

import java.util.Iterator;

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
      progress |= SinglePossibilityForCell();
      progress |= SinglePlaceForNumberInBlock();
      // final option for block/row/col( eg only place a 9 can go)
      // forward row col blocking(if the only place for a 7 can go in two places in a box but in the same row or coll you know it cant go in other cell in the row)
      // path finding
    }
    return board_;
  }

  private boolean SinglePlaceForNumberInBlock() {
    boolean progress = false;
    for (int by = 0; by < 3; by++) {
      for (int bx = 0; bx < 3; bx++) {
        Box box = board_.getBoxes()[bx][by];
        Iterator<Integer> iterator = box.getOptions_().iterator();
        while (iterator.hasNext()) {
          Integer next = iterator.next();
          int places = 0;
          Cell cell = null;
          for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
              if (box.getCells()[x][y].getPossibilities().contains(next)){
                places++;
                cell = box.getCells()[x][y];
              }
            }
          }
          if (places == 1 && cell != null) {
            iterator.remove();
            cell.setValue(next);
            progress = true;
          }
        }
      }
    }
    return progress;
  }

  private boolean SinglePossibilityForCell() {
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
