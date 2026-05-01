import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph4 {

  public static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt) {
      this.src = src;
      this.dest = dest;
      this.wt = wt;
    }
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    // graph[0].add(new Edge(0, 1, 2));
    // graph[0].add(new Edge(0, 2, 4));

    // graph[1].add(new Edge(1, 2, -4));

    // graph[2].add(new Edge(2, 3, 2));

    // graph[3].add(new Edge(3, 4, 4));

    // graph[4].add(new Edge(4, 1, -1));

    graph[0].add(new Edge(0, 1, 10));
    graph[0].add(new Edge(0, 2, 15));
    graph[0].add(new Edge(0, 3, 30));

    graph[1].add(new Edge(1, 3, 40));

    graph[2].add(new Edge(2, 3, 50));

  }

  static class Pair implements Comparable<Pair> {
    int v;
    int cost;

    public Pair(int v, int cost) {
      this.v = v;
      this.cost = cost;
    }

    @Override
    public int compareTo(Pair p2) {
      return this.cost - p2.cost; // ascending order
    }
  }

  public static void prims(ArrayList<Edge> graph[]) {
    boolean vis[] = new boolean[graph.length];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(0, 0));
    int finalcost = 0; // MST cost/ total min weight

    while (!pq.isEmpty()) {
      Pair curr = pq.remove();
      if (!vis[curr.v]) {
        vis[curr.v] = true;
        finalcost += curr.cost;

        for (int i = 0; i < graph[curr.v].size(); i++) {
          Edge e = graph[curr.v].get(i);
          pq.add(new Pair(e.dest, e.wt));
        }
      }
    }

    System.out.println("final cost of MST:" + finalcost);

  }

  public static void bellmanford(ArrayList<Edge> graph[], int src) { // O(E*V)
    int dist[] = new int[graph.length];
    for (int i = 0; i < dist.length; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }

    int V = graph.length;
    // algo - O(V)
    for (int i = 0; i < V - 1; i++) {
      // edges - O(E)
      for (int j = 0; j < V; j++) {
        for (int k = 0; k < graph[j].size(); k++) {
          Edge e = graph[j].get(k);
          // get u,v,wt
          int u = e.src;
          int v = e.dest;
          int wt = e.wt;

          // relaxation
          if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
            dist[v] = dist[u] + wt;
          }
        }
      }
    }

    // print
    for (int i = 0; i < dist.length; i++) {
      System.out.print(dist[i] + " ");
    }
    System.out.println();
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    int V = 5;
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);

    // bellmanford(graph, 0);
    prims(graph);
  }
}