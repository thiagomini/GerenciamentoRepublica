package business;

import model.Despesa;
import model.LancamentoValor;
import model.MoradorDeRepublica;
import model.PeriodicidadeEnum;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Gerencia os lançamentos de despesas para uma república
 */
public class GerenciadorDespesas {

    public LancamentoValor lancarValorUnico(MoradorDeRepublica moradorDeRepublica, String descricao, double valor, String dataVencimento) {
        Despesa novaDespesa = new Despesa(
                valor,
                descricao,
                PeriodicidadeEnum.DESPESA_UNICA,
                false,
                LocalDate.parse(dataVencimento)
        );

        moradorDeRepublica.adicionarDespesa(novaDespesa);
        return novaDespesa;
    }

    public LancamentoValor lancarValorSemanal(MoradorDeRepublica moradorDeRepublica, String descricao, int semanas, double valor, String dataVencimento) {
        Despesa novaDespesa = new Despesa(
                valor,
                descricao,
                PeriodicidadeEnum.SEMANAL,
                false,
                LocalDate.parse(dataVencimento)
        );

        this.criarLancamentosParciais(moradorDeRepublica, semanas, novaDespesa);

        return novaDespesa;
    }

    public LancamentoValor lancarValorMensal(MoradorDeRepublica moradorDeRepublica, String descricao, int meses, double valor, String dataVencimento) {
        Despesa novaDespesa = new Despesa(
                valor,
                descricao,
                PeriodicidadeEnum.MENSAL,
                false,
                LocalDate.parse(dataVencimento)
        );

        this.criarLancamentosParciais(moradorDeRepublica, meses, novaDespesa);
        return novaDespesa;
    }

    /**
     * Repete os lançamentos de uma despesa para as parcelas futuras, inserindo-os no fluxo de caixa de uma república.
     * @param moradorDeRepublica O Morador de república que adicionará a despesa
     * @param numeroLancamentos O número de lançamentos da despesa
     * @param despesaOriginal A despesa que foi criada originalmente
     */
    private void criarLancamentosParciais(MoradorDeRepublica moradorDeRepublica, int numeroLancamentos, Despesa despesaOriginal) {
        ArrayList<Despesa> despesasClonadas = this.getCloneDespesas(despesaOriginal, numeroLancamentos - 1);
        moradorDeRepublica.adicionarDespesa(despesaOriginal);
        despesasClonadas.forEach(moradorDeRepublica::adicionarDespesa);
    }

    /**
     * Retorna clones da despesa passada como parâmetro, atualizando a data de vencimento para cada.
     * @param despesa
     * @param numeroClones
     * @return
     */
    private ArrayList<Despesa> getCloneDespesas(Despesa despesa, int numeroClones) {
      ArrayList<Despesa> cloneDespesas = new ArrayList<>(numeroClones);

        for (int i = 0; i < numeroClones; i ++) {
            Despesa despesaCopia = despesa.copy();
            despesaCopia.adiarVencimentoEmMeses(i + 1);
            cloneDespesas.add(despesaCopia);
        }

        return cloneDespesas;
    }
}
