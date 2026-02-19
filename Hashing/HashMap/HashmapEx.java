package HashMap;

import java.util.*;

public class HashmapEx {
  public static void main(String[] args) {

    HashMap<String, Integer> hm = new HashMap<>();
    LinkedHashMap<String, Integer> lhm = new LinkedHashMap();
    TreeMap<String, Integer> tm = new TreeMap();

    // put - O(1)
    hm.put("India", 150);
    hm.put("China", 100);
    hm.put("US", 50);
    hm.put("Indonesia", 5);
    hm.put("Nepal", 6);

    lhm.put("India", 150);
    lhm.put("China", 100);
    lhm.put("US", 50);
    lhm.put("Indonesia", 5);
    lhm.put("Nepal", 6);

    tm.put("India", 150);
    tm.put("China", 100);
    tm.put("US", 50);
    tm.put("Indonesia", 5);
    tm.put("Nepal", 6);

    System.out.println(hm);
    System.out.println(lhm);
    System.out.println(tm);

    // get - O(1)
    // System.out.println(hm.get("India")); // true
    // System.out.println(hm.get("Indonesia")); // false

    // remove - O(1)
    // System.out.println(hm.remove("China"));
    // System.out.println(hm);

    // size
    // System.out.println(hm.size());

    // isEmpty
    // hm.clear();
    // System.out.println(hm.isEmpty());

    // iterations - O(1)
    Set<String> keys = hm.keySet();

    for (String k : keys) {
      System.out.println("key=" + k + ",value=" + hm.get(k));
    }
  }
}