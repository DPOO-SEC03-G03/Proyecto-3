package Logica;


public class MetodoPago {
	//*****************************************************
	//Atributos
	//*****************************************************
	
	String tipoTarjeta;
	String codigoDeSeguridad;
	String numeroTarjeta;
	String banco;
	String fechaVencimientoTarjeta;
	
	//************************************************************
	//constructor
	//************************************************************
	
	public MetodoPago(String tipoTarjeta, String codigoDeSeguridad, String numeroTarjeta, String banco, String fechaVencimientoTarjeta) {
		super();
		this.tipoTarjeta = tipoTarjeta;
		this.codigoDeSeguridad = codigoDeSeguridad;
		this.numeroTarjeta = numeroTarjeta;
		this.banco = banco;
		this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
		
	}
	
	//**********************************************************************
	//Getters and Setters
	//**********************************************************************
	
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public String getCodigoDeSeguridad() {
		return codigoDeSeguridad;
	}

	public void setCodigoDeSeguridad(String codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getFechaVencimientoTarjeta() {
		return fechaVencimientoTarjeta;
	}

	public void setFechaVencimientoTarjeta(String fechaVencimientoTarjeta) {
		this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
	}
	

}
