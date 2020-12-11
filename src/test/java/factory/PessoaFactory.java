package factory;

import model.Pessoa;

import java.util.ArrayList;
import java.util.Arrays;

public class PessoaFactory {
    private static final String NOME_PADRAO = "Fulano";
    private static final String APELIDO_PADRAO = "Apelido do Fulano";
    private static final String TELEFONE_PADRAO = "123456789";
    private static final String LINK_REDE_SOCIAL_PADRAO = "www.link.com.br";
    private static final ArrayList<String> NUMERO_RESPONSAVEIS_PADRAO = new ArrayList<>(Arrays.asList("010101", "020202"));


    public static Pessoa createPessoa() {
        return new Pessoa(
                NOME_PADRAO,
                APELIDO_PADRAO,
                TELEFONE_PADRAO,
                LINK_REDE_SOCIAL_PADRAO,
                NUMERO_RESPONSAVEIS_PADRAO.get(0),
                NUMERO_RESPONSAVEIS_PADRAO.get(1)
        );
    }


}
