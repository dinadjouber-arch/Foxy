package personnage;

import java.awt.Image;
import javax.swing.ImageIcon;

import mario1.Main;
import objet.Objet;
import objet.Piece;

public class Mario extends Personnage{
	
	private Image imgMario;
	private ImageIcon icoMario;
	
	private boolean saut;  //vrai si mario saute
	private int compteurSaut;  //duree du saut et hauteur du saut
	private int compteurMort;
	
	
	
	public Mario(int x,int y)
	{
		super(x,y,28,50);
		
		this.icoMario=new ImageIcon(getClass().getResource("/images/marioArretDroite.png"));
		this.imgMario=this.icoMario.getImage();
		
		
		this.saut=false;
		this.compteurSaut=0;
		this.compteurMort=0;
	}



	public Image getImgMario() {return imgMario;}
    public void setImgMario(Image imgMario) {this.imgMario = imgMario;}


    
    

	public boolean isSaut() {return saut;}
	public void setSaut(boolean saut) {this.saut = saut;}
	
	
	
	
	
	
	
	
	
	
	public Image saute()
	{
		ImageIcon icoSaut;
		Image imgSaut;
		String str;
		
		this.compteurSaut++;  //compter le temps du saut
		
		
		//montee du saut
		if(this.compteurSaut <= 40){
			if(this.getY() > Main.scene.getHauteurPlafond()){this.setY(this.getY() - 4);}
			else{this.compteurSaut = 41;}			
			if(this.isVersDroite() == true){str = "/images/marioSautDroite.png";}
			else{str = "/images/marioSautGauche.png";}			
		// Retombee du saut
		}else if(this.getY() + this.getHauteur() < Main.scene.getySol()){this.setY(this.getY() + 1);
			if(this.isVersDroite() == true){str = "/images/marioSautDroite.png";}
			else{str = "/images/marioSautGauche.png";}		
		// Saut termine	
		}else{				
			if(this.isVersDroite() == true){str = "/images/marioArretDroite.png";}
			else{str = "/images/marioArretGauche.png";}	
			this.saut = false;
			this.compteurSaut = 0;
		}
		
		icoSaut=new ImageIcon(getClass().getResource(str));
		imgSaut=icoSaut.getImage();		
		
		return imgSaut;
	}
	
	
	
	
	
	public void contact(Objet objet) 
	{		
		if((super.contactAvant(objet) && this.isVersDroite()) || (super.contactArriere(objet) && !this.isVersDroite()))
		{
			Main.scene.setDx(0);
		    this.setMarche(false);
		}
        if(super.contactDessous(objet) && this.saut)
        {
			Main.scene.setySol(objet.getY());			
		}else if(super.contactDessous(objet) == false){
			Main.scene.setySol(293); // altitude du sol initial
			if(this.saut == false){this.setY(243);}
		}
        if(super.contactDessus(objet))
        {
			Main.scene.setHauteurPlafond(objet.getY() + objet.getHauteur()); // le plafond devient le dessous de l'objet
		}else if(super.contactDessus(objet) == false && this.saut == false){
			Main.scene.setHauteurPlafond(0);
		}      
	}
	
	
	public boolean contactPiece(Piece piece)
	{
		if(this.contactArriere(piece) == true || this.contactAvant(piece) == true || this.contactDessous(piece) == true || this.contactDessus(piece) == true){
			return true;			
		}else{return false;}
		
		
	}

	
	public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	


		this.compteurMort++;
		
        str = "/images/boom.png";
        if(this.compteurMort > 100){
        	str = "/images/marioMeurt.png";
        	this.setY(this.getY() - 1);
       }
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img; 
	} 
	
    public void contact(Personnage personnage) {		
		if(((super.contactAvant(personnage) == true) || (super.contactArriere(personnage) == true))&&(personnage.isVivant())){
			this.setMarche(false);
		    this.setVivant(false);
		}else if(super.contactDessous(personnage) == true){
			personnage.setMarche(false);
			personnage.setVivant(false);
		}
    }				
	
	
	
	
	
	
	
	

}
