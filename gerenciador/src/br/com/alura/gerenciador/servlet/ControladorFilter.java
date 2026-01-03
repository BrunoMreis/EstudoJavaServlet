package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class ControladorFilter
 */
@WebFilter("/entrada")
public class ControladorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ControladorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String paramAcao = request.getParameter("acao");
		String nome = null;
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		try {
			if (paramAcao == null || !paramAcao.matches("^[a-zA-Z0-9]+$")) {
				throw new ServletException("Invalid action parameter");
			}
			Class<?> acaoClass = Class.forName("br.com.alura.gerenciador.acao." + paramAcao);
			Acao acao = (Acao) acaoClass.getDeclaredConstructor().newInstance();
			nome = acao.executa(httpRequest, httpResponse);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] direcao = nome.split(":");
		if (direcao[0].equals("redirect")) {
			httpResponse.sendRedirect(direcao[1]);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + direcao[1]);
			rd.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
