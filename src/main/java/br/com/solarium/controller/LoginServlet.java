package br.com.solarium.controller;

import br.com.solarium.dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import br.com.solarium.*;
import br.com.solarium.model.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		try {
			boolean loginValido = new UsuarioDAO().validarLogin(email, senha);
			if (loginValido == true) {
				
				Usuario usuario = new UsuarioDAO().buscarPorEmail(email);
				
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogado", usuario);
				
				response.sendRedirect("interfacePrincipal.html");
			} else {
				response.sendRedirect("index.html");
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}