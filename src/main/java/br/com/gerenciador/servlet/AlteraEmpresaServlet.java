package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idEmpresaString = request.getParameter("id");
		int idEmpresa = 0; 
		
		String nomeEmpresa = request.getParameter("nome");
		
		String dataAberturaEmpresaString = request.getParameter("dataAbertura");
		Date dataAberturaEmpresa = null;
		
		try {
			idEmpresa = Integer.parseInt(idEmpresaString);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAberturaEmpresa = sdf.parse(dataAberturaEmpresaString);
		} catch (ParseException e) {
			throw new ServletException(e);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("Um erro desconhecido ocorreu no servidor. Tente novamente mais tarde.");
			e.printStackTrace();
		}

		System.out.println("Alterando empresa com id " + idEmpresa);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscarEmpresaPeloId(idEmpresa);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAberturaEmpresa);
		
		response.sendRedirect("listaEmpresas");
		
	}

}
