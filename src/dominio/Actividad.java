package dominio;

import java.util.ArrayList;
import java.util.Date;

public class Actividad {

	private String nombre;
	//private ArrayList<Persona> integrantes;
	//private Date fechaInin;
	//private Date fechaFin;
	//private int prioridad;
	
	public Actividad(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "actividad [nombre=" + nombre + "]";
	}

	
	
	
}
