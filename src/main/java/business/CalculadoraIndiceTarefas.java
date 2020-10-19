package business;

import collection.TarefaCollection;
import model.MoradorDeRepublica;
import model.Tarefa;

import java.time.Month;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CalculadoraIndiceTarefas {

    /**
     * Calcula o IRT para um mês específico
     * @param moradorDeRepublica
     * @param mesReferencia
     * @param anoReferencia
     * @return O Índice de Realização de Tarefas de um mês e ano específicos
     */
    public static double getIndiceRealizacaoTarefasComuns(MoradorDeRepublica moradorDeRepublica, int mesReferencia, int anoReferencia) {
        ArrayList<Tarefa> tarefasComuns = TarefaCollection.getTarefasComunsDeMorador(moradorDeRepublica);
        return getIndiceRealizacaoTarefas(tarefasComuns, mesReferencia, anoReferencia);
    }


    /**
     * Calcula o IRT considerando todos os meses
     * @param moradorDeRepublica
     * @return O Índice de Realização de Tarefas de todos os meses
     */
    public static double getIndiceRealizacaoTarefasComuns(MoradorDeRepublica moradorDeRepublica) {
        ArrayList<Tarefa> tarefasComuns = TarefaCollection.getTarefasComunsDeMorador(moradorDeRepublica);
        return getIndiceRealizacaoTarefas(tarefasComuns);
    }

    /**
     * Calcula o ISR para um mês específico
     * @param moradorDeRepublica
     * @param mesReferencia
     * @param anoReferencia
     * @return O índice de Solução de Reclamações de um mês e ano específicos
     */
    public static double getIndiceSolucaoReclamacoes(MoradorDeRepublica moradorDeRepublica, int mesReferencia, int anoReferencia) {
        ArrayList<Tarefa> reclamacoes = TarefaCollection.getReclamacoesDeMorador(moradorDeRepublica);
        return getIndiceRealizacaoTarefas(reclamacoes, mesReferencia, anoReferencia);
    }

    /**
     * Calcula o ISR considerando todos os meses
     * @param moradorDeRepublica
     * @return O índice de Solução de Reclamações de todos os meses
     */
    public static double getIndiceSolucaoReclamacoes(MoradorDeRepublica moradorDeRepublica) {
        ArrayList<Tarefa> reclamacoes = TarefaCollection.getReclamacoesDeMorador(moradorDeRepublica);
        return getIndiceRealizacaoTarefas(reclamacoes);
    }

    private static double getIndiceRealizacaoTarefas(ArrayList<Tarefa> tarefas, int mesReferencia, int anoReferencia) {
        ArrayList<Tarefa> tarefasConcluidas =
                tarefas
                        .stream()
                        .filter(tarefa -> {
                            Month mesDoPrazoFinal = tarefa.getPrazoFinal().getMonth();
                            int anoDoPrazoFinal = tarefa.getPrazoFinal().getYear();

                            return  mesDoPrazoFinal == Month.of(mesReferencia)
                                    && anoDoPrazoFinal == anoReferencia
                                    && tarefa.getConcluidaEm() != null;
                        })
                        .collect(Collectors
                                .toCollection(ArrayList::new)
                        );

        return (double) tarefasConcluidas.size() / tarefas.size();
    }

    private static double getIndiceRealizacaoTarefas(ArrayList<Tarefa> tarefas) {
        ArrayList<Tarefa> tarefasConcluidas =
                tarefas
                        .stream()
                        .filter(tarefa -> tarefa.getConcluidaEm() != null)
                        .collect(Collectors
                                .toCollection(ArrayList::new)
                        );

        return (double) tarefasConcluidas.size() / tarefas.size();
    }
}
