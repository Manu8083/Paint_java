/**
 * 
 */
package paint_v1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;

/**
 * @author manuelromero
 *
 */
public class siwngPaint {
	
	JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn, saveImage, cargarimagen;
	drawArea drawArea;
	ActionListener actionListener = new ActionListener(){
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == clearBtn){
				drawArea.clear();
			}else if(e.getSource() == blackBtn){
				drawArea.black();
			}else if(e.getSource() == blueBtn){
				drawArea.blue();
			}else if(e.getSource() == greenBtn){
				drawArea.green();
			}else if(e.getSource() == redBtn){
				drawArea.red();
			}else if(e.getSource() == magentaBtn){
				drawArea.magenta();
			}else if(e.getSource() == saveImage){
				drawArea.saveImage();
			}else if(e.getSource() == cargarimagen){
				drawArea.cargarimagen(drawArea.getGraphics());
			}
		}
	};

	public static void main(String[] args){
			new siwngPaint().show();
	}
	
	public void show(){
		//creando el main principal
		JFrame frame = new JFrame("paint");
		Container content = frame.getContentPane();
		//creando el panel de dibujo
		content.setLayout(new BorderLayout());
		//creando area de dibujo
		drawArea = new drawArea();
		
		
		//panel de control
		content.add(drawArea, BorderLayout.CENTER);
		
		//creacion de controles
		JPanel controls = new JPanel();
		
		 clearBtn = new JButton("Borrar");
		 clearBtn.addActionListener(actionListener);
		 blackBtn = new JButton("Negro");
		 blackBtn.addActionListener(actionListener);
		 blueBtn = new JButton("Azul");
		 blueBtn.addActionListener(actionListener);
		 greenBtn = new JButton("Verde");
		 greenBtn.addActionListener(actionListener);
		 redBtn = new JButton("Rojo");
		 redBtn.addActionListener(actionListener);
		 magentaBtn = new JButton("Magenta");
		 magentaBtn.addActionListener(actionListener);
		 saveImage = new JButton("Guardar Imagen");
		 saveImage.addActionListener(actionListener);
		 cargarimagen = new JButton("Cargar Imagen");
		 cargarimagen.addActionListener(actionListener);
		 
		 //agregar al panel
		 controls.add(blackBtn);
		 controls.add(greenBtn);
		 controls.add(blueBtn);
		 controls.add(redBtn);
		 controls.add(magentaBtn);
		 controls.add(saveImage);
		 controls.add(cargarimagen);
		 controls.add(clearBtn);
		 
		 
		 content.add(controls, BorderLayout.NORTH);
		 
		 frame.setSize(900,900);
		 
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //mostrar el swing paint
		 
		frame.setVisible(true);
		
		
	}
	
	
}
