package business;

import builder.MoradorDeRepublicaBuilder;
import collection.MoradorDeRepublicaCollection;
import collection.RepublicaCollection;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * Classe responsável por criar uma república à partir de um usuário, tornando-o administrador da república criada
 * e removendo-o de outra república caso esteja associado.
 */
public class RepublicaCreator {

    /**
     * Cria um república e associa à Pessoa que o criou, tornando-a administradora e removendo-a de outra república caso
     * necessário.
     * @param criador O Criador da república
     * @param nome O nome da nova república
     * @param vantagens Lista de vantagens da nova república
     * @param vagas O número de vagas disponíveis
     * @param receitaColetiva A receita coletiva inicial
     * @param cep O CEP do endereço da república
     * @param bairro O Bairro da repúbçica
     * @param pontoReferencia O Ponto de referência da república
     * @param latitude A latitude da localização da república
     * @param longitude A longitude da localização da república
     * @param codigoEtica O Código de ética da república
     * @return A república criada
     */
    public static Republica createRepublica(
            Pessoa criador,
            String nome,
            String[] vantagens,
            int vagas,
            double receitaColetiva,
            String cep,
            String bairro,
            String pontoReferencia,
            double latitude,
            double longitude,
            String codigoEtica
                           ) {

        Geolocation geolocation = new Geolocation(latitude, longitude);

        Endereco endereco = new Endereco(cep, bairro, pontoReferencia, geolocation);

        LocalDate dataFundacao = LocalDate.now();
        ArrayList<String> listaVantagens = new ArrayList<>(Arrays.asList(vantagens));
        Republica republica = new Republica(nome, dataFundacao, null, listaVantagens, endereco, vagas, receitaColetiva, codigoEtica);

        return addRepublica(republica, criador);
    }

    /**
     *
     * @param criador O Criador da república
     * @param nome O nome da nova república
     * @param vantagens Lista de vantagens da nova república
     * @param vagas O número de vagas disponíveis
     * @param receitaColetiva A receita coletiva inicial
     * @param cep O CEP do endereço da república
     * @param bairro O Bairro da repúbçica
     * @param pontoReferencia O Ponto de referência da república
     * @return A república criada
     */
    public static Republica createRepublica(
            Pessoa criador,
            String nome,
            String[] vantagens,
            int vagas,
            double receitaColetiva,
            String cep,
            String bairro,
            String pontoReferencia
    ) {

        Endereco endereco = new Endereco(cep, bairro, pontoReferencia);
        LocalDate dataFundacao = LocalDate.now();
        ArrayList<String> listaVantagens = new ArrayList<>(Arrays.asList(vantagens));
        Republica republica = new Republica(nome, dataFundacao, null, listaVantagens, endereco, vagas, receitaColetiva);
        return addRepublica(republica, criador);
    }

    /**
     * Cria um MoradorDeRepublica para a republica e pessoa passadas como parâmetro e adiciona ambos às respectivas
     * collections.
     * @param republica A república criada pela pessoa.
     * @param criador A pessoa criadora da repúblcia
     * @return A república criada.
     */
    private static Republica addRepublica(Republica republica, Pessoa criador) {
        addMoradorDeRepublica(republica, criador);
        RepublicaCollection.addRepublica(republica);
        return republica;
    };

    private static MoradorDeRepublica addMoradorDeRepublica(Republica republica, Pessoa criador) {
        removerRepublicaAnterior(criador);

        MoradorDeRepublicaBuilder builder = new MoradorDeRepublicaBuilder();
        builder.addPessoa(criador, true);
        builder.addRepublica(republica);
        MoradorDeRepublica novoMoradorDeRepublica = builder.getResultado();

        MoradorDeRepublicaCollection.addMoradorDeRepublica(novoMoradorDeRepublica);

        return novoMoradorDeRepublica;
    }

    /**
     * Remove a associação do criador da nova república com uma república antiga, encerrando seu tempo
     * de administração caso ele seja administrador da antiga república.
     * @param criador A pessoa criadora da nova república
     */
    private static void removerRepublicaAnterior(Pessoa criador) {
        Optional<MoradorDeRepublica> moradorDeRepublica = MoradorDeRepublicaCollection.getMoradorDeRepublica(criador);
        moradorDeRepublica.ifPresent(deRepublica -> {
            deRepublica.setAtual(false);
            if (deRepublica.isRepresentante()) {
                deRepublica.encerrarAdministracao();
            }
        });
    }
}
