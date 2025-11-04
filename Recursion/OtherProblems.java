public class OtherProblems {

  // tile problem
  public static int tilingProblem(int n) {
    // base case
    if (n == 1 || n == 0) {
      return 1;
    }
    // // kaam
    // // vertical choice
    // int fnm1 = tilingProblem(n - 1);

    // // horizontal choice
    // int fnm2 = tilingProblem(n - 2);

    // int totways = fnm1 + fnm2;

    // return totways;

    return tilingProblem(n - 1) + tilingProblem(n - 2);

  }

  // remove duplicates from a given string
  public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
    if (idx == str.length()) {
      System.out.println(newStr);
      return;
    }

    char currChar = str.charAt(idx);
    if (map[currChar - 'a'] == true) {
      // duplicate
      removeDuplicates(str, idx + 1, newStr, map);
    } else {
      map[currChar - 'a'] = true;
      removeDuplicates(str, idx + 1, newStr.append(currChar), map);
    }
  }

  // friends pairing
  public static int friendsPair(int n) {
    if (n == 1 || n == 2) {
      return n;
    }

    // // choice
    // // single
    // int fnm1 = friendsPair(n - 1);

    // // pairing
    // int fnm2 = friendsPair(n - 2);
    // int pairways = (n - 1) * fnm2;

    // // total ways
    // int totways = fnm1 + pairways;

    // return totways;

    return friendsPair(n - 1) + (n - 1) * friendsPair(n - 2);
  }

  // print binary string of character N without consecutive ones
  public static void binaryStrings(int n, int lastPlace, String str) {
    // kaam
    // if (lastPlace == 0) {
    // // sit 0 on chair
    // binaryStrings(n - 1, 0, str.append("0"));
    // binaryStrings(n - 1, 1, str.append("1"));
    // } else {
    // binaryStrings(n - 1, 0, str.append("0"));
    // }

    // base case
    if (n == 0) {
      System.out.println(str);
      return;
    }

    binaryStrings(n - 1, 0, str + "0");
    if (lastPlace == 0) {
      binaryStrings(n - 1, 1, str + "1");
    }
  }

  public static void main(String args[]) {
    // System.out.println(tilingProblem(3));

    // String str = "apppnnacollege";
    // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

    // System.out.println(friendsPair(3));
    binaryStrings(3, 0, "");
  }

}
