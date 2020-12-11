package business;

import factory.MoradorDeRepublicaFactory;
import model.Despesa;
import model.MoradorDeRepublica;
import model.PeriodicidadeEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraIndicePagamentoTest {

    /**
     * Função <b>calcularMediaIndiceCompromissoDePagamento()</b>
     * Deve calcular corretamente o Índice de Compromisso de Pagamentos
     */
    @Test
    void CT010() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();

        Despesa novaDespesa = new Despesa(
                100d,
                "Despesa Teste",
                PeriodicidadeEnum.MENSAL,
                true,
                LocalDate.parse("2020-12-20")

        );

        novaDespesa.adicionarParticipanteDeRateio(moradorDeRepublica, 100d);
        moradorDeRepublica.adicionarDespesa(novaDespesa);

        novaDespesa.confirmarPagamentoDeMorador(moradorDeRepublica, LocalDate.parse("2020-12-18"));

        double indicePagamento = CalculadoraIndicePagamento.calcularMediaIndiceCompromissoDePagamento(moradorDeRepublica);

        assertEquals(1.11d, indicePagamento, 0.01);
    }
}