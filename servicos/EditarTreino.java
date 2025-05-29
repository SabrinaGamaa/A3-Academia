package servicos;

import modelos.Treino;
import repositorio.TreinoRepositorio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditarTreino {

    public static void editarTreinoPorId(String idAlunoStr, String tipoTreino, String descricao, String duracaoStr, String dataInicioStr, String idTreinoStr ) {
        TreinoRepositorio treinoRepositorio = new TreinoRepositorio();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


        Long idTreino = Long.parseLong(idTreinoStr);
        Treino treinoAntigo = treinoRepositorio.buscarTreinoPorId(idTreino);
        
        if (treinoAntigo == null) {
            throw new IllegalArgumentException("ID Treino " + idTreino + " não encontrado!");
        }

        Long alunoId = idAlunoStr.isBlank() ? treinoAntigo.getAlunoId(): Long.parseLong(idAlunoStr);


        tipoTreino = tipoTreino.isBlank() ? treinoAntigo.getTipoTreino() : tipoTreino;


        descricao = descricao.isBlank() ? treinoAntigo.getDescricao() : descricao;

        Duration duracao = duracaoStr.isBlank() ? treinoAntigo.getDuracao() : Duration.ofMinutes(Long.parseLong(duracaoStr));

        
        LocalDateTime dataInicio = LocalDateTime.parse(dataInicioStr, fmt);

        Treino treino = new Treino(idTreino, tipoTreino, descricao, duracao, dataInicio, alunoId);
        treinoRepositorio.editarTreino(treino);

    }

}
