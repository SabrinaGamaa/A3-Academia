package servicos;

import repositorio.TreinoRepositorio;

import java.util.Scanner;

public class DeletarTreino {

    public static void deletarTreinoPorId(Scanner sc) {
        TreinoRepositorio treinoRepositorio = new TreinoRepositorio();

        System.out.println(" === Deletar Treino === ");
        System.out.print("Digite o ID do Treino que deseja deletar: ");
        Long id = Long.parseLong(sc.nextLine());

        System.out.println("Tem certeza que deseja deletar o Treino: ");
        System.out.println(treinoRepositorio.buscarTreinoPorId(id));
        System.out.println();

        System.out.print("Confirme (s/n): ");
        String conf = sc.nextLine().toLowerCase();
        char confirmacao = conf.charAt(0);


        if (confirmacao == 's') {
            boolean deletado = treinoRepositorio.deletarTreino(id);
            if (deletado) {
                System.out.println("Treino deletado com sucesso.");
            } else {
                System.out.println("Nenhum treino encontrado com esse ID.");
            }
        } else {
            System.out.println("Operação cancelada, treino não foi deletado.");
        }
    }

}
