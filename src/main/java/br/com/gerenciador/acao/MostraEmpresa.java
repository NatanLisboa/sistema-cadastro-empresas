package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class MostraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		int id = Integer.parseInt(paramId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscarEmpresaPeloId(id);
		
		request.setAttribute("empresa", empresa);
		
		return "forward:/formEditaEmpresa.jsp";
	}
	
}
