package presentacion;

import java.awt.Color;

public class objetoGrafico {

	private String texto;
	private Color color;
	private int x,y;
	
	public objetoGrafico(int x, int y, String text, Color color){ 
		this.x = x;
		this.y = y;
		this.texto=text;
        this.color=color;
	}
	public void setX(int x) {
		this.x = x;
		}
	public void setY(int y) {
		this.y = y;
		}
	public int getX() {
	    	return x;
	    	}
	public int getY() {
	    	return y;
	    	}
	
	public void setTexto(String texto) {
		this.texto = texto; 
		} 
	public void setColor(Color color) {
		this.color = color; 
		}
	public String getTexto() {
		return texto;
		}
	public Color getColor() {
		return color;
		}
	
}
