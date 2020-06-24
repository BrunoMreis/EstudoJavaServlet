package br.com.alura.gerenciador.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empresa {
	
	private int id;
	private String nome;
	private LocalDate data;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getData() {
		return data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}

	
	

}
