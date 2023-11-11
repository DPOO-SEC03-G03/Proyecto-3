package Logica;

public class Persona 
{
	//**********************************************
	//Atributos
	//**********************************************
	/**
	 * Es el nombre de cada una de las personas
	 */
	private String nombre;
	
	/**
	 * Es el identificador de cada una de las personas
	 */
	private String cedula;
	
	/**
	 * Es el número telefonico por el cual se contacta a una persona
	 */
	private String cel;
	
	/**
	 * Es el medio por el cual se le pueden enviar correos y posiblemente sera 
	 * el username de cada uno de los que esten registrados
	 */
	private String email;
	
	/**
	 * Es la cantidad de años que lleva un trabajador en la empresa
	 */
	private String anosEmpresa;
	
	/**
	 * Es la palabra o numeros que usara para iniciar sesion
	 */
	private String contraseña;
	
	//********************************************************************
	//Constructor
	//********************************************************************
	public Persona(String nombre, String cedula, String cel, String email, String anosEmpresa, String contraseña) 
	{
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.cel = cel;
		this.email = email;
		this.anosEmpresa = anosEmpresa;
		this.contraseña = contraseña;
	}
	
	//*******************************************************************************************
	//Metodos para consultar los atributos
	//*******************************************************************************************
	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getCedula() 
	{
		return cedula;
	}

	public void setCedula(String cedula) 
	{
		this.cedula = cedula;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) 
	{
		this.cel = cel;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getAnosEmpresa() 
	{
		return anosEmpresa;
	}

	public void setAnosEmpresa(String anosEmpresa) 
	{
		this.anosEmpresa = anosEmpresa;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
