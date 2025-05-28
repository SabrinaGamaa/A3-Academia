package servicos;

import modelos.Aluno;
import modelos.Treino;
import repositorio.AlunoRepositorio;
import repositorio.TreinoRepositorio;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EditarTreino {

    public static void editarTreinoPorId(Scanner sc) {
        TreinoRepositorio treinoRepositorio = new TreinoRepositorio();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(" === Editar Treino === ");
        System.out.print("Digite o ID do TREINO que deseja editar os dados: ");
        Long idTreino = Long.parseLong(sc.nextLine());

        Treino treinoAntigo = treinoRepositorio.buscarTreinoPorId(idTreino);
        if (treinoAntigo == null) {
            System.out.println("Treino não encontrado. ");
            return;
        }

        System.out.println("\nPressione Enter para manter os dados atuais.");

        System.out.print("ID do Aluno: ");
        String idAlunoStr = sc.nextLine();
        Long alunoId = idAlunoStr.isBlank() ? treinoAntigo.getId() : Long.parseLong(idAlunoStr);

        System.out.print("Tipo de Treino: ");
        String tipoTreinoDigitado = sc.nextLine();
        String tipoTreino = tipoTreinoDigitado.isBlank() ? treinoAntigo.getTipoTreino() : tipoTreinoDigitado;

        System.out.print("Descrição: ");
        String descricaoDigitado = sc.nextLine();
        String descricao = descricaoDigitado.isBlank() ? treinoAntigo.getDescricao() : descricaoDigitado;

        System.out.print("Duração em minutos: ");
        String duracaoDigitada = sc.nextLine();
        Duration duracao = duracaoDigitada.isBlank() ? treinoAntigo.getDuracao() : Duration.ofMinutes(Long.parseLong(duracaoDigitada));

        LocalDateTime dataInicio = LocalDateTime.now();

        Treino treino = new Treino(idTreino, tipoTreino, descricao, duracao, dataInicio, alunoId);
        treinoRepositorio.editarTreino(treino);

    }

}
