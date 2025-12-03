public class LinkedList {

  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;

  // methods can be made in the ll class
  // add,remove,search etc

  public void addFirst(int data) {
    // step-1 create new node
    Node newNode = new Node(data);
    size++;

    // when ll is empty
    if (head == null) {
      head = tail = newNode;
      return;
    }

    // step-2 newNode's next = head
    newNode.next = head; // linking

    // step-3 head = newNode
    head = newNode;
  }

  public void addLast(int data) {
    Node newNode = new Node(data);
    size++;

    if (head == null) {
      head = tail = newNode;
      return;
    }
    tail.next = newNode;

    tail = newNode;
  }

  public void print() {
    Node temp = head;
    if (head == null) {
      System.out.println("ll is empty");
      return;
    }

    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.err.println("null");
  }

  public void add(int idx, int data) {
    if (idx == 0) {
      addFirst(data);
      return;
    }
    Node newNode = new Node(data);
    size++;
    Node temp = head;
    int i = 0;

    while (i < idx - 1) {
      temp = temp.next;
      i++;
    }

    // i = idx-1 ; temp -> prev node
    newNode.next = temp.next;
    temp.next = newNode;
  }

  public int removeFirst() {
    if (size == 0) {
      System.out.println("ll is empty");
      return Integer.MIN_VALUE;
    } else if (size == 1) {
      int val = head.data;
      head = tail = null;
      size = 0;
      return val;
    }
    int val = head.data;
    head = head.next;
    size--;
    return val;
  }

  public int removeLast() {
    if (size == 0) {
      System.out.println("ll is empty");
      return Integer.MIN_VALUE;
    } else if (size == 1) {
      int val = head.data;
      head = tail = null;
      size = 0;
      return val;
    }

    // prev node : idx = size-2
    Node prev = head;
    for (int i = 0; i < size - 2; i++) {
      prev = prev.next;
    }
    int val = prev.next.data; // tail.data
    prev.next = null;
    tail = prev;
    size--;
    return val;
  }

  public int itrSearch(int key) {
    Node temp = head;
    int i = 0;
    while (temp != null) {
      if (temp.data == key) {
        return i;
      }
      temp = temp.next;
      i++;
    }

    return -1;
  }

  public int helper(Node head, int key) {
    if (head == null) {
      return -1;
    }

    if (head.data == key) {
      return 0;
    }

    int idx = helper(head.next, key);
    if (idx == -1) {
      return -1;
    }

    return idx + 1;
  }

  public int recSearch(int key) {
    return helper(head, key);
  }

  public void reverse() {
    Node prev = null;
    Node curr = tail = head;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    head = prev;
  }

  public void deleteNthFromEnd(int n) {
    // calculate size
    int sz = 0;
    Node temp = head;
    while (temp != null) {
      temp = temp.next;
      sz++;
    }

    // first node to be deleted
    if (n == sz) {
      head = head.next;
      return;
    }

    // i = sz - n
    int i = 0;
    int iToFind = sz - n;
    Node prev = head;

    while (i < iToFind) {
      prev = prev.next;
      i++;
    }

    prev.next = prev.next.next;
    return;
  }

  // slow-fast approach
  public Node findMid(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next; // +1
      fast = fast.next.next; // +2
    }

    return slow; // slow is the mid
  }

  public boolean checkPalindrome() {
    if (head == null || head.next == null) {
      return true;
    }

    // step1
    Node mid = findMid(head);

    // step2
    Node prev = null;
    Node curr = mid;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    Node right = prev; // right half head
    Node left = head; // left half head

    while (right != null) {
      if (left.data != right.data) {
        return false;
      }

      left = left.next;
      right = right.next;
    }

    return true;
  }

  public static boolean isCycle() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) { // cycle exists
        return true;
      }
    }

    return false;
  }

  public static void removeCycle() {

    // detect cycle
    Node slow = head;
    Node fast = head;
    boolean cycle = false;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        cycle = true;
        break;
      }
    }

    if (!cycle) {
      return;
    }
    // find meeting point
    slow = head;
    Node prev = null;
    while (slow != fast) {
      prev = fast;
      slow = slow.next;
      fast = fast.next;
    }

    // remove cycle -> last.next = null
    prev.next = null;

  }

  private Node getMid(Node head) {
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next; // +1
      fast = fast.next.next; // +2
    }

    return slow; // slow is the mid
  }

  private Node merge(Node head1, Node head2) {
    Node mergedList = new Node(-1);
    Node temp = mergedList;

    while (head1 != null && head2 != null) {
      if (head1.data <= head2.data) {
        temp.next = head1;
        head1 = head1.next;
        temp = temp.next;
      } else {
        temp.next = head2;
        head2 = head2.next;
        temp = temp.next;
      }
    }

    while (head1 != null) {
      temp.next = head1;
      head1 = head1.next;
      temp = temp.next;
    }

    while (head2 != null) {
      temp.next = head2;
      head2 = head2.next;
      temp = temp.next;
    }

    return mergedList.next;
  }

  public Node mergeSort(Node head) {

    if (head == null || head.next == null) {
      return head;
    }

    // find mid
    Node mid = getMid(head);

    // left and right MS
    Node rightHead = mid.next;
    mid.next = null;
    Node newLeft = mergeSort(head);
    Node newRight = mergeSort(rightHead);

    // merge
    return merge(newLeft, newRight);
  }

  public void zigZag() {
    // find mid
    Node slow = head;
    Node fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    Node mid = slow;

    // reverse 2nd half
    Node curr = mid.next;
    mid.next = null;
    Node prev = null;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    Node left = head;
    Node right = prev;
    Node nextL, nextR;

    // zig-zag merge
    while (left != null && right != null) {
      nextL = left.next;
      left.next = right;
      nextR = right.next;
      right.next = nextL;
      right = nextR;
      left = nextL;
    }

  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    // ll.head = new Node(1);
    // ll.head.next = new Node(2);
    // ll.addFirst(2);
    // ll.addFirst(1);
    // ll.addLast(4);
    // ll.add(2, 3);
    // ll.addLast(5);
    // ll.print();

    // ll.reverse();
    // ll.print();

    // System.out.println(ll.itrSeach(3));
    // System.out.println(ll.recSearch(3));

    // System.out.println("size: " + ll.size);

    // ll.addFirst(1);
    // ll.addLast(2);
    // ll.addLast(2);
    // ll.addLast(1);

    // ll.print();

    // head = new Node(1);
    // head.next = new Node(2);
    // head.next.next = new Node(3);
    // head.next.next.next = head;
    // // ll.print();

    // System.out.println(isCycle());
    // removeCycle();
    // System.out.println(isCycle());

    // System.out.println(ll.checkPalindrome() ? "palindrome" : "not palindrome");

    ll.addFirst(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(4);
    ll.addLast(5);
    ll.addLast(6);

    // ll.print(); // 5-4-3-2-1-null
    // ll.head = ll.mergeSort(head);
    // ll.print(); // 1-2-3-4-5-null

    ll.print(); // 1-2-3-4-5-6-null
    ll.zigZag();
    ll.print(); // 1-6-2-5-3-4-null

  }
}