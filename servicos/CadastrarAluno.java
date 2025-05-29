package servicos;

import modelos.Aluno;
import repositorio.AlunoRepositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastrarAluno {
        public static void cadastrarAluno(String nome, String cpf, String dataNascimentoStr, String telefone, String email){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
        alunoRepositorio.criarTabelaAluno();

        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, fmt);


        Aluno aluno = new Aluno(null, nome, cpf, dataNascimento, telefone, email);
        alunoRepositorio.inserir(aluno);

    }
}
