package modelos;

//2.2. Módulo de Treinos
//    • Cadastrar um treino para um aluno (tipo de treino, descrição, duração, data de início).
//        • Listar todos os treinos de um aluno específico.
//        • Editar informações de um treino.
//    • Excluir um treino.

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Treino {

    private Long id;
    private String tipoTreino;
    private String descricao;
    private Duration duracao;
    private LocalDateTime dataInicio;

    private Long alunoId;
    
    public Treino(){
    }

    public Treino(Long id, String tipoTreino, String descricao, Duration duracao, LocalDateTime dataInicio, Long alunoId) {
        this.id = id;
        this.tipoTreino = tipoTreino;
        this.descricao = descricao;
        this.duracao = duracao;
        this.dataInicio = dataInicio;
        this.alunoId = alunoId;
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

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
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

    @Override
    public String toString() {
        return  "\nAluno ID: " + alunoId +
                "\nTreino ID: " + id +
                "\nTipo: " + tipoTreino +
                "\nDescrição: " + descricao +
                "\nDuração: " + duracao.toMinutes() + " minutos" +
                "\nData de Início: " + dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                "\n---------------------------";
    }
}
