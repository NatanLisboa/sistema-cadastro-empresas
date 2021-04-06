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

public class EditaEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
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
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

	}
	

