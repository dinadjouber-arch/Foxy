package Jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener{

	

	@Override
	public void keyPressed(KeyEvent e) {
	
		if(Main.scene.foxy.isVivant() && !Main.scene.partieGagnee())
		{	

		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{	
			if(Main.scene.getxPos()==-1)
			{ Main.scene.setxPos(0);
			  Main.scene.setxFond(-50);
			  Main.scene.setxFond2(750);}
			
			Main.scene.foxy.setMarche(true);
			Main.scene.foxy.setVersDroite(true);
			Main.scene.setDx(1);}
		
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
			{
			Main.scene.foxy.setMarche(true);
			Main.scene.foxy.setVersDroite(false);
			Main.scene.setDx(-1);}
	    if(e.getKeyCode() == KeyEvent.VK_SPACE)
		        {
		            Main.scene.foxy.setSaut(true);
		        }
	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.scene.foxy.setMarche(false);
		Main.scene.setDx(0);
		
		
	}
	
	
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	
	

}
