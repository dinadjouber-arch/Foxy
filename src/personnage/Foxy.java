package personnage;

import java.awt.Image;
import javax.swing.ImageIcon;

import Jeu.Main;
import objet.Objet;
import objet.Gem;

public class Foxy extends Personnage{
	
	private Image imgFoxy;
	private ImageIcon icoFoxy;
	
	private boolean saut;  //vrai si foxy saute
	private int compteurSaut;  //duree du saut et hauteur du saut
	private int compteurMort;



	
	
	
	public Foxy(int x, int y)
	{
		super(x,y,50,50);
		
		this.icoFoxy=new ImageIcon(getClass().getResource("/images/foxyArret.png"));
		this.imgFoxy=this.icoFoxy.getImage();
		
		
		this.saut=false;
		this.compteurSaut=0;
		this.compteurMort=0;


	}



	public Image getImgFoxy() {return imgFoxy;}
    public void setImgFoxy(Image imgFoxy) {this.imgFoxy = imgFoxy;}


    
    

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
			str = "/images/foxySaut.png";

		// Retombee du saut
		}else if(this.getY() + this.getHauteur() < Main.scene.getySol())
		{
			this.setY(this.getY() + 1);
			str = "/images/foxySaut.png";

		// Saut termine	
		}else
		{
			str = "/images/foxyArret.png";
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
		}else if(!super.contactDessous(objet)){
			Main.scene.setySol(295); // altitude du sol initial
			if(!this.saut){this.setY(295-this.getHauteur());}
		}
        if(super.contactDessus(objet))
        {
			Main.scene.setHauteurPlafond(objet.getY() + objet.getHauteur()); // le plafond devient le dessous de l'objet
		}else if(!super.contactDessus(objet) && !this.saut){
			Main.scene.setHauteurPlafond(0);
		}

	}
	
	
	public boolean contactPiece(Gem gem)
	{
		if(this.contactArriere(gem) || this.contactAvant(gem) || this.contactDessous(gem) || this.contactDessus(gem)){
			return true;			
		}else{return false;}
		
		
	}

	
	public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	


		this.compteurMort++;


		
        str = "/images/boom.png";
        if(this.compteurMort > 90){
        	str = "/images/foxyMeurt.png";
        	this.setY(this.getY() - 1);
       }
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img; 
	} 
	
    public void contact(Personnage personnage) {		
		if(((super.contactAvant(personnage)) || (super.contactArriere(personnage)))&&(personnage.isVivant())){
			this.setMarche(false);
		    this.setVivant(false);
		}else if(super.contactDessous(personnage)){
			personnage.setMarche(false);
			personnage.setVivant(false);
		}
    }				


}
