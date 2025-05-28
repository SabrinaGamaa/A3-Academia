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

        Aluno alunoAntigo = alunoRepositorio.listarAlunoPorId(id);
        if (alunoAntigo == null) {
            System.out.println("Aluno não encontrado. ");
            return;
        }

        System.out.println("\nPressione Enter para manter os dados atuais.");

        System.out.print("Nome: ");
        String nomeDigitado = sc.nextLine();
        String nome = nomeDigitado.isBlank() ? alunoAntigo.getNome() : nomeDigitado;

        System.out.print("CPF: ");
        String cpfDigitado = sc.nextLine();
        String cpf = cpfDigitado.isBlank() ? alunoAntigo.getCpf() : cpfDigitado;

        System.out.print("Data nascimento (DD/MM/YYYY): ");
        String dataNascimentoDigitada = sc.nextLine();
        LocalDate dataNascimento = dataNascimentoDigitada.isBlank()
                ? alunoAntigo.getDataNascimento()
                : LocalDate.parse(dataNascimentoDigitada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Telefone: ");
        String telefoneDigitado = sc.nextLine();
        String telefone = telefoneDigitado.isBlank() ? alunoAntigo.getTelefone() : telefoneDigitado;

        System.out.print("Email: ");
        String emailDigitado = sc.nextLine();
        String email = emailDigitado.isBlank() ? alunoAntigo.getEmail() : emailDigitado;


        Aluno aluno = new Aluno(id, nome, cpf, dataNascimento, telefone, email);
        alunoRepositorio.editarAluno(aluno);

    }

}
