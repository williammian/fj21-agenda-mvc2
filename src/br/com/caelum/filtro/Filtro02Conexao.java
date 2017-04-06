package br.com.caelum.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.jdbc.ConnectionFactory;

@WebFilter("/*")
public class Filtro02Conexao implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Connection connection = null;
		try{
			
			System.out.println("Abrindo conexão");
			connection = new ConnectionFactory().getConnection();
			
			System.out.println("Begin na transação");
			connection.setAutoCommit(false);
			
			request.setAttribute("connection", connection);
			
			chain.doFilter(request, response);
			
			System.out.println("Commit na transação");
			connection.commit();
						
		}catch(Exception err){
			try{
				System.out.println("Rollback na transação");
				if(connection != null)connection.rollback();
			}catch(SQLException e){}
			
			throw new ServletException(err);
		}finally{
			try{
				System.out.println("Fechando conexão");
				if(connection != null)connection.close();
			}catch(SQLException e){}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
			
	}

	@Override
	public void destroy() {
			
	}
	
}
