package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		String arquivoJsp = null;
		
		if(paramAcao.equals("ListarEmpresas")) {
			
			ListaEmpresas acao = new ListaEmpresas();
			arquivoJsp = acao.executa(request, response);
			
		} else if (paramAcao.equals("MostrarEmpresa")) {
			
			MostraEmpresa acao = new MostraEmpresa();
			arquivoJsp = acao.executa(request, response);
			
		} else if (paramAcao.equals("CadastrarEmpresa")) {
		
			CadastraEmpresa acao = new CadastraEmpresa();
			arquivoJsp = acao.executa(request, response);
			
		} else if (paramAcao.equals("EditarEmpresa")) {
			
			EditaEmpresa acao = new EditaEmpresa();
			arquivoJsp = acao.executa(request, response);
			
		} else if (paramAcao.equals("RemoverEmpresa")) {
		
			RemoveEmpresa acao = new RemoveEmpresa();
			arquivoJsp = acao.executa(request, response);
			
		}
		
		String[] tipoEEndereco = arquivoJsp.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
	}

}
