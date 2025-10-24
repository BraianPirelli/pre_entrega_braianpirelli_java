package ui;

import java.util.ArrayList;
import java.util.Scanner;

import execpciones.IngresoInvalidoException;
import modelo.CarritoProductos;
import modelo.Usuario;
import servicios.AccionesCategoria;
import servicios.AccionesCategoriaImpl;
import servicios.AccionesEmpresa;
import servicios.AccionesEmpresaImpl;
import servicios.AccionesUsuario;
import servicios.AccionesUsuarioImpl;

public class ManagerUi {
	public static void main(String[] args) {
		boolean salir = false;
		boolean cerrarSession = false;
		int contador = 0;
		AccionesUsuario accionesUsuario = new AccionesUsuarioImpl();
		Scanner scanner = new Scanner(System.in);
		
		CarritoProductos carritoAdmin = new CarritoProductos();
		ArrayList<CarritoProductos> carritosClientes = new ArrayList<CarritoProductos>();
		
		ArrayList<ArrayList<CarritoProductos>> listaPedidos = new ArrayList<ArrayList<CarritoProductos>>(); 
		
		AccionesCategoria accionesCategoria = new AccionesCategoriaImpl();
		AccionesEmpresa accionesEmpresa = new AccionesEmpresaImpl();

		do {

			System.out.println("----------------------------------------------------------------------------");
			System.out.println("1 - inicio de session");
			System.out.println("2 - salir");
			int opcion;
			
			try {
				opcion = scanner.nextInt();
			} catch (Exception e) {
				opcion = -1;
			}
			
			if (opcion == 1) {
				System.out.println("ingrese su usuario y contrasenia");
				String usuario = scanner.next();
				String contrasenia = scanner.next();
				
				if (accionesUsuario.verificarAdmin(usuario, contrasenia)) {
					contador = 0;
					do {
						cerrarSession = accionesUsuario.accionesAdmin(usuario, carritoAdmin, carritosClientes, listaPedidos, accionesCategoria, accionesEmpresa);
					} while (!cerrarSession);

				}
				
				if (accionesUsuario.verificarUsuario(usuario, contrasenia) != null) {
					contador = 0;
					Usuario aux = accionesUsuario.verificarUsuario(usuario, contrasenia);
					do {
						cerrarSession = accionesUsuario.accionesCliente(usuario, carritoAdmin, carritosClientes.get(aux.getIdPropio()), listaPedidos.get(aux.getIdPropio()) );
					} while (!cerrarSession);
				}
				
				if(accionesUsuario.usuarioInactivo(usuario, contrasenia)) {
					System.out.println("el usuario con el que esta intentando loguearse esta inactivo \nPor favor contacte con atencion al cliente.");
				}
				
				contador++;
				if (contador == 3) {
					throw new IngresoInvalidoException("ingreso bloqueado usuario y/o contrasenia incorrectos");
				}

			} else if (opcion == 2){
				salir = true;
			} else {
				System.out.println("la opcion ingresada es invalida");
			}

		} while (!salir);

		System.out.println("gracias por utilizar el programa");
	}
}








/*

LocalDate localfecha = LocalDate.now();	
java.time.Instant instant = localfecha.atStartOfDay(ZoneId.systemDefault()).toInstant();
Date fecha = Date.from(instant);

*/