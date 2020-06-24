package br.com.alura.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		String saida = Request
				.Post("http://localhost:8080/gerenciador/empresas")
				.addHeader("Accept", "application/json")
				.execute()
				.returnContent()
				.asString();

		System.out.println(saida);
	}

}
