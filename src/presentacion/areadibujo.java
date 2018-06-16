package presentacion;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

public class areadibujo extends JLabel{
	
	private ArrayList<objetoGrafico> objetosGraficos = new ArrayList<objetoGrafico>();

	 public areadibujo(){
		 
		 
	}
	 
	 void addObjetoGrafico(objetoGrafico objg) { 
		 objetosGraficos.add(objg);
	 }
	 public objetoGrafico getUltimoObjetoGrafico() {
		 return objetosGraficos.get(objetosGraficos.size()-1); 
	 }
	 public void paint(Graphics g){ super.paint(g);
	 super.paint(g);
	 for (int i = 0; i < objetosGraficos.size(); i++) { 
		 objetoGrafico objg = objetosGraficos.get(i);
		 g.setColor(((objetoGrafico)objg).getColor());
		 g.drawString(((objetoGrafico)objg).getTexto(),objg.getX(),objg.getY());
	 }
	
	 }
}

