import java.util.*;

public class DP4 {
  public static int LCSubstring(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();
    int dp[][] = new int[n + 1][m + 1];
    int ans = 0;

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          ans = Math.max(ans, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }

    return ans;
  }

  // for array inputs
  public static int LCS(int[] arr1, int[] arr2) {
    int n = arr1.length;
    int m = arr2.length;

    int dp[][] = new int[n + 1][m + 1];

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (arr1[i - 1] == arr2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          int ans1 = dp[i - 1][j];
          int ans2 = dp[i][j - 1];
          dp[i][j] = Math.max(ans1, ans2);
        }
      }
    }

    return dp[n][m];
  }

  // for string inputs
  public static int LCSTab(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();
    int dp[][] = new int[n + 1][m + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          int ans1 = dp[i - 1][j];
          int ans2 = dp[i][j - 1];
          dp[i][j] = Math.max(ans1, ans2);
        }
      }
    }

    return dp[n][m];
  }

  public static int LIS(int[] arr1) {
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < arr1.length; i++) {
      set.add(arr1[i]);
    }

    int arr2[] = new int[set.size()]; // array for sorted unique eles
    int i = 0;

    for (int num : set) {
      arr2[i] = num;
      i++;
    }

    Arrays.sort(arr2); // ascending order

    return LCS(arr1, arr2);
  }

  public static int EditDistance(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();
    int dp[][] = new int[n + 1][m + 1];

    // initialization
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0) {
          dp[i][j] = j;
        }
        if (j == 0) {
          dp[i][j] = i;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // same
          dp[i][j] = dp[i - 1][j - 1];
        } else { // diff
          int add = dp[i][j - 1] + 1;
          int del = dp[i - 1][j] + 1;
          int rep = dp[i - 1][j - 1] + 1;

          dp[i][j] = Math.min(add, Math.min(del, rep));
        }
      }
    }

    return dp[n][m];

  }

  public static int stringConversion(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();

    int lcs = LCSTab(str1, str2);

    int delOpns = n - lcs;
    int addOpns = m - lcs;

    return delOpns + addOpns;
  }

  public static void main(String[] args) {
    // largest common substring
    // String str1 = "ABCDE";
    // String str2 = "ABGCE";

    // System.out.println(LCSubstring(str1, str2));

    // largest increasing subsequence
    // int[] arr = { 50, 3, 10, 7, 40, 80 };
    // System.out.println(LIS(arr));

    // edit distance
    // String word1 = "intention";
    // String word2 = "execution";
    // System.out.println(EditDistance(word1, word2));

    // string conversion
    String word1 = "pear";
    String word2 = "sea";

    System.out.println(stringConversion(word1, word2));

  }
}