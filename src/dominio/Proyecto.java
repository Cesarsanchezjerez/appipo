package dominio;

import java.util.ArrayList;
import java.util.Date;

public class Proyecto {

	private String nombre;
	private ArrayList<Actividad> actividades= new ArrayList<Actividad>();
	private ArrayList<Persona> integrantes = new ArrayList<Persona>();
	private String fechaInin;
	private String fechaFin;
	
	public Proyecto(String nombre, String fechaInin, String fechaFin) {
		this.nombre = nombre;
		
		this.fechaInin = fechaInin;
		this.fechaFin = fechaFin;
	}
	public void añadirActividad(Actividad actividad) {
		actividades.add(actividad);
	}
	public void añadirIntegrante(Persona integrante) {
		integrantes.add(integrante);
	}
	// metodo modificar actividad
	public void modificarActividad(String nact,Actividad act) {
		
		for (int i = 0; i < actividades.size(); i++) {
			
			if(actividades.get(i).getNombre().equals(nact)) {
				actividades.get(i).setNombre(act.getNombre());
				actividades.get(i).setFechaInin(act.getFechaInin());
				actividades.get(i).setFechaFin(act.getFechaFin());
				actividades.get(i).setEstado(act.getEstado());
				actividades.get(i).setPrioridad(act.getPrioridad());
			}
		}
		
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

	public String getFechaInin() {
		return fechaInin;
	}

	public void setFechaInin(String fechaInin) {
		this.fechaInin = fechaInin;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	@Override
	public String toString() {
		return nombre;
	}
	
}
