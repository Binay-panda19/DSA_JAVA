import java.util.*;

import org.w3c.dom.Node;

public class Stacks {

  static class Stack1 {
    static ArrayList<Integer> list = new ArrayList<>();

    public static boolean isEmpty() {
      return list.size() == 0;
    }

    // push
    public static void push(int data) {
      list.add(data);
    }

    // pop
    public static int pop() {
      if (isEmpty()) {
        return -1;
      }
      int top = list.get(list.size() - 1);
      list.remove(list.size() - 1);
      return top;
    }

    // peek
    public static int peek() {
      if (isEmpty()) {
        return -1;
      }
      return list.get(list.size() - 1);
    }

  }

  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  static class Stack2 {

    static Node head = null;

    // is empty
    public static boolean isEmpty() {
      return head == null;
    }

    // push
    public static void push(int data) {
      Node newNode = new Node(data);

      if (isEmpty()) {
        head = newNode;
        return;
      }

      newNode.next = head;
      head = newNode;
    }

    // pop
    public static int pop() {
      if (isEmpty()) {
        return -1;
      }

      int top = head.data;
      head = head.next;
      return top;
    }

    // peek
    public static int peek() {
      if (isEmpty()) {
        return -1;
      }

      return head.data;
    }
  }

  public static void pushBottom(Stack<Integer> s, int data) {
    if (s.isEmpty()) {
      s.push(data);
      return;
    }

    int top = s.pop();
    pushBottom(s, data);
    s.push(top);
  }

  public static String reverseStr(String str) {
    Stack<Character> s = new Stack<>();

    int idx = 0;
    while (idx < str.length()) {
      s.push(str.charAt(idx));
      idx++;
    }

    StringBuilder str1 = new StringBuilder("");

    while (!s.isEmpty()) {
      char curr = s.pop();
      str1.append(curr);
    }

    return str1.toString();
  }

  public static void reverseStack(Stack<Integer> s) {
    if (s.isEmpty()) {
      return;
    }

    int top = s.pop();
    reverseStack(s);
    pushBottom(s, top);
  }

  public static void printStack(Stack<Integer> s) {
    while (!s.isEmpty()) {
      System.out.print(s.pop() + " ");
    }
  }

  public static void stocksSpan(int[] stocks, int[] span) {
    Stack<Integer> s = new Stack<>();

    span[0] = 1;
    s.push(0);

    for (int i = 1; i < stocks.length; i++) {
      int currPrice = stocks[i];
      while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
        s.pop();
      }
      if (s.isEmpty())
        span[i] = i + 1;
      else {
        int prevHigh = s.peek();
        span[i] = i - prevHigh;
      }

      s.push(i);
    }
  }

  public static int[] nextGreater(int[] arr) {
    int n = arr.length;
    int[] nextGreater = new int[n];
    Stack<Integer> s = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {

      while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
        s.pop();
      }
      if (s.isEmpty())
        nextGreater[i] = -1;
      else
        nextGreater[i] = arr[s.peek()];

      s.push(i);
    }

    return nextGreater;
  }

  public static boolean isValid(String str) {
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == '(' || ch == '{' || ch == '[') { // opening
        s.push(ch);
      } else {
        // closing
        if (s.isEmpty()) {
          return false;
        }
        if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')) {
          s.pop();
        } else {
          return false;
        }
      }
    }

    if (s.isEmpty()) {
      return true;
    }

    return false;
  }

  public static boolean isDuplicate(String str) {
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      // closing
      if (ch == ')') {
        int count = 0;
        while (s.peek() != '(') {
          s.pop();
          count++;
        }

        if (count < 1) {
          return true; // duplicate
        } else {
          s.pop(); // opening
        }
      } else {
        s.push(ch);
      }
    }

    return false;
  }

  public static void maxArea(int[] arr) {

    int maxArea = 0;
    int[] nsr = new int[arr.length];
    int[] nsl = new int[arr.length];

    // next smaller right
    Stack<Integer> s = new Stack<>();

    for (int i = arr.length - 1; i >= 0; i--) {

      while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        s.pop();
      }
      if (s.isEmpty())
        nsr[i] = arr.length;
      else
        nsr[i] = s.peek();

      s.push(i);
    }
    // next smaller left
    s = new Stack<>();

    for (int i = 0; i < arr.length; i++) {

      while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        s.pop();
      }
      if (s.isEmpty())
        nsl[i] = -1;
      else
        nsl[i] = s.peek();

      s.push(i);
    }
    // current area width = j-i-1 = nsr[i] - nsl[i] -1
    for (int i = 0; i < arr.length; i++) {
      int height = arr[i];
      int width = nsr[i] - nsl[i] - 1;
      int currArea = height * width;
      maxArea = maxArea < currArea ? currArea : maxArea;
    }

    System.out.println("Max area in histogram is: " + maxArea);
  }

  public static void main(String[] args) {

    // Stack1 s = new Stack1();

    // s.push(1);
    // s.push(2);
    // s.push(3);

    // while (!s.isEmpty()) {
    // System.out.println(s.peek());
    // s.pop();
    // }

    // Stack<Integer> s = new Stack<>();
    // s.push(1);
    // s.push(2);
    // s.push(3);
    // s.push(4);
    // s.push(5);
    // s.push(6);
    // reverseStack(s);
    // printStack(s);
    // pushBottom(s, 4);

    // String str = "abc";
    // String res = reverseStr(str);
    // System.out.println(res);

    // int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
    // int[] span = new int[stocks.length];
    // stocksSpan(stocks, span);

    // for (int i = 0; i < span.length; i++) {
    // System.out.print(span[i] + " ");
    // }

    // int[] arr = { 6, 8, 0, 1, 3 };
    // int[] next = nextGreater(arr);

    // for (int val : next) {
    // System.out.print(val + " ");
    // }

    // String str = "()({}[]))";
    // String str = "(((a+b)+(c+d)))";
    // System.out.println(isValid(str));
    // System.out.println(isDuplicate(str));

    int[] heights = { 2, 1, 5, 6, 2, 3 };
    maxArea(heights);

  }
}