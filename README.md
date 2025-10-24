
# Bienvenido a la preentrega del prodyecto ecommerce desarrollado por Braian Pirelli utilizando JAVA para TalentoTech.


El mismo viene preparado con varias funcionalidades


-control de usuarios (admin/cliente)
-crud usuarios
-crud categorias
-crud empresas
-crud productos
-manipulacion de pedidos

para ingresar por primera vez no contaremos con usuarios clientes cargados por tal motivo deberemos ingresar como administradores con el usuario default.

(solo un admin puede dar de alta usuarios, y no se pueden cargar mas administradores).

la app viene con datos cargados de manera predeterminada, como un usuario admin, 4 categorias, 4 empresas, y 5 productos.

todos ellos pueden ser modificados / dados de baja, excepto el admin (el es quien se encarga de dichas modificaciones).

menciono que seran dados de baja porque en la aplicacion se manejan bajas logicas en lugar de bajas fisicas.

para poder interactuar como usuario cliente, deberemos logearnos como admin, cargar un cliente, cerrar sesion como admin, y volver a logearnos pero esta vez, como clientes.

como clientes tendremos la posibilidad de llenar de forma figurativa un carrito de compras con los productos disponibles, verificar si es un pedido mayorista o no, de ser asi si cuenta con un descuento.

volver a cargar mas productos y finalmente confirmar un pedido, el cual se aniadira a la lista de pedidos confirmados por dicho cliente.


----------------------------------------------------
 
 
cosas a destacar

al contar con multiples usurios, cada uno tiene que contar con un carrito propio, esto se soluciona utilizando index de cada usuario que es creado por el administrador.
de la misma forma cada usuario cuenta con una lista de pedidos.
la cual a mi forma de ver es una lista de listas, por cada cliente existente.
se soluciono de la misma manera que el carrito de productos.
