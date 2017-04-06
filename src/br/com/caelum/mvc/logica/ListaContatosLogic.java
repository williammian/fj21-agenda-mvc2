package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class ListaContatosLogic implements Logica{
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response){
		
		Connection connection = (Connection)request.getAttribute("connection");
		
		ContatoDao dao = new ContatoDao(connection);
		List<Contato> contatos = dao.getLista();
		
		request.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}