package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ClienteRegistrado extends Persona
{
	private ArrayList<Reserva> infoReserva;
	private HashMap <Integer, ArrayList<Reserva>> reservas;
	private int reserva = 0;
	private Reserva nuevaReserva;

	private BaseDatos basedatos;

	public HashMap<String, List<String>> carrosEnUso;

	//*******************************************************
	//Atributos
	//******************************************************

	/**
	 * Es la fecha de nacimiento del cliente su orden es 
	 * día-mes-año
	 */
	private String fechaNacimiento;

	

	/**
	 * Es el lugar de nacimiento del cliente registrado
	 */
	private String nacionalidad;

	/**
	 * Es el lugar donde saco su documento de identidad
	 */
	private String paisExpedicion;

	//*******************************************************
	//Constructor
	//*******************************************************
	public ClienteRegistrado(String nombre, String cedula, String cel, String email, String anosEmpresa, String contraseña, String fechaNacimiento, 
			String nacionalidad, String paisExpedicion) //Llama al constructor de la clase Persona
	{
		super(nombre, cedula, cel, email, anosEmpresa, contraseña);
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.paisExpedicion = paisExpedicion;
		reservas = new HashMap<>();
		infoReserva = new ArrayList<>();
		carrosEnUso = new HashMap<>();
		this.basedatos = new BaseDatos();
		basedatos.cargarSede1("sede1.txt");
		basedatos.cargarSede2("sede2.txt");
		basedatos.cargarSede3("sede3.txt");
		
	}

	//***************************************************************
	//Metodos para consultar los Atributos
	//**************************************************************
	public String getFechaNacimiento() 
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) 
	{
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() 
	{
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) 
	{
		this.nacionalidad = nacionalidad;
	}

	public String getPaisExpedicion() 
	{
		return paisExpedicion;
	}

	public void setPaisExpedicion(String paisExpedicion) 
	{
		this.paisExpedicion = paisExpedicion;
	}
	
	public ArrayList<Reserva> getInfoReserva() {
		return infoReserva;
	}

	public void setInfoReserva(ArrayList<Reserva> infoReserva) {
		this.infoReserva = infoReserva;
	}

	public HashMap<Integer, ArrayList<Reserva>> getReservas() {
		return reservas;
	}

	public void setReservas(HashMap<Integer, ArrayList<Reserva>> reservas) {
		this.reservas = reservas;
	}

	public int getReserva() {
		return reserva;
	}

	public void setReserva(int reserva) {
		this.reserva = reserva;
	}

	public Reserva getNuevaReserva() {
		return nuevaReserva;
	}

	public void setNuevaReserva(Reserva nuevaReserva) {
		this.nuevaReserva = nuevaReserva;
	}

	public BaseDatos getBasedatos() {
		return basedatos;
	}

	public void setBasedatos(BaseDatos basedatos) {
		this.basedatos = basedatos;
	}

	public HashMap<String, List<String>> getCarrosEnUso() {
		return carrosEnUso;
	}

	public void setCarrosEnUso(HashMap<String, List<String>> carrosEnUso) {
		this.carrosEnUso = carrosEnUso;
	}

	//*************************************************************
	//Metodos Especificos
	//*************************************************************
	
	public void guardarCarrosEnUso(String categoria, String sedeEscogida, String fechaPickUp, String horaTurnIn, String sedeTurnIn) {
		
		this.nuevaReserva = new Reserva(categoria,sedeEscogida,fechaPickUp,sedeTurnIn,horaTurnIn);
		infoReserva.add(nuevaReserva);
		reservas.put(++reserva, infoReserva);
		
		HashMap<String, List<String>> sede = null;
		
		if (sedeEscogida.equals("sede1")) {
			sede = basedatos.getSede1();
		}
		
		else if (sedeEscogida.equals("sede2")) {
			sede = basedatos.getSede2();
		}
		
		else if (sedeEscogida.equals("sede3")) {
			sede = basedatos.getSede3();
		}

		
			System.out.println("Dentro del bloque IF!");

			Set<String> llaves = sede.keySet();
			System.out.println(llaves);
			
			String llaveEs = null;
			List<String> valorCarro = null;

			for (String llave : llaves){
				valorCarro = sede.get(llave);
				System.out.println(valorCarro);
				if (valorCarro.get(8).equals(categoria)){
					llaveEs = llave;
					break;
				}
			}
			
			for (String llave : llaves){
				if (categoria.equals("pequeño")) {
					if (valorCarro.get(8).equals("suv")){
						llaveEs = llave;
						break;
					}
				}
				else if (categoria.equals("suv")) {
					if (valorCarro.get(8).equals("vans")){
						llaveEs = llave;
						break;
					}
				}
				else if (categoria.equals("vans")) {
					if (valorCarro.get(8).equals("lujo")){
						llaveEs = llave;
						break;
					}
				}
				else if (categoria.equals("lujo")) {
					if (valorCarro.get(8).equals("Deportivo")){
						llaveEs = llave;
						break;
					}
				}
			}	
			
		carrosEnUso.put(llaveEs, valorCarro);
		
		final String outputFilePath =  "reservas.txt"; 
		File archivo = new File(outputFilePath);
		
		BufferedWriter bf = null; 
		
		try {
			bf = new BufferedWriter(new FileWriter(archivo));
			
			ArrayList<String> tempList = new ArrayList<String>();
			
			for (Map.Entry<String, List<String>> entry : carrosEnUso.entrySet()) {
				String llave = entry.getKey();
				tempList.add(llave);
				for (String valor : entry.getValue()) {
					tempList.add(valor);
				}
				for (String info : tempList) {
					bf.write(info + ";");
				}
				bf.newLine();
			}
			bf.flush(); 
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				bf.close();
			}
			catch (Exception e) {
				
			}
		}
		
		sede.remove(llaveEs);
		
		System.out.println("---------------------------------------------");
		System.out.println(carrosEnUso);
		System.out.println("-------------------------------------------------------------");
		System.out.println(reservas);
	}
	
}
