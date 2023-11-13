package modelo;

public class Empleado extends Persona
{
	//**********************************************************
		//Atributos especificos de la clase
		//**********************************************************
		
		private String sede;
		
		//**********************************************************
		//Constructor
		//**********************************************************
		public Empleado(String nombre, String cedula, String cel, String email, String anosEmpresa, String contraseña, String sede) 
		{
			super(nombre, cedula, cel, email, anosEmpresa, contraseña); //Llama al constructor de la clase Persona
			this.sede = sede;
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
		
		//**********************************************************
		//Metodos Especifico
		//**********************************************************
		
}
