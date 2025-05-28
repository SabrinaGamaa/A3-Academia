package servicos;

import modelos.Treino;
import repositorio.TreinoRepositorio;

import java.util.List;
import java.util.Scanner;

public class ListarTreinoPorAluno {

    public static void listarTreinos(Scanner sc) {
        System.out.println(" ---- LISTAR TREINO DO ALUNO ----- ");
        System.out.print("Digite o ID do aluno: ");
        long alunoId = Long.parseLong(sc.nextLine());

        TreinoRepositorio treinoRepositorio = new TreinoRepositorio();
        List<Treino> treinos = treinoRepositorio.listarTreinoAluno(alunoId);

        if (treinos.isEmpty()) {
            System.out.println("Nenhum treino encontrado com esse ID.");
        } else {
            for (Treino treino : treinos) {
                System.out.println(treino.toString());
            }
        }

    }

}
