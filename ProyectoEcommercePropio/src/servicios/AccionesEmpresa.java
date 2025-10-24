package servicios;


import java.util.ArrayList;

import modelo.Empresa;

public interface AccionesEmpresa {
	
	public ArrayList<Empresa> getEmpresas();

	public String cargarEmpresa(Empresa empresa);
	
	public String removerEmpresa(String nombre);
	
	public String modificarEmpresa(String nombre);
	
	public void listarEmpresas();
	
	public boolean existeEmpresa(String nombre);
	
	public Empresa buscarEmpresa(int index);
	
}
