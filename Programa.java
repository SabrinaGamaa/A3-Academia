import modelos.Aluno;
import repositorio.AlunoRepositorio;
import util.Conexao;

import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Conexao conexao = new Conexao();
        conexao.criarTabelaAluno();

        System.out.println("==== LOGIN ACADEMIA ====");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();

        Aluno aluno = new Aluno(null, nome, idade);
        AlunoRepositorio repositorio = new AlunoRepositorio();
        repositorio.inserir(aluno);

        sc.close();
    }
}
