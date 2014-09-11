package com.company;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SolverTest {

  Solver solver;


  @Test
  public void canFinishRow(){
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
    Board board = new Board();
    board.set(0,0,1);
    board.set(1,0,2);
    board.set(2,0,3);
    board.set(3,0,4);
    board.set(4,0,5);
    board.set(5,0,6);
    board.set(6,0,7);
    board.set(7,0,8);
    //null here

    solver = new Solver();
    solver.setBoard(board);
    Board result = solver.solve();

    System.out.println("Expected:\n" + expected);
    System.out.println("Got:\n" + result.getBoardString());
    assertThat(result.getCells()[8][0].getValue(), is(9));
  }

  @Test
  public void canFinishCol() {
    String expected = " 1     |       |       \n"
                    + " 2     |       |       \n"
                    + " 3     |       |       \n"
                    + "-------|-------|-------\n"
                    + " 4     |       |       \n"
                    + " 5     |       |       \n"
                    + " 6     |       |       \n"
                    + "-------|-------|-------\n"
                    + " 7     |       |       \n"
                    + " 8     |       |       \n"
                    + " 9     |       |       \n";

    Board board = new Board();
    board.set(0, 0, 1);
    board.set(0, 1, 2);
    board.set(0, 2, 3);
    board.set(0, 3, 4);
    board.set(0, 4, 5);
    //null here
    board.set(0, 6, 7);
    board.set(0, 7, 8);
    board.set(0, 8, 9);

    solver = new Solver();
    solver.setBoard(board);
    Board result = solver.solve();

    System.out.println("Expected:\n" + expected);
    System.out.println("Got:\n" + result.getBoardString());
    assertThat(result.getCells()[0][5].getValue(), is(6));
  }

  @Test
  public void canFinishBox() {
    String expected = " 1 2 3 |       |       \n"
                    + " 4 5 6 |       |       \n"
                    + " 7 8 9 |       |       \n"
                    + "-------|-------|-------\n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "-------|-------|-------\n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "       |       |       \n";

    Board board = new Board();
    board.set(0, 0, 1);
    board.set(1, 0, 2);
    board.set(2, 0, 3);
    board.set(0, 1, 4);
    board.set(1, 1, 5);
    board.set(2, 1, 6);
    board.set(0, 2, 7);
    //null here
    board.set(2, 2, 9);


    solver = new Solver();
    solver.setBoard(board);
    Board result = solver.solve();

    System.out.println("Expected:\n" + expected);
    System.out.println("Got:\n" + result.getBoardString());
    assertThat(result.getCells()[1][2].getValue(), is(8));
  }

  @Test
  public void canChainSolves() {
    String expected = "   2 3 | 4 5 6 | 7 8   \n"
                    + "       |       | 4 5 6 \n"
                    + "       |       | 1 2 3 \n"
                    + "-------|-------|-------\n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "-------|-------|-------\n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "       |       |       \n";
    Board board = new Board();
    board.set(1,0,2);
    board.set(2,0,3);
    board.set(3,0,4);
    board.set(4,0,5);
    board.set(5,0,6);
    board.set(6,0,7);
    board.set(7,0,8);

    board.set(6,1,4);
    board.set(7,1,5);
    board.set(8,1,6);
    board.set(6,2,1);
    board.set(7,2,2);
    board.set(8,2,3);

    solver = new Solver();
    solver.setBoard(board);
    Board result = solver.solve();

    System.out.println("Expected:\n" + expected);
    System.out.println("Got:\n" + result.getBoardString());
    assertThat(result.getCells()[0][0].getValue(), is(1));
  }


  @Test
  public void canSolveFinalRowOption() {
    String expected = " 1 2 3 | 4 5 6 | 7     \n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "-------|-------|-------\n"
                    + "       |       |   9   \n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "-------|-------|-------\n"
                    + "       |       |       \n"
                    + "       |       |       \n"
                    + "       |       |       \n";
    Board board = new Board();
    board.set(0,0,1);
    board.set(1,0,2);
    board.set(2,0,3);
    board.set(3,0,4);
    board.set(4,0,5);
    board.set(5,0,6);
    board.set(6,0,7);
    board.set(7,3,9);

    solver = new Solver();
    solver.setBoard(board);
    Board result = solver.solve();

    System.out.println("Expected:\n" + expected);
    System.out.println("Got:\n" + result.getBoardString());
    assertThat(result.getCells()[0][0].getValue(), is(1));
  }




}