package factory;

import model.MoradorDeRepublica;
import model.Tarefa;
import model.TipoTarefaEnum;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

public class TarefaFactory {
    private static final String DESCRICAO = "Tarefa Teste";

    public static Tarefa createTarefa(String tipoTarefa, String prazoFinal, MoradorDeRepublica criadaPor, MoradorDeRepublica[] responsaveis) {
        return new Tarefa(
                TipoTarefaEnum.valueOf(tipoTarefa),
                DESCRICAO,
                LocalDate.now(),
                LocalDate.parse(prazoFinal),
                null,
                criadaPor,
                new HashSet<>(Arrays.asList(responsaveis)),
                false
        );
    }

    public static Tarefa createTarefa(String tipoTarefa, String prazoFinal, String concluidaEm, MoradorDeRepublica criadaPor, MoradorDeRepublica[] responsaveis) {
        return new Tarefa(
                TipoTarefaEnum.valueOf(tipoTarefa),
                DESCRICAO,
                LocalDate.now(),
                LocalDate.parse(prazoFinal),
                LocalDate.parse(concluidaEm),
                criadaPor,
                new HashSet<>(Arrays.asList(responsaveis)),
                false
        );
    }



}
