package BitManipulation;

public class BitMani {

  public static void oddEven(int n) {
    int bitmask = 1;

    if ((n & bitmask) == 0) {
      System.out.println("EVEN");
    } else {

      System.out.println("EVEN");
    }
  }

  public static int getIthBit(int n, int i) {
    int bitmask = 1 << i;
    if ((n & bitmask) == 0) {
      return 0;
    } else {
      return 1;
    }
  }

  public static int setIthBit(int n, int i) {
    int bitmask = 1 << i;
    return n | bitmask;
  }

  public static int clearIthBit(int n, int i) {
    int bitmask = ~(1 << i);

    return n & bitmask;
  }

  public static int updateIthBit(int n, int i, int newBit) {
    // if (newBit == 0) {
    // return clearIthBit(n, i);
    // } else {
    // return setIthBit(n, i);
    // }

    // OR
    n = clearIthBit(n, i);
    int bitmask = newBit << i;

    return n | bitmask;
  }

  public static int ClearIBits(int n, int i) {
    int bitmask = (~0) << i;

    return n & bitmask;
  }

  public static int ClearBitsInRange(int n, int i, int j) {
    int a = (~0) << (j + 1);
    int b = (1 << i) - 1;

    int bitmask = a | b;

    return n & bitmask;
  }

  public static boolean isPowerOfTwo(int n) {
    return (n & (n - 1)) == 0;
  }

  public static int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
      if ((n & 1) != 0) { // check LSB
        count++;
      }
      n = n >> 1;
    }
    return count;
  }

  public static int FastExpo(int a, int n) {
    int ans = 1;

    while (n > 0) {
      if ((n & 1) != 0) { // check LSB
        ans *= a;
      }
      a *= a;
      n = n >> 1;
    }
    return ans;
  }

  public static void main(String[] args) {

    // System.out.println(5 & 6);
    // System.out.println(5 | 6);
    // System.out.println(5 ^ 6);
    // System.out.println(6 >> 1);
    // System.out.println(5 << 2);

    // oddEven(5);
    // System.out.println(clearIthBit(10, 3));

    // System.out.println(updateIthBit(10, 2, 1));
    // System.out.println(ClearIBits(15, 2));

    // System.out.println(ClearBitsInRange(10, 2, 4));

    // System.out.println(countSetBits(15));

    System.out.println(FastExpo(3, 5));
  }
}
