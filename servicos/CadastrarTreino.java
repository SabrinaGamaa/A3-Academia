package servicos;

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
        TreinoRepositorio.criarTabelaTreino();

        System.out.println(" =-=-=-= REGISTRAR TREINO NA ACADEMIA =-=-=-= ");
        System.out.print("ID do aluno: ");
        Long alunoId = Long.parseLong(sc.nextLine());

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


        Treino treino = new Treino(null, tipoTreino, descricao, duracao, data, alunoId);
        TreinoRepositorio.inserir(treino);
    }


}
