package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cell {
  private List<Integer> possibilities_ = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
  private Integer value_;
  private int x_;
  private int y_;
  private Board parent_;

  public Cell() {
  }

  public Cell(int x, int y, Board parent) {
    x_ = x;
    y_ = y;
    parent_ = parent;
  }

  public void setValue(int value) {
    this.value_ = value;
    possibilities_.clear();
    parent_.removePossibilityFromRow(y_, value);
    parent_.removePossibilityFromCol(x_, value);
    parent_.removePossibilityFromBox(x_ / 3, y_ / 3, value);
  }

  public Integer getValue() {
    return value_;
  }

  public List<Integer> getPossibilities() {
    return possibilities_;
  }

  public void removePossibilities(int i) {
    possibilities_.remove((Integer) i);
  }
}
