package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Despesa extends LancamentoValor {
    private final TabelaRateio tabelaRateio;

    private LocalDate dataVencimento;

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public TabelaRateio getTabelaRateio() {
        return tabelaRateio;
    }

    public Despesa(Double valor, String descricao, PeriodicidadeEnum periodicidade, boolean aprovado) {
        super(valor, descricao, periodicidade, aprovado);
        this.tabelaRateio = new TabelaRateio();
    }

    public Despesa(Double valor, String descricao, PeriodicidadeEnum periodicidade, boolean aprovado, LocalDate dataVencimento) {
        super(valor, descricao, periodicidade, aprovado);
        setDataVencimento(dataVencimento);
        this.tabelaRateio = new TabelaRateio();
    }

    public Despesa(Double valor, String descricao, PeriodicidadeEnum periodicidade, boolean aprovado, LocalDate dataLancamento, LocalDate dataVencimento, TabelaRateio tabelaRateio) {
        super(valor, descricao, periodicidade, aprovado, dataLancamento);
        setDataVencimento(dataVencimento);
        this.tabelaRateio = tabelaRateio;
    }

    public void adicionarParticipanteDeRateio(MoradorDeRepublica participante, double valor) {
        double valorTotalAtual = this.tabelaRateio.getValorTotal();
        if (valorTotalAtual + valor > this.valor) {
            throw new RuntimeException("Não é possível adicionar o valor "
                    + valor
                    + " pois excede o valor total da despesa (" + valorTotalAtual + ")"
            );
        }

        this.tabelaRateio.adicionarParticipante(participante, valor);
    }

    public boolean confirmarPagamentoDeMorador(MoradorDeRepublica moradorDeRepublica, LocalDate data) {
        return this.tabelaRateio.confirmarPagamentoDeMorador(moradorDeRepublica, data);
    }

    public Despesa copy() {
        return new Despesa(
            this.valor,
            this.descricao,
            this.periodicidade,
            this.aprovado,
            this.dataLancamento,
            this.dataVencimento,
            this.tabelaRateio.copy()
        );
    }

    public void adiarVencimentoEmMeses(int meses) {
        this.setDataVencimento(
                this.getDataVencimento().plusMonths(meses)
        );
    }

    public ArrayList<MoradorDeRepublica> getParticipantes() {
        return this.tabelaRateio
                .getParitipacaoMoradores()
                .stream()
                .map(ParticipacaoMorador::getMoradorDeRepublica)
                .collect(Collectors
                .toCollection(ArrayList::new)
                );
    }

    public Optional<LocalDate> getDataPagamentoDeMorador(MoradorDeRepublica moradorDeRepublica) {
        Optional<ParticipacaoMorador> pagamentoMorador = this.tabelaRateio.getPagamentoMorador(moradorDeRepublica);

        Optional<LocalDate> resultado = Optional.empty();
        if (pagamentoMorador.isPresent()) resultado = Optional.of(pagamentoMorador.get().getDataPagamento());

        return resultado;
    }
}
