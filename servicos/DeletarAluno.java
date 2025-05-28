package servicos;

import repositorio.AlunoRepositorio;

import java.util.Scanner;

public class DeletarAluno {

    public static void deletarAlunoPorId(Scanner sc) {
        AlunoRepositorio alunoRepositorio = new AlunoRepositorio();

        System.out.println(" === Deletar Aluno === ");
        System.out.print("Digite o ID do aluno que deseja deletar: ");
        Long id = Long.parseLong(sc.nextLine());

        System.out.println("Tem certeza que deseja deletar o aluno: ");
        System.out.println(alunoRepositorio.listarAlunoPorId(id));
        System.out.println();

        System.out.print("Confirme (s/n): ");
        String conf = sc.nextLine().toLowerCase();
        char confirmacao = conf.charAt(0);


        if (confirmacao == 's') {
            boolean deletado = alunoRepositorio.deletarAluno(id);
            if (deletado) {
                System.out.println("Aluno deletado com sucesso.");
            } else {
                System.out.println("Nenhum aluno encontrado com esse ID.");
            }
        } else {
            System.out.println("Operação cancelada, aluno não foi deletado.");
        }
    }

}
