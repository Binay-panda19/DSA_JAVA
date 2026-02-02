import java.util.*;
import java.util.LinkedList;

public class JCFQueue {

  // public class Queue1 {
  // Stack<Integer> s1 = new Stack<>();
  // Stack<Integer> s2 = new Stack<>();

  // public boolean isEmpty() {
  // return s1.isEmpty();
  // }

  // // add
  // public void add(int data) {
  // while (!s1.isEmpty()) {
  // s2.push(s1.pop());
  // }

  // s1.push(data);

  // while (!s2.isEmpty()) {
  // s1.push(s2.pop());
  // }
  // }

  // // remove
  // public int remove() {
  // if (isEmpty()) {
  // System.out.println("Queue is empty");
  // return -1;
  // }
  // return s1.pop();
  // }

  // // peek
  // public int peek() {
  // if (isEmpty()) {
  // System.out.println("Queue is empty");
  // return -1;
  // }
  // return s1.peek();
  // }
  // }

  // public static class Stack1 {
  // Queue<Integer> q1 = new LinkedList<>();
  // Queue<Integer> q2 = new LinkedList<>();

  // public boolean isEmpty() {
  // return q1.isEmpty() && q2.isEmpty();
  // }

  // public void push(int data) {
  // if (!q1.isEmpty()) {
  // q1.add(data);
  // } else {
  // q2.add(data);
  // }
  // }

  // public int pop() {
  // if (isEmpty()) {
  // System.out.println("empty stack");
  // return -1;
  // }

  // int top = -1;
  // // case 1
  // if (!q1.isEmpty()) {
  // while (!q1.isEmpty()) {
  // top = q1.remove();
  // if (q1.isEmpty()) {
  // break;
  // }
  // q2.add(top);
  // }
  // } else { // case 2
  // while (!q2.isEmpty()) {
  // top = q2.remove();
  // if (q2.isEmpty()) {
  // break;
  // }
  // q1.add(top);
  // }
  // }

  // return top;
  // }

  // public int peek() {
  // if (isEmpty()) {
  // System.out.println("empty stack");
  // return -1;
  // }

  // int top = -1;
  // // case 1
  // if (!q1.isEmpty()) {
  // while (!q1.isEmpty()) {
  // top = q1.remove();
  // q2.add(top);
  // }
  // } else { // case 2
  // while (!q2.isEmpty()) {
  // top = q2.remove();
  // q1.add(top);
  // }
  // }

  // return top;
  // }

  // }

  public static void printNonRepeating(String str) {
    int freq[] = new int[26];

    Queue<Character> q = new LinkedList<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      q.add(ch);
      freq[ch - 'a']++;

      while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
        q.remove();
      }

      if (q.isEmpty()) {
        System.out.print(-1 + " ");
      } else {
        System.out.print(q.peek() + " ");
      }

    }
  }

  public static void main(String[] args) {
    // JCFQueue jcf = new JCFQueue();
    // Queue1 q = jcf.new Queue1();

    // q.add(1);
    // q.add(2);
    // q.add(3);

    // while (!q.isEmpty()) {
    // System.out.println(q.peek());
    // q.remove();
    // }

    // Stack1 s = new Stack1();

    // s.push(1);
    // s.push(2);
    // s.push(3);

    // while (!s.isEmpty()) {
    // System.out.println(s.peek());
    // s.pop();
    // }

    String str = "aabccxb";

    printNonRepeating(str);
  }
}
