import java.util.*;

public class practice {

  public static void findMissingAndRepeatedValues(int[][] grid) {
    int[] sol = new int[2];
    int n = grid.length;
    // int[] arr = new int[n*n];
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] >= 1 && grid[i][j] <= n * n) {
          arr.add(grid[i][j]);
        }
      }
    }

    for (int i = 0; i < arr.size(); i++) {
      System.out.print(arr.get(i) + " ");
    }

    for (int i = 0; i < arr.size(); i++) {
      for (int j = 1; j <= n * n; j++) {
        if (!(arr.contains(j))) {
          sol[1] = j;
        }
      }

      int count = 0;
      Collections.sort(arr);

      for (int k = 0; k < arr.size(); k++) {
        if (arr.get(i) == arr.get(k)) {
          count++;
        }
      }

      if (count == 2) {
        sol[0] = arr.get(i);
      }

    }
    System.out.println();
    System.out.println(sol[0] + " " + sol[1]);

  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (nums1[i] == 0) {
          break;
        } else if (nums1[i] > nums2[j]) {
          int temp = nums1[i];
          nums1[i] = nums2[j];
          nums2[j] = temp;
        }

      }
    }

    for (int i = 0; i < m;) {
      for (int j = 0; j < n;) {
        if (nums1[m + i] == 0) {
          nums1[m + i] = nums2[j];
          i++;
          j++;
        }
      }
    }

  }

  public static void main(String[] args) {

    int[][] grid = { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } };
    int[] nums1 = { 1, 2, 3, 0, 0, 0 }, nums2 = { 2, 5, 6 };
    int m = 3, n = 3;

    // findMissingAndRepeatedValues(grid);
    merge(nums1, m, nums2, n);
    for (int i = 0; i < nums1.length; i++) {
      System.out.println(nums1[i]);
    }

  }
}
