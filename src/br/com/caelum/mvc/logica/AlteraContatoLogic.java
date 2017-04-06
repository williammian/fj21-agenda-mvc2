package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class AlteraContatoLogic implements Logica{
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String datanascimento = request.getParameter("datanascimento");
		
		Date dtNasc = null;
		try{
			dtNasc = new SimpleDateFormat("dd/MM/yyyy").parse(datanascimento);
		}catch(ParseException err){
			err.printStackTrace();
			return null;
		}
		
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDatanascimento(dtNasc);
		
		Connection connection = (Connection)request.getAttribute("connection");
		
		ContatoDao dao = new ContatoDao(connection);
		dao.altera(contato);
		
		request.setAttribute("nome", nome);
		
		return "/WEB-INF/jsp/contato-alterado.jsp";
	}

}
