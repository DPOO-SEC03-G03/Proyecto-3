package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Empleado extends Persona
{
	//**********************************************************
		//Atributos especificos de la clase
		//**********************************************************
		
		private String sede;
		
		private ArrayList<Empleado> empleados;
		private ArrayList<Empleado> empleadosSede1;
		private ArrayList<Empleado> empleadosSede2;
		private ArrayList<Empleado> empleadosSede3;
		
		//**********************************************************
		//Constructor
		//**********************************************************
		public Empleado(String nombre, String cedula, String cel, String email, String anosEmpresa, String contraseña, String sede) 
		{
			super(nombre, cedula, cel, email, anosEmpresa, contraseña); //Llama al constructor de la clase Persona
			this.sede = sede;
			
			empleados = new ArrayList<Empleado>();
			empleadosSede1 = new ArrayList<Empleado>();
			empleadosSede2 = new ArrayList<Empleado>();
			empleadosSede3 = new ArrayList<Empleado>();
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
		
		public ArrayList<Empleado> getEmpleados() {
			return empleados;
		}

		public void setEmpleados(ArrayList<Empleado> empleados) {
			this.empleados = empleados;
		}

		public ArrayList<Empleado> getEmpleadosSede1() {
			return empleadosSede1;
		}

		public void setEmpleadosSede1(ArrayList<Empleado> empleadosSede1) {
			this.empleadosSede1 = empleadosSede1;
		}

		public ArrayList<Empleado> getEmpleadosSede2() {
			return empleadosSede2;
		}

		public void setEmpleadosSede2(ArrayList<Empleado> empleadosSede2) {
			this.empleadosSede2 = empleadosSede2;
		}

		public ArrayList<Empleado> getEmpleadosSede3() {
			return empleadosSede3;
		}

		public void setEmpleadosSede3(ArrayList<Empleado> empleadosSede3) {
			this.empleadosSede3 = empleadosSede3;
		}
		
		//**********************************************************
		//Metodos Especifico
		//**********************************************************
		
		public void cargarArchivosEmpleados(String archivoEmpleadosGeneral, String archivoEmpleadosSede1, 
				String archivoEmpleadosSede2, String archivoEmpleadosSede3)
		{
			leerArchivoEmpleadosEmpresa(archivoEmpleadosGeneral);
			leerArchivoEmpleadosSede1(archivoEmpleadosSede1);
			leerArchivoEmpleadosSede2(archivoEmpleadosSede2);
			leerArchivoEmpleadosSede3(archivoEmpleadosSede3);
		}

		public void leerArchivoEmpleadosEmpresa(String archivo)
		{
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivo));
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] partes = linea.split(";");
					String cedula = partes[0];
					String contraseña = partes[1];
					String nombre = partes[2];
					String cel = partes[3];
					String email = partes[4];
					String anosEmpresa = partes[5];
					String sede = partes [6];
					Empleado info = new Empleado(nombre, cedula, cel, email, anosEmpresa, contraseña, sede);
					empleados.add(info);

				}

				br.close();
			} catch (Exception e) {

			}
		}
		
		public void leerArchivoEmpleadosSede1(String archivo)
		{
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivo));
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] partes = linea.split(";");
					String cedula = partes[0];
					String contraseña = partes[1];
					String nombre = partes[2];
					String cel = partes[3];
					String email = partes[4];
					String anosEmpresa = partes[5];
					String sede = partes [6];
					Empleado info = new Empleado(nombre, cedula, cel, email, anosEmpresa, contraseña, sede);
					empleadosSede1.add(info);

				}

				br.close();
			} catch (Exception e) {

			}
		}
		
		public void leerArchivoEmpleadosSede2(String archivo)
		{
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivo));
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] partes = linea.split(";");
					String cedula = partes[0];
					String contraseña = partes[1];
					String nombre = partes[2];
					String cel = partes[3];
					String email = partes[4];
					String anosEmpresa = partes[5];
					String sede = partes [6];
					Empleado info = new Empleado(nombre, cedula, cel, email, anosEmpresa, contraseña, sede);
					empleadosSede2.add(info);

				}

				br.close();
			} catch (Exception e) {

			}
		}
		
		public void leerArchivoEmpleadosSede3(String archivo)
		{
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivo));
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] partes = linea.split(";");
					String cedula = partes[0];
					String contraseña = partes[1];
					String nombre = partes[2];
					String cel = partes[3];
					String email = partes[4];
					String anosEmpresa = partes[5];
					String sede = partes [6];
					Empleado info = new Empleado(nombre, cedula, cel, email, anosEmpresa, contraseña, sede);
					empleadosSede3.add(info);

				}

				br.close();
			} catch (Exception e) {

			}
		}
		
		public void agregarConductorAdicional(ConductorAdicional conductorAdicional, Licencia infoLicencia) throws IOException
		{
			FileWriter file = new FileWriter ("conductoresAdicionales.txt", true);
			BufferedWriter br = new BufferedWriter(file);
			
			String numero = conductorAdicional.getNumero();
			String cedula = conductorAdicional.getCedula();
			String nombre = conductorAdicional.getNombre();
			String celular = conductorAdicional.getCel();
			String email = conductorAdicional.getEmail();
			
			String numeroLicencia = infoLicencia.getNumeroLicencia();
			String fechaVencimientoLicencia = infoLicencia.getFechaVencimientoLicencia();
			
			br.write(System.getProperty("line.separator")+ numero + ";" + cedula + ";" + nombre + ";" + celular + ";" + email + ";" + numeroLicencia + ";" + fechaVencimientoLicencia);
			br.close();
		}
}
