package builder;

import collection.MoradorDeRepublicaCollection;
import factory.MoradorDeRepublicaFactory;
import factory.PessoaFactory;
import model.MoradorDeRepublica;
import model.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoradorDeRepublicaBuilderTest {
    private MoradorDeRepublicaBuilder builder;

    @BeforeEach
    public void initializeBuilder() {
        this.builder = new MoradorDeRepublicaBuilder();
    }

    /**
     * BR 02 - Morador não pode residir em mais de uma república ao mesmo tempo
     */
    @Test
    void addPessoa_lancaErro() {
        Pessoa pessoa = PessoaFactory.createPessoa();
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica(pessoa);
        MoradorDeRepublicaCollection.addMoradorDeRepublica(moradorDeRepublica);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            this.builder.addPessoa(pessoa, false);
        });

        String expectedMessage = "A Pessoa " + pessoa.getNome() + " já está em uma república!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }
}