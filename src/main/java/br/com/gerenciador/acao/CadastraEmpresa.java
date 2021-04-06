package br.com.gerenciador.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class CadastraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		request.setAttribute("empresa", empresa.getNome());
		
		return "redirect:entrada?acao=ListarEmpresas";
			
	}
	
}
