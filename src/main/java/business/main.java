package business;

import builder.MoradorDeRepublicaBuilder;
import model.*;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {

        MoradorDeRepublica morador1 = criarMoradorDeRepublica(true);
        MoradorDeRepublica morador2 = criarMoradorDeRepublica(true);

        Tarefa tarefa = new Tarefa("COMUM", "teste", "2020-10-19", morador1, morador2);
        System.out.println(tarefa.getDataAgendamento());
    }


    private static MoradorDeRepublica criarMoradorDeRepublica(boolean administrador) {
        Pessoa pessoa = criarPessoa();
        Republica republica = criarRepublica();

        MoradorDeRepublicaBuilder builder = new MoradorDeRepublicaBuilder();
        builder.addRepublica(republica);
        builder.addPessoa(pessoa, administrador);
        return builder.getResultado();

    }

    private static Republica criarRepublica() {
        return new Republica(
               "Republica",
                LocalDate.now(),
                null,
                null,
                criarEndereco(),
                5,
                0d
        );
    }

    private static Endereco criarEndereco() {
        return new Endereco(
                "29560000",
                "Quincas Machado",
                "Pronto-socorro"
        );
    }

    private static Pessoa criarPessoa() {
        return new Pessoa(
                "Fulano",
                "apelido",
                "123456",
                "www",
                "010101",
                "020202"
        );
    }
}
