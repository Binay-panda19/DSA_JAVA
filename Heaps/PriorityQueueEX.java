import java.util.PriorityQueue;

public class PriorityQueueEX {

  static class Student implements Comparable<Student> {
    int rank;
    String name;

    public Student(String name, int rank) {
      this.name = name;
      this.rank = rank;
    }

    public int compareTo(Student s2) {
      return this.rank - s2.rank;
    }

  }

  public static void main(String[] args) {

    PriorityQueue<Student> pq = new java.util.PriorityQueue<>();

    pq.add(new Student("A", 5657));
    pq.add(new Student("B", 2445));
    pq.add(new Student("C", 24000));
    pq.add(new Student("D", 100000));
    // pq.add(7);
    // pq.add(5);
    // pq.add(11);

    while (!pq.isEmpty()) {
      System.err.print(pq.peek() + " ");
      pq.remove();
    }
  }
}