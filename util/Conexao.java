package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String path = "jdbc:sqlite:database/bancodados.db";

//  Conectar no banco de dados na pasta database
    public static Connection connection(){
        try {
//          Retorna a conexao com banco de dados
            return DriverManager.getConnection(path);
        } catch (SQLException e) {
            System.out.println("Erro na conexão SQL: " + e.getMessage());
            return null;
        }
    }
}
