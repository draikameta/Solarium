package br.com.solarium.dao;

import org.mindrot.jbcrypt.BCrypt;
import br.com.solarium.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.solarium.model.*;

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
    
    public Usuario buscarPorEmail(String email) throws SQLException {
        String sql = "SELECT id, nome, email FROM usuarios WHERE email = ?";
        
        try (Connection conn = ConexaoBD.getConnection();
        	 PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
        	stmt.setString(1, email);
        	
        	try (ResultSet rs = stmt.executeQuery()) {
        		if (rs.next()) {
        			int id = rs.getInt(1);
        			String nome = rs.getString(2);
        			String emailBanco = rs.getString(3);
        			
        			return new Usuario(id, nome, emailBanco);
        			
        		}
        	}
        }
        return null;
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