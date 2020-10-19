package model;

import collection.MoradorDeRepublicaCollection;

import java.util.TreeSet;

public class HistoricoMorador {

    private final TreeSet<MoradorDeRepublica> historicoMoradia;

    public TreeSet<MoradorDeRepublica> getHistoricoMoradia() {
        return historicoMoradia;
    }

    public HistoricoMorador(TreeSet<MoradorDeRepublica> historicoMoradia) {
        this.historicoMoradia = historicoMoradia;
    }

    @Override
    public String toString() {
       String resultadoFinal = "[";

       for (MoradorDeRepublica moradorDeRepublica : historicoMoradia) {
           Pessoa representante = MoradorDeRepublicaCollection
                   .getRepresentanteRepublica(moradorDeRepublica.getRepublica())
                   .get()
                   .getPessoa();

           resultadoFinal = resultadoFinal.concat(
                   "\n{" +
                           "nomeRepublica: " + moradorDeRepublica.getRepublica().getNome() +
                           "\nrepresentateAtual: " + representante.getNome() +
                           "\ncontatoRepresentante: " + representante.getTelefone() +
                           "\nreputacao: " + moradorDeRepublica.calcularReputacao() +
                   "\n}"

           );
       }

       resultadoFinal = resultadoFinal.concat("\n]");
       return resultadoFinal;
    }

}
