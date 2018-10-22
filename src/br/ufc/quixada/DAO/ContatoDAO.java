package br.ufc.quixada.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.entity.Contato;

public class ContatoDAO {
	Connection c;
	
	public ContatoDAO(Connection c) {
		this.c = c;
	}
	
	public List<Contato> findAll() {
		try {
			PreparedStatement ps = c.prepareStatement("select id,cpf from contatos");
			ResultSet rs = ps.executeQuery();
			
			List<Contato> l = new ArrayList<Contato>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String cpf = rs.getString("cpf");
				Contato ct = new Contato(id, cpf);
				l.add(ct);
			}
			ps.close();
			return l;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public void save(Contato ct) {
		try {
			PreparedStatement ps = c.prepareStatement("insert into contatos values (?,?)");
			ps.setInt(1, ct.getId());
			ps.setString(2, ct.getCpf());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
