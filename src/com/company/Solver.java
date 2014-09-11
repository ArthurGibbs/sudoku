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
      for (int y = 0; y < 9; y++) {
        for (int x = 0; x < 9; x++) {
          Cell target = board_.getCell(x, y);
          if (target.getOptions().size() == 1) {
            target.setValue(target.getOptions().get(0));
            progress = true;
          }
        }
      }
    }
    return board_;
  }
}
