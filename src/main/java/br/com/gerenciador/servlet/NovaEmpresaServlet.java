package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa!");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAberturaEmpresaString = request.getParameter("dataAbertura");
		Date dataAberturaEmpresa = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAberturaEmpresa = sdf.parse(dataAberturaEmpresaString);
		} catch (ParseException e) {
			throw new ServletException(e);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("Um erro desconhecido ocorreu no servidor. Tente novamente mais tarde.");
			e.printStackTrace();
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAberturaEmpresa);
		
		Banco banco = new Banco();
		banco.adicionarEmpresa(empresa);
		
		//chamar o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp"); // Diz ao programa para onde ele deve ir
		request.setAttribute("empresa", empresa.getNome());
		rd.forward(request, response); //Manda o programa ir a URL especificada, passando a requisição e a resposta como parâmetros
		
	}

}
