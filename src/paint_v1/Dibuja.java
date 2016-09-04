/**
 * 
 */
package paint_v1;

import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * @author manuelromero
 *
 */
public class Dibuja {
	ImageIcon dibujo = new ImageIcon(new ImageIcon(getClass().getResource("ImagenesGuardadas/imagen.jpg")).getImage());

	public  void cargarimagen(Graphics g){
		 g.drawImage(dibujo.getImage(), 50, 50, null);
	};
}
