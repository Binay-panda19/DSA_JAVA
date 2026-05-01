import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DisjointSetDS {

  static class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.wt = w;
    }

    @Override
    public int compareTo(Edge e2) {
      return this.wt - e2.wt;
    }

  }

  public static void createGraph(ArrayList<Edge> edges) {
    // edges
    edges.add(new Edge(0, 1, 10));
    edges.add(new Edge(0, 2, 15));
    edges.add(new Edge(0, 3, 30));
    edges.add(new Edge(1, 3, 40));
    edges.add(new Edge(2, 3, 50));
  }

  static int n = 4;
  static int par[] = new int[n];
  static int rank[] = new int[n];

  public static void init() {
    for (int i = 0; i < par.length; i++) {
      par[i] = i;
    }
  }

  public static int find(int x) {
    if (x == par[x]) {
      return x;
    }
    return find(par[x]);
  }

  public static void union(int a, int b) {
    int parA = find(a);
    int parB = find(b);

    if (rank[parA] == rank[parB]) {
      par[parB] = parA;
      rank[parA]++;
    } else if (rank[parA] < rank[parB]) {
      par[parA] = parB;
    } else {
      par[parB] = parA;
    }
  }

  // Kruskal's algorithm
  public static void kruskals(ArrayList<Edge> edges, int V) { // O(V + Elog(E))
    init();
    Collections.sort(edges); // O(ElogE)
    int mstCost = 0;
    int count = 0;

    for (int i = 0; count < V - 1; i++) { // O(V)
      Edge e = edges.get(i); // (src,dest,wt)

      int parA = find(e.src);
      int parB = find(e.dest);

      if (parA != parB) {
        union(parA, parB);
        mstCost += e.wt;
        count++;
      }
    }

    System.out.println("total cost : " + mstCost);
  }

  // Flood fill algorithm
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int originalColor = image[sr][sc];

    // If the color is already the same, no need to proceed
    if (originalColor == newColor)
      return image;

    dfs(image, sr, sc, originalColor, newColor);
    return image;
  }

  // helper funcn
  private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
    int rows = image.length;
    int cols = image[0].length;

    // Boundary check + color check
    if (r < 0 || c < 0 || r >= rows || c >= cols || image[r][c] != originalColor) {
      return;
    }

    // Fill the color
    image[r][c] = newColor;

    // Visit all 4 directions
    dfs(image, r + 1, c, originalColor, newColor); // down
    dfs(image, r - 1, c, originalColor, newColor); // up
    dfs(image, r, c + 1, originalColor, newColor); // right
    dfs(image, r, c - 1, originalColor, newColor); // left
  }

  public static void main(String[] args) {

    // init();
    // System.out.println(find(3));
    // union(1, 3);
    // System.err.println(find(3));
    // union(2, 4);
    // union(3, 6);
    // union(1, 4);
    // System.out.println(find(3));
    // System.out.println(find(4));
    // union(1, 5);

    int V = 4;
    ArrayList<Edge> edges = new ArrayList<>();
    createGraph(edges);

    kruskals(edges, V);
  }
}