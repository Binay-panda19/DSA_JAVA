package Arrays;
// import java.util.*;

public class ArraysCC {

  // linear search
  public static int LinearSearch(int mark[], int key) {
    for (int i = 0; i <= mark.length; i++) {
      if (key == mark[i]) {
        return i;
      }
    }
    return -1;
  }

  // largest and smallest
  public static void LargestSmallest(int mark[]) {
    int largest = Integer.MIN_VALUE;
    for (int i = 0; i < mark.length; i++) {
      if (largest < mark[i]) {
        largest = mark[i];
      }
    }

    System.out.println("largest:" + largest);

    int smallest = Integer.MAX_VALUE;
    for (int i = 0; i < mark.length; i++) {
      if (smallest > mark[i]) {
        smallest = mark[i];
      }
    }

    System.out.println("smallest:" + smallest);
  }

  // reverse
  public static void reverse(int[] arr) {

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {

      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;

      left++;
      right--;
    }
  }

  // pairs
  public static void printPairs(int num[]) {
    for (int i = 0; i < num.length; i++) {
      for (int j = i + 1; j < num.length; j++) {
        System.out.print("(" + num[i] + "," + num[j] + ")");
      }
      System.out.println();
    }
  }

  // subarrays
  public static void printSubarray(int num[]) {
    int ts = 0;
    for (int i = 0; i <= num.length; i++) {
      int start = i;
      for (int j = i; j < num.length; j++) {
        int end = j;
        for (int k = start; k <= end; k++) {
          System.out.print("(" + num[k] + ")");
        }
        ts++;
        System.out.println();
      }
      System.out.println();
    }

    System.out.println("total subarrays:" + ts);
  }

  // kadane's algo
  public int maxSubArray(int[] nums) {

    int currentSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {

      currentSum = Math.max(nums[i], currentSum + nums[i]);
      maxSum = Math.max(maxSum, currentSum);

    }

    return maxSum;
  }

  // where we change negative sum to zero
  public int maxSubArray2(int[] nums) {

    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;

    for (int num : nums) {

      currentSum += num;

      maxSum = currentSum > maxSum ? currentSum : maxSum;

      currentSum = currentSum > 0 ? currentSum : 0;
    }

    return maxSum;
  }

  // trapped rainwater
  public static void rainwater(int height[]) {

    int n = height.length;

    // auxiliary left max boundary
    int leftMax[] = new int[n];
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    }

    int rightMax[] = new int[n];
    rightMax[n - 1] = height[n - 1];
    // auxiliary right max boundary
    for (int i = n - 2; i >= 0; i--) {
      rightMax[i] = Math.max(height[i], rightMax[i + 1]);
    }

    int trappedWater = 0;

    // loop
    for (int i = 0; i < n; i++) {
      int waterLevel = Math.min(leftMax[i], rightMax[i]);
      trappedWater += waterLevel - height[i];
    }
    // waterLevel = min(leftMax,rightMax)
    // trapped water = waterLevel - height[i]

    System.out.println("trapped rainwater : " + trappedWater);
  }

  public static void Buy_Sell(int prices[]) {
    int buyPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (buyPrice < prices[i]) {
        int profit = prices[i] - buyPrice;// today's profit
        maxProfit = Math.max(maxProfit, profit);// global profit
      } else {
        buyPrice = prices[i];
      }
    }
    System.out.println("the maximum profit for the stock is :" + maxProfit);
  }

  public static void main(String args[]) {
    // int marks[] = new int[5];

    // Scanner sc = new Scanner(System.in);
    // for (int i = 0; i < marks.length; i++) {
    // System.out.print("give a value to the array: ");
    // marks[i] = sc.nextInt();
    // }

    // marks[0] = 54;
    // marks[1] = 57;
    // marks[2] = 56;
    // marks[3] = 58;
    // marks[4] = 50;

    // System.out.println(marks[0]);

    // for (int i = 0; i <= 4; i++) {
    // System.out.println(marks[i]);
    // }

    // System.out.println("key is at :" + LinearSearch(marks, 50));
    // LargestSmallest(marks);

    // int num[] = { 2, 4, 6, 8, 10 };
    // printPairs(num);

    // int height[] = { 4, 2, 0, 6, 3, 2, 5 };

    // rainwater(height);

    int prices[] = { 7, 1, 5, 3, 6, 4 };

    Buy_Sell(prices);
  }
}
