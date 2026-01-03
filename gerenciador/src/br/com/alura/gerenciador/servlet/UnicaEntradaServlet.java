package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		String nome = null;

		try {
			if (paramAcao == null || !paramAcao.matches("^[a-zA-Z0-9]+$")) {
				throw new ServletException("Invalid action parameter");
			}
			Class acaoClass = Class.forName("br.com.alura.gerenciador.acao." + paramAcao);
			Acao acao = (Acao) acaoClass.getDeclaredConstructor().newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] direcao = nome.split(":");
		if (direcao[0].equals("redirect")) {
			response.sendRedirect(direcao[1]);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + direcao[1]);
			rd.forward(request, response);
		}

//		if(paramAcao.equals("ListaEmpresas")) {
//		    ListaEmpresas acao = new ListaEmpresas();
//		    nome = acao.executa(request, response);
//		} else if(paramAcao.equals("RemoveEmpresa")) {
//		    RemoveEmpresa acao = new RemoveEmpresa();
//		    nome = acao.executa(request, response);
//		} else if(paramAcao.equals("MostraEmpresa")) {
//		    MostraEmpresa acao = new MostraEmpresa();
//		    nome = acao.executa(request, response);
//		} else if(paramAcao.equals("AlteraEmpresa")) {
//		    AlteraEmpresa acao = new AlteraEmpresa();
//		    nome = acao.executa(request, response);
//		} else if(paramAcao.equals("NovaEmpresa")) {
//		    NovaEmpresa acao = new NovaEmpresa();
//		    nome = acao.executa(request, response);
//		}
	}

}
