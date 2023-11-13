package modelo;

public class Sede 
{
	//****************************************************************************
	//Atributos
	//****************************************************************************
	
	/**
	 * Es el horario que todas las sedes manejan, es el mismo para todas.
	 */
	
	private String horario;
	
	/**
	 * Es el nombre que se le da a cada una de las sedes para poderla identificar
	 */
	
	private String nombre;
	
	/**
	 * Es la dirección especifica donde se encuentra la sede seleccionada
	 */
	
	private String ubicacion;

	//*********************************************************************************
	//Constructor
	//*********************************************************************************
	/*Construye una sede e inicializa los atributos de este con la 
	 * información entrada por parametro
	 * 
	 * @param horario - Es el horario que todas las sedes manejan por igual
	 * @param nombre - Es el nombre de la sede
	 * @param ubicación - Es la ubicacion especifica de la sede escogida
	 */
	public Sede(String horario, String nombre, String ubicacion) 
	{
		super();
		this.horario = horario;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	
	//************************************************************************************
	//Metodos para acceder a los atributos 
	//************************************************************************************
	
	/**
	 * @return lel horario que manejan todas las sedes (es el mismo)
	 */
	public String getHorario() 
	{
		return horario;
	}

	/**
	 * @return el nombre de la sede consultada
	 */
	public String getNombre() 
	{
		return nombre;
	}

	/**
	 * @return la ubicacion de la sede consultada
	 */
	public String getUbicacion() 
	{
		return ubicacion;
	}

}
