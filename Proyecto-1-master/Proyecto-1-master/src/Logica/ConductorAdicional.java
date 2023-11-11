package Logica;

public class ConductorAdicional extends Persona
{

	String numero;
	
	public ConductorAdicional(String nombre, String cedula, String cel, String email, String anosEmpresa,
			String contraseña, String number) {
		super(nombre, cedula, cel, email, anosEmpresa, contraseña);
		// TODO Auto-generated constructor stub
		this.numero = number;
		
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	
}
