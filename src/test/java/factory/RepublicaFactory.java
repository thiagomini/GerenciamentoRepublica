package factory;

import model.Endereco;
import model.Republica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class RepublicaFactory {
    private static final String NOME = "Republica";
    private static final LocalDate DATA_FUNDACAO = LocalDate.now();
    private static final LocalDate DATA_EXTINCAO = null;
    private static final ArrayList<String> VANTAGENS = new ArrayList<>(Arrays.asList("vantagem 1", "vantagem 2"));
    private static final Endereco ENDERECO = EnderecoFactory.createEndereco();
    private static final int VAGAS = 5;
    private static final String CODIGO_DE_ETICA = "Codigo de Etica";
    private static final Double RECEITA_COLETIVA = 0d;

    public static Republica createRepublica() {
        return new Republica(
                NOME,
                DATA_FUNDACAO,
                DATA_EXTINCAO,
                VANTAGENS,
                ENDERECO,
                VAGAS,
                RECEITA_COLETIVA,
                CODIGO_DE_ETICA
        );
    }


}
