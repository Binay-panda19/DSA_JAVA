import java.util.Arrays;
import java.util.stream.Gatherer.Integrator;

public class DP6 {

  // recursion
  public static int mcm(int[] arr, int i, int j) {
    if (i == j) {
      return 0;
    }

    int ans = Integer.MAX_VALUE;

    for (int k = i; k <= j - 1; k++) {
      int cost1 = mcm(arr, i, k);
      int cost2 = mcm(arr, k + 1, j);
      int cost3 = arr[i - 1] * arr[k] * arr[j];
      int finalCost = cost1 + cost2 + cost3;

      ans = Math.min(ans, finalCost);
    }

    return ans;
  }

  public static int mcmMemo(int[] arr, int i, int j, int dp[][]) {
    if (i == j) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int ans = Integer.MAX_VALUE;

    for (int k = i; k <= j - 1; k++) {
      int cost1 = mcmMemo(arr, i, k, dp);
      int cost2 = mcmMemo(arr, k + 1, j, dp);
      int cost3 = arr[i - 1] * arr[k] * arr[j];
      int finalCost = cost1 + cost2 + cost3;

      ans = Math.min(ans, finalCost);
    }

    return dp[i][j] = ans;
  }

  public static int mcmTab(int[] arr) {
    int n = arr.length;
    int dp[][] = new int[n][n];

    // initialization
    for (int k = 0; k < dp.length; k++) {
      dp[k][k] = 0;
    }

    for (int len = 2; len <= n - 1; len++) {
      for (int i = 1; i <= (n - len); i++) {
        int j = i + len - 1;
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
          int cost1 = dp[i][k];
          int cost2 = dp[k + 1][j];
          int cost3 = arr[i - 1] * arr[k] * arr[j];
          dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
        }
      }
    }
    print(dp);
    return dp[1][n - 1];
  }

  public static void print(int dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static int minPartition(int arr[]) {
    int n = arr.length;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    int W = sum / 2;
    int dp[][] = new int[n + 1][W + 1];

    // initialization
    for (int i = 0; i < dp.length; i++) { // 0th row
      dp[i][0] = 0;
    }

    for (int i = 0; i < dp[0].length; i++) { // 0th col
      dp[0][i] = 0;
    }

    // bottom up
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < W + 1; j++) {
        if (arr[i - 1] <= j) { // valid
          int incProfit = arr[i - 1] + dp[i - 1][j - arr[i - 1]];
          int excProfit = dp[i - 1][j];
          dp[i][j] = Math.max(incProfit, excProfit);
        } else { // invalid
          int excProfit = dp[i - 1][j];
          dp[i][j] = excProfit;
        }
      }
    }

    int sum1 = dp[n][W];
    int sum2 = sum - sum1;

    return Math.abs(sum2 - sum1);
  }

  public static int minArrJumps(int[] arr) {
    int n = arr.length;
    int dp[] = new int[n];

    Arrays.fill(dp, -1);
    dp[n - 1] = 0;

    for (int i = n - 2; i >= 0; i--) {
      int steps = arr[i];
      int ans = Integer.MAX_VALUE;
      for (int j = i + 1; j <= steps + i && j < n; j++) {
        if (dp[j] != -1) {
          ans = Math.min(ans, arr[j] + 1);
        }
      }
      if (ans != Integer.MAX_VALUE) {
        dp[i] = ans;
      }
    }
    return dp[0];
  }

  public static void main(String[] args) {
    // matric chain multiplication
    int arr[] = { 1, 2, 3, 4, 3 };
    int n = arr.length;

    int dp[][] = new int[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    // System.out.println("MCM Recursion = " + mcm(arr, 1, n - 1));
    // System.out.println("MCM Memo = " + mcmMemo(arr, 1, n - 1, dp));
    // System.out.println("MCM Tab = " + mcmTab(arr));

    // Min Partition
    // int[] arr1 = { 1, 6, 5, 11 };
    // System.out.println(minPartition(arr1));

    int[] arr2 = { 2, 3, 1, 1, 4 };

    System.err.println(minArrJumps(arr2));

  }
}