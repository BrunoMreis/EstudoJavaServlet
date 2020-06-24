package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		return "redirect:entrada?acao=ListaEmpresas";
		

	}

}
