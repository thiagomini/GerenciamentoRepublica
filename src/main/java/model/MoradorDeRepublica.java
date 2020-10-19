package model;

import business.CalculadoraIndicePagamento;
import business.CalculadoraIndiceTarefas;

import java.time.LocalDate;

public class MoradorDeRepublica extends AbstractModel{
    private static int idCount = 0;

    private Pessoa pessoa;
    private Republica republica;
    private Boolean atual;
    private LocalDate inicioAdministracao;
    private LocalDate fimAdministracao;


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Republica getRepublica() {
        return republica;
    }

    public void setRepublica(Republica republica) {
        this.republica = republica;
    }

    public Boolean getAtual() {
        return atual;
    }

    public void setAtual(Boolean atual) {
        this.atual = atual;
    }

    public LocalDate getInicioAdministracao() {
        return inicioAdministracao;
    }

    public void setInicioAdministracao(LocalDate inicioAdministracao) {
        this.inicioAdministracao = inicioAdministracao;
    }

    public LocalDate getFimAdministracao() {
        return fimAdministracao;
    }

    public void setFimAdministracao(LocalDate fimAdministracao) {
        this.fimAdministracao = fimAdministracao;
    }

    public MoradorDeRepublica() {
        this.id = ++idCount;
    }

    public boolean isRepresentante() {
        return this.inicioAdministracao != null && this.fimAdministracao == null;
    }

    public void encerrarAdministracao() {
        this.fimAdministracao = LocalDate.now();
    }

    public void adicionarDespesa(Despesa novaDespesa) {
        this.getRepublica().adicionarAoFluxoDeCaixa(novaDespesa);
    }

    /**
     * Calcula a reputação de um mês específico
     * @param mesReferencia
     * @param anoReferencia
     * @return A reputação do mês do morador
     */
    public double calcularReputacao(int mesReferencia, int anoReferencia) {
        double indiceSolucaoReclamacoes = CalculadoraIndiceTarefas.getIndiceSolucaoReclamacoes(this, mesReferencia, anoReferencia);
        double indiceRealizacaoTarefas = CalculadoraIndiceTarefas.getIndiceRealizacaoTarefasComuns(this, mesReferencia, anoReferencia);
        double indiceCompromissoPagamento = CalculadoraIndicePagamento.calcularMediaIndiceCompromissoDePagamento(this);

        return indiceCompromissoPagamento + indiceRealizacaoTarefas + indiceSolucaoReclamacoes;
    }

    /**
     * Calcula a reputação levando em conta todos os meses
     * @return A reputação geral do morador
     */
    public double calcularReputacao() {
        double indiceSolucaoReclamacoes = CalculadoraIndiceTarefas.getIndiceSolucaoReclamacoes(this);
        double indiceRealizacaoTarefas = CalculadoraIndiceTarefas.getIndiceRealizacaoTarefasComuns(this);
        double indiceCompromissoPagamento = CalculadoraIndicePagamento.calcularMediaIndiceCompromissoDePagamento(this);

        return indiceCompromissoPagamento + indiceRealizacaoTarefas + indiceSolucaoReclamacoes;
    }

}
