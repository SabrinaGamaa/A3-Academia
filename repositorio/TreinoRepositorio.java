package repositorio;

import modelos.Treino;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

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
            System.out.println("Tabela Treino criada ou já existia.");
        }
        catch (SQLException e) {
            System.out.println("Erro ao criar tabela Treino: " + e.getMessage());
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
            System.out.println("Erro ao tentar inserir o treino: " + e.getMessage());

        }
    }

}
