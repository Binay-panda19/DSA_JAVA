public class Backtracking {

  public static void changeArr(int arr[], int i, int val) {
    // base case
    if (i == arr.length) {
      printArr(arr);
      return;
    }

    // recursion (kaam)
    arr[i] = val;
    changeArr(arr, i + 1, val + 1); // fxn call step
    arr[i] = arr[i] - 2; // backtracking
  }

  public static void findSubsets(String str, String ans, int idx) {
    // base case
    if (idx == str.length()) {
      if (ans.length() == 0) {
        System.out.println("null");
      } else {
        System.out.println(ans);
      }
      return;
    }
    // recursion
    // Yes choice
    findSubsets(str, ans + str.charAt(idx), idx + 1);
    // No choice
    findSubsets(str, ans, idx + 1);
  }

  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void findPermutations(String str, String ans) {
    // base case
    if (str.length() == 0) {
      System.out.println(ans);
      return;
    }

    // abc
    // recursion
    for (int i = 0; i < str.length(); i++) {
      char curr = str.charAt(i);
      // "abcde" => "ab" + "de" => "abde"
      String newStr = str.substring(0, i) + str.substring(i + 1);  // "" + "bc"
      findPermutations(newStr, ans + curr);
    }
  }

  public static boolean isSafe(char board[][], int row, int col) {
    // vertical up
    for (int i = row - 1; i >= 0; i--) {
      if (board[i][col] == 'Q') {
        return false;
      }
    }

    // left diagonal up
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    // right diagonal up
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    return true;
  }

  public static void nQueens(char board[][], int row) {
    // base case
    if (row == board.length) {
      // printBoard(board);
      count++;
      return;
    }

    // column loop
    for (int i = 0; i < board.length; i++) {
      if (isSafe(board, row, i)) {
        board[row][i] = 'Q';
        nQueens(board, row + 1); // fxn call
        board[row][i] = 'X'; // backtracking
      }
    }
  }

  public static void printBoard(char board[][]) {
    System.out.println("--------Chess Board--------");
    System.out.println();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  static int count = 0;

  public static int gridWays(int i, int j, int n, int m) {
    // base case
    if (i == n - 1 && j == m - 1) {
      return 1;
    } else if (i == n || j == m) {
      return 0;
    }

    int w1 = gridWays(i + 1, j, n, m);
    int w2 = gridWays(i, j + 1, n, m);
    return w1 + w2;
  }

  public static boolean isPlace(int sudoku[][], int row, int col, int dig) {
    // column
    for (int i = 0; i <= 8; i++) {
      if (sudoku[i][col] == dig) {
        return false;
      }
    }

    // row
    for (int i = 0; i <= 8; i++) {
      if (sudoku[row][i] == dig) {
        return false;
      }
    }

    // grid
    int sr = (row / 3) * 3;
    int sc = (col / 3) * 3;
    for (int i = sr; i < sr + 3; i++) {
      for (int j = sc; j < sc + 3; j++) {
        if (sudoku[i][j] == dig) {
          return false;
        }
      }
    }

    return true;
  }

  public static boolean sudokuSolver(int sudoku[][], int row, int col) {
    // base case
    if (row == 9) {
      return true;
    }

    // recursion
    int nextRow = row, nextCol = col + 1;
    if (col + 1 == 9) {
      nextRow = row + 1;
      nextCol = 0;
    }

    if (sudoku[row][col] != 0) {
      return sudokuSolver(sudoku, nextRow, nextCol);
    }

    for (int dig = 1; dig <= 9; dig++) {
      if (isPlace(sudoku, row, col, dig)) {
        sudoku[row][col] = dig;
        if (sudokuSolver(sudoku, nextRow, nextCol)) {
          return true;
        }
        sudoku[row][col] = 0;
      }
    }

    return false;

  }

  public static void printSudoku(int sudoku[][]) {
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku.length; j++) {
        System.out.print(sudoku[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    // int arr[] = new int[5];
    String st = "abc";

    // changeArr(arr, 0, 1);
    // printArr(arr);
    // findSubsets(st, "", 0);
    // findPermutations(st, "");

    // int n = 4;
    // char board[][] = new char[n][n];
    // // initialize
    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < n; j++) {
    // board[i][j] = 'X';
    // }
    // }
    // nQueens(board, 0);
    // System.out.println("Total number of ways to solve N Queens = " + count);

    // int n = 3, m = 3;
    // System.out.println(gridWays(0, 0, n, m));

    // int sudoku[][] = {
    // { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
    // { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
    // { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
    // { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
    // { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
    // { 9, 6, 0, 4, 0, 5, 0, 0, 0 },
    // { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
    // { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
    // { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
    // };

    // if (sudokuSolver(sudoku, 0, 0)) {
    // System.out.println("solution exists");
    // printSudoku(sudoku);
    // } else {
    // System.out.println("solution does not exists");
    // }
  }
}