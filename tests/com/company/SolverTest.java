package com.company;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SolverTest {

  Solver solver;

  @Test
  public void canFinishRow(){
    String problem =
            " 1 2 3 | 4 5   | 7 8 9 \n"
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
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
            " 1 2 3 | 4 5 6 | 7 8 9 \n"
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

    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }

  @Test
  public void canFinishCol() {
    String problem =
            " 1     |       |       \n"
          + " 2     |       |       \n"
          + " 3     |       |       \n"
          + "-------|-------|-------\n"
          + " 4     |       |       \n"
          + "       |       |       \n"
          + " 6     |       |       \n"
          + "-------|-------|-------\n"
          + " 7     |       |       \n"
          + " 8     |       |       \n"
          + " 9     |       |       \n";
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
            " 1     |       |       \n"
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
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }

  @Test
  public void canFinishBox() {
    String problem =
            " 1 2 3 |       |       \n"
          + " 4 5 6 |       |       \n"
          + " 7 8   |       |       \n"
          + "-------|-------|-------\n"
          + "       |       |       \n"
          + "       |       |       \n"
          + "       |       |       \n"
          + "-------|-------|-------\n"
          + "       |       |       \n"
          + "       |       |       \n"
          + "       |       |       \n";
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
            " 1 2 3 |       |       \n"
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
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }

  @Test
  public void canChainSolves() {
    String problem =
            "   2 3 | 4 5 6 | 7 8   \n"
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
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
            " 1 2 3 | 4 5 6 | 7 8 9 \n"
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
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
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
            " 1 2 3 |     6 | 7 8 9 \n"
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
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }

  @Test
  public void canSolveFinalColOption() {
    String problem =
            " 1     |       |       \n"
          + " 2     |       |       \n"
          + " 3     |       |       \n"
          + "-------|-------|-------\n"
          + "       |   6   |       \n"
          + "       |       |   6   \n"
          + "       |       |       \n"
          + "-------|-------|-------\n"
          + " 7     |       |       \n"
          + " 8     |       |       \n"
          + " 9     |       |       \n";
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
            " 1     |       |       \n"
          + " 2     |       |       \n"
          + " 3     |       |       \n"
          + "-------|-------|-------\n"
          + "       |   6   |       \n"
          + "       |       |   6   \n"
          + " 6     |       |       \n"
          + "-------|-------|-------\n"
          + " 7     |       |       \n"
          + " 8     |       |       \n"
          + " 9     |       |       \n";
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }

  @Test
  public void canReserveOptionForCol() {
    String problem =
            " 1     |       |       \n"
          + " 2     |       |       \n"
          + " 3     |       |       \n"
          + "-------|-------|-------\n"
          + "       |       | 5 8 9 \n"
          + "       | 1 2 4 |       \n"
          + "       | 5 8 9 | 1 2 4 \n"
          + "-------|-------|-------\n"
          + " 7     |       |       \n"
          + " 8     |       |       \n"
          + " 9     |       |       \n";
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
            " 1     |       |       \n"
          + " 2     |       |       \n"
          + " 3     |       |       \n"
          + "-------|-------|-------\n"
          + " 4     |       | 5 8 9 \n"
          + " 5     | 1 2 4 |       \n"
          + " 6     | 5 8 9 | 1 2 4 \n"
          + "-------|-------|-------\n"
          + " 7     |       |       \n"
          + " 8     |       |       \n"
          + " 9     |       |       \n";
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
              " 8 7 5 | 4 3 6 | 2 9 1 \n"
            + " 6 1 3 | 5 9 2 | 7 4 8 \n"
            + " 9 4 2 | 1 7 8 | 5 3 6 \n"
            + "-------|-------|-------\n"
            + " 3 6 9 | 8 5 7 | 1 2 4 \n"
            + " 5 2 4 | 9 6 1 | 8 7 3 \n"
            + " 7 8 1 | 2 4 3 | 9 6 5 \n"
            + "-------|-------|-------\n"
            + " 4 5 7 | 6 1 9 | 3 8 2 \n"
            + " 2 9 6 | 3 8 5 | 4 1 7 \n"
            + " 1 3 8 | 7 2 4 | 6 5 9 \n";

    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }

  @Test
  public void canSolvePage209() {
    String problem =
      "       | 2     |       \n" +
      "   4 1 |       | 3     \n" +
      "   3   |   1 6 | 4   2 \n" +
      "-------|-------|-------\n" +
      " 3     |       |       \n" +
      "     6 |     1 |       \n" +
      "     4 |   5   | 1 6 8 \n" +
      "-------|-------|-------\n" +
      "   7 5 |     8 |     1 \n" +
      "       |     4 |     9 \n" +
      "     2 |     5 | 7 4   \n";
    Board problemBoard = new Board();
    problemBoard.fromString(problem);

    String expected =
      " 6 8 7 | 2 4 3 | 9 1 5 \n" +
      " 2 4 1 | 5 9 7 | 3 8 6 \n" +
      " 5 3 9 | 8 1 6 | 4 7 2 \n" +
      "-------|-------|-------\n" +
      " 3 1 8 | 6 7 2 | 5 9 4 \n" +
      " 9 5 6 | 4 8 1 | 2 3 7 \n" +
      " 7 2 4 | 3 5 9 | 1 6 8 \n" +
      "-------|-------|-------\n" +
      " 4 7 5 | 9 3 8 | 6 2 1 \n" +
      " 1 6 3 | 7 2 4 | 8 5 9 \n" +
      " 8 9 2 | 1 6 5 | 7 4 3 \n";
    Board expectedBoard = new Board();
    expectedBoard.fromString(expected);

    solveAndEvaluate(problemBoard, expectedBoard);
  }


  private void solveAndEvaluate(Board problemBoard, Board expectedBoard) {
    solver = new Solver();
    solver.setBoard(problemBoard);
    Board resultBoard = solver.solve();
    if (!expectedBoard.equals(resultBoard)) {
      System.out.println("Expected:\n" + expectedBoard.getBoardString());
      System.out.println("Got:\n" + resultBoard.getBoardString());
    }
    assertTrue(resultBoard.equals(expectedBoard));
  }


}