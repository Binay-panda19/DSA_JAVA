import java.util.ArrayList;

public class BST2 {

  static class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
    }
  }

  public static void printBST(Node root) {
    if (root == null) {
      return;
    }

    System.out.print(root.data + " ");
    printBST(root.left);
    printBST(root.right);
  }

  public static void getInorder(Node root, ArrayList<Integer> inorder) {
    if (root == null) {
      return;
    }

    getInorder(root.left, inorder);
    inorder.add(root.data);
    getInorder(root.right, inorder);
  }

  public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
    if (st > end) {
      return null;
    }

    int mid = (st + end) / 2;

    Node root = new Node(inorder.get(mid));
    root.left = createBST(inorder, st, mid - 1);
    root.right = createBST(inorder, mid + 1, end);

    return root;
  }

  public static Node balanceBST(Node root) {
    // inorder arraylist
    ArrayList<Integer> inorder = new ArrayList<>();
    getInorder(root, inorder);

    // inorder array -> BST
    return createBST(inorder, 0, inorder.size() - 1);

  }

  static class Info {
    boolean isBST;
    int size;
    int min;
    int max;

    Info(boolean isBST, int size, int min, int max) {
      this.isBST = isBST;
      this.size = size;
      this.min = min;
      this.max = max;
    }
  }

  public static int maxSize = 0;

  public static Info largestBST(Node root) {

    if (root == null) {
      return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    Info left = largestBST(root.left);
    Info right = largestBST(root.right);
    int size = left.size + right.size + 1;
    int min = Math.min(root.data, Math.min(left.min, right.min));
    int max = Math.max(root.data, Math.max(left.max, right.max));

    if (root.data <= left.max || root.data >= right.min) {
      return new Info(false, size, min, max);
    }

    if (left.isBST && right.isBST) {
      maxSize = Math.max(maxSize, size);
      return new Info(true, size, min, max);
    }

    return new Info(false, size, min, max);
  }

  public static Node mergeBSTs(Node root1, Node root2) {
    // inorder for root1
    ArrayList<Integer> arr1 = new ArrayList<>();
    getInorder(root1, arr1);

    // inorder for root2
    ArrayList<Integer> arr2 = new ArrayList<>();
    getInorder(root2, arr2);

    // merge inorder 1,2
    int i = 0, j = 0;
    ArrayList<Integer> newArr = new ArrayList<>();
    while (i < arr1.size() && j < arr2.size()) {
      if (arr1.get(i) >= arr2.get(j)) {
        newArr.add(arr2.get(j));
        j++;
      } else {
        newArr.add(arr1.get(i));
        i++;
      }
    }

    while (i < arr1.size()) {
      newArr.add(arr1.get(i));
      i++;
    }
    while (j < arr2.size()) {
      newArr.add(arr2.get(j));
      j++;
    }

    return createBST(newArr, 0, newArr.size() - 1);
  }

  public static Node createBST(int[] arr, int st, int end) {
    if (st > end) {
      return null;
    }

    int mid = (st + end) / 2;

    Node root = new Node(arr[mid]);
    root.left = createBST(arr, st, mid - 1);
    root.right = createBST(arr, mid + 1, end);

    return root;
  }

  public static void main(String[] args) {
    // int arr[] = { 3, 5, 6, 8, 10, 11, 12 };

    // Node root1 = new Node(50);
    // root1.left = new Node(30);
    // root1.left.right = new Node(20);
    // root1.left.left = new Node(5);

    // root1.right = new Node(60);
    // root1.right.left = new Node(45);
    // root1.right.right = new Node(70);
    // root1.right.right.left = new Node(65);
    // root1.right.right.right = new Node(80);

    // Node root = createBST(arr, 0, arr.length - 1);
    // printBST(root1);
    // System.out.println();
    // balanceBST(root1);
    // printBST(root1);

    // largestBST(root1);
    // System.out.println("largest BST in BT:" + maxSize);

    Node root1 = new Node(2);
    root1.left = new Node(1);
    root1.right = new Node(4);

    Node root2 = new Node(9);
    root2.left = new Node(3);
    root2.right = new Node(12);

    Node root = mergeBSTs(root1, root2);

    printBST(root);
  }
}