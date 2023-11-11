package Presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import Logica.AdminGeneral;
import Logica.AdminLocal;
import Logica.Categoria;
import Logica.ClienteRegistrado;
import Logica.ConductorAdicional;
import Logica.Empleado;
import Logica.Reserva;
import Logica.Sede;
import Logica.BaseDatos;
import Logica.Licencia;
import Logica.MetodoPago;
import Logica.Vehiculo;


import Procesamiento.Inventario;

public class Aplicacion 
{

	private Categoria categoria;
	private BaseDatos baseDatos;
	private ClienteRegistrado cliente;
	private AdminGeneral adminGeneral;
	private AdminLocal adminLocal;
	private Sede sede;
	private Empleado empleado;
	private Vehiculo vehiculo;
	
	
	private Inventario inventario;
	
	private HashMap<String, List<String>> clientes;
	private HashMap<String, List<String>> empleados;
	int contador;
	

	public Aplicacion()
	{
		categoria = new Categoria ();
		baseDatos = new BaseDatos();
		adminLocal = new AdminLocal(null, null, null, null, null, null, null);
		adminGeneral = new AdminGeneral(null, null, null, null, null, null);
		cliente = new ClienteRegistrado(null, null, null, null, null, null, null, null,null);
		sede = new Sede(null, null, null);
		empleado = new Empleado(null, null, null, null, null, null, null);
		vehiculo = new Vehiculo(null, null, null, null, null, null, null, null, null, null); 

		
		inventario = new Inventario(baseDatos, vehiculo);

		baseDatos.cargarBaseDatos("empleados.txt", 
								  "ClientesRegistrados.txt",
								  "sede1.txt",
								  "sede2.txt",
								  "sede3.txt");
		categoria.cargarFlotilla("vehiculos.txt");
		sede.cargarInformacionSedes("infoSede1.txt", "infoSede2.txt", "infoSede3.txt");
		empleado.cargarArchivosEmpleados("empleados.txt", "empleadosSede1.txt", "empleadosSede2.txt", "empleadosSede3.txt");
		
		clientes = baseDatos.getClientesRegistrados();
		empleados = baseDatos.getEmpleados();
		contador = 0;
	}

	/**
	 * Ejecuta la aplicación: le muestra el menú al usuario y la pide que ingrese
	 * una opción, y ejecuta la opción seleccionada por el usuario. Este proceso se
	 * repite hasta que el usuario seleccione la opción de abandonar la aplicación.
	 * @throws IOException 
	 */
	public void ejecutarAplicacion() throws IOException
	{
		System.out.println("\nOpciones sobre el menu");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if(opcion_seleccionada == 1)
					ejecutarInicioSesion();
				else if (opcion_seleccionada == 2)
					ejecutarCrearUsuario ();
				else if (opcion_seleccionada == 3) {
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				} else if (baseDatos == null && cliente == null) {
					System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo.");
				} else {
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	/**
	 * Muestra al usuario el menú con las opciones para que escoja la siguiente
	 * acción que quiere ejecutar.
	 * 
	 */
	public void mostrarMenu()
	{
		
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("OJO El unico que puede crear cuentas de empleado es el AdminLocal, inicia secion para hacerlo");
		System.out.println("1. Iniciar Sesión");
		System.out.println("2. Crear Cuenta Nuevo Cliente");
		System.out.println("3. Salir");
	}

	public void ejecutarInicioSesion() throws IOException
	{
		System.out.println("¿Como desearia iniciar sesión?");
		System.out.println("1. Cliente");
		System.out.println("2. AdminGeneral");
		System.out.println("3. AdminLocal");
		System.out.println("4. Empleados");

		int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));

		if(opcion_seleccionada == 1)
		{
			String usuario = input("Por favor ingrese su usuario ");
			String contraseña = input ("Por favor ingrese su contraseña ");
			
			List<String> infoUsuario = clientes.get(usuario);
			int tamanio = infoUsuario.size();
			String actual = null;
			Boolean encontro = false;
			if(clientes.containsKey(usuario))
			{
				for(int i = 0; i < tamanio && encontro == false; i++)
				{
					actual = infoUsuario.get(i); 
					if(actual.equals(contraseña))
					{	boolean terminoDeUsarApp = false;
					while (terminoDeUsarApp == false)
					{
						System.out.println("\nA. Reservar Vehiculo");
						System.out.println("\nB. Alquilar Vehiculo");
						System.out.println("\nC. Agregar conductor Adicional");

						String opcion = input("\nPor favor seleccione una opción");
						if(opcion.equals("A")) {
							reservarVehiculo();
							System.out.println("1. Continuar en la vista del Cliente");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}
						else if(opcion.equals("B")) {
							alquilarVehiculo();
							System.out.println("1. Continuar en la vista del Cliente");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}
						else if(opcion.equals("C")) {
							agregarConductorAdicional();
							System.out.println("1. Continuar en la vista del Cliente");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}else {
							System.out.println("No es una opcion valida, trate otra vez");
						}
					
					}	
				}
					
			}
				
		}
			else
			{
				System.out.println("No se encontro el usuario ingresado :(");
			}
		} 
		
		else if (opcion_seleccionada == 2)
		{
			String usuario = input("Por favor ingrese su usuario, no se le olvide que para validar que es adminGeneral"
					+ " debe poner un 1 al final de su Cedula (username) ");
			String contraseña = input ("Por favor ingrese su contraseña ");
			
			List<String> infoEmpleados = empleados.get(usuario);
			int tamanio = infoEmpleados.size();
			String actual = null;
			Boolean encontro = false;
			if(empleados.containsKey(usuario))
			{
				for(int i = 0; i < tamanio && encontro == false; i++)
				{
					actual = infoEmpleados.get(i); 
					if(actual.equals(contraseña))
					{
						boolean terminoDeUsarApp = false;
						while (terminoDeUsarApp == false)
						{
						System.out.println("\nA. Registrar Compra Nuevos Vehiculos");
						System.out.println("\nB. Dar de Baja a un Vehiculo");
						System.out.println("\nC. Informacion Tiempo Real");
						System.out.println("\nD. Gestionar Sede");

						String opcion = input("\nPor favor seleccione una opción");
						if(opcion.equals("A")) {
							registrarCompraNuevosVehiculos();
							System.out.println("1. Continuar en la vista del AdminGeneral");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}
						else if(opcion.equals("B")) {
							darBajaVehiculo();
							System.out.println("1. Continuar en la vista del AdminGeneral");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}
						else if(opcion.equals("C")) {
							informacionTiempoReal();
							System.out.println("1. Continuar en la vista del AdminGeneral");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}
						else if (opcion.equals("D")) {
							gestionarSede();
							System.out.println("1. Continuar en la vista del AdminGeneral");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}else {
							System.out.println("No es una opcion valida, trate otra vez");
						}
					}
					}
					
				}
				
			}
			else
			{
				System.out.println("No se encontro el usuario ingresado :(");
			}
		}
		
		else if (opcion_seleccionada == 3)
		{
			String usuario = input("Por favor ingrese su usuario, no se le olvide que para validar que es adminLocal"
					+ " debe poner un 2 al final de su Cedula (username) ");
			String contraseña = input ("Por favor ingrese su contraseña ");
			
			List<String> infoEmpleados = empleados.get(usuario);
			int tamanio = infoEmpleados.size();
			String actual = null;
			Boolean encontro = false;
			if(empleados.containsKey(usuario))
			{
				for(int i = 0; i < tamanio && encontro == false; i++)
				{
					actual = infoEmpleados.get(i); 
					if(actual.equals(contraseña))
					{
						boolean terminoDeUsarApp = false;
						while (terminoDeUsarApp == false)
						{
						System.out.println("\nA. Registrar Empleados");
						System.out.println("\nB. Gestionar Informacion Empleados");
						System.out.println("\nC. Crear Usuarios Clientes");
						

						String opcion = input("\nPor favor seleccione una opción");
						if(opcion.equals("A")) {
							registrarEmpleado();
							System.out.println("1. Continuar en la vista del AdminLocal");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}
						else if(opcion.equals("B")) {
							gestionarInfoEmpleados();
							System.out.println("1. Continuar en la vista del AdminLocal");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}
						else if(opcion.equals("C")) {
							crearUsuarios();
							System.out.println("1. Continuar en la vista del AdminLocal");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}else {
							System.out.println("No es una opcion valida, trate otra vez");
						}
					}
					}
					
				}
				
			}
			else
			{
				System.out.println("No se encontro el usuario ingresado :(");
			}
		}
		
		else if (opcion_seleccionada == 4)
		{
			String usuario = input("Por favor ingrese su usuario, no se le olvide que para validar que es Empleado"
					+ " debe poner un 3 al final de su Cedula (username) ");
			String contraseña = input ("Por favor ingrese su contraseña ");
			
			List<String> infoEmpleados = empleados.get(usuario);
			int tamanio = infoEmpleados.size();
			String actual = null;
			Boolean encontro = false;
			if(empleados.containsKey(usuario))
			{
				for(int i = 0; i < tamanio && encontro == false; i++)
				{
					actual = infoEmpleados.get(i); 
					if(actual.equals(contraseña))
					{
						boolean terminoDeUsarApp = false;
						while (terminoDeUsarApp == false)
						{
						System.out.println("\nA. Entrega Vehiculo");
						System.out.println("\nB. Devolucion Vehiculo");
						System.out.println("\nC. Registro Conductor Adicional");
						System.out.println("\nD. Actualizar Estado Vehiculo");

						String opcion = input("\nPor favor seleccione una opción");
						if(opcion.equals("A")) {
							entregaVehiculo();
							System.out.println("1. Continuar en la vista del Empleado");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada == 2;
						}
						else if(opcion.equals("B")) {
							devolucionVehiculo();
							System.out.println("1. Continuar en la vista del Empleado");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}
						else if(opcion.equals("C")) {
							registroConductorAdicional();
							System.out.println("1. Continuar en la vista del Empleado");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}
						else if(opcion.equals("D")) {
							actualizarEstadoVehiculo();
							System.out.println("1. Continuar en la vista del Empleado");
							System.out.println("2. Finaizar uso de la App");
							opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
							terminoDeUsarApp = opcion_seleccionada ==2;
						}else {
							System.out.println("No es una opcion valida, trate otra vez");
						}
					}
					}
					
				}
				
			}
			else
			{
				System.out.println("No se encontro el usuario ingresado :(");
			}
		}

	}
	
	public void ejecutarCrearUsuario () throws IOException
	{
		System.out.println("\n Por favor siga las indicaciones para crear su cuenta");
		
		
		boolean terminoDeUsarApp = false;
		while (terminoDeUsarApp == false)
		{
		String cedula = input("\n Por favor digite su cedula/Documento de Identificacion (10 digitos) ");
		String nombre = input("\n Por favor escriba su nombre completo");
		String celular = input("\n Por favor digite su numero celular (10 digitos)");
		String email = input("\n Por favor escriba su correo electronico");
		String contraseña = input("\n Escriba la contraseña con la que le gustaria iniciar sesión desde ahora en adelante");
		String fechaNacimiento = input("\n Escriba cuando nacio en formato (día-mes-año)");
		String nacionalidad = input("\n Escriba su país de nacimineto");
		String lugarExpedicionCC = input("\n Escriba el país donde saco su Cedula o Documento de Identificacion");
		
		String numeroLicencia = input("\n Escriba el numero de su licencia");
		String fechaVencimientoLicencia = input("\n Escriba la fecha en que se le vence la licencia en formato (día-mes-año)");
		
		String medioPago = input("\n Por favor escriba si usa una Tarjeta de Credito o Tarjeta Debito");
		String cvc = input("\n Por favor digite el codigo de seguridsad de su Tarjeta");
		String numeroTarjeta = input("\n Por favor digite el numero de su Tarjeta (16 digitos)");
		String fechaVencimientoTarjeta = input("\n Por favor escriba la fecha cuando debe cambiar su tarjeta formato (mes-año)");
		String banco = input("\n Por favor escriba el banco al que pertenece su Tarjeta");
		
		ClienteRegistrado cliente_nuevo = new ClienteRegistrado(nombre,cedula,celular,email,null,contraseña,fechaNacimiento,nacionalidad,lugarExpedicionCC);
		Licencia licencia = new Licencia(numeroLicencia, fechaVencimientoLicencia);
		MetodoPago metodo = new MetodoPago(medioPago, cvc, numeroTarjeta, fechaVencimientoTarjeta, banco);
		
		
		
		baseDatos.crearCuentaCliente(cliente_nuevo, licencia, metodo);
		
		System.out.println("1. Crear otra cuenta");
		System.out.println("2. Finaizar uso de la App");
		System.out.println("\n Para poder iniciar sesion por favor salga de la app y vuelva a entrar :) ");
		int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
		terminoDeUsarApp = opcion_seleccionada ==2;
		}
	}

	/**
	 * Funciones relacionadas al cliente 
	 */

	public void reservarVehiculo()
	{
		
		System.out.println("\n Por favor sigue las siguientes instrucciones para realizar la reserva ");
		
		String categoriaCarro = input("\n Por favor ingrese la categoria que desea (suv, deportivo, lujo, pequeño o vans ) ");
		String sede = input("\n En que sede desea realizar la reserva (sede1, sede2 o sede3)");
		String fechaPickUp = input ("\n Cuando recogeria el vehiculo (día-mes-año)");
		String sedeDevolucion = input ("\n En que sede realizara la devolucion (sede1, sede2 o sede3)");
		String fechaDevolucion = input ("\n En que fecha realizara la devolucion (día-mes-año)");
		
		cliente.guardarCarrosEnUso(categoriaCarro, sede, fechaPickUp, fechaDevolucion, sedeDevolucion);
		
		System.out.println("\n Se ha realizado su reserva con el identificador numero "+ ++contador + " y se le realizo un cobro del 30% sobre " + "\n la tarifa calculada"); 
		
	}

	public void alquilarVehiculo()
	
	{
		String rta = input("¿Desea un alquiler? (Si-No)");
		if(rta.equals("Si")) {
			System.out.println("Si no has realizado una reserva no se te olvide que Los alquileres solamente se pueden hacer dentro de una sede");	
		}else if (rta.equals("No")) {
			System.out.println("Perfecto, si realizaste una reserva te esperamos para entregarte tu vehiculo");
		}else
		{
			System.out.println("No ingreso una opcion valida, trate otra vez");
		}
		
	}

	public void agregarConductorAdicional()
	{
		String rta = input("¿Desea agregar un conductor adicional? (Si-No)");
		
		if(rta.equals("Si")) {
			System.out.println("Al momento de recoger el vehiculo un empleado le pedira la informacion para registrar los conductores adicionales" + "\n(Por conductor adicional se cobra 120.000 mil cop )");
		}else if (rta.equals("No")) {
			System.out.println("Perfecto, el unico que podra manejar el vehiculo sera la persona que realizo la reserva. ");
		}else {
			System.out.println("No ingreso una opcion valida, trate otra vez");
		}
	}

	/**
	 * Funciones relacionadas con el AdminGerenal	
	 * @throws IOException 
	 */
	
	public void registrarCompraNuevosVehiculos() throws IOException
	{
		System.out.println("\n Por favor sigue los pasos para poder registrar el Nuevo Vehiculo");
		
		String placa = input("Por favor ingrese la placa de registro del nuevo vehiculo");
		String marca = input("Por favor ingrese la marca del nuevo vehiculo");
		String modelo = input("Por favor ingrese el modelo de su vehiculo (como lo llamo la marca para identificarlo)");
		String ano = input("Por favor ingrese el año de su vehiculo");
		String color = input("El color de su vehiculo");
		String transmision = input("¿Que tipo de transmision es el nuevo vehiculo?");
		String ubicacion = input("¿A que sede va a llegar el nuevo vehiculo?");
		String alquilado = input("Por favor escriba False");
		String estado = input("Por favor escriba Listo para validar que el nuevo vehiculo estara disponible para ser Reservado o Alquilado ");
		String tipo = input("Y por ultimo a que categoria pertenece este nuevo vehiculo (suv, pequeño, lujo, deportivo, vans)");
		
		Vehiculo carritoNuevo = new Vehiculo(placa, marca, modelo, ano, color, transmision, ubicacion, alquilado, estado, tipo);
		adminGeneral.registrarCompraNuevoVehiculo(placa, marca, modelo, ano, color, transmision, ubicacion, alquilado, estado, tipo);
		
		inventario.agregarCarroNuevo(carritoNuevo);
		if (ubicacion.equals("sede1")) {
			inventario.agregarCarroNuevoSede1(carritoNuevo);
		}else if (ubicacion.equals("sede2")) {
			inventario.agregarCarroNuevoSede2(carritoNuevo);
		}else if (ubicacion.equals("sede3")) {
			inventario.agregarCarroNuevoSede3(carritoNuevo);
		}else {
			System.out.println("No existe una sede con ese nombre, por favor trate nuevamente de realizar el registro ");
		}
			
		System.out.println("\n El nuevo vehiculo ya quedo registrado en la Base de Datos");
		
		
	}
		
	
	public void darBajaVehiculo() throws IOException 
	{
		String placa = input("Escriba la placa del vehiculo al que quiere dar baja");
		String sede = input("Escriba la sede a la que pertenece el vehiculo (sede1, sede2, sede3)");
		
		
			inventario.darBajarVehiculo(placa, sede);
		
	}
	
	public void informacionTiempoReal()
	{
		System.out.println("\n Dependiendo de la opción que escojas podras ver los carros que hay en una sede, las reservas realizadas y los carros que estan en uso.");
		System.out.println("1. Sede1");
		System.out.println("2. Sede2");
		System.out.println("3. Sede3");
		System.out.println("4. Reservas Actuales");
		System.out.println("5. Carros en Uso");
		
		int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
		
		if(opcion_seleccionada == 1) {
			imprimirSede1();
		} else if (opcion_seleccionada == 2) {
			imprimirSede2();
		}else if (opcion_seleccionada == 3) {
			imprimirSede3();
		}else if (opcion_seleccionada == 4) {
			reservasActuales();
		}else if (opcion_seleccionada == 5) {
			carrosEnUso();
		}else {
			System.out.println("No es una opcion valida, trate otra vez");
		}
	}
	
	public void gestionarSede()
	{
		System.out.println("Aca podras consultar la información de cada una de las sedes de la Empresa");
		System.out.println("1. Consultar información sede 1");
		System.out.println("2. Consultar informacion sede 2");
		System.out.println("3. Consultar informacion sede 3");
		
		int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
		
		if (opcion_seleccionada == 1) {
			imprimirSedeInfo1();
		}
		else if (opcion_seleccionada == 2) {
			imprimirSedeInfo2();
		}
		else if (opcion_seleccionada == 3) {
			imprimirSedeInfo3();
		}else {
			System.out.println("No es una opcion valida, trate otra vez");
		}
	}

	/**
	 * Funciones relacionadas con los AdminLocales
	 * @throws IOException 
	 */

	public void registrarEmpleado() throws IOException
	{
		System.out.println("\n AdminLocal por favor siga el paso a paso para poder registrar al nuevo empleado en la Base de Datos");
		System.out.println("\n AdminLocal, no se le olvide que el username sera SU CEDULA y debe poner al final un 2 si es otroAdmin o 3 si es un empleado normal" + "\nal momento de digitar la cedula");
		
	
			String cedula = input("\n Por favor digite su cedula/Documento de Identificacion (11 digitos) ");
			String contraseña = input("\n Escriba la contraseña con la que el empleado va a iniciar sesion");
			String nombre = input("\n Por favor escriba su nombre completo");
			String celular = input("\n Por favor digite su numero celular (10 digitos)");
			String email = input("\n Por favor escriba su correo electronico");
			String anosEmpresa = input("\n Por favor ingrese la cantidad de años que lleva en la Empresa");
			String sede = input("\n Escriba la sede en la que va a trabajar");
			
			Empleado empleado = new Empleado(nombre, cedula, celular, email, anosEmpresa, contraseña, sede);
			adminLocal.crearNuevoEmpleado(empleado);
			
			if (sede.equals("sede1"))
			{
				adminLocal.agregarNuevoEmpleadoSede1(empleado);
			}else if (sede.equals("sede2")) {
				adminLocal.agregarNuevoEmpleadoSede2(empleado);
			}else if (sede.equals("sede3")) {
				adminLocal.agregarNuevoEmpleadoSede3(empleado);
			}else {
				System.out.println("No existe una sede con ese nombre, por favor trate nuevamente de realizar el registro ");
			}
			
			
			
			System.out.println("\n Se ha creado exitosamente la nueva cuenta del empleado");
			System.out.println("\n Para poder iniciar sesion por favor salga de la app y vuelva a entrar :) ");
			
		
	}
	
	public void gestionarInfoEmpleados()
	{
		 System.out.println("Aca podra ver las listas de los empleados por sede o a todos los empleados de la empresa");
		 System.out.println("1. Lista empleados toda la Empresa");
		 System.out.println("2. Lista empleados sede 1");
		 System.out.println("3. Lista empleados sede 2");
		 System.out.println("4. Lista empleados sede 3");
		 
		 int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
		 
		 if(opcion_seleccionada == 1) {
			 imprimirEmpleados();
		 }else if (opcion_seleccionada == 2) {
			 imprimirEmpleadosSede1();
		 }else if (opcion_seleccionada == 3) {
			 imprimirEmpleadosSede2();
		 }else if (opcion_seleccionada == 4) {
			 imprimirEmpleadosSede3();
		 }else {
			 System.out.println("No es una opcion valida, trate otra vez");
		 }
		 
	}
	
	public void crearUsuarios() throws IOException
	{

		System.out.println("\n Por favor siga las indicaciones para crear la cuenta del nuevo cliente");
		
		
	
		String cedula = input("\n Por favor digite su cedula/Documento de Identificacion (1o digitos) ");
		String nombre = input("\n Por favor escriba su nombre completo");
		String celular = input("\n Por favor digite su numero celular (10 digitos)");
		String email = input("\n Por favor escriba su correo electronico");
		String contraseña = input("\n Escriba la contraseña con la que le gustaria iniciar sesión desde ahora en adelante");
		String fechaNacimiento = input("\n Escriba cuando nacio en formato (día-mes-año)");
		String nacionalidad = input("\n Escriba su país de nacimineto");
		String lugarExpedicionCC = input("\n Escriba el país donde saco su Cedula o Documento de Identificacion");
		
		String numeroLicencia = input("\n Escriba el numero de su licencia");
		String fechaVencimientoLicencia = input("\n Escriba la fecha en que se le vence la licencia en formato (día-mes-año)");
		
		String medioPago = input("\n Por favor escriba si usa una Tarjeta de Credito o Tarjeta Debito");
		String cvc = input("\n Por favor digite el codigo de seguridsad de su Tarjeta");
		String numeroTarjeta = input("\n Por favor digite el numero de su Tarjeta (16 digitos)");
		String fechaVencimientoTarjeta = input("\n Por favor escriba la fecha cuando debe cambiar su tarjeta formato (mes-año)");
		String banco = input("\n Por favor escriba el banco al que pertenece su Tarjeta");
		
		ClienteRegistrado cliente_nuevo = new ClienteRegistrado(nombre,cedula,celular,email,null,contraseña,fechaNacimiento,nacionalidad,lugarExpedicionCC);
		Licencia licencia = new Licencia(numeroLicencia, fechaVencimientoLicencia);
		MetodoPago metodo = new MetodoPago(medioPago, cvc, numeroTarjeta, fechaVencimientoTarjeta, banco);
		
		
		
		baseDatos.crearCuentaCliente(cliente_nuevo, licencia, metodo);
		System.out.println("\n Se ha creado una nueva cuenta y ya se guardo en la Base de Datos");
		
		System.out.println("\n Para poder iniciar sesion por favor salga de la app y vuelva a entrar :) ");
		
	}

	/**
	 *Funciones relacionadas con los empleados 
	 */
	
	public void entregaVehiculo()
	{
		System.out.println("Vehiculo Entregado");
	}

	public void devolucionVehiculo() throws IOException
	{
		String numero = input("Por favor escriba la placa del vehiculo que sera devuelto ");
		inventario.devolucionVehiculo(numero);
		System.out.println("Se ha devuelto el carro con exito se elimino de la base de datos de Carros en Uso :)");
		System.out.println("Para actualizar el estado del vehiculo devuleto por favor use la opcion D nuevamente con la placa del vehiculo ");
	}

	public void registroConductorAdicional() throws IOException
	{
		
		System.out.println("\n Por favor siga las indicaciones para añadir un conductor Adicional a la reserva o alquiler, vamos en el servicio numero: " + contador);
		
		String numeroReserva = input("\n Por favor digite el numero de reserva que se le dio, si no reservo y esto es un alquiler por favor digite el valor del servicio en el que vamos");
		String cedula = input("\n Por favor digite su cedula/Documento de Identificacion (1o digitos) ");
		String nombre = input("\n Por favor escriba su nombre completo");
		String celular = input("\n Por favor digite su numero celular");
		String email = input("\n Por favor escriba su correo electronico");
		
		String numeroLicencia = input("\n Escriba el numero de su licencia");
		String fechaVencimientoLicencia = input("\n Escriba la fecha en que se le vence la licencia en formato (día-mes-año)");
		
		ConductorAdicional conductorAnanido = new ConductorAdicional(nombre,cedula,celular,email,null,null,numeroReserva);
		Licencia licencia = new Licencia(numeroLicencia, fechaVencimientoLicencia);
		
		empleado.agregarConductorAdicional(conductorAnanido, licencia);
		System.out.println("\n Se ha añadido un nuevo conductor y ya se guardo en la Base de Datos");
	}

	public void actualizarEstadoVehiculo() throws IOException
	{
		String fecha = null;
		String placa = input("Por favor ingrese la placa del vehiculo");
		String sede = input("A que sede pertenece el carro devuleto (sede1, sede2, sede3)");
		String estado = input ("A que estado va a pasar el carro (limpieza, mantenimiento o Listo)");
		if(estado.equals("limpieza") || estado.equals("mantenimiento") )
		{
			fecha = input("Para que fecha el vehiculo estara disponible otra vez (día - mes - año)");
		}
		
		inventario.cambiarEstadoCarro(placa, sede, estado);
		System.out.println("El vehiculo volvera a estar Listo para: " + fecha);
	}
	
	/**
	 * Funciones Generales
	 */
	
	public void imprimirSede1()
	{
		HashMap<String,List<String>> sede1 = baseDatos.getSede1();
		System.out.println(sede1);
		
	}
	
	public void imprimirSede2()
	{
		HashMap<String,List<String>> sede2 = baseDatos.getSede2();
		System.out.println(sede2);
		
	}
	
	public void imprimirSede3()
	{
		HashMap<String,List<String>> sede3 = baseDatos.getSede1();
		System.out.println(sede3);
		
	}
	
	public void reservasActuales()
	{
		HashMap<Integer, ArrayList<Reserva>> actuales = cliente.getReservas();
		System.out.println(actuales);
		
	}
	
	public void carrosEnUso()
	{
		HashMap<String,List<String>> enUso = cliente.getCarrosEnUso();
		System.out.println(enUso);
		
	}
	
	public void imprimirSedeInfo1()
	{
		ArrayList<Sede> infoSede1 = sede.getInfoSede1();
		Sede informacion;
		for (int i = 0; i < infoSede1.size(); i++) {
			 informacion = infoSede1.get(i);
			System.out.println((i + 1) + ": " + informacion.getHorario() + "-> " + informacion.getNombre());
		}
	}
	
	public void imprimirSedeInfo2()
	{
		ArrayList<Sede> infoSede2 = sede.getInfoSede2();
		Sede informacion;
		for (int i = 0; i < infoSede2.size(); i++) {
			 informacion = infoSede2.get(i);
			System.out.println((i + 1) + ": " + informacion.getHorario() + "-> " + informacion.getNombre());
		}
	}
	
	public void imprimirSedeInfo3()
	{
		ArrayList<Sede> infoSede3 = sede.getInfoSede3();
		Sede informacion;
		for (int i = 0; i < infoSede3.size(); i++) {
			 informacion = infoSede3.get(i);
			System.out.println((i + 1) + ": " + informacion.getHorario() + "-> " + informacion.getNombre());
		}
	}
	
	public void imprimirEmpleados()
	{
		ArrayList<Empleado> empleadosGeneral = empleado.getEmpleados();
		Empleado empleados;
		for (int i = 0; i < empleadosGeneral.size(); i++) {
			 empleados = empleadosGeneral.get(i);
			System.out.println((i + 1) + ": " + empleados.getNombre() + ";" + empleados.getCedula() + ";" + empleados.getCel() + ";" + empleados.getEmail() + ";" + empleados.getSede()
			+ ";" + " Años en la empresa: " + empleados.getAnosEmpresa());
		}
	}
	
	public void imprimirEmpleadosSede1()
	{
		ArrayList<Empleado> empleadosSede1 = empleado.getEmpleadosSede1();
		Empleado empleadoSede1;
		for (int i = 0; i < empleadosSede1.size(); i++) {
			 empleadoSede1 = empleadosSede1.get(i);
			System.out.println((i + 1) + ": " + empleadoSede1.getNombre() + ";" + empleadoSede1.getCedula() + ";" + empleadoSede1.getCel() + ";" + empleadoSede1.getEmail() + ";" + empleadoSede1.getSede()
			+ ";" + " Años en la empresa: " + empleadoSede1.getAnosEmpresa());
		}
	}
	
	public void imprimirEmpleadosSede2()
	{
		ArrayList<Empleado> empleadosSede2 = empleado.getEmpleadosSede2();
		Empleado empleadoSede2;
		for (int i = 0; i < empleadosSede2.size(); i++) {
			 empleadoSede2 = empleadosSede2.get(i);
			System.out.println((i + 1) + ": " + empleadoSede2.getNombre() + ";" + empleadoSede2.getCedula() + ";" + empleadoSede2.getCel() + ";" + empleadoSede2.getEmail() + ";" + empleadoSede2.getSede()
			+ ";" + " Años en la empresa: " + empleadoSede2.getAnosEmpresa());
		}
	}
	
	public void imprimirEmpleadosSede3()
	{
		ArrayList<Empleado> empleadosSede3 = empleado.getEmpleadosSede3();
		Empleado empleadoSede3;
		for (int i = 0; i < empleadosSede3.size(); i++) {
			 empleadoSede3 = empleadosSede3.get(i);
			System.out.println((i + 1) + ": " + empleadoSede3.getNombre() + ";" + empleadoSede3.getCedula() + ";" + empleadoSede3.getCel() + ";" + empleadoSede3.getEmail() + ";" + empleadoSede3.getSede()
			+ ";" + " Años en la empresa: " + empleadoSede3.getAnosEmpresa());
		}
	}


	/**
	 * Este método sirve para imprimir un mensaje en la consola pidiéndole
	 * información al usuario y luego leer lo que escriba el usuario.
	 * 
	 * @param mensaje El mensaje que se le mostrará al usuario
	 * @return La cadena de caracteres que el usuario escriba como respuesta.
	 */
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws IOException
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}
}
