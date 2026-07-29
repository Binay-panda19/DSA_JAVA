public class DP3 {

  public static int CoinChange(int coin[], int sum) {
    int n = coin.length;
    int dp[][] = new int[n + 1][sum + 1];

    for (int i = 0; i < n + 1; i++) { // 0th row
      dp[i][0] = 1;
    }

    for (int i = 1; i < sum + 1; i++) { // 0th col
      dp[0][i] = 0;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (coin[i - 1] <= j) { // valid
          dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j];
        } else { // invalid
          dp[i][j] = dp[i - 1][j];
        }

      }
    }
    // print(dp);
    return dp[n][sum];
  }

  public static int RodCutting(int length[], int[] prices, int totRod) {
    int n = length.length;
    int dp[][] = new int[n + 1][totRod + 1];

    for (int i = 0; i < n + 1; i++) { // 0th row
      dp[i][0] = 0;
    }

    for (int i = 0; i < totRod + 1; i++) { // 0th col
      dp[0][i] = 0;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < totRod + 1; j++) {
        if (length[i - 1] <= j) { // valid
          dp[i][j] = Math.max(prices[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
        } else { // invalid
          dp[i][j] = dp[i - 1][j];
        }

      }
    }
    // print(dp);
    return dp[n][totRod];
  }

  public static int LCS(String str1, String str2, int n, int m) {
    if (n == 0 || m == 0) {
      return 0;
    }

    if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // same
      return LCS(str1, str2, n - 1, m - 1) + 1;
    } else { // diff
      int ans1 = LCS(str1, str2, n - 1, m);
      int ans2 = LCS(str1, str2, n, m - 1);
      return Math.max(ans1, ans2);
    }
  }

  public static int LCS(String str1, String str2, int n, int m, int[][] dp) {
    if (n == 0 || m == 0) {
      return 0;
    }

    if (dp[n][m] != -1) {
      return dp[n][m];
    }

    if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // same
      return dp[n][m] = LCS(str1, str2, n - 1, m - 1, dp) + 1;
    } else { // diff
      int ans1 = LCS(str1, str2, n - 1, m, dp);
      int ans2 = LCS(str1, str2, n, m - 1, dp);
      return dp[n][m] = Math.max(ans1, ans2);
    }

  }

  public static int LCSTab(String str1, String str2, int n, int m) {
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

  public static void main(String[] args) {
    // coin change
    // int[] coins = { 2, 5, 3, 6 };
    // int sum = 10;

    // System.out.println(CoinChange(coins, sum));

    // rod cutting
    // int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
    // int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20 };
    // int totRod = 8;

    // System.err.println(RodCutting(length, prices, totRod));

    // longest common subsequence
    String str1 = "ABCDE";
    String str2 = "ACEB";
    int n = str1.length();
    int m = str2.length();

    int dp[][] = new int[n + 1][m + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        dp[i][j] = -1;
      }
    }

    System.out.println("LCS recursion : " + LCS(str1, str2, n, m));
    System.out.println("LCS memoization : " + LCS(str1, str2, n, m, dp));
    System.out.println("LCS Tabulation : " + LCSTab(str1, str2, n, m));

  }
}