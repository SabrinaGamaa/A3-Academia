import servicos.*;

import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

//        // Cadastrar Alunos e Treinos
//        CadastrarAluno.cadastrarAluno(sc);
//        CadastrarTreino.cadastrarTreino(sc);
//
//
//        // Listar Treino por id do aluno
//        ListarTreinoPorAluno.listarTreinos(sc);
//
//
//
//        // Listar Aluno por nome
//        ListarAlunoPorNome.listarAluno(sc);
//
//
//        // Listar todos os alunos
//        ListarAlunos.listarTodosAlunos();
//
//        System.out.println();
//        System.out.println();

//        EditarAluno.editarAlunoPorId(sc);

//        EditarTreino.editarTreinoPorId(sc);

//        DeletarAluno.deletarAlunoPorId(sc);
        DeletarTreino.deletarTreinoPorId(sc);

        sc.close();
    }
}
