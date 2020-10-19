package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Classe que representa uma tabela de rateio de despesa entre os moradores de uma república
 */

public class TabelaRateio extends AbstractModel {
    private static int idCount = 0;
    private ArrayList<ParticipacaoMorador> paritipacaoMoradores = new ArrayList<>();

    public ArrayList<ParticipacaoMorador> getParitipacaoMoradores() {
        return paritipacaoMoradores;
    }

    public TabelaRateio() {
        this.id = ++idCount;
    }

    public void adicionarParticipante(MoradorDeRepublica participante, Double valor) {
        this.paritipacaoMoradores.add(
                new ParticipacaoMorador(participante, valor)
        );
    }

    public double getValorTotal() {
        return this.paritipacaoMoradores
                    .stream()
                    .reduce(0d, (subTotal, participacaoMorador) -> subTotal + participacaoMorador.getValorContribuido(), Double::sum);
    }

    /**
     * Retorna a porcentagem paga por uma pessoa nessa tabela de rateio
     * @param participante A pessoa que deseja recuperar a porcentagem de contribuição
     * @return A fração que representa a porcentagem paga pelo participante (ex: 0.05 = 5%)
     */
    public double getPorcentagemPaga(Pessoa participante) {
        Optional<ParticipacaoMorador> participacaoDoMorador =
                this.paritipacaoMoradores
                .stream()
                .filter(participacaoMorador -> participacaoMorador.getMoradorDeRepublica().getPessoa().equals(participante))
                .findFirst();

        if (!participacaoDoMorador.isPresent()) return 0d;

        double totalAmount = this.getValorTotal();
        return participacaoDoMorador.get().getValorContribuido() / totalAmount;
    }

    public TabelaRateio copy() {
        TabelaRateio tabelaClonada = new TabelaRateio();
        this.getParitipacaoMoradores()
                .forEach(
                        participacaoMorador -> tabelaClonada
                                .adicionarParticipante(
                                        participacaoMorador.getMoradorDeRepublica(),
                                        participacaoMorador.getValorContribuido()
                                )
                );

        return tabelaClonada;
    }

    public Optional<ParticipacaoMorador> getPagamentoMorador(MoradorDeRepublica moradorDeRepublica) {
        return this.getParitipacaoMoradores()
                .stream()
                .filter(participacaoMorador -> participacaoMorador.getMoradorDeRepublica().equals(moradorDeRepublica))
                .findFirst();
    }

    public boolean confirmarPagamentoDeMorador(MoradorDeRepublica moradorDeRepublica, LocalDate dataPagamento) {
        Optional<ParticipacaoMorador> participacaoMorador = this.getPagamentoMorador(moradorDeRepublica);
        if (!participacaoMorador.isPresent()) return false;

        participacaoMorador.get().setDataPagamento(dataPagamento);
        return true;
    }

    @Override
    public String toString() {
        return "TabelaRateio{" +
                "paritipacaoMoradores=" + paritipacaoMoradores +
                '}';
    }
}
