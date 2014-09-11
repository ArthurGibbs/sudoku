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
  public void canSolveFinalBoxOption() {
    String problem =
            "       |       |       \n"
          + "     4 |       |       \n"
          + "       |       | 4     \n"
          + "-------|-------|-------\n"
          + "       | 4     |       \n"
          + "       |       |       \n"
          + "       |       |       \n"
          + "-------|-------|-------\n"
          + "       |     4 |       \n"
          + "       |       |       \n"
          + "       |       |       \n";
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
            "       |   4   |       \n"
          + "     4 |       |       \n"
          + "       |       | 4     \n"
          + "-------|-------|-------\n"
          + "       | 4     |       \n"
          + "       |       |       \n"
          + "       |       |       \n"
          + "-------|-------|-------\n"
          + "       |     4 |       \n"
          + "       |       |       \n"
          + "       |       |       \n";
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }

  @Test
  public void canSolveFinalRowOption() {
    String problem =
            " 1 2 3 |       | 7 8 9 \n"
          + "       |       |       \n"
          + "       |       |       \n"
          + "-------|-------|-------\n"
          + "       |   6   |       \n"
          + "       |       |       \n"
          + "       |       |       \n"
          + "-------|-------|-------\n"
          + "       | 6     |       \n"
          + "       |       |       \n"
          + "       |       |       \n";
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
            "       |   4   |       \n"
          + "     4 |       |       \n"
          + "       |       | 4     \n"
          + "-------|-------|-------\n"
          + "       | 4     |       \n"
          + "       |       |       \n"
          + "       |       |       \n"
          + "-------|-------|-------\n"
          + "       |     4 |       \n"
          + "       |       |       \n"
          + "       |       |       \n";
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }


  @Test
  public void canSolvePage3() {
    String problem = " 1   5 |     6 |       \n"
                   + "       | 1 8 9 |       \n"
                   + " 8   3 | 7     | 9   4 \n"
                   + "-------|-------|-------\n"
                   + " 7 3   |       | 5 4   \n"
                   + "       |       |     9 \n"
                   + " 4 1   |       | 3 7   \n"
                   + "-------|-------|-------\n"
                   + " 9   1 | 6     | 4   8 \n"
                   + "       | 5 9 7 |       \n"
                   + "     2 |     4 |       \n";
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected = " 1 9 5 | 3 4 6 | 8 2 7 \n"
                    + " 2 4 7 | 1 8 9 | 6 3 5 \n"
                    + " 8 6 3 | 7 2 5 | 9 1 4 \n"
                    + "-------|-------|-------\n"
                    + " 7 3 8 | 9 6 1 | 5 4 2 \n"
                    + " 5 2 6 | 4 7 3 | 1 8 9 \n"
                    + " 4 1 9 | 2 5 8 | 3 7 6 \n"
                    + "-------|-------|-------\n"
                    + " 9 7 1 | 6 3 2 | 4 5 8 \n"
                    + " 3 8 4 | 5 9 7 | 2 6 1 \n"
                    + " 6 5 2 | 8 1 4 | 7 9 3 \n";
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }

  @Test
  public void canSolvePage69() {
    String problem =
              "       |   3 6 | 2     \n"
            + "       | 5 9   |     8 \n"
            + "   4 2 |       |       \n"
            + "-------|-------|-------\n"
            + "   6   |     7 | 1   4 \n"
            + "   2 4 | 9     |     3 \n"
            + "   8   |     3 | 9   5 \n"
            + "-------|-------|-------\n"
            + "   5 7 |       |       \n"
            + "       | 3 8   |     7 \n"
            + "       |   2 4 | 6     \n";
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
              "       |   3 6 | 2     \n"
            + "       | 5 9   |     8 \n"
            + "   4 2 |       |       \n"
            + "-------|-------|-------\n"
            + "   6   |     7 | 1   4 \n"
            + "   2 4 | 9     |     3 \n"
            + "   8   |     3 | 9   5 \n"
            + "-------|-------|-------\n"
            + "   5 7 |       |       \n"
            + "       | 3 8   |     7 \n"
            + "       |   2 4 | 6     \n";
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }

  @Test
  public void canSolvePage209() {
    String problem =
        "       | 2     |       \n"
      + "   4 1 |       | 3     \n"
      + "   3   |   1 6 | 4   2 \n"
      + "-------|-------|-------\n"
      + " 3     |       |       \n"
      + "     6 |     1 |       \n"
      + "     4 |   5   | 1 6 8\n"
      + "-------|-------|-------\n"
      + "   7 5 |     8 |     1 \n"
      + "       |     4 |     9 \n"
      + "     2 |     5 | 7 4   \n";
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
        "       |   3 6 | 2     \n"
      + "       | 5 9   |     8 \n"
      + "   4 2 |       |       \n"
      + "-------|-------|-------\n"
      + "   6   |     7 | 1   4 \n"
      + "   2 4 | 9     |     3 \n"
      + "   8   |     3 | 9   5 \n"
      + "-------|-------|-------\n"
      + "   5 7 |       |       \n"
      + "       | 3 8   |     7 \n"
      + "       |   2 4 | 6     \n";
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }


  private void solveAndEvaluate(Board problemBoard, Board expectedBoard) {
    solver = new Solver();
    solver.setBoard(problemBoard);
    Board resultBoard = solver.solve();
    System.out.println("Expected:\n" + expectedBoard.getBoardString());
    System.out.println("Got:\n" + resultBoard.getBoardString());
    assertThat(resultBoard.getBoardString(), is(expectedBoard.getBoardString()));
  }


}