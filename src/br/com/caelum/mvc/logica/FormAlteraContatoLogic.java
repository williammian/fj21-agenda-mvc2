package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class FormAlteraContatoLogic implements Logica{
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Connection connection = (Connection)request.getAttribute("connection");
		
		ContatoDao dao = new ContatoDao(connection);
		
		Contato contato = dao.get(id);
		
		request.setAttribute("contato", contato);
		
		return "/WEB-INF/jsp/altera-contato.jsp";
	}

}
