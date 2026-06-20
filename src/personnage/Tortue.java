package personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import objet.Objet;

public class Tortue extends Personnage implements Runnable{

	private Image imgTortue;
	private ImageIcon icoTortue;
	
	private int dxTortue;   //pas de deplacement du champignon
	final int PAUSE=15;  //temps d'attente en ms entre chaque 2 tours de boucle
	
	

	public Tortue(int x, int y) {
		super(x, y, 27, 30);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxTortue=1;
		
		this.icoTortue=new ImageIcon(getClass().getResource("/images/tortueArretDroite.png"));
		this.imgTortue=this.icoTortue.getImage();	
		
		
		Thread chronoTortue=new Thread(this);
		chronoTortue.start();
	}
	
	
	
	public Image getImage() {return this.imgTortue;}



	@Override
	public void run() {
		
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient compl�tement cr��s
		catch (InterruptedException e){}				
		while(true){ // boucle infinie
			if(this.vivant)
			{
		    this.bouge();
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
		}		}
		
	}
	
	
	
	public void bouge()//deplacement de la tortue
	{
		if(this.isVersDroite())
			this.dxTortue=1;
		else
			this.dxTortue=-1;
		
		super.setX(this.dxTortue+super.getX());
	}
	
	
	public void contact(Objet objet) {			
		if(this.contactAvant(objet) && this.isVersDroite()){					
            this.setVersDroite(false);
	    	this.dxTortue = -1; 
	    }else if(super.contactArriere(objet) && !this.isVersDroite()){
	    	this.setVersDroite(true);
	    	this.dxTortue = 1;     
	    }	
	}
	
	
	
	public void contact(Personnage personnage) {			
		if(super.contactAvant(personnage) == true && this.isVersDroite() == true){					
	        super.setVersDroite(false);
	    	this.dxTortue = -1; 
	    }else if(super.contactArriere(personnage) == true && this.isVersDroite() == false){
	    	super.setVersDroite(true);
	    	this.dxTortue = 1;     
	    }	
	}
	
	
	
	
	public Image meurt(){		
		String str;	
		ImageIcon ico;
		Image img;
		
        {str = "/images/tortueFermee.png";}
        		
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
		return img;
	}
}
