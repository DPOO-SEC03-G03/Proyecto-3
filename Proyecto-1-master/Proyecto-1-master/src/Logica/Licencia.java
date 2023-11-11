package Logica;

public class Licencia 
{
	//*******************************************************
	//Atributos
	//*******************************************************
	
	String numeroLicencia;
	String fechaVencimientoLicencia;
	
	//******************************************************************
	//Constructor
	//******************************************************************
	
	public Licencia(String numeroLicencia, String fechaVencimientoLicencia) {
		super();
		this.numeroLicencia = numeroLicencia;
		this.fechaVencimientoLicencia = fechaVencimientoLicencia;
	}

	
	//********************************************************************
	//Getters and Setters
	//********************************************************************
	
	public String getNumeroLicencia() {
		return numeroLicencia;
	}

	public void setNumeroLicencia(String numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}

	public String getFechaVencimientoLicencia() {
		return fechaVencimientoLicencia;
	}

	public void setFechaVencimientoLicencia(String fechaVencimientoLicencia) {
		this.fechaVencimientoLicencia = fechaVencimientoLicencia;
	}
}
