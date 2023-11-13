package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminGeneral extends Persona
{
	ArrayList<String> infoNuevoVehiculo;
	
	//********************************************************************************
	//Esta clase hereda los atributos de persona y no tiene ningun atributo espeifico de la clase
	//*********************************************************************************
	
	
	//*****************************************************************************
	//Constructor
	//*****************************************************************************
	
	public AdminGeneral(String nombre, String cedula, String cel, String email, String anosEmpresa, String contraseña) {
		super(nombre, cedula, cel, email, anosEmpresa,contraseña);//Llama al constructor de la clase Persona
		infoNuevoVehiculo = new ArrayList<String>();
	}
	
	//*****************************************************************************
	//Metodos especificos (No hay metodos para consultar Atributos)
	//*****************************************************************************
	
	public void registrarCompraNuevoVehiculo(String placa, String marca, String modelo, String ano, String color, String trasmision, String ubicacion, String alquilado, String estado, String tipo)
	{
		infoNuevoVehiculo.add(marca);
		infoNuevoVehiculo.add(modelo);
		infoNuevoVehiculo.add(ano);
		infoNuevoVehiculo.add(color);
		infoNuevoVehiculo.add(trasmision);
		infoNuevoVehiculo.add(ubicacion);
		infoNuevoVehiculo.add(alquilado);
		infoNuevoVehiculo.add(estado);
		infoNuevoVehiculo.add(tipo);
		
		Categoria categorias = new Categoria ();
		if (tipo.equals("SUV")) 
		{
			categorias.getSUV().put(placa, infoNuevoVehiculo);
		}
		else if (tipo.equals("pequeño"))
		{
			categorias.getPequeno().put(placa, infoNuevoVehiculo);
		}
		else if (tipo.equals("lujo"))
		{
			categorias.getPequeno().put(placa, infoNuevoVehiculo);
		}
		else if (tipo.equals("deportivo"))
		{
			categorias.getPequeno().put(placa, infoNuevoVehiculo);
		}
		else if (tipo.equals("vans"))
		{
			categorias.getPequeno().put(placa, infoNuevoVehiculo);
		}
	}
	
	public void darBajaVehiculo()
	{
		
	}
}
