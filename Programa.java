import servicos.CadastrarAluno;
import servicos.CadastrarTreino;
import servicos.ListarAluno;
import servicos.ListarTreinoPorAluno;

import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

//        CadastrarAluno.cadastrarAluno(sc);
//        CadastrarTreino.cadastrarTreino(sc);
//        ListarTreinoPorAluno.listarTreinos(sc);
        ListarAluno.listarAluno(sc);

        sc.close();

    }
}
