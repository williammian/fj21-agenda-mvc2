package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.modelo.Contato;

public class ContatoDao {

	private Connection connection;
	
	public ContatoDao(Connection connection){
		this.connection = connection;
	}
	
	public void adicionaContato(Contato contato){
		String sql = "insert into contatos " +
					 "(nome, email, endereco, datanascimento) " +
					 "values(?,?,?,?)";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDatanascimento().getTime()));
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException err){
			throw new RuntimeException(err);
		}
	}
	
	public List<Contato> getLista(){
		try{
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos order by nome");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setDatanascimento(rs.getDate("datanascimento"));
				
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			return contatos;
		}catch(SQLException err){
			throw new RuntimeException(err);
		}
	}
	
	public Contato get(Long id){
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
						
			Contato contato = new Contato();
			
			while(rs.next()){
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setDatanascimento(rs.getDate("datanascimento"));
			}
			
			rs.close();
			stmt.close();
			return contato;
		}catch(SQLException err){
			throw new RuntimeException(err);
		}
	}
	
	public void altera(Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?, datanascimento=? where id=?";
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDatanascimento().getTime()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException err){
			throw new RuntimeException(err);
		}
	}
	
	public void remove(Contato contato){
		try{
			PreparedStatement stmt = this.connection.prepareStatement("delete from Contatos where id=?");
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException err){
			throw new RuntimeException(err);
		}
	}
}
