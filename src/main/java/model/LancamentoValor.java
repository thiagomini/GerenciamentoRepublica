package model;

import java.time.LocalDate;

public class LancamentoValor extends AbstractModel{
    private static int idCount = 0;

    protected Double valor;
    protected String descricao;
    protected PeriodicidadeEnum periodicidade;
    protected boolean aprovado;
    protected LocalDate dataLancamento;

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PeriodicidadeEnum getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(PeriodicidadeEnum periodicidade) {
        this.periodicidade = periodicidade;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public LancamentoValor(Double valor, String descricao, PeriodicidadeEnum periodicidade, boolean aprovado) {
        this.valor = valor;
        this.descricao = descricao;
        this.periodicidade = periodicidade;
        this.aprovado = aprovado;
        this.dataLancamento = LocalDate.now();
        this.id = ++idCount;
    }

    public LancamentoValor(Double valor, String descricao, PeriodicidadeEnum periodicidade, boolean aprovado, LocalDate dataLancamento) {
        this.valor = valor;
        this.descricao = descricao;
        this.periodicidade = periodicidade;
        this.aprovado = aprovado;
        this.dataLancamento = dataLancamento;
    }
}
