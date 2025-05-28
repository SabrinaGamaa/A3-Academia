package servicos;

import modelos.Aluno;
import repositorio.AlunoRepositorio;

import java.util.List;

public class ListarAlunos {

    public static void listarTodosAlunos() {
        AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
        List<Aluno> lista = alunoRepositorio.listarAluno();

        lista.forEach(System.out::println);
    }

}
