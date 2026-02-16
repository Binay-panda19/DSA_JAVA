import java.util.*;

public class HeapsEX {

  static class Heap {
    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data) {
      // add the data at last
      arr.add(data);

      int x = arr.size() - 1; // x is the index of child
      int par = (x - 1) / 2; // parent index

      while (arr.get(x) < arr.get(par)) {
        int temp = arr.get(x);
        arr.set(x, arr.get(par));
        arr.set(par, temp);

        x = par;
        par = (x - 1) / 2;
      }
    }

    public int peek() {
      return arr.get(0);
    }

    private void heapify(int i) { // O(log n)
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      int minIdx = i;

      if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
        minIdx = left;
      }

      if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
        minIdx = right;
      }

      if (minIdx != i) {
        // swap
        int temp = arr.get(i);
        arr.set(i, arr.get(minIdx));
        arr.set(minIdx, temp);

        heapify(minIdx);
      }
    }

    public int remove() { // O(log n)

      int data = arr.get(0);

      // swap first and last
      int temp = arr.get(0);
      arr.set(0, arr.get(arr.size() - 1));
      arr.set(arr.size() - 1, temp);

      // delete last
      arr.remove(arr.size() - 1);

      heapify(0);

      return data;

    }

    public boolean isEmpty() {
      return arr.size() == 0;
    }
  }

  public static void heapify(int[] arr, int i, int size) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int maxIdx = i;

    if (left < size && arr[maxIdx] < arr[left]) {
      maxIdx = left;
    }

    if (right < size && arr[maxIdx] < arr[right]) {
      maxIdx = right;
    }

    if (maxIdx != i) {
      // swap
      int temp = arr[i];
      arr[i] = arr[maxIdx];
      arr[maxIdx] = temp;

      heapify(arr, maxIdx, size);
    }

  }

  public static void heapSort(int[] arr) {
    // step1 build maxHeap
    int n = arr.length;
    for (int i = n / 2; i >= 0; i--) {
      heapify(arr, i, n);
    }

    // step2 push largest to the end
    for (int i = n - 1; i > 0; i--) {
      // swap -> largest-first with last
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, 0, i);
    }
  }

  public static void main(String[] args) {
    Heap h = new Heap();

    h.add(3);
    h.add(1);
    h.add(5);
    h.add(7);

    // while (!h.isEmpty()) {
    // System.out.print(h.peek() + " ");
    // h.remove();
    // }

    int arr[] = { 1, 2, 4, 5, 3 };
    heapSort(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

  }
}