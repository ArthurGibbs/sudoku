package com.company;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

public class BoardTest {

  Board board;

  @Test
  public void newBoardInitializesCells() {
    board = new Board();
    assertNull(board.getCells()[1][2].getValue());
  }

  @Test
  public void canToStringBoard(){
    String expected = " 1 2 3 | 4 5 6 | 7 8 9 \n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "-------|-------|-------\n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "-------|-------|-------\n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "       |       |       \n";
    board = new Board();
    board.set(0,0,1);
    board.set(1,0,2);
    board.set(2,0,3);

    board.set(3,0,4);
    board.set(4,0,5);
    board.set(5,0,6);

    board.set(6,0,7);
    board.set(7,0,8);
    board.set(8,0,9);

    String result = board.getBoardString();
    assertThat(result, is(expected));
  }

}