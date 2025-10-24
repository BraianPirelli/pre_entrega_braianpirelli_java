package servicios;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import modelo.CarritoProductos;
import modelo.Categoria;
import modelo.Empresa;
import modelo.Perfume;
import modelo.Pintura;
import modelo.Producto;
import modelo.Usuario;

public class AccionesUsuarioImpl implements AccionesUsuario {
	private Usuario admin;
	private ArrayList<Usuario> usuarios;
	private String mensaje;
	private Scanner scanner;
	

	public AccionesUsuarioImpl() {
		this.admin = new Usuario("admin", "admin");
		this.mensaje = "";
		this.scanner = new Scanner(System.in);
		this.usuarios = new ArrayList<Usuario>();
	}

	@Override
	public String cargarUsuario(Usuario usuario) {
		if (!usuario.getUsuario().equals("admin") && this.usuarios.add(usuario)) {
			this.mensaje = "se cargo correctamente el usuario";
		} else {
			this.mensaje = "no se pudo cargar correctamente el usuario";
		}
		return mensaje;
	}

	@Override
	public String removerUsuario(String usuario) {
		if (existeUsuario(usuario)) {
			
			int x = 0;
			for (Usuario aux : usuarios) {
				if (aux.getUsuario().equals(usuario)) {
					aux.setEstado(false);
					usuarios.set(x, aux);
					
					this.mensaje = "se removio correctamente el usuario";
					return mensaje;
				}
				x++;
			}

			this.mensaje = "no se pudo remover el usuario";
		} else {
			this.mensaje = "el usuario no existe";
		}
		return mensaje;
	}

	@Override
	public String modificarUsuario(String usuario) {
		if (existeUsuario(usuario)) {

			String nuevoUsuario;

			System.out.println("ingrese el nuevo nombre usuario: ");

			nuevoUsuario = scanner.next();

			while (existeUsuario(usuario) && nuevoUsuario.equals("admin")) {
				System.out.println("el usuario ingresado esta en uso \n ingrese un usuario diferente: ");

				nuevoUsuario = scanner.next();
			}

			int x = 0;
			for (Usuario aux : usuarios) {
				if (aux.getUsuario().equals(usuario)) {
					aux.setUsuario(nuevoUsuario);
					usuarios.set(x, aux);
					this.mensaje = "se modifico correctamente el usuario";
					return mensaje;
				}
				x++;
			}
			this.mensaje = "no se pudo modificar el usuario";

			scanner.close();
		} else {
			this.mensaje = "no se pudo encontrar el usuario a modificar";
		}
		return mensaje;
	}

	@Override
	public void listarUsuario() {
		int x = 1;
		System.out.println("los usuarios cargados actualmente son: ");
		for (Usuario usuario : usuarios) {
			System.out.println("-----------------------------------------");
			System.out.println(x + ":\n");
			System.out.println(usuario.toString());
			System.out.println("\n");
			x++;
		}
		System.out.println("-----------------------------------------");
		System.out.println("\n");
	}

	@Override
	public boolean existeUsuario(String usuario) {
		for (Usuario aux : usuarios) {
			if (aux.getUsuario().equals(usuario)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Usuario buscarUsuario(String usuario) {
		for (Usuario aux : usuarios) {
			if (aux.getUsuario().equals(usuario)) {
				return aux;
			}
		}
		return null;
	}

	@Override
	public boolean verificarAdmin(String usuario, String contrasenia) {
		if (admin.getUsuario().equals(usuario) && admin.getContrasenia().equals(contrasenia)) {
			return true;
		}
		return false;
	}

	@Override
	public Usuario verificarUsuario(String usuario, String contrasenia) {
		for (Usuario aux : usuarios) {
			if (aux.getUsuario().equals(usuario) && aux.getContrasenia().equals(contrasenia) && aux.isEstado()) {
				return aux;
			}
		}
		return null;
	}
	
	@Override 
	public boolean usuarioInactivo(String usuario, String contrasenia) {
		for (Usuario aux : usuarios) {
			if (aux.getUsuario().equals(usuario) && aux.getContrasenia().equals(contrasenia) && !aux.isEstado()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean accionesAdmin(String usuario, CarritoProductos carritoAdmin, ArrayList<CarritoProductos> carritosClientes, ArrayList<ArrayList<CarritoProductos>> listaPedidos, AccionesCategoria accionesCategoria, AccionesEmpresa accionesEmpresa) {
		System.out.println("bienvenido administrador " + usuario);
		System.out.println("ingrese la accion a realizar");
		System.out.println("1 - abml usuarios");
		System.out.println("2 - abml productos");
		System.out.println("3 - abml categorias");
		System.out.println("4 - abml empresas");
		System.out.println("5 - cerrar sesion");

		int accion;

		try {
			accion = scanner.nextInt();
		} catch (Exception e) {
			accion = -1;
		}
		
		switch (accion) {
		case 1:
			System.out.println("ingrese la accion a realizar");
			System.out.println("1 - alta usuario");
			System.out.println("2 - baja usuario");
			System.out.println("3 - modificar usuario");
			System.out.println("4 - listar usuarios");
			System.out.println("5 - buscar usuario");
			
			int aUsuarios;

			try {
				aUsuarios = scanner.nextInt();
			} catch (Exception e) {
				aUsuarios = -1;
			}
			
			switch (aUsuarios) {
				case 1:
					System.out.println("selecciono cargar usuario");
					System.out.println("ingrese el usuario");
					String user = scanner.next();
					System.out.println("ingrese la contrasenia");
					String pass = scanner.next();
					
					System.out.println(cargarUsuario(new Usuario(user, pass)));
					carritosClientes.add(new CarritoProductos(""));
					listaPedidos.add(new ArrayList<CarritoProductos>());
					
					break;
				case 2:
					System.out.println("selecciono dar de baja usuario");
					System.out.println("ingrese el usuario");
					user = scanner.next();
					
					System.out.println(removerUsuario(user));
					break;
				case 3:
					System.out.println("selecciono modificar un usuario");
					System.out.println("ingrese el usuario");
					user = scanner.next();
					System.out.println(modificarUsuario(user));
					break;
				case 4:
					System.out.println("selecciono listar usuarios");
					listarUsuario();
					break;
				case 5:
					System.out.println("selecciono buscar un usuario");
					System.out.println("ingrese el usuario");
					user = scanner.next();
					Usuario aux = buscarUsuario(user);
					this.mensaje = aux == null ? "el usuario no existe" : aux.toString(); 
					System.out.println(mensaje);
					break;
				default:
					System.out.println("opcion incorrecta!");
					break;
			}
			break;
		case 2:
			System.out.println("ingrese la accion a realizar");
			System.out.println("1 - alta producto");
			System.out.println("2 - baja producto");
			System.out.println("3 - modificar producto");
			System.out.println("4 - listar productos"); 
			System.out.println("5 - buscar producto");
			int aProductos;

			try {
				aProductos = scanner.nextInt();
			} catch (Exception e) {
				aProductos = -1;
			}
			
			String codigo;
			String nombre;
			double precio;
			Categoria cat;
			Empresa emp;
			int stock;
			String auxNombre;
			String auxDesc;
			int index;
			
			switch (aProductos) {
				case 1:
					System.out.println("selecciono cargar un nuevo producto");
					System.out.println("seleccione que tipo de articulo desea cargar:");
					System.out.println("1 - pinturas");
					System.out.println("2 - perfumes");
					int aTipoProducto;

					try {
						aTipoProducto = scanner.nextInt();
					} catch (Exception e) {
						aTipoProducto= -1;
					}
					
					codigo = Integer.toString(carritoAdmin.getProductos().size()+1001);
					System.out.println("ingrese el nombre:");
					nombre = scanner.next();
					System.out.println("ingrese el precio:");
					precio = scanner.nextDouble();
					
					System.out.println("seleccione la categoria perteneciente:");
					accionesCategoria.listarCategorias();
					index = scanner.nextInt();
					while(index < 0 || index > accionesCategoria.getCategorias().size()) {
						System.out.println("el indice de categoria ingresado es invalido \n ingrese uno nuevo valido");
						index = scanner.nextInt();
					}
					cat = accionesCategoria.buscarCategoria(index-1);
					
					System.out.println("seleccione la empresa perteneciente:");
					accionesEmpresa.listarEmpresas();
					index = scanner.nextInt();
					while(index < 0 || index > accionesEmpresa.getEmpresas().size()) {
						System.out.println("el indice de empresa ingresado es invalido \n ingrese uno nuevo valido");
						index = scanner.nextInt();
					}
					emp = accionesEmpresa.buscarEmpresa(index-1);
					
					System.out.println("ingrese el stock:");
					stock = scanner.nextInt();			
					
					switch(aTipoProducto) {
					case 1:

						System.out.println("ingrese el color:");
						String color = scanner.next();
						System.out.println("ingrese la densidad:");
						double densidad = scanner.nextDouble();
						
						carritoAdmin.agregarProducto(new Pintura(codigo, nombre, precio, fecha(), cat, emp, stock, color, densidad));
						System.out.println("se agrego correctamente la nueva pintura");
						break;
					case 2:

						System.out.println("ingrese la fragancia:");
						String fragancia = scanner.next();
						System.out.println("ingrese la cantidad:");
						double cantidad = scanner.nextDouble();
						System.out.println("ingrese el pais de origen:");
						String pais = scanner.next();
						
						carritoAdmin.agregarProducto(new Perfume(codigo, nombre, precio, fecha(), cat, emp, stock, fragancia, cantidad, pais));
						System.out.println("se agrego correctamente el nuevo perfume");
						break;	
					default:
						carritoAdmin.agregarProducto(new Producto(codigo, nombre, precio, fecha(), cat, emp, stock));
						System.out.println("se agrego correctamente producto");
						break;
					}
					
					
					break; 
				case 2:
					System.out.println("selecciono dar de baja un producto");
					System.out.println("-------------------------------------");
					for (Producto producto : carritoAdmin.getProductos()) {
						if(producto.isEstado()) {
							System.out.println(producto.toString());							
						}
					}
					System.out.println("-------------------------------------");
					System.out.println("ingrese el codigo del producto que desea eliminar");
					System.out.println("-------------------------------------");
					codigo = scanner.next();
					System.out.println("confirmar baja: \nS - confirmar \nN - cancelar");
					String confirmar = scanner.next();
					confirmar.toLowerCase();
					if(!confirmar.isEmpty() && confirmar.equals("s")) {
						carritoAdmin.removerProducto(codigo);
						System.out.println("se removio correctamente el producto");
					} else {
						System.out.println("no se removio el producto");
					}
					
					break;
					
				case 3:
					System.out.println("selecciono modificar un producto");
					System.out.println("ingrese la opcion a modificar");
					System.out.println("1 - nombre");
					System.out.println("2 - precio");
					System.out.println("3 - stock");
					
					int aTipoModificacion;

					try {
						aTipoModificacion = scanner.nextInt();
					} catch (Exception e) {
						aTipoModificacion = -1;
					}
					
					System.out.println("-------------------------------------");
					for (Producto producto : carritoAdmin.getProductos()) {
						if(producto.isEstado()) {
							System.out.println(producto.toString());							
						}
					}
					System.out.println("-------------------------------------");
					System.out.println("ingrese el codigo del producto que desea modificar");
					System.out.println("-------------------------------------");
					codigo = scanner.next();
					
					switch(aTipoModificacion) {
					case 1:
						System.out.println("ingrese el nuevo nombre del producto");
						nombre = scanner.next();
						
						if(carritoAdmin.modificarProducto(codigo, nombre)) {
							System.out.println("se modifico correctamente el producto");	
						}else {
							System.out.println("no se modifico correctamente el producto");	
						}
						break;
					case 2:
						System.out.println("ingrese el nuevo precio del producto");
						double auxPrecio = scanner.nextDouble();

						if(carritoAdmin.modificarProducto(codigo, auxPrecio)) {
							System.out.println("se modifico correctamente el producto");	
						}else {
							System.out.println("no se modifico correctamente el producto");	
						}
						break;
					case 3:
						System.out.println("ingrese el nuevo stock del producto");
						int auxStock = scanner.nextInt();

						if(carritoAdmin.modificarProducto(codigo, auxStock)) {
							System.out.println("se modifico correctamente el producto");	
						}else {
							System.out.println("no se modifico correctamente el producto");	
						}
						break;
					default:
						System.out.println("no se modifico correctamente el producto");	
						break;
					}
					
					break;
				case 4:
					System.out.println("selecciono listar productos");
					System.out.println("-------------------------------------");
					for (Producto producto : carritoAdmin.getProductos()) {
						System.out.println(producto.toString());
					}
					System.out.println("-------------------------------------");
					
					break;
				case 5:
					System.out.println("selecciono buscar un producto");
					System.out.println("ingrese el nombre del producto que desea buscar");
					nombre = scanner.next();

					System.out.println("los siguientes productos coinciden con su busqueda:");
					ArrayList<Producto> auxLista = carritoAdmin.buscarProducto(nombre);
					if(auxLista.size() > 0) {						
						for (Producto producto : auxLista) {
							System.out.println(producto.toString());
						}
					} else {
						System.out.println("\t- no hay productos.");
					}
					
					break;
				default:
					System.out.println("opcion incorrecta!");
					break;
			}
			break;
		case 3:
			System.out.println("ingrese la accion a realizar");
			System.out.println("1 - alta categoria");
			System.out.println("2 - baja categoria");
			System.out.println("3 - modificar categoria");
			System.out.println("4 - listar categorias"); 
			
			int aCategorias;

			try {
				aCategorias = scanner.nextInt();
			} catch (Exception e) {
				aCategorias = -1;
			}
			
			switch (aCategorias) {
				case 1:
					System.out.println("selecciono cargar una nueva categoria");
					System.out.println("-------------------------------------");
					
					System.out.println("ingrese el nombre:");
					auxNombre = scanner.next();
					System.out.println("ingrese la descripcion:");
					auxDesc = scanner.next();
					
					
					System.out.println(accionesCategoria.cargarCategoria(new Categoria(auxNombre, auxDesc)));
					
					break;
				case 2:
					System.out.println("selecciono dar de baja una categoria ");
					System.out.println("-------------------------------------");
					
					if(accionesCategoria.getCategorias() != null) {

						for (Categoria categoria : accionesCategoria.getCategorias()) {
							if(categoria.isEstado() && !categoria.getNombre().equals("uncategorized")) {								
								System.out.println(categoria.toString());
							}
						}
						System.out.println("-------------------------------------");
						System.out.println("ingrese el nombre de la categoria que desea eliminar");
						System.out.println("-------------------------------------");
						nombre = scanner.next();
						
						

						System.out.println(accionesCategoria.removerCategoria(nombre));	
					} else {
						System.out.println("actualmente no cuenta con categorias cargadas");
					}
					
					break;
				case 3:
					System.out.println("selecciono modificar una categoria");
					
					System.out.println("-------------------------------------");
					for (Categoria categoria : accionesCategoria.getCategorias()) {
						if(categoria.isEstado() && !categoria.getNombre().equals("uncategorized")) {
							System.out.println(categoria.toString());							
						}
					}
					System.out.println("-------------------------------------");
					System.out.println("ingrese el nombre de la categoria que desea modificar");
					System.out.println("-------------------------------------");
					nombre = scanner.next();
					
					System.out.println(accionesCategoria.modificarCategoria(nombre));
					
					break;
				case 4:
					System.out.println("selecciono de listar categorias");
					accionesCategoria.listarCategorias();
					
					break;
				default:
					System.out.println("opcion incorrecta!");
					break;
			} 
			break;
		case 4:
			System.out.println("ingrese la accion a realizar");
			System.out.println("1 - alta empresa");
			System.out.println("2 - baja empresa");
			System.out.println("3 - modificar empresa");
			System.out.println("4 - listar empresas"); 
			
			int aEmpresas;

			try {
				aEmpresas = scanner.nextInt();
			} catch (Exception e) {
				aEmpresas = -1;
			}
			
			switch (aEmpresas) {
				case 1:
					System.out.println("selecciono la opcion de cargar una empresa");
					System.out.println("------------------------------------------------------");
					System.out.println("ingrese el nombre y la descripcion de la nueva empresa:");
					System.out.println("------------------------------------------------------");
					auxNombre = scanner.next();
					auxDesc = scanner.next();
					
					System.out.println(accionesEmpresa.cargarEmpresa(new Empresa(auxNombre, auxDesc)));
					break;
				case 2:
					System.out.println("selecciono la opcion de dar de baja una empresa");

					if(accionesEmpresa.getEmpresas() != null) {

						for (Empresa empresa : accionesEmpresa.getEmpresas()) {
							if(empresa.isEstado() && !empresa.getNombre().equals("sin empresa")) {								
								System.out.println(empresa.toString());
							}
						}
						System.out.println("-------------------------------------");
						System.out.println("ingrese el nombre de la emrpesa que desea eliminar");
						System.out.println("-------------------------------------");
						nombre = scanner.next(); 
						
						System.out.println(accionesEmpresa.removerEmpresa(nombre));
					} else {
						System.out.println("actualmente no cuenta con empresas cargadas");
					}
					break;
				case 3:
					System.out.println("selecciono la opcion de modificar empresa");
					
					System.out.println("-------------------------------------");
					for (Empresa empresa : accionesEmpresa.getEmpresas()) {
						if(empresa.isEstado() && !empresa.getNombre().equals("sin empresa")) {
							System.out.println(empresa.toString());							
						}
					}
					System.out.println("-------------------------------------");
					System.out.println("ingrese el nombre de la empresa que desea modificar");
					System.out.println("-------------------------------------");
					nombre = scanner.next();
					
					System.out.println(accionesEmpresa.modificarEmpresa(nombre));
					
					break;
				case 4:
					System.out.println("selecciono la opcion de listar empresas");
					
					accionesEmpresa.listarEmpresas();
					break;
				default:
					System.out.println("opcion incorrecta!");
					break;
			}
			break;
		case 5:
			return true;
		default:
			System.out.println("opcion incorrecta!");
			break;
		}
		return false;
	}

	@Override
	public boolean accionesCliente(String usuario, CarritoProductos carritoAdmin, CarritoProductos carritoCliente, ArrayList<CarritoProductos> listaPedidos) {
		System.out.println("bienvenido " + usuario);
		System.out.println("ingrese la accion a realizar");
		System.out.println("1 - seleccionar productos");
		System.out.println("2 - mostrar productos seleccionados");
		System.out.println("3 - confirmar pedido");
		System.out.println("4 - listar pedidos confirmados");
		System.out.println("5 - cerrar sesion");
		
		int accion;

		try {
			accion = scanner.nextInt();
		} catch (Exception e) {
			accion = -1;
		}
		
		switch (accion) {
			case 1:
				System.out.println("seleccione los articulos para cargar en su carrito:");
				
				int x = 0;
				int salir = x;
				for (Producto producto : carritoAdmin.getProductos()) {
					System.out.println("codigo: " + x + " - " + producto.getNombre() + " $" + producto.getPrecio());
					System.out.println();
					x++;
					salir = x;
				}
				System.out.println(x + ": salir");
				
				
				do {
					System.out.println("ingrese el codigo de producto");

					try {
						x = scanner.nextInt();
					} catch (Exception e) {
						x = -1;
					}
					
					if(x < salir) {
						if(carritoAdmin.getProductos().get(x).getStock() > 0) {
							carritoCliente.agregarProducto(carritoAdmin.getProductos().get(x));
							carritoAdmin.getProductos().get(x).setStock(carritoAdmin.getProductos().get(x).getStock()-1);
							
							System.out.println("se agrego " + carritoAdmin.getProductos().get(x) + " al carrito");
						} else {
							System.out.println("no se agrego el producto por stock insuficiente");
						}
					} else {
						System.out.println("codigo incorrecto");
					}
				}while(salir != x);
				
				System.out.println("si esta conforme con su pedido proceda a confrmarlo");
				
				break;
			case 2:
				System.out.println("los productos cargados en su carrito actalmente son:");
				x = 0;
				if(carritoCliente != null) {
					for (Producto producto : carritoCliente.getProductos()) {
						System.out.println("codigo: " + x + " - " + producto.getNombre() + " $" + producto.getPrecio());
						System.out.println();
						x++;
					}
					System.out.println("el valor total de carrito es: $" + carritoCliente.getValorTotal());
					System.out.println("descuento: $" + carritoCliente.calcularDescuento());
					System.out.println("valor neto a pagar: $" + carritoCliente.getValorAPagar());
				} else {
					System.out.println("el carrito se encuentra vacio");
				}
				
				break;
			case 3:
				System.out.println("los productos cargados en su carrito actalmente son:");
				x = 0;
				for (Producto producto : carritoCliente.getProductos()) {
					System.out.println("codigo: " + x + " - " + producto.getNombre() + " $" + producto.getPrecio());
					System.out.println();
					x++;
				}
				System.out.println("desea finalizar su pedido? \nS = si \nN = no");
				String eleccion;
				
				try {
					eleccion = scanner.next();
					eleccion.toLowerCase();
				} catch(Exception e){
					eleccion = "x";
				}
				
				if(eleccion.equals("s")) {
					System.out.println("se agrego correctamente el pedido a la lista de pedidos");
					listaPedidos.add(carritoCliente);
					carritoCliente = new CarritoProductos("");
				}else if(eleccion.equals("n")) {
					System.out.println("no se agrego el pedido a la lista de pedidos");
				} else {
					System.out.println("la opcion seleccionada es invalida");
				}
				
				
				break;
			case 4:
				System.out.println("selecciono la opcion de listar los pedidos confirmados");
				for(x = 0; x < listaPedidos.size(); x++) {
					System.out.println("el pedido numero " + (x+1) + ", \nesta conformado por:");
					for (Producto unidad : listaPedidos.get(x).getProductos()) {
						System.out.println(unidad.toString(""));
						
					}
					System.out.println("");
				}
				
				break;
			case 5:
				return true;
			default:
				System.out.println("opcion invalida");
				break;
		}
		
		return false;
	}
	
	public Date fecha() {
		LocalDate localfecha = LocalDate.now();	
		java.time.Instant instant = localfecha.atStartOfDay(ZoneId.systemDefault()).toInstant();
		Date fecha = Date.from(instant);
		return fecha;
	}
}
