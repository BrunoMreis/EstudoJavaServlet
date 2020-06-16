package br.com.gerenciador.alura;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "novaEmpresa", urlPatterns = { "/novaEmpresa", "/frio" })
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		PrintWriter saida = response.getWriter();
		String reqNome = request.getParameter("nome");
		String reqData = request.getParameter("data");
		

		Banco banco = new Banco();
		Empresa empresa = new Empresa();
		empresa.setNome(reqNome);
		empresa.setData(LocalDate.parse(reqData, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		banco.adicionaBanco(empresa);

//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
		
		response.sendRedirect("listaEmpresas");

	}

}
