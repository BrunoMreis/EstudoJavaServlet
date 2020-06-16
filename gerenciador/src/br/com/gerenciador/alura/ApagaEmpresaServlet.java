package br.com.gerenciador.alura;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/apagaEmpresa")
public class ApagaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String stringID = (String) request.getParameter("id");
		int id = Integer.parseInt(stringID);
		
		Banco bd = new Banco();
		
		bd.removeEmpresa(id);
		
		response.sendRedirect("listaEmpresas");
		
		
		
	
	}

}