package br.com.alura.gerenciador.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {

	private static Map<Integer,Empresa> lista =  new HashMap<Integer, Empresa>();
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static int id = 1;

	public void adicionaBanco(Empresa empresa) {
		empresa.setId(Banco.id);
		lista.put(id, empresa);
		id++;
	}

	public Map<Integer,Empresa> getEmpresas() {
		return lista;
	}
	
	public void removeEmpresa(int id) {
		lista.remove(id);
	}
	
	static {
		 
		  Empresa empresa = new Empresa();
		  empresa.setId(Banco.id);
		  empresa.setNome("Alura");
		  empresa.setData(LocalDate.now());
		  Banco.lista.put(id, empresa);
		  id++;
		  
		  Empresa empresa2 = new Empresa();
		  empresa2.setId(Banco.id);
		  empresa2.setNome("Caelum");
		  empresa2.setData(LocalDate.now());		  
		  Banco.lista.put(id, empresa2);
		  id++;
		  
		  Usuario usuario1 = new Usuario();
		  usuario1.setLogin("Bruno");
		  usuario1.setSenha("123");
		  Usuario usuario2 = new Usuario();
		  usuario2.setLogin("Qualquer");
		  usuario2.setSenha("123");
		  usuarios.add(usuario1);
		  usuarios.add(usuario2);
		}


	public Usuario exiteUsuario(String login, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}	
		
		return null;
		
	}
	
	public Empresa getEmpresa(Integer id) {
		
		return Banco.lista.get(id);
	}

	public void edita(Integer id, Empresa empresa) {
		Banco.lista.replace(id, empresa);
	}

}
