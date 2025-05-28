package servicos;

import modelos.Aluno;
import repositorio.AlunoRepositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EditarAluno {

    public static void editarAlunoPorId(Scanner sc) {
        AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(" === Editar aluno === ");
        System.out.print("Digite o ID do aluno que deseja editar os dados: ");
        Long id = Long.parseLong(sc.nextLine());

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

        Aluno aluno = new Aluno(id, nome, cpf, dataNascimento, telefone, email);
        alunoRepositorio.editarAluno(aluno);

    }

}
