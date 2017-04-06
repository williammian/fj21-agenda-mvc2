package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class RemoveContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		Connection connection = (Connection)request.getAttribute("connection");
		
		ContatoDao dao = new ContatoDao(connection);
		dao.remove(contato);
		
		return "/WEB-INF/jsp/contato-removido.jsp";
	}
	
}
