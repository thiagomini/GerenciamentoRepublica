package builder;

import collection.MoradorDeRepublicaCollection;
import model.MoradorDeRepublica;
import model.Pessoa;
import model.Republica;

import java.time.LocalDate;

public class MoradorDeRepublicaBuilder {
    private MoradorDeRepublica resultado;

    public MoradorDeRepublicaBuilder () {
        this.reset();
    }
    public void reset() {
        this.resultado = new MoradorDeRepublica();
    }

    public void addPessoa(Pessoa pessoa, Boolean administrador) {
        if (MoradorDeRepublicaCollection.pessoaJaTemRepublica(pessoa)) {
            throw new RuntimeException("A Pessoa " + pessoa.getNome() + " já está em uma república!");
        }
        this.resultado.setPessoa(pessoa);
        this.resultado.setAtual(true);
        if (administrador) {
            this.resultado.setInicioAdministracao(LocalDate.now());
        }
    }

    public void addRepublica(Republica republica) {
        this.resultado.setRepublica(republica);
    }

    public MoradorDeRepublica getResultado() {
        return this.resultado;
    }

}
