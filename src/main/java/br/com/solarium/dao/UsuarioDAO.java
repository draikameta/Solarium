package br.com.solarium.dao;

import maven.org.mindrot.jbcrypt.BCrypt;
import br.com.solarium.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean validarLogin(String email, String senha) throws SQLException {
        String sql = "SELECT senha FROM usuarios where email = ?";
        
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email); 
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String hashDoBanco = rs.getString(1);
                    return BCrypt.checkpw(senha, hashDoBanco);
                }
            }
        }
        return false; 
    }

    public void cadastrar(String nome, String email, String senha) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            String hash = BCrypt.hashpw(senha, BCrypt.gensalt());
            
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, hash);
            
            stmt.execute();
        }
    }
}