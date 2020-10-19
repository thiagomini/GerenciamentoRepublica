package collection;

import model.MoradorDeRepublica;
import model.Pessoa;
import model.Republica;

import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MoradorDeRepublicaCollection {
    private static final TreeSet<MoradorDeRepublica> MORADORES_DE_REPUBLICAS = new TreeSet<>();

    public static TreeSet<MoradorDeRepublica> getMoradoresDeRepublicas() {
        return MORADORES_DE_REPUBLICAS;
    }

    public static void addMoradorDeRepublica(MoradorDeRepublica novoMorador) {
        MORADORES_DE_REPUBLICAS.add(novoMorador);
    }

    public static void removerMoradorDeRepublica(int id) {
        MORADORES_DE_REPUBLICAS.removeIf((moradorDeRepublica -> moradorDeRepublica.getId() == id ));
    }

    public static void removerMoradorDeRepublica(MoradorDeRepublica moradorDeRepublica) {
        MORADORES_DE_REPUBLICAS.remove(moradorDeRepublica);
    }

    /**
     * Lista as moradias de uma determinada pessoa
     * @param pessoa
     * @return
     */
    public static TreeSet<MoradorDeRepublica> listarMoradias(Pessoa pessoa) {
        return MORADORES_DE_REPUBLICAS
                .stream()
                .filter(morador -> morador.getPessoa().equals(pessoa))
                .collect(Collectors
                .toCollection(TreeSet::new)
                );
    }

    public static void clear() {
        MORADORES_DE_REPUBLICAS.clear();
    }

    public static Boolean pessoaJaTemRepublica(Pessoa pessoa) {
        for (MoradorDeRepublica morador: MORADORES_DE_REPUBLICAS) {
            if (morador.getPessoa().equals(pessoa) && morador.getAtual()) {
                return true;
            };
        }
        return false;
    }

    public static Optional<Republica> getRepublicaAtualDaPessoa(Pessoa pessoa) {
        for (MoradorDeRepublica morador : MORADORES_DE_REPUBLICAS) {
            if (morador.getPessoa().equals(pessoa)) {
                return Optional.of(morador.getRepublica());
            }
        }
        return Optional.empty();
    }

    public static Optional<MoradorDeRepublica> getMoradorDeRepublica(Pessoa pessoa) {
        for (MoradorDeRepublica morador : MORADORES_DE_REPUBLICAS) {
            if (morador.getPessoa().equals(pessoa)) {
                return Optional.of(morador);
            }
        }
        return Optional.empty();
    }

    public static Optional<MoradorDeRepublica> getRepresentanteRepublica(Republica republica) {
        return MORADORES_DE_REPUBLICAS
                .stream()
                .filter(moradorDeRepublica -> moradorDeRepublica.getRepublica().equals(republica)
                                              && moradorDeRepublica.isRepresentante()
                )
                .findFirst();
    }

}
