package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco bd = new Banco();

		String tipo = request.getHeader("Accept");

		String saida;
		if (tipo.contains("json")) {
			Gson gson = new Gson();
			saida = gson.toJson(bd.getEmpresas());
		} else if (tipo.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			saida = xstream.toXML(bd.getEmpresas());
		} else {
			saida = "{'message':'no content'}";
		}

		PrintWriter out = response.getWriter();
		out.print(saida);

	}

}
