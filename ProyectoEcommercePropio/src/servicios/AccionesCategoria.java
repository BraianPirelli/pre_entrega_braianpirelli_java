package servicios;

import java.util.ArrayList;

import modelo.Categoria;

public interface AccionesCategoria {

	public ArrayList<Categoria> getCategorias();
	
	public String cargarCategoria(Categoria categoria);
	
	public String removerCategoria(String nombre);
	
	public String modificarCategoria(String nombre);
	
	public void listarCategorias();
	
	public boolean existeCategoria(String nombre);
	
	public Categoria buscarCategoria(int index);
	
}
