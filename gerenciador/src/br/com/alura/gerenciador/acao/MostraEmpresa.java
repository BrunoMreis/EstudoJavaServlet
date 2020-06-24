package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringID = (String) request.getParameter("id");
		Integer id = Integer.parseInt(stringID);
		
		Banco db = new Banco();
		
		Empresa empre = db.getEmpresa(id);
		request.setAttribute("empresa", empre);
		
		return "forward:alteraEmpresa.jsp";


	}

}
