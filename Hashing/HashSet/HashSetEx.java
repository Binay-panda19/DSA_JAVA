import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetEx {
    public static void main(String[] args) {

        HashSet<String> cities = new HashSet<>();

        cities.add("Delhi");
        cities.add("Bangalore");
        cities.add("Mumbai");
        cities.add("Pune");

        System.out.println(cities);

        System.out.println(cities.size());

        System.out.println(cities.contains("Pune"));
        System.out.println(cities.contains("Hyderabad"));

        LinkedHashSet<String> Lset = new LinkedHashSet<>();

        Lset.add("Delhi");
        Lset.add("Bangalore");
        Lset.add("Mumbai");
        Lset.add("Pune");
        System.out.println(Lset);

        TreeSet<String> Tset = new TreeSet<>();

        Tset.add("Delhi");
        Tset.add("Bangalore");
        Tset.add("Mumbai");
        Tset.add("Pune");
        System.out.println(Tset);

    }
}