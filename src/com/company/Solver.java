package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
      progress |= SinglePlaceForNumberInBlocks();
      progress |= SinglePlaceForNumberInRowsCols();
      progress |= BlockUnusableOptions();       //only does rows so far
      // forward row col blocking(if the only place for a 7 can go in two places in a box but in the same row or coll you know it cant go in other cell in the row)
      // path finding
    }
    return board_;
  }

  private boolean BlockUnusableOptions() {
    boolean progress = false;
    for (int by = 0; by < 3; by++) {
      for (int bx = 0; bx < 3; bx++) {
        Box box = board_.getBoxes()[bx][by];
        progress |= BlockUsusableRowOptionsInBox(box);
      }
    }
    return progress;
  }

  private boolean BlockUsusableRowOptionsInBox(Box box) {
    boolean progress = false;
    for (int y = 0; y < 3; y++) {
      List<Cell> rowCells = new ArrayList<Cell>();
      List<Integer> options = new ArrayList<Integer>();
      for (int x = 0; x < 3; x++) {
        Cell cell = box.getCell(x, y);
        rowCells.add(cell);
        if (cell.getValue() == null) {
          options.addAll(cell.getPossibilities());
        }
      }
      List<Cell> otherCells = new ArrayList(box.getCells());
      otherCells.removeAll(rowCells);
      for (int option : options) {
        boolean justRow = true;
        for (Cell cell : otherCells) {
          if (cell.getPossibilities().contains(option)) {
            justRow = false;
            break;
          }
        }
        if (justRow) {
          List<Cell> targetCells = new ArrayList<Cell>(board_.getRows()[box.getY()*3+y].getCells());
          targetCells.removeAll(rowCells);
          for (Cell cell : targetCells) {
            progress |= cell.removePossibilities(option);
        }
        }
      }
    }
    return progress;
  }

  private boolean SinglePlaceForNumberInRowsCols() {
    boolean progress = false;
    for (int by = 0; by < 9; by++) {
      RowCol rowcol = board_.getRows()[by];
      progress |= SolveSingleOptionInCollection(rowcol.getCells(), rowcol.getOptions());
    }
    for (int by = 0; by < 9; by++) {
      RowCol rowcol = board_.getCols()[by];
      progress |= SolveSingleOptionInCollection(rowcol.getCells(), rowcol.getOptions());
    }
    return progress;
  }

  private boolean SinglePlaceForNumberInBlocks() {
    boolean progress = false;
    for (int by = 0; by < 3; by++) {
      for (int bx = 0; bx < 3; bx++) {
        Box box = board_.getBoxes()[bx][by];
        progress |= SolveSingleOptionInCollection(box.getCells(), box.getOptions_());
      }
    }
    return progress;
  }

  private boolean SolveSingleOptionInCollection(List<Cell> cells, List<Integer> options_) {
    boolean progress = false;
    Iterator<Integer> iterator = options_.iterator();
    while (iterator.hasNext()) {
      Integer option = iterator.next();
      int places = 0;
      Cell targetCell = null;
      for (Cell loopCell: cells) {
          Cell cellInQuestion = loopCell;
          if (cellInQuestion.getValue() == null && cellInQuestion.getPossibilities().contains(option)){
            places++;
            targetCell = cellInQuestion;
          }
      }
      if (places == 1 && targetCell != null) {
        iterator.remove();
        targetCell.setValue(option);
        progress = true;
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
