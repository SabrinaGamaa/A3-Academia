package repositorio;

import modelos.Aluno;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositorio {

    //  Chamar para saber se a tabela está criada dentro do banco de dados
    public void criarTabelaAluno() {
        String sql = "CREATE TABLE IF NOT EXISTS Aluno (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "cpf TEXT NOT NULL," +
                "data_nascimento TEXT NOT NULL," +
                "telefone TEXT," +
                "email TEXT" +
                ");";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserir(Aluno aluno){
        String sql = "INSERT INTO Aluno(nome, cpf, data_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?)";

//      Tentar abrir a conexao com o banco de dados Conexao.java
        try (Connection con = Conexao.conectar();
        PreparedStatement inserirAluno = con.prepareStatement(sql)){
//          Substitui os "?" da query pelos valores do objeto aluno
            inserirAluno.setString(1, aluno.getNome().toLowerCase());
            inserirAluno.setString(2, aluno.getCpf());
            inserirAluno.setString(3, String.valueOf(aluno.getDataNascimento()));
            inserirAluno.setString(4, aluno.getTelefone());
            inserirAluno.setString(5, aluno.getEmail().toLowerCase());
            inserirAluno.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Erro ao inserir aluno no banco de dados: " + e.getMessage(), e);
        }
    }

    public List<Aluno> listarAluno() {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM Aluno";

        try (Connection con = Conexao.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        LocalDate.parse(rs.getString("data_nascimento"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
                lista.add(aluno);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar os alunos: " + e);
        }
        return lista;
    }


    public List<Aluno> listarAlunoPorNome(String nome) {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM Aluno WHERE nome = ?";

        try (Connection con = Conexao.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql); { stmt.setString(1, nome);}
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        LocalDate.parse(rs.getString("data_nascimento"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
                lista.add(aluno);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar Aluno: " + e);
        }

        return lista;
    }

    public Aluno listarAlunoPorId(long id) {
        String sql = "SELECT * FROM Aluno WHERE id = ?";


        try (Connection con = Conexao.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql); { stmt.setLong(1, id);}
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Aluno(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        LocalDate.parse(rs.getString("data_nascimento"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        rs.getString("telefone"),
                        rs.getString("email")
                );

            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar Aluno: " + e);
        }

        return null;
    }

    public void editarAluno(Aluno aluno) {
        String sql = "UPDATE Aluno SET nome = ?, cpf = ?, data_nascimento = ?, telefone = ?, email = ? WHERE id = ?";

        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, String.valueOf(aluno.getDataNascimento()));
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getEmail());
            stmt.setLong(6, aluno.getId());

            stmt.executeUpdate();

//            if (mudancas > 0) {
//                System.out.println(aluno.toString());
//                ("Aluno atualizado com Sucesso!");
//            }
//            else {
//                System.out.println("Nenhum aluno com esse ID.");
//            }

        } catch (SQLException e) {
            throw new RuntimeException("Error ao atualizar aluno: " + e.getMessage());
        }
    }

    public boolean deletarAluno(long id) {
        String sql = "DELETE FROM Aluno WHERE id = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setLong(1, id);
            int mudanca = stmt.executeUpdate();
            return mudanca > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar Aluno: " + e.getMessage());
            return false;
        }
    }


}
