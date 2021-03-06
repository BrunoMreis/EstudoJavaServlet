package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String stringID = (String) request.getParameter("id");
		int id = Integer.parseInt(stringID);
		
		Banco bd = new Banco();
		
		bd.removeEmpresa(id);
		
		
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
