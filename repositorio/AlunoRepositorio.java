package repositorio;

import modelos.Aluno;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoRepositorio {

    public void inserir(Aluno aluno){

        String sql = "INSERT INTO Aluno(nome, idade) VALUES (?, ?)";

//      Tentar abrir a conexao com o banco de dados Conexao.java
        try (Connection con = Conexao.conectar();
        PreparedStatement inserirAluno = con.prepareStatement(sql)){
//          Substitui os "?" da query pelos valores do objeto aluno
            inserirAluno.setString(1, aluno.getNome());
            inserirAluno.setInt(2, aluno.getIdade());
            inserirAluno.executeUpdate();

        } catch (SQLException e){
            System.out.println("Erro ao tentar inserir o aluno: " + e.getMessage());

        }

    }
}
