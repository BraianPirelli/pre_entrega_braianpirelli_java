package servicios;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Empresa;

public class AccionesEmpresaImpl implements AccionesEmpresa{

	private ArrayList<Empresa> empresas;
	private String mensaje;
	private Scanner scanner;
	
	public AccionesEmpresaImpl() {
		super();
		this.empresas = new ArrayList<Empresa>();

		empresas.add(new Empresa("sin empresa", "articulo sin empresa"));
		empresas.add(new Empresa("bimbo", "panificadora universal"));
		empresas.add(new Empresa("la serenisima", "lacteos de excelencia"));
		empresas.add(new Empresa("fiambres 214", "los fiambres del domingo"));
		
		this.mensaje = "";
		this.scanner = new Scanner(System.in);
	}
	@Override
	public String cargarEmpresa(Empresa empresa) {
		if (this.empresas.add(empresa)) {
			this.mensaje = "se cargo correctamente la empresa";
		} else {
			this.mensaje = "no se pudo cargar correctamente la empresa";
		}
		return mensaje; 
	}

	@Override
	public String removerEmpresa(String nombre) {
		if (existeEmpresa(nombre)) {
			int x = 0;
			for (Empresa aux : empresas) {
				if (aux.getNombre().equals(nombre)) {
					aux.setEstado(false);
					empresas.set(x, aux);
					
					this.mensaje = "se removio correctamente la empresa";
					return mensaje;
				}
				x++;
			}

			this.mensaje = "no se pudo remover la empresa";
		} else {
			this.mensaje = "la empresa no existe";
		}
		return mensaje;	
	}

	@Override
	public String modificarEmpresa(String nombre) {
		if (existeEmpresa(nombre)) {

			String nuevoNombre;
			String nuevaDescripcion;

			System.out.println("ingrese el nuevo nombre de empresa y su respectiva descripcion: ");

			nuevoNombre= scanner.next();
			nuevaDescripcion= scanner.next();

			while (existeEmpresa(nuevoNombre)) {
				System.out.println("el nombre ingresado esta en uso \n ingrese un nombre diferente y su respectiva descripcion: ");

				nuevoNombre= scanner.next();
				nuevaDescripcion= scanner.next();
			}

			int x = 0;
			for (Empresa aux : empresas) {	
				if (aux.getNombre().equals(nuevoNombre)) {
					aux.setNombre(nombre);
					this.empresas.set(x, aux);
					this.mensaje = "se modifico correctamente la empresa";
					return mensaje;
				}
				x++;
			}
			this.mensaje = "no se pudo modificar la empresa";

			scanner.close();
		} else {
			this.mensaje = "no se pudo encontrar la empresa a modificar";
		}
		return mensaje;
	}

	@Override
	public void listarEmpresas() {
			int x = 1;
			System.out.println("las empresas cargadas actualmente son: ");
			for (Empresa aux : empresas) {
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
	public boolean existeEmpresa(String nombre) {
		for (Empresa aux : empresas) {
			if (aux.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Empresa buscarEmpresa(int index) {
		return getEmpresas().get(index);
	}
	
	@Override
	public ArrayList<Empresa> getEmpresas() {
		return empresas;
	}
	
}
