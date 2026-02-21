package HashMap;

import java.util.HashMap;
import java.util.Set;

public class HashMapQues {

  public static void majorElement(int arr[]) {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (hm.containsKey(arr[i])) {
        hm.put(arr[i], hm.get(arr[i]) + 1);
      } else {
        hm.put(arr[i], 1);
      }
    }

    Set<Integer> keys = hm.keySet();

    for (int k : keys) {
      if (hm.get(k) > arr.length / 3) {
        System.out.println("Major element=" + k);
      }
    }
  }

  public static void majorElementOpt(int arr[]) { // little optimised
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
    }

    for (int k : hm.keySet()) {
      if (hm.get(k) > arr.length / 3) {
        System.out.println("Major element=" + k);
      }
    }
  }

  public static boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      if (map.get(ch) != null) {
        if (map.get(ch) == 1) {
          map.remove(ch);
        } else {
          map.put(ch, map.get(ch) - 1);
        }
      } else {
        return false;
      }
    }
    return map.isEmpty();
  }

  public static String getStart(HashMap<String, String> tickets) {
    HashMap<String, String> revMap = new HashMap<>();

    for (String key : tickets.keySet()) {
      revMap.put(tickets.get(key), key);
    }

    for (String key : tickets.keySet()) {
      if (!revMap.containsKey(key)) {
        return key;
      }
    }

    return null;
  }

  public static void largestSubarray(int nums[]) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    // (sum,idx)

    int sum = 0, len = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (hm.containsKey(sum)) {
        len = Math.max(len, i - hm.get(sum));
      } else {
        hm.put(sum, i);
      }
    }

    System.out.println("the largest subarray with sum = 0 => " + len);

  }

  public static void subarrayEqualToK(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    // (sum,count)

    map.put(0, 1); // for the first element or any subarray equal to the whole array
    int sum = 0, ans = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (map.containsKey(sum - k)) {
        ans += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    System.out.println(ans);
  }

  public static void main(String[] args) {
    int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
    String s = "race";
    String t = "take";

    int nums[] = { 15, -2, 2, -8, 1, 7, 10, 23 };

    int arr1[] = { 10, 2, -2, -20, 10 };
    int k = -10;

    subarrayEqualToK(arr1, k);

    // largestSubarray(nums);

    HashMap<String, String> tickets = new HashMap<>();

    tickets.put("Chennai", "Bengaluru");
    tickets.put("Mumbai", "Delhi");
    tickets.put("Goa", "Chennai");
    tickets.put("Delhi", "Goa");

    String start = getStart(tickets);
    // System.out.print(start);

    // for (String _ : tickets.keySet()) {
    // System.out.print(" -> " + tickets.get(start));
    // start = tickets.get(start);
    // }

    // System.out.println(isAnagram(s, t));

    // majorElement(arr);
  }
}