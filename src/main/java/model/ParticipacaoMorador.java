package model;

import java.time.LocalDate;

/**
 * Representa o valor de participação de um determinado morador em uma tabela de rateio.
 */

public class ParticipacaoMorador {
    private MoradorDeRepublica moradorDeRepublica;
    private double valorContribuido;
    private LocalDate dataPagamento;

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public MoradorDeRepublica getMoradorDeRepublica() {
        return moradorDeRepublica;
    }

    public void setMoradorDeRepublica(MoradorDeRepublica moradorDeRepublica) {
        this.moradorDeRepublica = moradorDeRepublica;
    }

    public double getValorContribuido() {
        return valorContribuido;
    }

    public void setValorContribuido(double valorContribuido) {
        if (valorContribuido <= 0) throw new IllegalArgumentException("valo contribuído recebido (" + valorContribuido + ") deve ser > 0");
        this.valorContribuido = valorContribuido;
    }

    public ParticipacaoMorador(MoradorDeRepublica moradorDeRepublica, double valorContribuido, LocalDate dataPagamento) {
        setMoradorDeRepublica(moradorDeRepublica);
        setValorContribuido(valorContribuido);
        setDataPagamento(dataPagamento);
    }

    public ParticipacaoMorador(MoradorDeRepublica moradorDeRepublica, double valorContribuido) {
        setMoradorDeRepublica(moradorDeRepublica);
        setValorContribuido(valorContribuido);
        this.dataPagamento = null;
    }
}
