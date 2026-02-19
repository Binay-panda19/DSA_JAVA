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

  public static void main(String[] args) {
    int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
    String s = "race";
    String t = "take";

    System.out.println(isAnagram(s, t));

    majorElement(arr);
  }
}