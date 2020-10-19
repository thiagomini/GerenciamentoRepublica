package collection;

import model.Republica;

import java.util.TreeSet;

public class RepublicaCollection {

    private static final TreeSet<Republica> REPUBLICAS = new TreeSet<>();

    public static TreeSet<Republica> getRepublicas() {
        return REPUBLICAS;
    }

    public static boolean contemRepublica(Republica republica) {
        return REPUBLICAS.contains(republica);
    }

    public static void addRepublica(Republica novaRepublica) {
        REPUBLICAS.add(novaRepublica);
    }

    public static void removerRepublica(Republica republica) {
        REPUBLICAS.remove(republica);
    }

    public static void removerRepublica(int id) {
        REPUBLICAS.removeIf((moradorDeRepublica -> moradorDeRepublica.getId() == id ));
    }

    public static void clear() {
        REPUBLICAS.clear();
    }

}
