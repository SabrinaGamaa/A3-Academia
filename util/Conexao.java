package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {

//  Meu banco de dados, se não existir bancodados.db ele cria
    private static final String path = "jdbc:sqlite:database/bancodados.db";

    public static Connection conectar(){
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(path); //Retorna a conexao com banco de dados
        } catch (ClassNotFoundException e) {
            System.out.println("Driver SQLite não encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Erro na conexão SQL: " + e.getMessage());
            return null;
        }
    }

//  Chamar para saber se a tabela está criada dentro do banco de dados
    public void criarTabelaAluno() {
        String sql = "CREATE TABLE IF NOT EXISTS Aluno (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "idade INTEGER NOT NULL" +
                ");";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("Tabela Aluno criada ou já existia.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}
