package modelo;

public class Vehiculo 
{
	//******************************************************
	//Atributos
	//******************************************************
	
	/**
	 * Es el identificador de cada uno de los vehiculos, se puede interpretar como 
	 * un tipo de nombre unico
	 */
	
	private String placa;
	
	/**
	 * Es el nombre de la marca que creo el vehiculo, a ellos pertenece la idea
	 */
	
	private String marca;
	
	/**
	 * Es la manera en que la marca creadora del vehiculo llamo a este, para que así fuera
	 * conocido al publico
	 */
	
	private String modelo;
	
	/**
	 * Es año en que se saco el vehiculo, sale en su tarjeta de propiedad
	 */
	
	private int ano;
	
	/**
	 * Es el color del vehiculo
	 */
	
	private String color;
	
	/**
	 * Se especifica si el vehiculo es de caja manual o automatica
	 */
	
	private String transmision;
	
	/**
	 * Permite ver la ubicación actual del vehiculo, sea que este en una sede o andando por Bogota
	 */
	
	private String ubicacion;
	
	/**
	 * Es un booleano que confirma si el vehiculo esta alquilado o no
	 */
	
	private boolean alquilado;
	
	/**
	 * Confirma si el vehiculo esta en limpieza, mantenimiento o ninguna de las dos "Listo"
	 */
	
	private String estado;
	
	/**
	 * Especifica la categoria a la que pertenece el Vehiculo
	 */
	
	private String tipo;

	
	//*******************************************************************************
	//Constructor
	//*******************************************************************************
	/*
	 * Construye un vehiculo e inicializa los atributos de este 
	 * con la información entrada por parametro.
	 * @param placa - La placa del vehiculo
	 * @param marca - La marca del vehiculo
	 * @param modelo - El modelo del vehiculo
	 * @param ano - El año del vehiculo
	 * @param color - Es el color del vehiculo
	 * @param transmision - La transmision del vehiculo
	 * @param ubicacion - La ubicacion del vehiculo
	 * @param alquilado - La confirmacion si esta o no alquilado
	 * @param estado - El estado del vehiculo
	 */
	public Vehiculo(String placa, String marca, String modelo, int ano, String color, String transmision,
			String ubicacion, boolean alquilado, String estado, String tipo) 
	{
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.color = color;
		this.transmision = transmision;
		this.ubicacion = ubicacion;
		this.alquilado = alquilado;
		this.estado = estado;
		this.tipo = tipo;
	}

	
	//*******************************************************************************************
	//Metodos para consultar los Atributos y en General Funcionar
	//*******************************************************************************************
	
	/**
	 * @return la placa del vehiculo consultado
	 */
	public String getPlaca() {
		return placa;
	}
	
	/**
	 * @return la marca del vehiculo consultado
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * @return el modelo del vehiculo consultado
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @return el año del vehiculo consultado
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * @return el color del vehiculo consultado
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return la transmision del vehiculo consultado
	 */
	public String getTransmision() {
		return transmision;
	}

	/**
	 * @return la ubicacion del vehiculo consultado
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @return si el vehiculo consultado esta o no alquilado
	 */
	public boolean isAlquilado() {
		return alquilado;
	}

	/**
	 * @return el estado del vehiculo consultado
	 */
	public String getEstado() {
		return estado;
	}
	
	/**
	 *  @return la categoria a la que pertenece el vehiculo
	 */
	public String getTipo(){
		return tipo;
	}

}
