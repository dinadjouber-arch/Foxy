package personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import mario1.Main;
import objet.Objet;

public class Personnage {

	private int hauteur,largeur; //dimensions du personnage
	private int x,y; //position du personnage
	private boolean marche; //vrai quand il marche
	private boolean versDroite; //vrai quand il est tourne vers la droite
	public int compteur;  //compteur des pas du personnage
	
	protected boolean vivant; //vrai si le personnage est vivant
	
	
	
	public Personnage(int x,int y,int largeur,int hauteur)
	{
		this.x=x;
		this.y=y;
		this.largeur=largeur;
		this.hauteur=hauteur;
		this.compteur=0;
		this.marche=false;
		this.versDroite=true;
		this.vivant=true;
		
	}


	

	public int getHauteur() {return hauteur;}
	public void setHauteur(int hauteur) {this.hauteur = hauteur;}

    public int getLargeur() {return largeur;}
    public void setLargeur(int largeur) {this.largeur = largeur;}

    public int getX() {return x;}
    public void setX(int x) {this.x = x;}

    public int getY() {return y;}
    public void setY(int y) {this.y = y;}

    public boolean isMarche() {return marche;}
    public void setMarche(boolean marche) {this.marche = marche;}

	public boolean isVersDroite() {return versDroite;}
    public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}

    public int getCompteur() {return compteur;}
    public void setCompteur(int compteur) {this.compteur = compteur;}
    
    public boolean isVivant() {	return vivant;}
	public void setVivant(boolean vivant) {this.vivant = vivant;}




	public Image marche(String nom,int frequence)
	{
		Image img;
		ImageIcon ico;
		String str="/images/"+nom+"ArretDroite.png";
		    
		    	
		    	if((this.marche==false))
		    	{
		    		if(this.isVersDroite()) str="/images/"+nom+"ArretDroite.png";
		    		else str="/images/"+nom+"ArretGauche.png";
		    		
		    	}
		    	else 
		    	{this.compteur++;
		    		
		    		if(this.compteur/frequence==0)
		    		{
		    			if(this.isVersDroite()) str="/images/"+nom+"ArretDroite.png";
		    		    else str="/images/"+nom+"ArretGauche.png";
		    		}
		    		else
		    		{
		    			if(this.isVersDroite()) str="/images/"+nom+"MarcheDroite.png";
		    		    else str="/images/"+nom+"MarcheGauche.png";}
		    		
		    		if (this.compteur==2*frequence)
		    			this.compteur=0;
		    		
		    	}
		    	
		    	
		    	ico=new ImageIcon(getClass().getResource(str));
		    	img=ico.getImage();
		    	
		
		return img;
	}
	
	
	
	
	
	
	public boolean contactAvant(Objet objet)
	{
		if(this.isVersDroite() == true){
		if(this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){return false;}
		else{return true;}
	    }else{return false;}
	}
	

	public boolean contactArriere(Objet objet)
	{
		if(this.x > objet.getX() + objet.getLargeur()-5 || this.x + this.largeur < objet.getX() + objet.getLargeur() - 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){return false;}
		else{return true;}
	}
	

	public boolean contactDessous(Objet objet)
	{
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || this.y + this.hauteur < objet.getY() || this.y + this.hauteur > objet.getY() + 5){return false;}
		else{return true;}		
	}
	
	
	public boolean contactDessus(Objet objet)
	{
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || this.y < objet.getY() + objet.getHauteur() || this.y > objet.getY() + objet.getHauteur() + 5){return false;}
		else{return true;}
		
	}
	
	
	
	public boolean proche (Objet objet)   //methode pour eviter qu il y ait un conflit entre contact avec bloc et avec tuyau
	{
		if((this.x>objet.getX()-10 && this.x<objet.getX()+objet.getLargeur()+10)||(this.x+this.largeur>objet.getX()-10 && this.x+this.largeur<objet.getX()+objet.getLargeur()+10))
		    return true;
		else
			return false;
		
		
		
		
	}
	
	
	public void deplacement()//pour eviter que les ennemis ne suivent le fond
	{
		if (Main.scene.getxPos()>0)
			this.x=this.x-Main.scene.getDx();
	}
	
	
	
	
	
	
	
	//gerer les contacts entre les personnages
	
	 protected boolean contactAvant(Personnage personnage){
			if(this.isVersDroite() == true){
				if(this.x + this.largeur < personnage.getX() || this.x + this.largeur > personnage.getX() + 5 || this.y + this.hauteur <= personnage.getY() || this.y >= personnage.getY() + personnage.getHauteur()){return false;}
				else{return true;}
			}else{return false;}
		} 
	    
	    protected boolean contactArriere(Personnage personnage){		
			if(this.x > personnage.getX() + personnage.getLargeur() || this.x + this.largeur < personnage.getX() + personnage.getLargeur() - 5 || this.y + this.hauteur <= personnage.getY() || this.y >= personnage.getY() + personnage.getHauteur()){return false;}
			else{return true;}
		}

	    protected boolean contactDessous(Personnage personnage){
	    	if(this.x + this.largeur < personnage.getX() || this.x > personnage.getX() + personnage.getLargeur() || this.y + this.hauteur < personnage.getY() || this.y + this.hauteur > personnage.getY()){return false;}
			else{return true;}
		}
	    
	    public boolean proche(Personnage personnage){  	
	    	if((this.x > personnage.getX() - 10 && this.x < personnage.getX() + personnage.getLargeur() + 10) 
	    	|| (this.x + this.largeur > personnage.getX() - 10 && this.x + this.largeur < personnage.getX() + personnage.getLargeur() + 10)){return true;}
	    	else{return false;}
	    }
	
	
	
	
	
	
}
