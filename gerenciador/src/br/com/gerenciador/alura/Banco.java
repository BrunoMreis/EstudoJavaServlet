package br.com.gerenciador.alura;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Banco {

	private static Map<Integer,Empresa> lista =  new HashMap<Integer, Empresa>();
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
		}



	public Empresa getEmpresa(Integer id) {
		
		return Banco.lista.get(id);
	}

	public void edita(Integer id, Empresa empresa) {
		Banco.lista.replace(id, empresa);
	}

}
