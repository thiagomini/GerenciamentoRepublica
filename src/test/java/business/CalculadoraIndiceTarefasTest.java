package business;

import collection.TarefaCollection;
import factory.MoradorDeRepublicaFactory;
import factory.TarefaFactory;
import model.MoradorDeRepublica;
import model.Tarefa;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraIndiceTarefasTest {

    /**
     * Função <b>getIndiceRealizacaoTarefasComuns()</b>
     * Deve calcular corretamente o Índice de Realização de Tarefas
     */
    @Test
    void CT011() {

        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublica[] responsaveis = new MoradorDeRepublica[]{ moradorDeRepublica };

        Tarefa[] tarefas = new Tarefa[] {
                TarefaFactory.createTarefa("COMUM", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("COMUM", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("COMUM", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("COMUM", "2020-10-20", "2020-10-19", moradorDeRepublica, responsaveis),
        };

        Arrays
                .stream(tarefas)
                .iterator()
                .forEachRemaining(TarefaCollection::addTarefa);

        double indiceRealizacaoTarefas = CalculadoraIndiceTarefas.getIndiceRealizacaoTarefasComuns(moradorDeRepublica, 10, 2020);

        assertEquals(0.25d, indiceRealizacaoTarefas, 0.001);
    }
}