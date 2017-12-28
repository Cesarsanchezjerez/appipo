package dominio;

public class Actividad {

	private String nombre;

	
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
