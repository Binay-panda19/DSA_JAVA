import java.util.HashSet;

public class HashSetQues {

  public static void distinctElements(int[] nums) {
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }

    System.out.println(set.size());
  }

  public static void union(int arr1[], int arr2[]) {
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < arr1.length; i++) {
      set.add(arr1[i]);
    }

    for (int i = 0; i < arr2.length; i++) {
      set.add(arr2[i]);
    }

    System.out.println("Union: " + set.size());
  }

  public static void intersection(int arr1[], int arr2[]) {
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < arr1.length; i++) {
      set.add(arr1[i]);
    }
    int count = 0;
    for (int i = 0; i < arr2.length; i++) {
      if (set.contains(arr2[i])) {
        count++;
        set.remove(arr2[i]);
      }
    }

    System.out.println("Intersection: " + count);
  }

  public static void main(String[] args) {
    int nums[] = { 4, 3, 5, 6, 7, 4, 3, 1, 2 };

    int arr1[] = { 7, 3, 9 };
    int arr2[] = { 6, 3, 9, 2, 9, 4 };

    union(arr1, arr2);
    intersection(arr1, arr2);

    // distinctElements(nums);
  }
}