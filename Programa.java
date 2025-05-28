import servicos.*;

import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Cadastrar Alunos e Treinos
        //CadastrarAluno.cadastrarAluno(sc);
        //CadastrarTreino.cadastrarTreino(sc);

        //System.out.println();

        // Listar Treino por id do aluno
        //ListarTreinoPorAluno.listarTreinos(sc);

        //System.out.println();

        // Listar Aluno por nome
        //ListarAlunoPorNome.listarAluno(sc);

        //System.out.println();
        //System.out.println();
        //System.out.println();

        // Listar todos os alunos
        ListarAlunos.listarTodosAlunos();

        System.out.println();
        System.out.println();

        EditarAluno.editarAlunoPorId(sc);

        sc.close();
    }
}
