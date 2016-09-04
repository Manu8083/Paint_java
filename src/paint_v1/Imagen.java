/**
 * 
 */
package paint_v1;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * @author manuelromero
 *
 */
public class Imagen extends javax.swing.JPanel {
	public Imagen(){
		this.setSize(300,400);
	}
	 public void paint(Graphics grafico){
		 Dimension height = getSize();
		 
		 ImageIcon Img= new ImageIcon(getClass().getResource("imagenesGuardadas/imagen.jpg"));
		 //Se selecciona la imagen que tenemos en el paquete de la //ruta de la imagen
		 
		 grafico.drawImage(Img.getImage(), 0, 0, height.width, height.width, null);
		 
		 setOpaque(false);
		 super.paintComponents(grafico);
	 }
}
