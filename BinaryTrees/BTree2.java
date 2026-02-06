package BinaryTrees;

import java.util.*;

public class BTree2 {

  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static int height(Node root) {
    if (root == null) {
      return 0;
    }

    int lh = height(root.left);
    int rh = height(root.right);

    return Math.max(lh, rh) + 1;

  }

  public static int count(Node root) {
    if (root == null) {
      return 0;
    }

    int lc = count(root.left);
    int rc = count(root.right);

    return lc + rc + 1;
  }

  public static int sum(Node root) {
    if (root == null) {
      return 0;
    }

    int ls = sum(root.left);
    int rs = sum(root.right);

    return ls + rs + root.data;
  }

  public static int diameter2(Node root) {
    if (root == null) {
      return 0;
    }

    int leftDiam = diameter2(root.left);
    int leftht = height(root.left);
    int rightDiam = diameter2(root.right);
    int rightht = height(root.right);

    int selfDiam = leftht + rightht + 1;

    return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
  }

  public static class Info {
    int diam;
    int ht;

    Info(int d, int h) {
      this.diam = d;
      this.ht = h;
    }
  }

  public static Info diameter(Node root) {
    if (root == null) {
      return new Info(0, 0);
    }

    Info leftInfo = diameter(root.left);
    Info rightInfo = diameter(root.right);
    int finalDiam = Math.max(leftInfo.ht + rightInfo.ht + 1, Math.max(leftInfo.diam, rightInfo.diam));
    int finalHt = Math.max(leftInfo.ht, rightInfo.ht) + 1;

    return new Info(finalDiam, finalHt);
  }

  public static boolean isIdentical(Node node, Node subRoot) {
    if (node == null && subRoot == null) {
      return true;
    } else if (node == null || subRoot == null || node.data != subRoot.data) {
      return false;
    }

    if (!isIdentical(node.left, subRoot.left)) {
      return false;
    }
    if (!isIdentical(node.right, subRoot.right)) {
      return false;
    }

    return true;
  }

  public static boolean isSubtree(Node root, Node subRoot) {
    if (root == null) {
      return false;
    }

    if (root.data == subRoot.data) {
      if (isIdentical(root, subRoot)) {
        return true;
      }
    }

    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public static class Infoo {
    Node node;
    int hd;

    Infoo(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

  public static void topView(Node root) {
    // level order traversal
    Queue<Infoo> q = new LinkedList<>();
    HashMap<Integer, Node> map = new HashMap<>();

    int min = 0, max = 0;
    q.add(new Infoo(root, 0));
    q.add(null);

    while (!q.isEmpty()) {
      Infoo curr = q.remove();
      if (curr == null) {
        if (q.isEmpty()) {
          break;
        } else {
          q.add(null);
        }
      } else {
        if (!map.containsKey(curr.hd)) { // first time my hd is occuring
          map.put(curr.hd, curr.node);
        }

        if (curr.node.left != null) {
          q.add(new Infoo(curr.node.left, curr.hd - 1));
          min = Math.min(min, curr.hd - 1);
        }
        if (curr.node.right != null) {
          q.add(new Infoo(curr.node.right, curr.hd + 1));
          max = Math.max(max, curr.hd + 1);
        }
      }

    }

    for (int i = min; i < max; i++) {
      System.out.print(map.get(i).data + " ");
    }

    System.out.println();

  }

  public static void main(String[] args) {

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.right = new Node(6);
    root.right.left = new Node(7);

    Node subRoot = new Node(2);
    subRoot.left = new Node(4);
    subRoot.right = new Node(5);

    // System.out.println("height: " + height(root));
    // System.out.println("count: " + count(root));
    // System.out.println("sum: " + sum(root));

    // System.out.println("diameter of tree: " + diameter(root).diam);

    // System.out.println(isSubtree(root, subRoot));

    topView(root);
  }
}