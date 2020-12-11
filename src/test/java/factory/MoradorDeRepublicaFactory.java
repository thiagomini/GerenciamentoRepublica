package factory;

import model.MoradorDeRepublica;
import model.Pessoa;

import java.time.LocalDate;

public class MoradorDeRepublicaFactory {

    private static final Boolean ATUAL = true;
    private static final LocalDate INICIO_ADMINISTRACAO = null;
    private static final LocalDate FIM_ADMINISTRACAO = null;


    public static MoradorDeRepublica createMoradorDeRepublica() {
        MoradorDeRepublica moradorDeRepublica = new MoradorDeRepublica();

        moradorDeRepublica.setAtual(ATUAL);
        moradorDeRepublica.setPessoa(PessoaFactory.createPessoa());
        moradorDeRepublica.setRepublica(RepublicaFactory.createRepublica());
        moradorDeRepublica.setInicioAdministracao(INICIO_ADMINISTRACAO);
        moradorDeRepublica.setFimAdministracao(FIM_ADMINISTRACAO);

        return moradorDeRepublica;
    }

    public static MoradorDeRepublica createMoradorDeRepublica(boolean administrador) {
        MoradorDeRepublica moradorDeRepublica = new MoradorDeRepublica();

        moradorDeRepublica.setAtual(ATUAL);
        moradorDeRepublica.setPessoa(PessoaFactory.createPessoa());
        moradorDeRepublica.setRepublica(RepublicaFactory.createRepublica());
        moradorDeRepublica.setInicioAdministracao(administrador ? LocalDate.now() : null);
        moradorDeRepublica.setFimAdministracao(FIM_ADMINISTRACAO);

        return moradorDeRepublica;
    }

    public static MoradorDeRepublica createMoradorDeRepublica(Pessoa pessoa) {
        MoradorDeRepublica moradorDeRepublica = new MoradorDeRepublica();
        moradorDeRepublica.setAtual(ATUAL);
        moradorDeRepublica.setPessoa(pessoa);
        moradorDeRepublica.setRepublica(RepublicaFactory.createRepublica());
        moradorDeRepublica.setInicioAdministracao(INICIO_ADMINISTRACAO);
        moradorDeRepublica.setFimAdministracao(FIM_ADMINISTRACAO);
        return moradorDeRepublica;
    }

}
