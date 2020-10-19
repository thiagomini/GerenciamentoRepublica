package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Republica extends AbstractModel{
    private static int idCount = 0;

    private String nome;
    private LocalDate dataFundacao;
    private LocalDate dataExtincao;
    private ArrayList<String> vantagens = new ArrayList<>();
    private Endereco endereco;
    private Integer vagas;
    private String codigoEtica;
    private Double receitaColetiva = 0d;

    public ArrayList<LancamentoValor> getFluxoCaixa() {
        return fluxoCaixa;
    }

    private ArrayList<LancamentoValor> fluxoCaixa = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public LocalDate getDataExtincao() {
        return dataExtincao;
    }

    public void setDataExtincao(LocalDate dataExtincao) {
        this.dataExtincao = dataExtincao;
    }

    public ArrayList<String> getVantagens() {
        return vantagens;
    }

    public void setVantagens(ArrayList<String> vantagens) {
        this.vantagens = vantagens;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        if (vagas <= 0) throw new IllegalArgumentException("número de vagas recebido (" + vagas + ") deve ser > 0");
        this.vagas = vagas;
    }

    public String getCodigoEtica() {
        return codigoEtica;
    }

    public void setCodigoEtica(String codigoEtica) {
        this.codigoEtica = codigoEtica;
    }

    public Double getReceitaColetiva() {
        return receitaColetiva;
    }

    public void setReceitaColetiva(Double receitaColetiva) {
        if (receitaColetiva < 0) throw new IllegalArgumentException("receita coletiva (" + receitaColetiva + ") deve ser >= 0");
        this.receitaColetiva = receitaColetiva;
    }

    /**
     * Construtor com todas as informações
     * @param nome Nome da república
     * @param dataFundacao Data de fundação da república
     * @param dataExtincao Data de Extinção da república
     * @param vantagens Lista de vantagens da república
     * @param endereco O Endereço da república
     * @param vagas Número de vagas totais da república
     * @param receitaColetiva Valor de saldo da república
     * @param codigoEtica Código de ética da república.
     */
    public Republica(String nome, LocalDate dataFundacao, LocalDate dataExtincao, ArrayList<String> vantagens, Endereco endereco, Integer vagas, Double receitaColetiva, String codigoEtica) {
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.dataExtincao = dataExtincao;
        this.vantagens = vantagens;
        this.endereco = endereco;
        setVagas(vagas);
        this.codigoEtica = codigoEtica;
        setReceitaColetiva(receitaColetiva);
        this.id = ++idCount;
    }

    /**
     * Construtor padrão sem código de ética
     * @param nome Nome da república
     * @param dataFundacao Data de fundação da república
     * @param dataExtincao Data de Extinção da república
     * @param vantagens Lista de vantagens da república
     * @param endereco O Endereço da república
     * @param vagas Número de vagas totais da república
     * @param receitaColetiva Valor de saldo da república
     */
    public Republica(String nome, LocalDate dataFundacao, LocalDate dataExtincao, ArrayList<String> vantagens, Endereco endereco, Integer vagas, Double receitaColetiva) {
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.dataExtincao = dataExtincao;
        this.vantagens = vantagens;
        this.endereco = endereco;
        setVagas(vagas);
        this.codigoEtica = "";
        setReceitaColetiva(receitaColetiva);
        this.id = ++idCount;
    }

    public void adicionarAoFluxoDeCaixa(LancamentoValor novoLancamento) {
        this.getFluxoCaixa().add(novoLancamento);
    }

}
