package collection;

import factory.MoradorDeRepublicaFactory;
import factory.PessoaFactory;
import model.MoradorDeRepublica;
import model.Pessoa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoradorDeRepublicaCollectionTest {

    @AfterEach
    void clearCollection() {
        MoradorDeRepublicaCollection.clear();
    }

    @Test
    void pessoaJaTemRepublica_RetornaTrue() {
        Pessoa pessoa = PessoaFactory.createPessoa();
        MoradorDeRepublica morador = MoradorDeRepublicaFactory.createMoradorDeRepublica(pessoa);

        MoradorDeRepublicaCollection.addMoradorDeRepublica(morador);

        boolean resultado = MoradorDeRepublicaCollection.pessoaJaTemRepublica(pessoa);

        assertTrue(resultado);
    }

    @Test
    void pessoaJaTemRepublica_RetornaFalse() {
        Pessoa pessoa1 = PessoaFactory.createPessoa();
        MoradorDeRepublica morador = MoradorDeRepublicaFactory.createMoradorDeRepublica(pessoa1);

        Pessoa pessoa2 = PessoaFactory.createPessoa();

        MoradorDeRepublicaCollection.addMoradorDeRepublica(morador);

        boolean resultado = MoradorDeRepublicaCollection.pessoaJaTemRepublica(pessoa2);

        assertFalse(resultado);
    }

    @Test
    void pessoaJaTemRepublica_RetornaFalseCasoSejaHistorico() {
        Pessoa pessoa = PessoaFactory.createPessoa();
        MoradorDeRepublica morador = MoradorDeRepublicaFactory.createMoradorDeRepublica(pessoa);
        morador.setAtual(false);

        MoradorDeRepublicaCollection.addMoradorDeRepublica(morador);

        boolean resultado = MoradorDeRepublicaCollection.pessoaJaTemRepublica(pessoa);

        assertFalse(resultado);
    }

    @Test
    void addMoradorDeRepbulica() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublicaCollection.addMoradorDeRepublica(moradorDeRepublica);

        boolean resultado = MoradorDeRepublicaCollection.getMoradoresDeRepublicas().contains(moradorDeRepublica);
        assertTrue(resultado);
    }

    @Test
    void removerMoradorDeRepbulica_peloId() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublicaCollection.addMoradorDeRepublica(moradorDeRepublica);

        MoradorDeRepublicaCollection.removerMoradorDeRepublica(moradorDeRepublica.getId());

        boolean resultado = MoradorDeRepublicaCollection.getMoradoresDeRepublicas().contains(moradorDeRepublica);
        assertFalse(resultado);
    }

    @Test
    void removerMoradorDeRepbulica_pelaReferencia() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublicaCollection.addMoradorDeRepublica(moradorDeRepublica);

        MoradorDeRepublicaCollection.removerMoradorDeRepublica(moradorDeRepublica);

        boolean resultado = MoradorDeRepublicaCollection.getMoradoresDeRepublicas().contains(moradorDeRepublica);
        assertFalse(resultado);
    }
}