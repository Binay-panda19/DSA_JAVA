package Strings;

public class Strings {
  public static Boolean isPalindrome(String str) {
    int n = str.length();
    for (int i = 0; i < n / 2; i++) {
      if (str.charAt(i) != str.charAt(n - i - 1)) {
        System.out.println("This is not a palindrome.");
        return false;
      }
    }
    System.out.println("This string is a palindrome.");
    return true;
  }

  public static float getShortestPath(String str) {
    int n = str.length();
    int x = 0, y = 0;
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      if (ch == 'N') {
        y++;
      } else if (ch == 'S') {
        y--;
      } else if (ch == 'E') {
        x++;
      } else if (ch == 'W') {
        x--;
      }
    }
    int x2 = x * x;
    int y2 = y * y;
    int sum = x2 + y2;
    return (float) Math.sqrt(sum);
  }

  public static void main(String[] args) {
    // String str = "binay";
    // isPalindrome(str);

    String dir = "WNEENESENNN";

    System.out.println(getShortestPath(dir));

  }
}
