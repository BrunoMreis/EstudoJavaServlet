package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqNome = request.getParameter("nome");
		String reqData = request.getParameter("data");
		

		Banco banco = new Banco();
		Empresa empresa = new Empresa();
		empresa.setNome(reqNome);
		empresa.setData(LocalDate.parse(reqData, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		banco.adicionaBanco(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		
		return "redirect:entrada?acao=ListaEmpresas";

	}

}
