import modelos.Aluno;
import modelos.Treino;
import repositorio.TreinoRepositorio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CadastrarTreino {
    public static void cadastrarTreino(Scanner sc){
        TreinoRepositorio TreinoRepositorio = new TreinoRepositorio();
        Aluno aluno = new Aluno();
        TreinoRepositorio.criarTabelaTreino();

        System.out.println(" =-=-=-= REGISTRAR TREINO NA ACADEMIA =-=-=-= ");
        System.out.print("Tipo de Treino: ");
        String tipoTreino = sc.nextLine();

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        System.out.print("Duração em Minutos: ");
        Duration duracao = Duration.ofMinutes(sc.nextInt());
        sc.nextLine();

        LocalDateTime data = LocalDateTime.now();
        String dataInicio= data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("Data de Inicio: " + dataInicio);

        System.out.println("ID do aluno: ");
        Long alunoId = Long.parseLong(sc.nextLine());

        Treino Treino = new Treino(null, tipoTreino, descricao, duracao, data, alunoId);
        TreinoRepositorio.inserir(Treino);

    }
}
