import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph5 {

  static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt) {
      this.src = src;
      this.dest = dest;
      this.wt = wt;
    }
  }

  public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < graph.length; i++) {
      int src = flights[i][0];
      int dest = flights[i][1];
      int wt = flights[i][2];

      Edge e = new Edge(src, dest, wt);
      graph[src].add(e);
    }
  }

  static class Info {
    int v;
    int cost;
    int stops;

    public Info(int v, int c, int s) {
      this.v = v;
      this.cost = c;
      this.stops = s;
    }
  }

  @SuppressWarnings("unchecked")
  public static int cheapestFlights(int n, int flights[][], int src, int dest, int k) {
    ArrayList<Edge> graph[] = new ArrayList[n];
    createGraph(flights, graph);

    int dist[] = new int[graph.length];
    for (int i = 0; i < dist.length; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }

    Queue<Info> q = new LinkedList<>();
    q.add(new Info(0, 0, 0));

    while (!q.isEmpty()) {
      Info curr = q.remove();
      if (curr.stops > k) {
        break;
      }

      for (int i = 0; i < graph[curr.v].size(); i++) {
        Edge e = graph[curr.v].get(i);
        // int u = e.src;
        int v = e.dest;
        int wt = e.wt;

        if (curr.cost + wt < dist[v] && curr.stops <= k) {
          dist[v] = curr.cost + wt;
          q.add(new Info(v, dist[v], curr.stops + 1));
        }
      }
    }

    return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
  }

  static class Edge2 implements Comparable<Edge2> {
    int dest;
    int cost;

    public Edge2(int d, int c) {
      this.cost = c;
      this.dest = d;
    }

    @Override
    public int compareTo(Edge2 e2) {
      return this.cost - e2.cost;
    }

  }

  public static int connectCities(int cities[][]) {
    boolean vis[] = new boolean[cities.length];
    int finalcost = 0;
    PriorityQueue<Edge2> pq = new PriorityQueue<>();

    pq.add(new Edge2(0, 0));

    while (!pq.isEmpty()) {
      Edge2 curr = pq.remove();
      if (!vis[curr.dest]) {
        vis[curr.dest] = true;
        finalcost += curr.cost;

        for (int i = 0; i < cities[curr.dest].length; i++) {
          if (cities[curr.dest][i] != 0) {
            pq.add(new Edge2(i, cities[curr.dest][i]));
          }
        }
      }
    }

    return finalcost;
  }

  public static void main(String[] args) {
    // int n = 4;
    // int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600
    // }, { 2, 3, 200 } };
    // int src = 0, dest = 3, k = 1;

    int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 }, { 4, 7, 0, 0, 0 } };

    // System.out.println("The min cost : " + cheapestFlights(n, flights, src, dest,
    // k));

    System.out.println("Total cost : " + connectCities(cities));

  }
}