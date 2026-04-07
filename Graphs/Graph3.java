import java.util.*;

public class Graph3 {
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

    graph[0].add(new Edge(0, 3));

    graph[2].add(new Edge(2, 3));

    graph[3].add(new Edge(3, 1));

    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));

    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));
  }

  public static void topSort(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();

    for (int i = 0; i < vis.length; i++) {
      if (!vis[i]) {
        topSortUtil(graph, i, vis, s); // modified dfs
      }
    }

    while (!s.isEmpty()) {
      System.out.print(s.pop() + " ");
    }
  }

  public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!vis[e.dest]) {
        topSortUtil(graph, e.dest, vis, s);
      }
    }
    s.push(curr);
  }

  public static void calIndeg(ArrayList<Edge>[] graph, int indeg[]) {
    for (int i = 0; i < indeg.length; i++) {
      for (int j = 0; j < graph[i].size(); j++) {
        Edge e = graph[i].get(j);
        indeg[e.dest]++;
      }
    }
  }

  public static void topSort2(ArrayList<Edge>[] graph) {
    int indeg[] = new int[graph.length];
    calIndeg(graph, indeg);
    Queue<Integer> q = new java.util.LinkedList<>();

    for (int i = 0; i < indeg.length; i++) {
      if (indeg[i] == 0) {
        q.add(i);
      }
    }

    // bfs
    while (!q.isEmpty()) {
      int curr = q.remove();
      System.out.print(curr + " "); // topological sort print

      for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        indeg[e.dest]--;
        if (indeg[e.dest] == 0) {
          q.add(e.dest);
        }
      }
    }
    System.out.println();

  }

  // exponential time complexity
  public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
    if (src == dest) {
      System.out.println(path + dest);
      return;
    }

    for (int i = 0; i < graph[src].size(); i++) {
      Edge e = graph[src].get(i);
      printAllPath(graph, e.dest, dest, path + src);
    }
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    int V = 6;
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);

    // topSort(graph);
    // System.out.println();
    // topSort2(graph);

    printAllPath(graph, 5, 1, "");
  }
}