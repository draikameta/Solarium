package br.com.solarium.dao;

import br.com.solarium.model.Anuncio;
import br.com.solarium.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import br.com.solarium.util.ConexaoBD;
import java.util.ArrayList;
import java.util.List;

public class AnuncioDAO {
	
	public List<Anuncio> exibirAnuncios() throws SQLException {
	    String sql = "SELECT id_anuncio, id_usuario, titulo, preco, imagem, tipo FROM anuncios";
	    List<Anuncio> anuncios = new ArrayList<>();

	    try (Connection conn = ConexaoBD.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                int idAnuncio = rs.getInt(1);
	                int idUsuario = rs.getInt(2);
	                String titulo = rs.getString(3);
	                double preco = rs.getDouble(4);
	                String imagem = rs.getString(5);
	                String tipo = rs.getString(6);

	                Anuncio anuncio = new Anuncio(idAnuncio, idUsuario, titulo, preco, imagem, tipo);
	                anuncios.add(anuncio);
	            }
	        }
	    }
	    return anuncios;
	}
}
