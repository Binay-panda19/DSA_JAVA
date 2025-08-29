public class BasicSorting {

  public static void BubbleSort(int num[]) {

    for (int turn = 0; turn < num.length - 1; turn++) {
      for (int j = 0; j < num.length - 1 - turn; j++) {
        if (num[j] > num[j + 1]) {
          // swap
          int temp = num[j];
          num[j] = num[j + 1];
          num[j + 1] = temp;
        }
      }
    }
  }

  public static void SelectionSort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minPos = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[minPos] > arr[j]) {
          minPos = j;
        }
      }
      // swap
      int temp = arr[minPos];
      arr[minPos] = arr[i];
      arr[i] = temp;
    }
  }

  public static void InsertionSort(int arr[]) {
    for (int i = 1; i < arr.length - 1; i++) {
      int curr = arr[i];
      int prev = i - 1;
      // finding the element
      while (prev >= 0 && arr[prev] > curr) {
        arr[prev + 1] = arr[prev];
        prev--;
      }
      // insertion
      arr[prev + 1] = curr;
    }
  }

  public static void Print(int arr[]) {
    System.out.println("the sorted array is: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String args[]) {
    int num[] = { 5, 4, 2, 1, 3 };

    InsertionSort(num);
    Print(num);
  }
}