package br.edu.ifsc.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {

		System.out.println("......kabummmmm");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) req).getSession();
		
		if (session != null && session.getAttribute("usuario.logado") != null){
			System.out.println("Usuário " + session.getAttribute("usuario.logado") + " logado.");
			session.setMaxInactiveInterval(10 * 10);
		} else {
			System.out.println("Usuário não está logado.");
		}
	
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

		System.out.println("Tiizzzzzz....");

	}

}
