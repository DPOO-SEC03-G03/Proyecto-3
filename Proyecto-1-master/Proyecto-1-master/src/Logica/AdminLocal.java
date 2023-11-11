package Logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AdminLocal extends Persona
{
	//**********************************************************
	//Atributos especificos de la clase
	//**********************************************************
	
	private String sede;
	
	//**********************************************************
	//Constructor
	//**********************************************************
	public AdminLocal(String nombre, String cedula, String cel, String email, String anosEmpresa, String contraseña, String sede) 
	{
		super(nombre, cedula, cel, email, anosEmpresa, contraseña); //Llama al constructor de la clase Persona
		this.sede = sede;
	}
	
	//***********************************************************
	//Metodos para consultar los atributos
	//**********************************************************
	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
	
	//**********************************************************
	//Metodos Especifico
	//**********************************************************
	public void crearNuevoEmpleado (Empleado nuevo_empleado) throws IOException
	{
		FileWriter file = new FileWriter ("empleados.txt", true);
		BufferedWriter br = new BufferedWriter(file);
		
		String cedula = nuevo_empleado.getCedula();
		String nombre = nuevo_empleado.getNombre();
		String celular = nuevo_empleado.getCel();
		String email = nuevo_empleado.getEmail();
		String anosEmpresa = nuevo_empleado.getAnosEmpresa();
		String contraseña = nuevo_empleado.getContraseña();
		String sede = nuevo_empleado.getSede();
		
		String rta = System.getProperty("line.separator") + cedula + ";" + contraseña + ";" + nombre + ";" + celular + ";" + email + ";" + anosEmpresa +";" +sede;
		
		br.write(rta);
		br.close();
		
		
	}
	
	public void agregarNuevoEmpleadoSede1 (Empleado nuevo_empleado) throws IOException
	{
		FileWriter file = new FileWriter ("empleadosSede1.txt", true);
		BufferedWriter br = new BufferedWriter(file);
		
		String cedula = nuevo_empleado.getCedula();
		String nombre = nuevo_empleado.getNombre();
		String celular = nuevo_empleado.getCel();
		String email = nuevo_empleado.getEmail();
		String anosEmpresa = nuevo_empleado.getAnosEmpresa();
		String contraseña = nuevo_empleado.getContraseña();
		String sede = nuevo_empleado.getSede();
		
		String rta = System.getProperty("line.separator") + cedula + ";" + contraseña + ";" + nombre + ";" + celular + ";" + email + ";" + anosEmpresa +";" +sede;
		
		br.write(rta);
		br.close();
	}
	
	public void agregarNuevoEmpleadoSede2 (Empleado nuevo_empleado) throws IOException
	{
		FileWriter file = new FileWriter ("empleadosSede2.txt", true);
		BufferedWriter br = new BufferedWriter(file);
		
		String cedula = nuevo_empleado.getCedula();
		String nombre = nuevo_empleado.getNombre();
		String celular = nuevo_empleado.getCel();
		String email = nuevo_empleado.getEmail();
		String anosEmpresa = nuevo_empleado.getAnosEmpresa();
		String contraseña = nuevo_empleado.getContraseña();
		String sede = nuevo_empleado.getSede();
		
		String rta = System.getProperty("line.separator") + cedula + ";" + contraseña + ";" + nombre + ";" + celular + ";" + email + ";" + anosEmpresa +";" +sede;
		
		br.write(rta);
		br.close();
	}
	
	public void agregarNuevoEmpleadoSede3 (Empleado nuevo_empleado) throws IOException
	{
		FileWriter file = new FileWriter ("empleadosSede3.txt", true);
		BufferedWriter br = new BufferedWriter(file);
		
		String cedula = nuevo_empleado.getCedula();
		String nombre = nuevo_empleado.getNombre();
		String celular = nuevo_empleado.getCel();
		String email = nuevo_empleado.getEmail();
		String anosEmpresa = nuevo_empleado.getAnosEmpresa();
		String contraseña = nuevo_empleado.getContraseña();
		String sede = nuevo_empleado.getSede();
		
		String rta = System.getProperty("line.separator") + cedula + ";" + contraseña + ";" + nombre + ";" + celular + ";" + email + ";" + anosEmpresa +";" +sede;
		
		br.write(rta);
		br.close();
	}
}
