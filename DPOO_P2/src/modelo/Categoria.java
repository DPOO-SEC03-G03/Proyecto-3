package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Aca van a ir todas las funciones relacionadas con la carga de datos de cada uno de los 
 * datos encontrados en el txt de los vehiculos.
 */

public class Categoria 
{
	//*******************************************************************************
	//Atributos
	//*******************************************************************************
	
	private HashMap<String, List<String>> SUV;
	private HashMap<String, List<String>> pequeno;
	private HashMap<String, List<String>> lujo;
	private HashMap<String, List<String>> vans;
	private HashMap<String, List<String>> deportivo;
	
	
	//**********************************************************************************
	//Constructor
	//**********************************************************************************
	
	public Categoria ()
	{
		SUV = new HashMap<>();
		pequeno = new HashMap<>();
		lujo = new HashMap<>();
		vans = new HashMap<>();
		deportivo = new HashMap<>();
	}

	//Metodos OJO recomendable poner setters and getters
	
	public HashMap<String, List<String>> getSUV()
	{
		return SUV;
	}

	public HashMap<String, List<String>> getPequeno() 
	{
		return pequeno;
	}

	public HashMap<String, List<String>> getLujo() 
	{
		return lujo;
	}

	public HashMap<String, List<String>> getVans() 
	{
		return vans;
	}

	public HashMap<String, List<String>> getDeportivo() 
	{
		return deportivo;
	}
	
	//Metodos de Logica
	
	public void cargarFlotilla(String archivoVehiculos)
	{
		try 
		{
			cargarVehiculos(archivoVehiculos);
		}catch (Exception e) {

		}
	}
	
	
	
	/**
	 * Cada una de estas funciones carga los txt de los vehiculos y los almacena en cada 
	 * uno de los HashMap respectivamente (dependiendo de su categoria)
	 * @param archivo
	 */
	public void cargarVehiculos (String archivo)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                // Usar la primera parte como clave
                String placa = partes[0];
                String categoria = partes[9];
                
                // Agregar las demás partes a una lista
                List<String> valores = new ArrayList<>();          
                if (categoria.equals("suv"))
                {
	                for (int i = 1; i < partes.length; i++) {
	                    valores.add(partes[i]);
	                }
	                SUV.put(placa, valores);
                }

                // Insertar la clave y la lista de valores en el HashMap
                if (categoria.equals("pequeño"))
                {
                	 for (int i = 1; i < partes.length; i++) {
 	                    valores.add(partes[i]);
 	                }
                	 pequeno.put(placa, valores); 
                }
                
                if (categoria.equals("lujo"))
                {
                	 for (int i = 1; i < partes.length; i++) {
 	                    valores.add(partes[i]);
 	                }
                	 lujo.put(placa, valores); 
                }
                
                if (categoria.equals("vans"))
                {
                	 for (int i = 1; i < partes.length; i++) {
 	                    valores.add(partes[i]);
 	                }
                	 vans.put(placa, valores); 
                }
                
                if (categoria.equals(" Deportivo"))
                {
                	 for (int i = 1; i < partes.length; i++) {
 	                    valores.add(partes[i]);
 	                }
                	 deportivo.put(placa, valores); 
                }
            }
            br.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Imprimir el HashMap
        System.out.println(SUV);
        System.out.println(pequeno);
        System.out.println(lujo);
        System.out.println(deportivo);
        System.out.println(vans);
        

    }
	
}
	
	

