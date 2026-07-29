public class DP5 {

  public static boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();
    boolean dp[][] = new boolean[n + 1][m + 1];

    // initialization
    dp[0][0] = true;

    // p == " "
    for (int i = 1; i < n + 1; i++) {
      dp[i][0] = false;
    }
    // s == " "
    for (int i = 1; i < m + 1; i++) {
      if (p.charAt(i - 1) == '*') {
        dp[0][i] = dp[0][i - 1];
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        // ith char == jth char || jth char == ?
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        }
        // jth char == *
        else if (p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
        }
        // any other case
        else
          dp[i][j] = false;
      }
    }
    return dp[n][m];
  }

  public static int Catalan(int n) {
    if (n == 0 || n == 1)
      return 1;

    int ans = 0;

    for (int i = 0; i < n; i++) {
      ans += Catalan(i) * Catalan(n - i - 1);
    }

    return ans;
  }

  public static int CatalanMemo(int n, int[] dp) {
    if (n == 0 || n == 1)
      return 1;

    if (dp[n] != 0)
      return dp[n];

    int ans = 0;

    for (int i = 0; i < n; i++) {
      ans += CatalanMemo(i, dp) * CatalanMemo(n - i - 1, dp);
    }

    return dp[n] = ans;
  }

  public static int CatalanTab(int n) { // O(n2)
    int dp[] = new int[n + 1];

    dp[0] = dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {

    // wildcard matching
    // String s = "baaabab";
    // String p = "*****ba*****ab";

    // System.out.println(isMatch(s, p));

    // catalans number
    int n = 3;
    int[] dp = new int[n + 1];

    System.out.println(Catalan(n));
    System.out.println(CatalanMemo(n, dp));
    System.out.println(CatalanTab(n));
  }
}