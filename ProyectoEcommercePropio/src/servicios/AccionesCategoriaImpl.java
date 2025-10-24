package servicios;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Categoria;

public class AccionesCategoriaImpl implements AccionesCategoria{
	
	private ArrayList<Categoria> categorias;
	private String mensaje;
	private Scanner scanner;
	
	@Override
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public AccionesCategoriaImpl() {
		super();
		this.categorias = new ArrayList<Categoria>();

		categorias.add(new Categoria("uncategorized", "articulo sin categoria"));
		categorias.add(new Categoria("panificados", "pan lactal, pan de panchos, pan de hamburguesas"));
		categorias.add(new Categoria("lacteos", "queso crema, leche, yogurt"));
		categorias.add(new Categoria("fiambres", "jamon, queso, salame, mortadela"));
		
		this.mensaje = "";
		this.scanner = new Scanner(System.in);
	}

	@Override
	public String cargarCategoria(Categoria categoria) {
		if (this.categorias.add(categoria)) {
			this.mensaje = "se cargo correctamente la categoria";
		} else {
			this.mensaje = "no se pudo cargar correctamente la categoria";
		}
		return mensaje; 
	}

	@Override
	public String removerCategoria(String nombre) {
		if (existeCategoria(nombre)) {
			int x = 0;
			for (Categoria aux : categorias) {
				if (aux.getNombre().equals(nombre)) {
					aux.setEstado(false);
					categorias.set(x, aux);
					this.mensaje = "se removio correctamente la categoria";
					return mensaje;
				}
				x++;
			}

			this.mensaje = "no se pudo remover la categoria";
		} else {
			this.mensaje = "la categoria no existe";
		}
		return mensaje;	
	}

	@Override
	public String modificarCategoria(String nombre) {
		if (existeCategoria(nombre)) {

			String nuevoNombre;
			String nuevaDescripcion;

			System.out.println("ingrese el nuevo nombre de categoria y su respectiva descripcion: ");

			nuevoNombre= scanner.next();
			nuevaDescripcion= scanner.next();

			while (existeCategoria(nuevoNombre)) {
				System.out.println("el nombre ingresado esta en uso \n ingrese un nombre diferente y su respectiva descripcion: ");

				nuevoNombre= scanner.next();
				nuevaDescripcion= scanner.next();
			}

			int x = 0;
			for (Categoria aux : categorias) {	
				if (aux.getNombre().equals(nuevoNombre)) {
					aux.setNombre(nombre);
					aux.setDescripcion(nuevaDescripcion);
					this.categorias.set(x, aux);
					this.mensaje = "se modifico correctamente la categoria";
					return mensaje;
				}
				x++;
			}
			this.mensaje = "no se pudo modificar la categoria";

			scanner.close();
		} else {
			this.mensaje = "no se pudo encontrar la categoria a modificar";
		}
		return mensaje;
	}

	@Override
	public void listarCategorias() {
		int x = 1;
		System.out.println("las categorias cargadas actualmente son: ");
		for (Categoria aux : categorias) {
			System.out.println("-----------------------------------------");
			System.out.println(x + ":\n");
			System.out.println(aux.toString());
			System.out.println("\n");
			x++;
		}
		System.out.println("-----------------------------------------");
		System.out.println("\n");
	}

	@Override
	public boolean existeCategoria(String nombre) {
		for (Categoria aux : categorias) {
			if (aux.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Categoria buscarCategoria(int index) {
		return getCategorias().get(index);
	}
	
}
