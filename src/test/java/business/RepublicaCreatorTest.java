package business;

import collection.MoradorDeRepublicaCollection;
import collection.RepublicaCollection;
import factory.MoradorDeRepublicaFactory;
import factory.PessoaFactory;
import model.MoradorDeRepublica;
import model.Pessoa;
import model.Republica;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RepublicaCreatorTest {

    /**
     * Função <b>createRepublica()</b><br>
     * Deve adicionar corretamente uma república na sua collection.
     */
    @Test
    void CT002() {
        Pessoa pessoa = PessoaFactory.createPessoa();

        Republica novaRepublica = RepublicaCreator.createRepublica(
                pessoa,
                "Republica Nova",
                new String[]{"vantagem 1"},
                5,
                0d,
                "29560-000",
                "bairro",
                "ponto de referencia"
        );

        assertTrue(RepublicaCollection.contemRepublica(novaRepublica));
    }

    /**
     * Função <b>createRepublica()</b><br>
     * Deve adicionar corretamente um morador na sua collection.
     */
    @Test
    void CT003() {
        Pessoa pessoa = PessoaFactory.createPessoa();

        Republica novaRepublica = RepublicaCreator.createRepublica(
                pessoa,
                "Republica Nova",
                new String[]{"vantagem 1"},
                5,
                0d,
                "29560-000",
                "bairro",
                "ponto de referencia"
        );

        assertTrue(MoradorDeRepublicaCollection.pessoaJaTemRepublica(pessoa));
    }

    /**
     * Função <b>createRepublica()</b><br>
     * BR 02 - Morador de República deve se tornar o administrador da república que criou.
     */
    @Test
    void CT004() {
        Pessoa pessoa = PessoaFactory.createPessoa();

        Republica novaRepublica = RepublicaCreator.createRepublica(
                pessoa,
                "Republica Nova",
                new String[]{"vantagem 1"},
                5,
                0d,
                "29560-000",
                "bairro",
                "ponto de referencia"
        );

        Optional<MoradorDeRepublica> moradorDeRepublica = MoradorDeRepublicaCollection.getMoradorDeRepublica(pessoa);
        assertTrue(moradorDeRepublica.isPresent());
        assertNotNull(moradorDeRepublica.get().getInicioAdministracao());
    }

    /**
     * Função <b>createRepublica()</b><br>
     * BR 02 - Ao confirmar a criação de uma república o morador deixa a república atual.
     */
    @Test
    void CT005() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublicaCollection.addMoradorDeRepublica(moradorDeRepublica);

        Pessoa pessoa = moradorDeRepublica.getPessoa();

        Republica novaRepublica = RepublicaCreator.createRepublica(
                pessoa,
                "Republica Nova",
                new String[]{"vantagem 1"},
                5,
                0d,
                "29560-000",
                "bairro",
                "ponto de referencia"
        );

        Optional<MoradorDeRepublica> novoMoradorDeRepublica = MoradorDeRepublicaCollection.getMoradorDeRepublica(pessoa);
        assertTrue(novoMoradorDeRepublica.isPresent());
        assertFalse(moradorDeRepublica.getAtual());
    }

    /**
     * BR 02 (extra) - Ao confirmar a criação de uma república, caso o morador seja administrador da república anterior,
     * encerra o período de administração da república anterior como o tempo atual
     */
    @Test
    void CT006() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica(true);
        MoradorDeRepublicaCollection.addMoradorDeRepublica(moradorDeRepublica);

        Pessoa pessoa = moradorDeRepublica.getPessoa();

        Republica novaRepublica = RepublicaCreator.createRepublica(
                pessoa,
                "Republica Nova",
                new String[]{"vantagem 1"},
                5,
                0d,
                "29560-000",
                "bairro",
                "ponto de referencia"
        );

        Optional<MoradorDeRepublica> novoMoradorDeRepublica = MoradorDeRepublicaCollection.getMoradorDeRepublica(pessoa);
        assertTrue(novoMoradorDeRepublica.isPresent());
        assertFalse(moradorDeRepublica.isRepresentante());
    }


}