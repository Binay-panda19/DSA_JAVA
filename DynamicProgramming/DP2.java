public class DP2 {

  public static int Knapsack(int val[], int wt[], int W, int n) {

    if (W == 0 || n == 0) {
      return 0;
    }

    if (wt[n - 1] <= W) {
      // include
      int ans1 = val[n - 1] + Knapsack(val, wt, W - wt[n - 1], n - 1);

      // exclude
      int ans2 = Knapsack(val, wt, W, n - 1);

      return Math.max(ans1, ans2);
    } else {
      // exclude
      return Knapsack(val, wt, W, n - 1);
    }
  }

  public static int KnapsackMemo(int val[], int wt[], int W, int n, int dp[][]) {

    if (W == 0 || n == 0) {
      return 0;
    }

    if (dp[n][W] != -1) {
      return dp[n][W];
    }

    if (wt[n - 1] <= W) {
      // include
      int ans1 = val[n - 1] + KnapsackMemo(val, wt, W - wt[n - 1], n - 1, dp);

      // exclude
      int ans2 = KnapsackMemo(val, wt, W, n - 1, dp);

      dp[n][W] = Math.max(ans1, ans2);
      return dp[n][W];

    } else {
      // exclude
      dp[n][W] = KnapsackMemo(val, wt, W, n - 1, dp);
      return dp[n][W];
    }
  }

  public static int KnapsackTab(int val[], int wt[], int W) {
    int n = val.length;
    int dp[][] = new int[n + 1][W + 1];

    for (int i = 0; i < dp.length; i++) { // 0th row
      dp[i][0] = 0;
    }

    for (int i = 0; i < dp[0].length; i++) { // 0th col
      dp[0][i] = 0;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < W + 1; j++) {
        int v = val[i - 1]; // ith item value
        int w = wt[i - 1]; // ith item wt

        if (w <= j) { // valid
          int incProfit = v + dp[i - 1][j - w];
          int excProfit = dp[i - 1][j];
          dp[i][j] = Math.max(incProfit, excProfit);
        } else { // invalid
          int excProfit = dp[i - 1][j];
          dp[i][j] = excProfit;
        }
      }
    }
    // print(dp);
    return dp[n][W];
  }

  public static void print(boolean dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static boolean targetSumTab(int[] num, int sum) { // O(n*sum)
    int n = num.length;
    boolean dp[][] = new boolean[n + 1][sum + 1];

    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int k = 1; k < sum + 1; k++) {
        int val = num[i - 1];
        if (val <= k && dp[i - 1][k - val] == true) {
          dp[i][k] = true;
        } else if (dp[i - 1][k] == true) {
          dp[i][k] = true;
        }
      }
    }
    print(dp);
    return dp[n][sum];
  }

  public static int UnboundKnapsack(int val[], int wt[], int W) {
    int n = val.length;
    int dp[][] = new int[n + 1][W + 1];

    for (int i = 0; i < dp.length; i++) { // 0th row
      dp[i][0] = 0;
    }

    for (int i = 0; i < dp[0].length; i++) { // 0th col
      dp[0][i] = 0;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < W + 1; j++) {
        int v = val[i - 1]; // ith item value
        int w = wt[i - 1]; // ith item wt

        if (w <= j) { // valid
          int incProfit = v + dp[i][j - w];
          int excProfit = dp[i - 1][j];
          dp[i][j] = Math.max(incProfit, excProfit);
        } else { // invalid
          int excProfit = dp[i - 1][j];
          dp[i][j] = excProfit;
        }
      }
    }
    // print(dp);
    return dp[n][W];
  }

  public static void main(String[] args) {

    // knapsack
    int val[] = { 15, 14, 10, 45, 30 };
    int wt[] = { 2, 5, 1, 3, 4 };
    int W = 7;
    // int dp[][] = new int[val.length + 1][W + 1];
    // for (int i = 0; i < dp.length; i++) {
    // for (int j = 0; j < dp[0].length; j++) {
    // dp[i][j] = -1;
    // }
    // }

    // target sum
    // int[] num = { 4, 2, 7, 1, 3 };
    // int targetSum = 18;
    // System.out.println(targetSumTab(num, targetSum));

    // System.out.println(Knapsack(val, wt, W, val.length));

    // System.out.println(KnapsackMemo(val, wt, W, val.length, dp));

    // System.out.println(KnapsackTab(val, wt, W));

    System.out.println(UnboundKnapsack(val, wt, W));

  }
}