package br.com.cadastro.aplicacao;

import br.com.cadastro.dao.CadastroUsuarioDAO;
import br.com.cadastro.model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		CadastroUsuarioDAO usuarioDao = new CadastroUsuarioDAO();
		
		Usuario usuario = new Usuario();
		usuario.setNome("Fernando Tavares");
		usuario.setEmail("fernando@gmail.com");
		usuario.setSexo("Masculino");
		usuario.setPais("Brasil");
		usuario.setSenha("12345678");
		
	//usuarioDao.save(usuario);
	
	Usuario u1 = new Usuario();
	u1.setNome("Juliana Ribeiro");
	u1.setEmail("juliana@gmail.com");
	u1.setSexo("Feminino");
	u1.setPais("feminino");
	u1.setSenha("123456789");
	u1.setId(1);
	
	//usuarioDao.update(u1);
	
	usuarioDao.deleteByID(1);
	
	for(Usuario u : usuarioDao.getUsuarios()) {
		System.out.println("Usuario: "+u.getNome());
	 }
   }
}
