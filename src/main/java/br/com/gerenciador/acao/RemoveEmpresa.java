package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String paramId = request.getParameter("id");
		int id = Integer.parseInt(paramId);
		
		System.out.println("Removendo empresa " + id);
		
		Banco banco = new Banco();
		banco.removerEmpresa(id);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}
}
