package modelo;

public class Reserva 
{
	//********************************************
	//Atributos
	//********************************************
	private String categoriaCarro;
	private String sede;
	private String fechaHoraReclamo;
	private String sedeEntrega;
	private String fechaHoraEntrega;
	
	//************************************************************
	//Constructor
	//************************************************************
	public Reserva(String categoriaCarro, String sede, String fechaHoraReclamo, String sedeEntrega,
			String fechaHoraEntrega) {
		super();
		this.categoriaCarro = categoriaCarro;
		this.sede = sede;
		this.fechaHoraReclamo = fechaHoraReclamo;
		this.sedeEntrega = sedeEntrega;
		this.fechaHoraEntrega = fechaHoraEntrega;
	}
	//***************************************************
	//Getters and Setters
	//***************************************************

	public String getCategoriaCarro() {
		return categoriaCarro;
	}

	public void setCategoriaCarro(String categoriaCarro) {
		this.categoriaCarro = categoriaCarro;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getFechaHoraReclamo() {
		return fechaHoraReclamo;
	}

	public void setFechaHoraReclamo(String fechaHoraReclamo) {
		this.fechaHoraReclamo = fechaHoraReclamo;
	}

	public String getSedeEntrega() {
		return sedeEntrega;
	}

	public void setSedeEntrega(String sedeEntrega) {
		this.sedeEntrega = sedeEntrega;
	}

	public String getFechaHoraEntrega() {
		return fechaHoraEntrega;
	}

	public void setFechaHoraEntrega(String fechaHoraEntrega) {
		this.fechaHoraEntrega = fechaHoraEntrega;
	}
}
