package dominio;

import java.util.ArrayList;
import java.util.Date;

public class Actividad {

	private String nombre;
	private ArrayList<Persona> integrantes;
	private String fechaInin;
	private String fechaFin;
	private int prioridad;
	
	
	public Actividad (String nomb, ArrayList<Persona> integ, String fechaI, String fechaF, int prior ) {
		nombre = nomb;
		integrantes=integ;
		fechaInin=fechaI;
		fechaFin=fechaF;
		prioridad=prior;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ArrayList<Persona> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(ArrayList<Persona> integrantes) {
		this.integrantes = integrantes;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaInin() {
		return fechaInin;
	}

	public void setFechaInin(String fechaInin) {
		this.fechaInin = fechaInin;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	
	
	
}
