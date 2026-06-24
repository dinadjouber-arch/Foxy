package personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import objet.Objet;

public class Frog extends Personnage implements Runnable{

	private Image imgFrog;
	private ImageIcon icoFrog;
	
	private int dxFrog;   //pas de deplacement de la grenouille
	final int PAUSE=15;  //temps d'attente en ms entre chaque 2 tours de boucle
	
	

	public Frog(int x, int y) {
		super(x, y, 37, 40);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxFrog =1;
		
		this.icoFrog =new ImageIcon(getClass().getResource("/images/frogArret.png"));
		this.imgFrog =this.icoFrog.getImage();
		
		
		Thread chronoFrog=new Thread(this);
		chronoFrog.start();
	}
	
	
	
	public Image getImage() {return this.imgFrog;}



	@Override
	public void run() {
		
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient completement crees
		catch (InterruptedException ignored){}
		while(true){ // boucle infinie
			if(this.vivant)
			{
		    this.bouge();
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException ignored){}
		}		}
		
	}
	
	
	
	public void bouge()//deplacement de la grenouille
	{
		if(this.isVersDroite())
			this.dxFrog =1;
		else
			this.dxFrog =-1;
		
		super.setX(this.dxFrog +super.getX());
	}
	
	
	public void contact(Objet objet) {			
		if(this.contactAvant(objet) && this.isVersDroite()){					
            this.setVersDroite(false);
	    	this.dxFrog = -1;
	    }else if(super.contactArriere(objet) && !this.isVersDroite()){
	    	this.setVersDroite(true);
	    	this.dxFrog = 1;
	    }	
	}
	
	
	
	public void contact(Personnage personnage) {			
		if(super.contactAvant(personnage) && this.isVersDroite()){
	        super.setVersDroite(false);
	    	this.dxFrog = -1;
	    }else if(super.contactArriere(personnage) && !this.isVersDroite()){
	    	super.setVersDroite(true);
	    	this.dxFrog = 1;
	    }	
	}
	
	
	
	
	public Image meurt(){		
		String str;	
		ImageIcon ico;
		Image img;
		
        {str = "/images/frogMeurt.png";}
        		
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
		return img;
	}
}
