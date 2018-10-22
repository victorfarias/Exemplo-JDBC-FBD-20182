package br.ufc.quixada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.ufc.quixada.DAO.ContatoDAO;
import br.ufc.quixada.entity.Contato;

public class Main {

	public static void main(String[] args) {
		
		Connection c;
		
		try {
			c = DriverManager.getConnection("jdbc:postgresql://localhost/contato", "postgres", "alunoufc");
			ContatoDAO cdao = new ContatoDAO(c);
			
			Contato ct = new Contato(4,"57384");
			cdao.save(ct);
			
			
			List<Contato> l = cdao.findAll();
			for(int i=0; i<l.size(); i++) {
				System.out.println(l.get(i).getCpf());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
//		try {
//			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/contato", "postgres", "alunoufc");
//			PreparedStatement ps = c.prepareStatement("select id,cpf from contatos");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				int id = rs.getInt("id");
//				String cpf = rs.getString("cpf");
//				System.out.println(id + " " + cpf);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
