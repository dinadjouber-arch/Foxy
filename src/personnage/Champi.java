package personnage;

import java.awt.Image;

import javax.swing.ImageIcon;
import objet.Objet;



public class Champi extends Personnage implements Runnable{
	
	
	private Image imgChampi;
	private ImageIcon icoChampi;
	
	private int dxChamp;   //pas de deplacement du champignon
	final int PAUSE=15;  //temps d'attente en ms entre chaque 2 tours de boucle
	
	

	public Champi(int x, int y) {
		super(x, y, 27, 30);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxChamp=1;
		
		this.icoChampi=new ImageIcon(getClass().getResource("/images/champArretDroite.png"));
		this.imgChampi=this.icoChampi.getImage();	
		
		
		Thread chronoChamp=new Thread(this);
		chronoChamp.start();
	}
	
	
	
	public Image getImage() {return this.imgChampi;}



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
		}	}	
		
	}
	
	
	
	public void bouge()//deplacement du champignon
	{
		if(this.isVersDroite())
			this.dxChamp=1;
		else
			this.dxChamp=-1;
		
		super.setX(this.dxChamp+super.getX());
	}
	
	
	public void contact(Objet objet) {			
		if(this.contactAvant(objet) && this.isVersDroite()){					
            this.setVersDroite(false);
	    	this.dxChamp = -1; 
	    }else if(super.contactArriere(objet) && !this.isVersDroite()){
	    	this.setVersDroite(true);
	    	this.dxChamp = 1;     
	    }	
	}
	
	public void contact(Personnage personnage) {			
		if(super.contactAvant(personnage) == true && this.isVersDroite() == true){					
	        super.setVersDroite(false);
	    	this.dxChamp = -1; 
	    }else if(super.contactArriere(personnage) == true && this.isVersDroite() == false){
	    	super.setVersDroite(true);
	    	this.dxChamp = 1;     
	    }	
	}
	
	
	
	
	public Image meurt(){		
		String str;	
		ImageIcon ico;
		Image img;
		
        if(this.isVersDroite() == true){str = "/images/champEcraseDroite.png";}
        else{str = "/images/champEcraseGauche.png";}		
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
		return img;
	}

}
