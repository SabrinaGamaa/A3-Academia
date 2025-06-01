package repositorio;

import modelos.Treino;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class TreinoRepositorio {

    public void criarTabelaTreino(){
        String sql = "CREATE TABLE IF NOT EXISTS Treino (" +
                "id_treino INTEGER PRIMARY KEY AUTOINCREMENT," +
                "aluno_id INTEGER NOT NULL," +
                "tipo_treino TEXT NOT NULL," +
                "descricao TEXT NOT NULL," +
                "duracao TEXT NOT NULL," +
                "data_inicio TEXT NOT NULL," +
                "FOREIGN KEY (aluno_id) REFERENCES Aluno(id)" +
                ");";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela Treino: " + e.getMessage());
        }
        
    }
    
    public void inserir(Treino treino) {
        String sql = "INSERT INTO Treino(tipo_treino, descricao, duracao, data_inicio, aluno_id) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = Conexao.conectar();
             PreparedStatement inserirTreino = con.prepareStatement(sql)){

            inserirTreino.setString(1, treino.getTipoTreino());
            inserirTreino.setString(2, treino.getDescricao());

            long minutos = treino.getDuracao().toMinutes();
            String duracaoMinutos = minutos + " minutos";
            inserirTreino.setString(3, duracaoMinutos);

            String dataInicio= treino.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            inserirTreino.setString(4, dataInicio);
            inserirTreino.setLong(5, treino.getAlunoId());

            inserirTreino.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Erro ao tentar inserir o treino: " + e.getMessage());
        }
    }

    public List<Treino> listarTreinoAluno(long alunoId) {
        List<Treino> lista = new ArrayList<>();
        String sql = "SELECT * FROM Treino WHERE aluno_id = ?";

        try (Connection con = Conexao.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql); { stmt.setLong(1, alunoId);}
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String strDur = rs.getString("duracao");
                String[] partes = strDur.split(" ");
                int minutos = Integer.parseInt(partes[0]);
                Duration duracao = Duration.ofMinutes(minutos);

                Treino treino = new Treino(
                        rs.getLong("id_treino"),
                        rs.getString("tipo_treino"),
                        rs.getString("descricao"),
                        duracao,
                        LocalDateTime.parse(rs.getString("data_inicio"), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        rs.getLong("aluno_id")
                );
                lista.add(treino);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return lista;
    }
    
    public List<Treino> listarTreinoAlunos() {
        List<Treino> lista = new ArrayList<>();
        String sql = "SELECT * FROM Treino";

        try (Connection con = Conexao.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String strDur = rs.getString("duracao");
                String[] partes = strDur.split(" ");
                int minutos = Integer.parseInt(partes[0]);
                Duration duracao = Duration.ofMinutes(minutos);

                Treino treino = new Treino(
                        rs.getLong("id_treino"),
                        rs.getString("tipo_treino"),
                        rs.getString("descricao"),
                        duracao,
                        LocalDateTime.parse(rs.getString("data_inicio"), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        rs.getLong("aluno_id")
                );
                lista.add(treino);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return lista;
    }
    
    public List<Treino> listarTreinoAlunoPorNome(String nomeStr) {
        List<Treino> lista = new ArrayList<>();
        String sql = "SELECT * FROM Treino JOIN Aluno ON Treino.aluno_id = Aluno.id WHERE Aluno.nome LIKE ?";

        try (Connection con = Conexao.conectar()) {
            String nome = nomeStr.toLowerCase();
            PreparedStatement stmt = con.prepareStatement(sql); { stmt.setString(1,"%"+nome+"%");}
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String strDur = rs.getString("duracao");
                String[] partes = strDur.split(" ");
                int minutos = Integer.parseInt(partes[0]);
                Duration duracao = Duration.ofMinutes(minutos);

                Treino treino = new Treino(
                        rs.getLong("id_treino"),
                        rs.getString("tipo_treino"),
                        rs.getString("descricao"),
                        duracao,
                        LocalDateTime.parse(rs.getString("data_inicio"), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        rs.getLong("aluno_id")
                );
                lista.add(treino);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Falha ao carregar buscar banco de dados. " + e);
        }

        return lista;
    }

    public Treino buscarTreinoPorId(long id) {
        String sql = "SELECT * FROM Treino WHERE id_treino = ?";

        try (Connection con = Conexao.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql); { stmt.setLong(1, id);}
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String strDur = rs.getString("duracao");
                String[] partes = strDur.split(" ");
                int minutos = Integer.parseInt(partes[0]);
                Duration duracao = Duration.ofMinutes(minutos);

                return new Treino(
                        rs.getLong("id_treino"),
                        rs.getString("tipo_treino"),
                        rs.getString("descricao"),
                        duracao,
                        LocalDateTime.parse(rs.getString("data_inicio"), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        rs.getLong("aluno_id")
                );
            }

        } catch (NullPointerException e) {
            throw new NullPointerException("ID Treino não encontrado!");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return null;
    }

    public void editarTreino(Treino treino) {
        String sql = "UPDATE Treino SET aluno_id = ?, tipo_treino = ?, descricao = ?, duracao = ?, data_inicio = ? WHERE id_treino = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setLong(1, treino.getAlunoId());
            stmt.setString(2, treino.getTipoTreino());
            stmt.setString(3, treino.getDescricao());

            long minutos = treino.getDuracao().toMinutes();
            String duracaoMinutos = minutos + " minutos";
            stmt.setString(4, duracaoMinutos);

            String dataInicio= treino.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            stmt.setString(5, dataInicio);

            stmt.setLong(6, treino.getId());

            stmt.executeUpdate();

//            if (mudancas > 0) {
//                System.out.println(treino.toString());
//                System.out.println("Treino editado com sucesso!");
//            }
//            else {
//                System.out.println("Nenhum Treino com esse ID.");
//            }

        } catch (SQLException e) {
            throw new RuntimeException("Error ao atualizar treino: " + e.getMessage());
        }
    }

    public boolean deletarTreino(long idTreino) {
        String sql = "DELETE FROM Treino WHERE id_treino = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setLong(1, idTreino);
            int mudanca = stmt.executeUpdate();
            return mudanca > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar Treino: " + e.getMessage());
            return false;
        }
    }


}
