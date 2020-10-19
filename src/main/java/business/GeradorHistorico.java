package business;

import collection.MoradorDeRepublicaCollection;
import model.HistoricoMorador;
import model.MoradorDeRepublica;

import java.util.TreeSet;

/**
 * Gera um histórico de um morador para um outro morador
 */
public class GeradorHistorico {

    public static HistoricoMorador getHistorico(MoradorDeRepublica requerente, MoradorDeRepublica observado) throws IllegalAccessException {
        if (!moraNaMesmaRepublica(requerente, observado))
            throw new IllegalAccessException("O requerente deve morar na mesma república para ver o histórico de um morador");

        TreeSet<MoradorDeRepublica> moradiasDoObservado = MoradorDeRepublicaCollection.listarMoradias(observado.getPessoa());
        return new HistoricoMorador(moradiasDoObservado);
    }

    private static boolean moraNaMesmaRepublica(MoradorDeRepublica morador1, MoradorDeRepublica morador2) {
        return morador1.getRepublica().equals(morador2.getRepublica())
               && morador1.getAtual()
               && morador2.getAtual();
    }

}
