package Recursion;

public class RecursionBasics {

  // print numbers from n to 1
  public static void PrintDec(int n) {
    if (n > 0) {
      System.out.println(n);
      PrintDec(n - 1);
    }
  }

  // print numbers from 1 to n
  public static void PrintInc(int n) {
    if (n == 1) {
      System.err.print(n + " ");
      return;
    }
    PrintInc(n - 1);
    System.out.print(n + " ");
  }

  // print factorial of a number
  public static int Fact(int n) {
    if (n == 0) {
      return 1;
    }

    int f2 = Fact(n - 1);
    int f1 = n * f2;

    return f1;
  }

  // print sum of n natural numbers
  public static int Sum(int n) {
    if (n == 1) {
      return 1;
    }

    int f2 = Sum(n - 1);
    int f1 = n + f2;

    return f1;
  }

  // calculate nth fibonacci number
  public static int Fibo(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    int f1 = Fibo(n - 1);
    int f2 = Fibo(n - 2);
    int fn = f1 + f2;
    return fn;
  }

  // is the array given is sorted or not
  public static boolean isSorted(int arr[], int i) {
    if (i == arr.length - 1) {
      return true;
    }

    if (arr[i] > arr[i + 1]) {
      return false;
    }
    return isSorted(arr, i + 1);
  }

  // first occurence of an element in an array
  public static int FirstOcc(int arr[], int i, int key) {
    if (i == arr.length - 1)
      return -1;
    if (arr[i] == key) {
      return i;
    }
    return FirstOcc(arr, i + 1, key);
  }

  // last occurence of an element in an array
  public static int LastOcc(int arr[], int i, int key) {
    if (i == arr.length - 1) {
      return -1;
    }
    int isFound = LastOcc(arr, i + 1, key);
    if (isFound == -1 && arr[i] == key) {
      return i;
    }
    return isFound;
  }

  // return power of x^n
  public static int Power(int x, int n) {
    if (n == 0) {
      return 1;
    }
    // int xnm1 = Power(x, n - 1);
    // int xn = x * xnm1;
    // return xn;

    return x * Power(x, n - 1);
  }

  // optimised version
  public static int Power2(int x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    // int halfPowerSq = Power2(x, n / 2) * Power2(x, n / 2); // O(n) not O(log n)
    int halfPower = Power2(x, n/2);
    int halfPowerSq = halfPower * halfPower //now it is O(log n)
    if (n % 2 != 0) {
      halfPowerSq = x * halfPowerSq;
    }
    return halfPowerSq;
  }

  public static void main(String[] args) {
    // PrintDec(10);
    // PrintInc(5);

    // System.out.println(Fact(10));
    // System.out.println(Sum(5));

    // System.out.print(Fibo(7));

    // int[] arr = { 1, 2, 4, 5, 6, 3, 5, 3 };
    // int[] arr = { 5, 4, 3, 2, 6 };
    // System.out.println(isSorted(arr, 0));

    // System.out.println(FirstOcc(arr, 0, 3));
    // System.out.println(LastOcc(arr, 0, 3));

    System.out.println(Power2(2, 10));

  }
}