/**
 * 
 */
package paint_v1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 * @author manuelromero
 *
 */
public class drawArea extends JComponent{
	private Image image; //imagen en la que vamos a dibujar
	private Graphics2D g2; // objeto Graphics2D
	
	private int	currentX, currentY, oldX, oldY;
	
	public drawArea () {
		 setDoubleBuffered(false);
		 addMouseListener(new MouseAdapter(){
			 
			 public void mousePressed(MouseEvent e){
				 	//guardar coordenadas en X y Y cuando el mouse es presionado;
				 	oldX = e.getX();
				 	oldY = e.getY();
				 	repaint(); //repintando el area
				 	oldX = currentX; //se almacenan las coodenadas current con las old
				 	oldY = currentY;
			 }
			 
		 });
		 
		 addMouseMotionListener(new MouseMotionAdapter(){

			@Override
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				
				
				if(g2 != null){
					g2.drawLine(oldX,oldY,currentX,currentY);
					repaint();
					oldX = currentX;
					oldY = currentY;
				}
			}
			 
		 });
		 
	}
	
	 protected void paintComponent(Graphics g){
		 if (image == null ){
			 // si imagen es diferente de null ==> dibujar 
			 image =  createImage(getSize().width, getSize().height);
			 g2 = (Graphics2D) image.getGraphics();
			 // enable antialiasing
			 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			 clear();
		 }
		  g.drawImage(image, 0, 0, null);
		  
	 };
	 
	 public void clear(){
		 g2.setPaint(Color.white);
		 g2.fillRect(0, 0, getSize().width, getSize().height);
		 g2.setPaint(Color.black);	
		 repaint();
	 }
	 
	 
	 public void red(){
		 g2.setPaint(Color.red);
	 }
	 public void black(){
		 g2.setPaint(Color.black);
	 }
	 public void magenta(){
		 g2.setPaint(Color.magenta);
	 }
	 public void green(){
		 g2.setPaint(Color.green);
	 }
	 public void blue(){
		 g2.setPaint(Color.blue);
	 }
	 
	 public void saveImage(){
		 try {
			 	JOptionPane.showMessageDialog(null, "Su Imagen Se Guardo Correctamente :D");
				ImageIO.write((RenderedImage) image, "jpg", new File("imagenesGuardadas/imagen.jpg"));
			} catch (IOException e) {
				System.out.println("Error de escritura");
			}
	 }

	 
	
	public void cargarimagen(Graphics g){		
			ImageIcon dibujo = new ImageIcon(new ImageIcon(getClass().getResource("imagenesGuardadas/imagen.jpg")).getImage());
			g.drawImage(dibujo.getImage(), 90, 90, null);
			
			JOptionPane.showMessageDialog(null, "La funcion de cargar se ejecuto");		
	};
}
