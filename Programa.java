import servicos.ListarAlunoPorNome;
import servicos.ListarAlunos;

import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

//        cadastrarAluno.cadastrarAluno(sc);
//        CadastrarTreino.cadastrarTreino(sc);
//        ListarTreinoPorAluno.listarTreinos(sc);
//        ListarAlunoPorNome.listarAluno(sc);
        ListarAlunos.listarTodosAlunos();

        sc.close();
    }
}
