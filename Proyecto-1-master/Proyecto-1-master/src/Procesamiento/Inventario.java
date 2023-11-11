package Procesamiento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


import Logica.BaseDatos;
import Logica.Vehiculo;

public class Inventario 
{
	//*****************************************************************
	//Atributos
	//*****************************************************************
	
	BaseDatos basedatos;
	Vehiculo vehiculo;
	
	//**********************************************************************
	//Constructor
	//**********************************************************************
	public Inventario(BaseDatos basedatos, Vehiculo carritos) 
	{
		super();
		this.basedatos = basedatos;
		this.vehiculo = carritos;
	}
	
	//******************************************************************
	//Metodos
	//******************************************************************
	
	public void agregarCarroNuevo(Vehiculo carro_nuevo)throws IOException
	{
		FileWriter file = new FileWriter ("vehiculos.txt", true);
		BufferedWriter br = new BufferedWriter(file);
		
		String placa = carro_nuevo.getPlaca();
		String marca = carro_nuevo.getMarca();
		String modelo = carro_nuevo.getModelo();
		String ano = carro_nuevo.getAno();
		String color = carro_nuevo.getColor();
		String transmision = carro_nuevo.getTransmision();
		String ubicacion = carro_nuevo.getUbicacion();
		String enUso = carro_nuevo.isAlquilado();
		String estado = carro_nuevo.getEstado();
		String tipo = carro_nuevo.getTipo();
		
		br.write(System.getProperty("line.separator") + placa + ";" + marca + ";" + modelo + ";" + ano + ";" + color + ";" + transmision + ";"
				+ ubicacion + ";" + enUso + ";" + estado + ";" + tipo);
		br.close();
	}
	
	public void agregarCarroNuevoSede1(Vehiculo carro_nuevo)throws IOException
	{
		FileWriter file = new FileWriter ("sede1.txt", true);
		BufferedWriter br = new BufferedWriter(file);
		
		String placa = carro_nuevo.getPlaca();
		String marca = carro_nuevo.getMarca();
		String modelo = carro_nuevo.getModelo();
		String ano = carro_nuevo.getAno();
		String color = carro_nuevo.getColor();
		String transmision = carro_nuevo.getTransmision();
		String ubicacion = carro_nuevo.getUbicacion();
		String enUso = carro_nuevo.isAlquilado();
		String estado = carro_nuevo.getEstado();
		String tipo = carro_nuevo.getTipo();
		
		br.write(System.getProperty("line.separator") + placa + ";" + marca + ";" + modelo + ";" + ano + ";" + color + ";" + transmision + ";"
				+ ubicacion + ";" + enUso + ";" + estado + ";" + tipo);
		br.close();
	}
	
	public void agregarCarroNuevoSede2(Vehiculo carro_nuevo)throws IOException
	{
		FileWriter file = new FileWriter ("sede2.txt", true);
		BufferedWriter br = new BufferedWriter(file);
		
		String placa = carro_nuevo.getPlaca();
		String marca = carro_nuevo.getMarca();
		String modelo = carro_nuevo.getModelo();
		String ano = carro_nuevo.getAno();
		String color = carro_nuevo.getColor();
		String transmision = carro_nuevo.getTransmision();
		String ubicacion = carro_nuevo.getUbicacion();
		String enUso = carro_nuevo.isAlquilado();
		String estado = carro_nuevo.getEstado();
		String tipo = carro_nuevo.getTipo();
		
		br.write(System.getProperty("line.separator") + placa + ";" + marca + ";" + modelo + ";" + ano + ";" + color + ";" + transmision + ";"
				+ ubicacion + ";" + enUso + ";" + estado + ";" + tipo);
		br.close();
	}
	
	public void agregarCarroNuevoSede3(Vehiculo carro_nuevo)throws IOException
	{
		FileWriter file = new FileWriter ("sede3.txt", true);
		BufferedWriter br = new BufferedWriter(file);
		
		String placa = carro_nuevo.getPlaca();
		String marca = carro_nuevo.getMarca();
		String modelo = carro_nuevo.getModelo();
		String ano = carro_nuevo.getAno();
		String color = carro_nuevo.getColor();
		String transmision = carro_nuevo.getTransmision();
		String ubicacion = carro_nuevo.getUbicacion();
		String enUso = carro_nuevo.isAlquilado();
		String estado = carro_nuevo.getEstado();
		String tipo = carro_nuevo.getTipo();
		
		br.write(System.getProperty("line.separator") + placa + ";" + marca + ";" + modelo + ";" + ano + ";" + color + ";" + transmision + ";"
				+ ubicacion + ";" + enUso + ";" + estado + ";" + tipo);
		br.close();
	}
	
	public void eliminarLineaArchivoIniciaPorPlaca(String archivo, String placa) throws IOException
	{
		File inputFile = new File(archivo);
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String trimmedLine;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            trimmedLine = currentLine.trim();
            if(trimmedLine.startsWith(placa) == false) {
                writer.write(currentLine + System.getProperty("line.separator"));
            } 
        }
        writer.close(); 
        reader.close(); 
        Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}
	
	public void darBajarVehiculo(String placa, String sede) throws IOException
	{
		eliminarLineaArchivoIniciaPorPlaca("vehiculos.txt", placa);
		eliminarLineaArchivoIniciaPorPlaca(sede +".txt", placa);
	}
	
	public void cambiarEstadoCarro(String placa, String sede, String estado) throws IOException
	{
		File file;
		FileReader fileReader;
        BufferedReader bufferedReader;
        StringBuilder content;
        String line;
        String[] splitLine;
		String newInfo;
		FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        
		for (int y = 0; y < 2; y++) {
			// Paso 1: Leer el contenido del archivo        
	        if(y == 0) {
	        	file = new File(sede + ".txt");
	        }else {
	        	file = new File("vehiculos.txt");
	        }
	        fileReader = new FileReader(file);
	        bufferedReader = new BufferedReader(fileReader);
	        
	        content = new StringBuilder();
	        line = "";
	        
	        while ((line = bufferedReader.readLine()) != null) {
	            // Realiza las modificaciones necesarias en cada línea
	            // Por ejemplo, puedes reemplazar texto o modificar datos
	        	if(line.trim().startsWith(placa) == true) {
	        		splitLine = line.trim().split(";");
	        		newInfo = "";
	        		for (int i = 0; i < splitLine.length; i++) {
	        			if(i == 8) {
	        				newInfo += estado + ";";
	        			}else {
	        				newInfo += splitLine[i].trim() + ";";
	        			}
						
						
					}
	                content.append(newInfo).append(System.getProperty("line.separator"));
	            }  else {
	            	content.append(line.trim() + System.getProperty("line.separator") );
	            }
	            
	        }
	        
	        // Cierra los lectores
	        bufferedReader.close();
	        fileReader.close();
	        
	        // Paso 2: Escribir el contenido modificado de vuelta al archivo
	        fileWriter = new FileWriter(file);
	        bufferedWriter = new BufferedWriter(fileWriter);
	        
	        bufferedWriter.write(content.toString());
	        
	        // Cierra los escritores
	        bufferedWriter.close();
	        fileWriter.close();
	        
	        System.out.println("Archivo modificado con éxito.");
		}
		
	}
	
	public void devolucionVehiculo(String placa) throws IOException
	{
		eliminarLineaArchivoIniciaPorPlaca("carrosEnUso.txt", placa);
	}

}
