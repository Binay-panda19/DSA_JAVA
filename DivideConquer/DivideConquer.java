public class DivideConquer {

  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void mergeSort(int arr[], int si, int ei) {
    if (si >= ei) {
      return;
    }
    // kaam
    int mid = si + (ei - si) / 2; // (si+ei)/2
    mergeSort(arr, si, mid);// left
    mergeSort(arr, mid + 1, ei);// right
    merge(arr, si, mid, ei);
  }

  public static void merge(int arr[], int si, int mid, int ei) {
    int temp[] = new int[ei - si + 1];
    int i = si; // iterator for left
    int j = mid + 1; // iterator for right
    int k = 0; // iterator for temp arr
    while (i <= mid && j <= ei) {
      if (arr[i] < arr[j]) {
        temp[k] = arr[i];
        i++;
      } else {
        temp[k] = arr[j];
        j++;
      }
      k++;
    }

    // left
    while (i <= mid) {
      temp[k++] = arr[i++];
    }

    // right
    while (j <= ei) {
      temp[k++] = arr[j++];
    }

    // copy temp arr to original
    for (k = 0, i = si; k < temp.length; k++, i++) {
      arr[i] = temp[k];
    }

  }

  public static void quickSort(int arr[], int si, int ei) {
    if (si >= ei) {
      return;
    }

    // last element
    int pIdx = partition(arr, si, ei);
    quickSort(arr, si, pIdx - 1); // left
    quickSort(arr, pIdx + 1, ei); // right

  }

  public static int partition(int arr[], int si, int ei) {
    int pivot = arr[ei];
    int i = si - 1; // to make space for els smaller that pivot

    for (int j = si; j < ei; j++) {
      if (arr[j] <= pivot) {
        i++;
        // swap
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
    i++;
    // swap
    int temp = pivot;
    arr[ei] = arr[i];
    arr[i] = temp;
    return i;
  }

  public static int search(int arr[], int tar, int si, int ei) {
    if (si > ei) {
      return -1;
    }

    // kaam
    int mid = si + (ei - si) / 2;
    // case Found
    if (arr[mid] == tar) {
      return mid;
    }

    // mid on L1
    if (arr[si] <= arr[mid]) {
      // case b : left
      if (arr[si] <= tar && tar <= arr[mid]) {
        return search(arr, tar, si, mid - 1);
      }
      // case b : right
      else {
        return search(arr, tar, mid + 1, ei);
      }
    }

    // mid on L2
    else {
      // case c : right
      if (arr[mid] <= tar && tar <= arr[ei]) {
        return search(arr, tar, mid + 1, ei);
      }
      // case d : left
      else {
        return search(arr, tar, si, mid - 1);
      }
    }

  }

  public static void main(String[] args) {
    int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
    int target = 0; // output = 4
    // mergeSort(arr, 0, arr.length - 1);
    // quickSort(arr, 0, arr.length - 1);
    // printArr(arr);

    System.out.println("target : " + search(arr, target, 0, arr.length - 1));

  }
}