package dominio;

import java.util.ArrayList;
import java.util.Date;

public class Proyecto {

	private String nombre;
	private ArrayList<Actividad> actividades;
	private ArrayList<Persona> integrantes;
	private Date fechaInin;
	private Date fechaFin;
	
	public Proyecto(String nombre, ArrayList<Persona> integrantes, Date fechaInin, Date fechaFin) {
		this.nombre = nombre;
		this.actividades = actividades;
		this.integrantes = integrantes;
		this.fechaInin = fechaInin;
		this.fechaFin = fechaFin;
	}
	public void añadirActividad(Actividad actividad) {
		actividades.add(actividad);
	}
	public void añadirIntegrante(Persona integrante) {
		integrantes.add(integrante);
	}
	// metodos eliminar V.1.0 abra que probar si fincionan me imagino que si.....
	public void eliminarActividad(Actividad actividad) {
		for(int i=0;i<actividades.size();i++)
			if(actividades.get(i).equals(actividad))
				actividades.remove(i);
	}
	public void eliminarIntegrante(Persona integrante) {
		for(int i=0;i<integrantes.size();i++)
			if(integrantes.get(i).equals(integrante))
				integrantes.remove(i);
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}

	public ArrayList<Persona> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(ArrayList<Persona> integrantes) {
		this.integrantes = integrantes;
	}

	public Date getFechaInin() {
		return fechaInin;
	}

	public void setFechaInin(Date fechaInin) {
		this.fechaInin = fechaInin;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}