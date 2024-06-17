
package com.mycompany.a3.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root"; 
    private static final String PASSWORD = "EvertonLopes007@"; 

    public static void cadastrarUsuario(String nome, String email, String usuario, String senha, boolean isAdmin) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO usuarios (nome, email, usuario, senha, isAdmin) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString(2, email);
        statement.setString(3, usuario);
        statement.setString(4, senha); 
        statement.setBoolean(5, isAdmin);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted <= 0) {
            throw new SQLException("Falha ao inserir usuário.");
        }

        connection.close();
    }

}
