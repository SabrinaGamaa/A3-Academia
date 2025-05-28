package servicos;

import modelos.Aluno;
import repositorio.AlunoRepositorio;

import java.util.Scanner;

public class BurcarAlunoPorId {

    public static void listarAlunoId(Scanner sc) {
        System.out.println(" ----- LISTAR ALUNO PELO ID ---- ");
        System.out.print("ID do aluno: ");
        long id = Long.parseLong(sc.nextLine());

        AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
        Aluno aluno = alunoRepositorio.listarAlunoPorId(id);

        if (aluno == null) {
            System.out.println("Nenhum Aluno com esse ID encontrado.");
        } else {
            System.out.println(aluno.toString());
        }

    }

}
