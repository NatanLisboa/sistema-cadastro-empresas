package br.com.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.acao.CadastraEmpresa;
import br.com.gerenciador.acao.EditaEmpresa;
import br.com.gerenciador.acao.ListaEmpresas;
import br.com.gerenciador.acao.MostraEmpresa;
import br.com.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("ListarEmpresas")) {
			
			ListaEmpresas acao = new ListaEmpresas();
			acao.executa(request, response);
			
		} else if (paramAcao.equals("MostrarEmpresa")) {
			
			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(request, response);
			
		} else if (paramAcao.equals("CadastrarEmpresa")) {
		
			CadastraEmpresa acao = new CadastraEmpresa();
			acao.executa(request, response);
			
		} else if (paramAcao.equals("EditarEmpresa")) {
			
			EditaEmpresa acao = new EditaEmpresa();
			acao.executa(request, response);
			
		} else if (paramAcao.equals("RemoverEmpresa")) {
		
			RemoveEmpresa acao = new RemoveEmpresa();
			acao.executa(request, response);
			
		}
		
		
	}

}
