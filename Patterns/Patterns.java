package Patterns;

public class Patterns {
  // Hollow rectangle
  public static void Hollow_rect(int rows, int cols) {
    // outer loop
    for (int i = 1; i <= rows; i++) {
      // inner loop - cols
      for (int j = 1; j <= cols; j++) {
        // cell-(i,j)
        if (i == 1 || i == rows || j == 1 || j == cols) { // boundary condition
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  // inverted and rotated pyramid
  public static void inverted_pyramid(int rows, int cols) {
    for (int i = 0; i <= rows; i++) {
      // spaces
      for (int j = 1; j <= (rows - i); j++) {
        System.out.print(" ");
      }
      // stars
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  // inverted pyramid with numbers
  public static void inverted_number(int rows) {
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= (rows - i + 1); j++) {
        System.out.print(j);

      }
      System.out.println();
    }
  }

  // FLOYD's Triangle
  public static void floyd_tri(int rows) {
    int n = 1;
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(n + " ");
        n++;
      }
      System.out.println();
    }
  }

  // 0-1 trinagle
  public static void ZeroOneTriangle(int rows) {
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= i; j++) {
        if ((i + j) % 2 == 0) {
          System.out.print("1");
        } else {
          System.out.print("0");
        }

        // if (n == 1) {
        // n = 0;
        // } else if (n == 0) {
        // n = 1;
        // }
      }
      System.out.println();
    }
  }

  // butterfly pattern
  public static void butterfly(int n) {
    // 1st half
    for (int i = 1; i <= n; i++) {
      // stars-i
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      // spaces-2*(n-i)
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      // stars-i
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    // 2nd half
    for (int i = n; i >= 1; i--) {
      // stars-i
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      // spaces-2*(n-i)
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      // stars-i
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  // solid rhombus
  public static void solid_rhombus(int n) {
    for (int i = 1; i <= n; i++) {
      // spaces
      for (int j = 1; j <= (n - i); j++) {
        System.out.print(" ");
      }
      // stars
      for (int j = 1; j <= n; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  // hollow rhombus
  public static void hollow_rhombus(int n) {
    for (int i = 1; i <= n; i++) {
      // spaces
      for (int j = 1; j <= (n - i); j++) {
        System.out.print(" ");
      }

      // hollow boundary line
      for (int j = 1; j <= n; j++) {
        if (i == 1 || i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  // diamond
  public static void diamond(int n) {
    // 1st half
    for (int i = 1; i <= n; i++) {
      // spaces-(n-1)
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      // stars-(2*i-1)
      for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    // 2nd half
    for (int i = n; i >= 1; i--) {
      // spaces-(n-1)
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      // stars-(2*i-1)
      for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    diamond(5);
  }
}