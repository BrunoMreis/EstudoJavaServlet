package br.com.gerenciador.alura;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editaEmpresa")
public class EditaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringID = (String) request.getParameter("id");
		String StringNome = (String) request.getParameter("nome");
		
		String StringData = (String) request.getParameter("data");
		LocalDate data = LocalDate.parse(StringData, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		Integer id = Integer.parseInt(stringID);
		
		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setData(data);
		empresa.setNome(StringNome);
		
		Banco db = new Banco();
		db.edita(id, empresa);
		
		response.sendRedirect("listaEmpresas");
		
	
	}

}
