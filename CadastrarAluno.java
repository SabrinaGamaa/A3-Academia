import modelos.Aluno;
import repositorio.AlunoRepositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Scanner;

public class CadastrarAluno {
    public static void cadastrarAluno(Scanner sc){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
        alunoRepositorio.criarTabelaAluno();

        System.out.println("==== REGISTRAR ALUNO NA ACADEMIA ====");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF (sem caracter): ");
        String cpf = sc.nextLine();

        System.out.print("Data nascimento (DD/MM/YYYY): ");
        LocalDate dataNascimento = LocalDate.parse(sc.nextLine(), fmt);

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("E-mail: ");
        String email = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        Aluno aluno = new Aluno(null, nome, cpf, dataNascimento, telefone, email, idade);
        alunoRepositorio.inserir(aluno);

    }
}
