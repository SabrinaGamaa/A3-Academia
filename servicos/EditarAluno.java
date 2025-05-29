package servicos;

import modelos.Aluno;
import repositorio.AlunoRepositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EditarAluno {

    public static void editarAlunoPorId(String idStr, String nome, String cpf, String dataNascimentoStr, String telefone, String email) {
        AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        Long id = Long.parseLong(idStr);

        Aluno alunoAntigo = alunoRepositorio.listarAlunoPorId(id);
        if (alunoAntigo == null) {
            throw new IllegalArgumentException("Aluno não encontrado. ");
        }

        nome = nome.isBlank() ? alunoAntigo.getNome() : nome;


        cpf = cpf.isBlank() ? alunoAntigo.getCpf() : cpf;
        

        LocalDate dataNascimento = dataNascimentoStr.isBlank()
                ? alunoAntigo.getDataNascimento()
                : LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        telefone = telefone.isBlank() ? alunoAntigo.getTelefone() : telefone;


        email = email.isBlank() ? alunoAntigo.getEmail() : email;


        Aluno aluno = new Aluno(id, nome, cpf, dataNascimento, telefone, email);
        alunoRepositorio.editarAluno(aluno);

    }

}
