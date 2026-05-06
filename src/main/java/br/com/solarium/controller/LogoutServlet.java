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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		request.getSession().invalidate();
		response.sendRedirect("index.html");
	}
}
