package br.com.gerenciador.alura;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringID = (String) request.getParameter("id");
		Integer id = Integer.parseInt(stringID);
		
		Banco db = new Banco();
		
		Empresa empre = db.getEmpresa(id);
		request.setAttribute("empresa", empre);
		RequestDispatcher rD = request.getRequestDispatcher("/alteraEmpresa.jsp");
		
		rD.forward(request, response);
	}

}
