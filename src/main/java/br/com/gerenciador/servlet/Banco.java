package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static int id = 1;
	
	public void adicionarEmpresa(Empresa empresa) {
		empresa.setId(Banco.id++);
		Banco.lista.add(empresa);
	}
	
	public void removerEmpresa(int id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while (it.hasNext()) {
			
			Empresa empresa = it.next();
			
			if (empresa.getId() == id) {
				it.remove();
			}
			
		}
		
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;	
	}
	

}
