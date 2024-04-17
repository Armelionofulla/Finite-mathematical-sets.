import java.util.Arrays;
import java.util.HashSet;

public class MathSET<Key> {
    private final HashSet<Key> set;
    private final HashSet<Key> universe;

    // Konstruktori inicializon MathSET me universin e dhënë të çelësave
    public MathSET(Key[] universe) {
        this.set = new HashSet<>();
        this.universe = new HashSet<>();
        this.universe.addAll(Arrays.asList(universe));
    }

    // Shton një çelës në set
    public void add(Key key) {
        set.add(key);
    }

    // Llogarit setin komplement, pra çelësat në univers që nuk janë në setin aktual
    public MathSET<Key> complement() {
        MathSET<Key> complementSet = new MathSET<>(universe.toArray((Key[]) new Object[0]));
        complementSet.set.removeAll(this.set);
        return complementSet;
    }

    // Kryen bashkimin e setit aktual me një set tjetër
    public void union(MathSET<Key> a) {
        set.addAll(a.set);
    }

    // Kryen përshpejtimin e setit aktual me një set tjetër
    public void intersection(MathSET<Key> a) {
        set.retainAll(a.set);
    }

    // Fshin një çelës nga seti
    public void delete(Key key) {
        set.remove(key);
    }

    // Kontrollon nëse një çelës është i pranishëm në set
    public boolean contains(Key key) {
        return set.contains(key);
    }

    // Kontrollon nëse seti është i zbrazët
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // Kthen numrin e çelësave në set
    public int size() {
        return set.size();
    }

    // Metoda main për testimin e funksionalitetit
    public static void main(String[] args) {
        Integer[] universeArray = {1, 2, 3, 4, 5};
        MathSET<Integer> mathSet = new MathSET<>(universeArray);

        mathSet.add(1);
        mathSet.add(3);
        mathSet.add(5);
        mathSet.add(6);
        mathSet.add(9);

        System.out.println("Seti Origjinal: " + mathSet.set);

        MathSET<Integer> complementSet = mathSet.complement();
        System.out.println("Seti i Komplementit: " + complementSet.set);

        MathSET<Integer> otherSet = new MathSET<>(new Integer[]{3, 4, 5, 6});
        mathSet.union(otherSet);
        System.out.println("Seti i Bashkimit: " + mathSet.set);

        mathSet.intersection(otherSet);
        System.out.println("Seti i Përshpejtimit: " + mathSet.set);

        mathSet.delete(3);
        System.out.println("Seti pas fshirjes së 3: " + mathSet.set);

        System.out.println("A është 5 në set? " + mathSet.contains(5));
        System.out.println("A është seti i zbrazët? " + mathSet.isEmpty());
        System.out.println("Madhësia e setit: " + mathSet.size());
    }
}
