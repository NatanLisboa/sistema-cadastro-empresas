package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;

public class RemoveEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String paramId = request.getParameter("id");
		int id = Integer.parseInt(paramId);
		
		System.out.println("Removendo empresa " + id);
		
		Banco banco = new Banco();
		banco.removerEmpresa(id);
		
		response.sendRedirect("entrada?acao=ListarEmpresas");
		
	}
}
