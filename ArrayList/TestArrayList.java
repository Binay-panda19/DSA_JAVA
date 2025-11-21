import java.util.ArrayList;

public class TestArrayList {

  public static int max(ArrayList<Integer> list) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < list.size(); i++) {
      max = Math.max(max, list.get(i));
    }

    return max;
  }

  // brute force - O(n^2)
  public static int storeWater(ArrayList<Integer> height) {
    int maxWater = 0;

    for (int i = 0; i < height.size(); i++) {
      for (int j = i + 1; j < height.size(); j++) {
        int ht = Math.min(height.get(i), height.get(j));
        int wt = j - i;
        int currWater = ht * wt;
        maxWater = Math.max(maxWater, currWater);
      }
    }

    return maxWater;
  }

  // 2 -pointer approach - O(n)
  public static int storeWater2(ArrayList<Integer> height) {
    int maxWater = 0;
    int lp = 0;
    int rp = height.size() - 1;

    while (lp < rp) {
      // calculate water area
      int ht = Math.min(height.get(lp), height.get(rp));
      int wid = rp - lp;
      int currWater = ht * wid;
      maxWater = Math.max(maxWater, currWater);

      // update pointer
      if (height.get(lp) < height.get(rp)) {
        lp++;
      } else {
        rp--;
      }
    }

    return maxWater;
  }

  public static boolean pairSum1a(ArrayList<Integer> list, int target) {

    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(i) + list.get(j) == target) {
          return true;
        }
      }
    }
    return false;
  }

  // 2 - pointer approach
  public static boolean pairSum1b(ArrayList<Integer> list, int target) {
    int lp = 0;
    int rp = list.size() - 1;

    while (lp < rp) {
      if (list.get(lp) + list.get(rp) == target) {
        return true;
      } else if (list.get(lp) + list.get(rp) < target) {
        lp++;
      } else {
        rp--;
      }
    }

    return false;
  }

  public static boolean pairSum2(ArrayList<Integer> list, int target) {
    int bp = -1;
    int n = list.size();

    for (int i = 0; i < n; i++) {
      if (list.get(i) > list.get(i + 1)) {
        bp = i;
        break;
      }
    }

    int lp = bp + 1;
    int rp = bp;

    while (lp != rp) {
      // case 1
      if (list.get(lp) + list.get(rp) == target) {
        return true;
      } else if (list.get(lp) + list.get(rp) < target) {
        lp = (lp + 1) % n;
      } else {
        rp = (n + rp - 1) % n;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    ArrayList<Integer> height = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    // 1,8,6,2,5,4,8,3,7
    // height.add(1);
    // height.add(8);
    // height.add(6);
    // height.add(2);
    // height.add(5);
    // height.add(4);
    // height.add(8);
    // height.add(3);
    // height.add(7);

    // System.out.println(storeWater2(height));

    list.add(11);
    list.add(15);
    list.add(6);
    list.add(8);
    list.add(9);
    list.add(10);

    int target = 100;

    // System.out.println(pairSum1a(list, target));
    // System.out.println(pairSum1b(list, target));
    System.out.println(pairSum2(list, target));

    // System.out.println(max(list));

    // System.out.println(list);

    // System.out.println(list.get(2));

    // list.remove(2);
    // System.out.println(list);

    // list.set(2, 10);
    // System.out.println(list.contains(23));

    // print reverse of arraylist - O(n)
    // for (int i = list.size() - 1; i >= 0; i--) {
    // System.out.print(list.get(i) + " ");
    // }
    // System.out.println();
  }
}
