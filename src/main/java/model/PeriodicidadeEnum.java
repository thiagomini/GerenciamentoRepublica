package model;

public enum PeriodicidadeEnum {
    DESPESA_UNICA(0), SEMANAL(7), MENSAL(30);

    public int getValorPeriodicidade() {
        return valorPeriodicidade;
    }

    public int valorPeriodicidade;

    PeriodicidadeEnum(int valor) {
        valorPeriodicidade = valor;
    }
}
