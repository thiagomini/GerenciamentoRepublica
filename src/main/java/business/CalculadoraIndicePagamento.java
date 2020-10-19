package business;

import model.Despesa;
import model.MoradorDeRepublica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class CalculadoraIndicePagamento {

    public static double calcularMediaIndiceCompromissoDePagamento(MoradorDeRepublica moradorDeRepublica) {
        ArrayList<Despesa> despesas =
                moradorDeRepublica
                        .getRepublica()
                        .getFluxoCaixa()
                        .stream()
                        .filter(
                                lancamentoValor -> lancamentoValor.getClass() == Despesa.class
                                                   && lancamentoValor.isAprovado()
                        )
                        .map( lancamentoValor -> (Despesa) lancamentoValor )
                        .collect(Collectors
                                .toCollection(ArrayList::new)
                        );

        ArrayList<Despesa> despesasDoMorador = getDespesasDoMorador(moradorDeRepublica, despesas);

        ArrayList<Double> indiceCompromissos =
                despesasDoMorador
                        .stream()
                        .map(despesa -> getIndiceCompromissoPagamento(moradorDeRepublica, despesa))
                        .collect(Collectors
                        .toCollection(ArrayList::new)
                        );

        OptionalDouble media = indiceCompromissos
                .stream()
                .mapToDouble(a -> a)
                .average();

        return media.isPresent() ? media.getAsDouble() : 0d;

    }

    private static ArrayList<Despesa> getDespesasDoMorador(MoradorDeRepublica moradorDeRepublica, ArrayList<Despesa> despesas) {
        return despesas
            .stream()
            .filter(despesa -> despesa.getParticipantes().contains(moradorDeRepublica))
            .collect(Collectors
            .toCollection(ArrayList::new)
            );
    }

    private static double getIndiceCompromissoPagamento(MoradorDeRepublica moradorDeRepublica, Despesa despesa) {
        LocalDate diaDoVencimento = despesa.getDataVencimento();
        Optional<LocalDate> dataPagamento = despesa.getDataPagamentoDeMorador(moradorDeRepublica);
        if (!dataPagamento.isPresent()) return 0d;

        int diferencaEmDias = diaDoVencimento.until(dataPagamento.get()).getDays();

        return (double) diaDoVencimento.getDayOfMonth() / (diaDoVencimento.getDayOfMonth() + diferencaEmDias);
    }

}
