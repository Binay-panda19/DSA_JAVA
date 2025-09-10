package Matrix;

// import java.util.Scanner;

public class Matrix {
  public static boolean Search(int matrix[][], int key) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[1][j] == key) {
          System.out.println("Found the element");
          return true;
        }
      }
    }
    System.out.println("the element not found");
    return false;
  }

  public static void SpiralMatrix(int matrix[][]) {

    int startRow = 0;
    int endRow = matrix.length - 1;
    int startCol = 0;
    int endCol = matrix.length - 1;

    while (startRow <= endRow && startCol <= endCol) {
      // print top
      for (int i = startCol; i <= endCol; i++) {
        System.out.print(matrix[startRow][i] + " ");
      }

      // print right
      for (int i = startRow + 1; i <= endRow; i++) {
        System.out.print(matrix[i][endCol] + " ");
      }

      // print bottom
      for (int i = endCol - 1; i >= startCol; i--) {
        if (startRow == endRow) {
          break;
        }
        System.out.print(matrix[endRow][i] + " ");
      }

      // print left
      for (int i = endRow - 1; i >= startRow + 1; i--) {
        if (startCol == endCol) {
          break;
        }
        System.out.print(matrix[i][startCol] + " ");
      }
      startRow++;
      startCol++;
      endRow--;
      endCol--;
    }
    System.out.println();
  }

  public static void diagonalSum(int matrix[][]) {
    // int priSum = 0;
    // int secSum = 0;
    // int totalSum = 0;
    // for (int i = 0; i < matrix.length; i++) {
    // for (int j = 0; j < matrix.length; j++) {
    // // primary sum
    // if (i == j) {
    // priSum += matrix[i][j];
    // }

    // // secondary sum
    // if (i + j == matrix.length - 1) {
    // secSum += matrix[i][j];
    // }
    // }
    // }
    // totalSum = priSum + secSum;
    // System.out.println("total sum for matrix diagonal is:" + totalSum);
    // System.out.println(secSum + "," + priSum);

    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      // pd
      sum += matrix[i][i];
      // sd
      if (i != matrix.length - 1 - i) {
        sum += matrix[i][matrix.length - 1 - i];
      }
    }

    System.out.println("total sum :" + sum);
  }

  public static boolean StaircaseSearch(int matrix[][], int key) {
    int row = 0;
    int col = matrix[0].length - 1;

    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] == key) {
        System.out.println("found key at :" + "(" + row + "," + col + ")");
        return true;
      } else if (key < matrix[row][col]) {
        col--;
      } else {
        row++;
      }
    }
    System.out.println("key not found");
    return false;
  }

  public static void main(String args[]) {

    int matrix[][] = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 }
    };

    int sortedMatrix[][] = {
        { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 50 }
    };
    // Scanner sc = new Scanner(System.in);
    // for (int i = 0; i < matrix.length; i++) {
    // for (int j = 0; j < matrix[0].length; j++) {
    // matrix[i][j] = sc.nextInt();
    // }
    // }

    // output
    // for (int i = 0; i < matrix.length; i++) {
    // for (int j = 0; j < matrix[0].length; j++) {
    // System.out.println(matrix[i][j]);
    // ;
    // }
    // }

    // diagonalSum(matrix);
    StaircaseSearch(sortedMatrix, 27);
  }
}
