package com.company;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CellTest {

    private Cell cell;

    @Test
    public void newCellHas9Options() {
    cell = new Cell();
      List<Integer> result = cell.getPossibilities();
      assertThat(result, is(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    @Test
    public void optionsCanBeRemoved() {
      cell = new Cell();
      cell.removePossibilities(3);
      cell.removePossibilities(7);
      List<Integer> result = cell.getPossibilities();
      assertThat(result, is(Arrays.asList(1, 2, 4, 5, 6, 8, 9)));
    }

    @Test
    public void valueCanBeSet() {
      cell = new Cell();
      cell.setValue(4);
      List<Integer> result = cell.getPossibilities();
      assertThat(result, is(Arrays.asList(4)));
      assertThat(cell.getValue(), is(4));
    }
}