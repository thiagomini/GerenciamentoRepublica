package model;

public class Receita extends LancamentoValor{

    public Receita(Double valor, String descricao, PeriodicidadeEnum periodicidade, boolean aprovado) {
        super(valor, descricao, periodicidade, aprovado);
    }
}
