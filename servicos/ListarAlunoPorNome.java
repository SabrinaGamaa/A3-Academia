package servicos;

import modelos.Aluno;
import repositorio.AlunoRepositorio;

import java.util.List;
import java.util.Scanner;

public class ListarAlunoPorNome {

    public static void listarAluno(Scanner sc) {
        System.out.println(" ----- LISTAR ALUNO PELO NOME ---- ");
        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine().toLowerCase();

        AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
        List<Aluno> alunos = alunoRepositorio.listarAlunoPorNome(nome);

        if (nome.isEmpty()) {
            System.out.println("Nenhum Aluno com esse nome encontrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno.toString());
            }
        }

    }

}
