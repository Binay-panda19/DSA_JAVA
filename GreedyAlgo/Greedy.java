package GreedyAlgo;

import java.util.*;

public class Greedy {

  public static void activitieSelection(int[] start, int[] end) {
    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    // sorting if not sorted end array
    int activities[][] = new int[start.length][3];
    for (int i = 0; i < start.length; i++) {
      activities[i][0] = i;
      activities[i][1] = start[i];
      activities[i][2] = end[i];
    }

    // lambda func - shortform
    Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

    // 1st activity
    maxAct = 1;
    ans.add(0);
    int lastEnd = end[0];
    for (int i = 0; i < end.length; i++) {
      if (start[i] >= lastEnd) {
        // activity select
        maxAct++;
        ans.add(i);
        lastEnd = end[i];
      }
    }

    System.out.println("The max activities done:" + maxAct);

    for (int i = 0; i < ans.size(); i++) {
      System.out.print("A" + ans.get(i) + " ");
    }
    System.out.println();
  }

  public static void fractionalKnapsack(int[] value, int[] weight, int W) {

    double[][] ratio = new double[value.length][2];
    // 0th col - idx,1st col - ratio

    for (int i = 0; i < value.length; i++) {
      ratio[i][0] = i;
      ratio[i][1] = value[i] / (double) weight[i];
    }

    // ascending order
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

    int capacity = W;
    int finalVal = 0;

    for (int i = ratio.length - 1; i >= 0; i--) {
      int idx = (int) ratio[i][0];
      if (capacity >= weight[idx]) { // include full weight
        finalVal += value[idx];
        capacity -= weight[idx];
      } else { // include fractional weight
        finalVal += (ratio[i][1] * capacity);
        capacity = 0;
        break;
      }
    }

    System.out.println("the total value attained: " + finalVal);
  }

  public static void minAbsDiff(int[] A, int[] B) {
    int minDiff = 0;

    Arrays.sort(A);
    Arrays.sort(B);

    for (int i = 0; i < B.length; i++) {
      minDiff += Math.abs(A[i] - B[i]);
    }

    System.out.println("the minm abs diff: " + minDiff);
  }

  public static void maxLengthChain(int[][] pairs) {
    Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

    int chainLen = 1;
    int chainEnd = pairs[0][1]; // last selected pair end

    for (int i = 0; i < pairs.length; i++) {
      if (pairs[i][0] > chainEnd) {
        chainLen++;
        chainEnd = pairs[i][1];
      }
    }

    System.out.println("the max length of chain: " + chainLen);

  }

  public static void indianCoins(Integer[] coins, int val) {

    Arrays.sort(coins, Comparator.reverseOrder());
    ArrayList<Integer> ans = new ArrayList<>();
    int count = 0;

    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= val) {
        while (coins[i] <= val) {
          count++;
          ans.add(coins[i]);
          val -= coins[i];
        }
      }
    }

    System.out.println("the min coins used: " + count);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }
  }

  public static class Job {
    int deadline;
    int profit;
    int id;

    public Job(int i, int d, int p) {
      id = i;
      deadline = d;
      profit = p;
    }
  }

  public static void jobSequencing(int[][] jobInfo) {

    ArrayList<Job> jobs = new ArrayList<>();

    for (int i = 0; i < jobInfo.length; i++) {
      jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
    }

    Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

    ArrayList<Integer> seq = new ArrayList<>();
    int time = 0;
    for (int i = 0; i < jobs.size(); i++) {
      Job curr = jobs.get(i);
      if (curr.deadline > time) {
        seq.add(curr.id);
        time++;
      }
    }

    System.out.println("max jobs: " + seq.size());

    for (int i = 0; i < seq.size(); i++) {
      System.out.print(seq.get(i) + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {

    int[] start = { 1, 3, 0, 5, 8, 5 };
    int[] end = { 2, 4, 6, 7, 9, 9 };

    int[] value = { 60, 100, 120 };
    int[] weight = { 10, 20, 30 };
    int W = 50;

    int[] A = { 4, 1, 8, 7 };
    int[] B = { 2, 3, 6, 5 };

    // minAbsDiff(A, B);

    int[][] pairs = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

    Integer[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

    int[][] jobInfo = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

    jobSequencing(jobInfo);

    // indianCoins(coins, 590);

    // maxLengthChain(pairs);

    // fractionalKnapsack(value, weight, W);

    // activitieSelection(start, end);
  }
}