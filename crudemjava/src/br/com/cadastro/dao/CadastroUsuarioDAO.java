package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import br.com.cadastro.factory.ConnectionFactory;
import br.com.cadastro.model.Usuario;

public class CadastroUsuarioDAO {
	
	public void save(Usuario usuario) {

		String sql = "INSERT INTO usuario(nome,email, sexo, pais, senha) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSexo());
			pstm.setString(4, usuario.getPais());
			pstm.setString(5, usuario.getSenha());
			
			pstm.execute();
			
			System.out.println("Conectado!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm !=null) {
					pstm.close();
				}
				
				if(conn !=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void update (Usuario usuario) {
		
		String sql = "UPADATE usuario SET nome = ?, email = ?, sexo = ?, pais = ?, senha = ? " + 
	    "WERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSexo());
			pstm.setString(4, usuario.getPais());
			pstm.setString(5, usuario.getSenha());
			
			pstm.setInt(6, usuario.getId());
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm !=null) {
					pstm.close();
				}
				
				if(conn !=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void deleteByID (int id) {
		
		String sql = "DELETE FROM usuario WERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm !=null) {
					pstm.close();
				}
				
				if(conn !=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
     public List<Usuario> getUsuarios(){
		
		String sql = "SELECT * FROM usuario";
		
		List <Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rset.getInt("id"));
				usuario.setNome(rset.getNString("nome"));
				usuario.setEmail(rset.getNString("email"));
				usuario.setSexo(rset.getNString("sexo"));
				usuario.setPais(rset.getNString("pais"));
				usuario.setSenha(rset.getNString("senha"));
				
				usuarios.add(usuario);
				
			  }
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}
					
					if(pstm!=null) {
						pstm.close();
					}
					
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
			return usuarios;
	}
		

}
