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

  // string compression
  public static int compress(char[] chars) {

    int index = 0; // position to write
    int i = 0; // scanning pointer

    while (i < chars.length) {

      char current = chars[i];
      int count = 0;

      // count repeating characters
      while (i < chars.length && chars[i] == current) {
        i++;
        count++;
      }

      // write the character
      chars[index++] = current;

      // write count if greater than 1
      if (count > 1) {
        String num = Integer.toString(count);
        for (char c : num.toCharArray()) {
          chars[index++] = c;
        }
      }
    }

    return index;
  }

  public static StringBuilder compress2(String str) {

    StringBuilder s = new StringBuilder("");

    int i = 0; // scanning pointer

    while (i < str.length()) {

      char current = str.charAt(i);
      int count = 0;

      // count repeating characters
      while (i < str.length() && str.charAt(i) == current) {
        i++;
        count++;
      }

      // write the character
      s.append(current);

      // write count if greater than 1
      if (count > 1) {
        String num = Integer.toString(count);
        s.append(num);
      }
    }

    return s;
  }

  public static void main(String[] args) {
    // String str = "binay";
    // isPalindrome(str);

    char[] chars = { 'a', 'a', 'a', 'b', 'b', 'c', 'd', 'd', 'd' };

    String str = "aaabbcdddd";

    System.out.println(compress(chars));
    System.out.println(compress2(str));

    String dir = "WNEENESENNN";

    // System.out.println(getShortestPath(dir));

  }
}
