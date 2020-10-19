package model;

import java.time.LocalDate;
import java.util.HashSet;

/**
 * Classe que representa Tarefas, Sugestões e Reclamações. Cada variante dessas é representada
 * pelo TipoTarefaEnum. Os responsáveis pela tarefa estão associados pelo atributo responsáveis
 */
public class Tarefa extends AbstractModel {
    private static int idCount = 0;

    private TipoTarefaEnum tipoTarefa;
    private String descricao;
    private LocalDate dataAgendamento;
    private LocalDate prazoFinal;
    private LocalDate concluidaEm;
    private MoradorDeRepublica criadaPor;
    private HashSet<MoradorDeRepublica> responsaveis = new HashSet<>();
    private boolean excluida;

    public TipoTarefaEnum getTipoTarefa() {
        return tipoTarefa;
    }

    public HashSet<MoradorDeRepublica> getResponsaveis() {
        return responsaveis;
    }

    public void setTipoTarefa(TipoTarefaEnum tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalDate getPrazoFinal() {
        return prazoFinal;
    }

    public void setPrazoFinal(LocalDate prazoFinal) {
        this.prazoFinal = prazoFinal;
    }

    public LocalDate getConcluidaEm() {
        return concluidaEm;
    }

    public void setConcluidaEm(LocalDate concluidaEm) {
        this.concluidaEm = concluidaEm;
    }

    public MoradorDeRepublica getCriadaPor() {
        return criadaPor;
    }

    public void setCriadaPor(MoradorDeRepublica criadaPor) {
        this.criadaPor = criadaPor;
    }

    public boolean isExcluida() {
        return excluida;
    }

    public void setExcluida(boolean excluida) {
        this.excluida = excluida;
    }

    /**
     * Cria a tarefa e atribui apenas a um responsável.
     * @param tipoTarefa
     * @param descricao
     * @param prazoFinal
     * @param criadaPor
     * @param responsavel
     */
    public Tarefa(String tipoTarefa, String descricao, String prazoFinal, MoradorDeRepublica criadaPor, MoradorDeRepublica responsavel) {
        this.tipoTarefa = TipoTarefaEnum.valueOf(tipoTarefa.toUpperCase());
        this.descricao = descricao;
        this.dataAgendamento = LocalDate.now();
        this.prazoFinal = LocalDate.parse(prazoFinal);
        this.criadaPor = criadaPor;
        this.excluida = false;
        this.responsaveis.add(responsavel);
        this.id = ++idCount;
    }

    public Tarefa(TipoTarefaEnum tipoTarefa, String descricao, LocalDate dataAgendamento, LocalDate prazoFinal, LocalDate concluidaEm, MoradorDeRepublica criadaPor, HashSet<MoradorDeRepublica> responsaveis, boolean excluida) {
        this.tipoTarefa = tipoTarefa;
        this.descricao = descricao;
        this.dataAgendamento = dataAgendamento;
        this.prazoFinal = prazoFinal;
        this.concluidaEm = concluidaEm;
        this.criadaPor = criadaPor;
        this.responsaveis = responsaveis;
        this.excluida = excluida;
        this.id = ++idCount;
    }

    public void addResponsavel(MoradorDeRepublica novoResponsavel) {
        this.responsaveis.add(novoResponsavel);
    }

    public void removerResponsavel(MoradorDeRepublica responsavel) {
        this.responsaveis.remove(responsavel);
    }

    public void concluirTarefa() {
        this.setConcluidaEm(LocalDate.now());
    }


}
