package dominio;

public class Persona {
	private String nombre;
	private String DNI;
	
	public Persona(String nombre, String dNI) {
		this.nombre = nombre;
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	@Override
	public String toString() {
		return nombre + " " +DNI;
	}
	
}
