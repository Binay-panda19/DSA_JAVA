import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph2 {

  static class Edge {
    int src;
    int dest;

    public Edge(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }

  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    // cycle -> undirected graph
    // graph[0].add(new Edge(0, 1));
    // graph[0].add(new Edge(0, 2));
    // graph[0].add(new Edge(0, 3));

    // graph[1].add(new Edge(1, 0));
    // graph[1].add(new Edge(1, 2));

    // graph[2].add(new Edge(2, 0));
    // graph[2].add(new Edge(2, 1));

    // graph[3].add(new Edge(3, 0));
    // graph[3].add(new Edge(3, 4));

    // graph[4].add(new Edge(4, 3));

    // bipartite
    // graph[0].add(new Edge(0, 1));
    // graph[0].add(new Edge(0, 2));

    // graph[1].add(new Edge(1, 0));
    // graph[1].add(new Edge(1, 3));

    // graph[2].add(new Edge(2, 0));
    // graph[2].add(new Edge(2, 4));

    // graph[3].add(new Edge(3, 1));
    // graph[3].add(new Edge(3, 4));

    // graph[4].add(new Edge(4, 3));
    // graph[4].add(new Edge(4, 2));

    // cycle -> directed graph
    // graph[0].add(new Edge(0, 2));
    // graph[1].add(new Edge(1, 0));
    // graph[2].add(new Edge(2, 3));
    // graph[3].add(new Edge(3, 0));

    // no cycle -> directed graph
    graph[0].add(new Edge(0, 2));
    graph[1].add(new Edge(1, 0));
    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 4));

  }

  public static boolean detectCycle(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];

    for (int i = 0; i < graph.length; i++) {
      if (!vis[i]) {
        if (detectCycleUtil(graph, vis, i, -1)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
    vis[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      // case 3
      if (!vis[e.dest]) {
        if (detectCycleUtil(graph, vis, e.dest, curr)) {
          return true;
        }
      }
      // case 1
      else if (vis[e.dest] && e.dest != par) {
        return true;
      }
      // case 2 -> eat 5 star,do nothing -> continue
    }
    return false;
  }

  public static boolean isBipartite(ArrayList<Edge>[] graph) {
    int[] col = new int[graph.length];
    for (int i = 0; i < col.length; i++) {
      col[i] = -1; // no color
    }

    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < graph.length; i++) {
      if (col[i] == -1) { // BFS
        q.add(i);
        col[i] = 0; // yellow
        while (!q.isEmpty()) {
          int curr = q.remove();
          for (int j = 0; j < graph[curr].size(); j++) {
            Edge e = graph[curr].get(j);
            if (col[e.dest] == -1) {
              int nextcol = col[curr] == 0 ? 1 : 0;
              col[e.dest] = nextcol;
              q.add(e.dest);
            } else if (col[e.dest] == col[curr]) {
              return false; // NON BIPARTITE
            }
          }
        }
      }
    }
    return true;
  }

  public static boolean isCycle(ArrayList<Edge>[] graph) {
    boolean[] vis = new boolean[graph.length];
    boolean[] stack = new boolean[graph.length];

    for (int i = 0; i < graph.length; i++) {
      if (!vis[i]) {
        if (isCycleUtil(graph, i, vis, stack)) {
          return true;
        }
      }
    }

    return false;

  }

  public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
    vis[curr] = true;
    stack[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (stack[e.dest]) { // cycle
        return true;
      }
      if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
        return true;
      }

    }

    stack[curr] = false; // remove from the stack
    return false;
  }

  public static void main(String[] args) {
    int V = 5;

    @SuppressWarnings("unchecked")
    ArrayList<Edge>[] graph = new ArrayList[V];

    createGraph(graph);
    // System.out.println(detectCycle(graph));

    // System.out.println(isBipartite(graph));

    System.out.println(isCycle(graph));
  }
}