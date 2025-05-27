package modelos;

//2.2. Módulo de Treinos
//    • Cadastrar um treino para um aluno (tipo de treino, descrição, duração, data de início).
//        • Listar todos os treinos de um aluno específico.
//        • Editar informações de um treino.
//    • Excluir um treino.

import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

public class Treino {

    private Long id;
    private String tipoTreino;
    private String descricao;
    private Duration duracao;
    private LocalDate dataInicio;

    public Treino(Long id, String tipoTreino, String descricao, Duration duracao, LocalDate dataInicio) {
        this.id = id;
        this.tipoTreino = tipoTreino;
        this.descricao = descricao;
        this.duracao = duracao;
        this.dataInicio = dataInicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoTreino() {
        return tipoTreino;
    }

    public void setTipoTreino(String tipoTreino) {
        this.tipoTreino = tipoTreino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Treino treino = (Treino) o;
        return Objects.equals(id, treino.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
