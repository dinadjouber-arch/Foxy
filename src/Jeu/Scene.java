package Jeu;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import affichage.Score;
import personnage.Foxy;
import personnage.Frog;
import objet.Rock;
import objet.Bloc;
import objet.Objet;
import objet.Gem;

public class Scene extends JPanel{

    private final Image imgFond1;
	private final Image imgFond2;  //pour mettre l'image de fond deux fois bout a bout


    private final Image imgMaison1;

    private Image imgDepart;
    private Image imgSkulls;
	
	
	private ImageIcon icoTree;
	private Image imgTree;
	
	private ImageIcon icoMaisonFin;
	private Image imgMaisonFin;
	
	private boolean ok;
	
	
	
	private int xFond;
	private int xFond2;
	
	
	private int dx=0;//deplacement de la scene
	
	
	
	private int xPos; //la position absolue (aide pour que la maison de depart et les autres elements ne suivent pas foxy)
	
	
	
	private int ySol;        //hauteur du sol
	private int hauteurPlafond;    //hauteur du plafond
	
	
	
	public Foxy foxy;
	
	
	
	public Rock rock1;
	public Rock rock2;
	public Rock rock3;
	public Rock rock4;
	public Rock rock5;
	public Rock rock6;
	public Rock rock7;
	public Rock rock8;
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;


	
	
	public Gem gem1;
	public Gem gem2;
	public Gem gem3;
	public Gem gem4;
	public Gem gem5;
	public Gem gem6;
	public Gem gem7;
	public Gem gem8;

	

	
	public Frog frog1;
	public Frog frog2;
	public Frog frog3;
	

	
	
	

	
	ArrayList<Objet> tabObjets= new ArrayList<Objet>();
	public ArrayList<Gem> tabGems = new ArrayList<Gem>();

	private ArrayList<Frog> tabFrogs; // tableau qui enregistre toutes les grenouilles du jeu
	

	private Score score;
	
	
	
	Scene()
	{
		super();
		this.xFond=-50;
		this.xFond2=750;
		
		this.xPos=-1;
		
		
		this.hauteurPlafond=0;
		this.ySol=293;


        ImageIcon icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		this.imgFond1= icoFond.getImage();
		this.imgFond2= icoFond.getImage();


        ImageIcon icoMaison1 = new ImageIcon(getClass().getResource("/images/maison1.png"));
		this.imgMaison1 = icoMaison1.getImage();

        ImageIcon icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		this.imgDepart= icoDepart.getImage();

        ImageIcon icoSkulls = new ImageIcon(getClass().getResource("/images/skulls.png"));
        this.imgSkulls= icoSkulls.getImage();
		
		icoMaisonFin =new ImageIcon(getClass().getResource("/images/maisonFin.png"));
		this.imgMaisonFin =this.icoMaisonFin.getImage();
		
		icoTree=new ImageIcon(getClass().getResource("/images/tree.png"));
		this.imgTree =this.icoTree.getImage();
		
		
		this.foxy =new Foxy(300,250);
		
		
		
		rock1 = new Rock(600, 248);
		rock2 = new Rock(1000, 248);
		rock3 = new Rock(1600, 248);
		rock4 = new Rock(1900, 248);
		rock5 = new Rock(2500, 248);
		rock6 = new Rock(3000, 248);
		rock7 = new Rock(3800, 248);
		rock8 = new Rock(4470, 248);
		
		bloc1 = new Bloc(400, 180);
		bloc2 = new Bloc(1200, 180);
		bloc3 = new Bloc(1270, 170);
		bloc4 = new Bloc(1340, 160);
		bloc5 = new Bloc(2000, 180);
		bloc6 = new Bloc(2600, 160);
		bloc7 = new Bloc(3500, 160);
		bloc8 = new Bloc(3550, 140);

		
		
		gem1 = new Gem(402, 145);
		gem2 = new Gem(1202, 140);
		gem3 = new Gem(1272, 95);
		gem4 = new Gem(1342, 40);
		gem5 = new Gem(1650, 145);
		gem6 = new Gem(2650, 145);
		gem7 = new Gem(3000, 135);
		gem8 = new Gem(3400, 125);

		

	
		
		frog1 = new Frog(950, 258);
		frog2 = new Frog(1500, 258);
		frog3 = new Frog(3100, 258);
		
		
		
		 tabObjets = new ArrayList<Objet>();	
			this.tabObjets.add(this.rock1);
			this.tabObjets.add(this.rock2);
			this.tabObjets.add(this.rock3);
			this.tabObjets.add(this.rock4);
			this.tabObjets.add(this.rock5);
			this.tabObjets.add(this.rock6);
			this.tabObjets.add(this.rock7);
			this.tabObjets.add(this.rock8);
			
			this.tabObjets.add(this.bloc1);
			this.tabObjets.add(this.bloc2);
			this.tabObjets.add(this.bloc3);
			this.tabObjets.add(this.bloc4);
			this.tabObjets.add(this.bloc5);
			this.tabObjets.add(this.bloc6);
			this.tabObjets.add(this.bloc7);
			this.tabObjets.add(this.bloc8);


		
	
			
		tabGems = new ArrayList<Gem>();
			this.tabGems.add(this.gem1);
			this.tabGems.add(this.gem2);
			this.tabGems.add(this.gem3);
			this.tabGems.add(this.gem4);
			this.tabGems.add(this.gem5);
			this.tabGems.add(this.gem6);
			this.tabGems.add(this.gem7);
			this.tabGems.add(this.gem8);

		
		
		
		

			
			
			tabFrogs = new ArrayList<Frog>();
			this.tabFrogs.add(this.frog1);
			this.tabFrogs.add(this.frog2);
			this.tabFrogs.add(this.frog3);
			
			
			
			
		
			this.score=new Score();
	
		
		
		
		//relier la scene et le clavier
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		
		
		Thread chronoEcran=new Thread(new Chrono());
		chronoEcran.start();
		
		
	}
	
	
	
	

	
	
	public int getDx() {return dx;}
	public void setDx(int dx) {this.dx = dx;}


	public int getxPos() {return xPos;}
    public void setxPos(int xPos) {this.xPos = xPos;}
    
    
    public int getxFond() {return xFond;}
    public void setxFond(int xFond) {this.xFond = xFond;}


    public int getxFond2() {return xFond2;}
    public void setxFond2(int xFond2) {this.xFond2 = xFond2;}
    
    


	public int getySol() {return ySol;}
	public void setySol(int y) {this.ySol=y;}
  


	public int getHauteurPlafond() {return hauteurPlafond;}
	public void setHauteurPlafond(int hauteurPlafond) {this.hauteurPlafond=hauteurPlafond;}
	

	
	
	
	public void deplacementFond() { // Deplacement du fond lorsque foxy se deplace
		if(this.xPos>=0) {
			this.xPos = this.xPos + this.dx;
			this.xFond = this.xFond - this.dx;
			this.xFond2 = this.xFond2 - this.dx;			
		// Remise a zero des abscisses pour rotation des images de fond
		if (this.xFond == -800) {this.xFond = 800;}
		else if (this.xFond2 == -800) {this.xFond2 = 800;}
		else if (this.xFond == 800) {this.xFond = -800;}
		else if (this.xFond2 == 800) {this.xFond2 = -800;}	
		}
        for (Objet tabObjet : this.tabObjets) {
            tabObjet.deplacement();
        }

        for (Frog tabFrog : this.tabFrogs) {
            tabFrog.deplacement();
        }
        for (Gem tabGem : this.tabGems) {
            tabGem.deplacement();
        }
	}
	
	public boolean partieGagnee(){
			if((this.foxy.isVivant())&&(this.xPos > 3850)){
						if(this.ok){
							this.ok = false;
						}
						return true;
					}else{return false;}				
	}
	
	private boolean partiePerdue(){
		if(!this.foxy.isVivant()){return true;}
		else{return false;}
	}
		
	public boolean finDePartie(){
		if(this.partieGagnee() || this.partiePerdue()){ return true;}
		else{return false;}
	}
	
	
	


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
 		Graphics g2 = (Graphics2D) g; // Graphics2D donne un meilleur rendu graphique		
 
 		// Detections des contacts avec des objets
        for (Objet tabObjet : this.tabObjets) {
            // foxy
            if (this.foxy.proche(tabObjet)) {
                this.foxy.contact(tabObjet);
            }



            // grenouilles
            for (Frog tabFrog : this.tabFrogs) {
                if (tabFrog.proche(tabObjet)) {
                    tabFrog.contact(tabObjet);
                }
            }


        }
 		

 		





 	 	
 	 	// Detection des contacts de foxy avec des personnages(grenouilles)

        for (Frog tabFrog : this.tabFrogs) {
            if (this.foxy.proche(tabFrog) && tabFrog.isVivant()) {
                this.foxy.contact(tabFrog);
            }
        }
 	 	
 	 	
    	// Detection des contacts de foxy avec des gems
 	 	for(int i = 0; i < this.tabGems.size(); i++){
 	 	    if(this.foxy.proche(this.tabGems.get(i))){
 	 	        if(this.foxy.contactPiece(this.tabGems.get(i))){
 	 	            this.tabGems.remove(i);
 	 	            this.score.setNbreGems(this.score.getNbreGems() + 1);
 	 	            i--; //  on recule pour ne rien sauter
 	 	        }
 	 	    }
 	 	}
 	 	
 		// Deplacement de tous les objets "fixes" du jeu et des personnages (hors foxy)
 		this.deplacementFond();
 		
 	    // Image de fond
 		g2.drawImage(this.imgFond1, this.xFond, 0, 800,350,null);
 		g2.drawImage(this.imgFond2, this.xFond2, 0, 800,350,null);
 		// Image de la maison de depart
 		g2.drawImage(imgMaison1, 20 - this.xPos, 153, null);
 		// Image du panneau de depart
 		g2.drawImage(imgDepart, 220 - this.xPos, 238, null);
        g2.drawImage(imgSkulls, 220 - this.xPos, 268,30,30, null);

        // Image des deux arbres a l'arrivee
 		g2.drawImage(imgTree, 4000 - this.xPos, 188, null);
		g2.drawImage(imgTree, 4370 - this.xPos, 188, null);
 		// Image de la maison d'arrivee
	  	g2.drawImage(imgMaisonFin, 4250 - this.xPos, 197, null);
 		
 		// Images des objets
        for (Objet tabObjet : this.tabObjets) {
            g2.drawImage(tabObjet.getImgObjet(), tabObjet.getX(), tabObjet.getY(), null);

        }
 				

 	    // Images des grenouilles
 		for(int i = 0; i < this.tabFrogs.size(); i++){
 		    if(this.tabFrogs.get(i).isVivant()){
				if(!this.tabFrogs.get(i).isVersDroite()){g2.drawImage(this.tabFrogs.get(i).marche("frog", 52), this.tabFrogs.get(i).getX(), this.tabFrogs.get(i).getY(),this.tabFrogs.get(i).getLargeur(), this.tabFrogs.get(i).getHauteur(), null);}
				else {g2.drawImage(this.tabFrogs.get(i).marche("frog", 52), this.tabFrogs.get(i).getX()+this.tabFrogs.get(i).getLargeur(), this.tabFrogs.get(i).getY(), -this.tabFrogs.get(i).getLargeur(),this.tabFrogs.get(i).getHauteur(),null);}
 		    }else{
 		        g2.drawImage(this.tabFrogs.get(i).meurt(), this.tabFrogs.get(i).getX(), this.tabFrogs.get(i).getY()+5,this.tabFrogs.get(i).getLargeur(), this.tabFrogs.get(i).getHauteur(), null);
 		        if(this.tabFrogs.get(i).getCompteur() > 100){
 		            this.tabFrogs.remove(i);
 		            i--; // on recule pour ne pas sauter l'élément suivant
 		        }
 		    }
 		}
 		
 		// Images des gems
        for (Gem tabGem : this.tabGems) {
            g2.drawImage(tabGem.getImgObjet(), tabGem.getX(), tabGem.getY(),tabGem.getLargeur(), tabGem.getHauteur(), null);
        }
 		
 		// Image de foxy
 		if(Main.scene.foxy.isVivant()){
 		    if(this.foxy.isSaut())
			 {
				 if(this.foxy.isVersDroite())g2.drawImage(this.foxy.saute(), this.foxy.getX(), this.foxy.getY(), this.foxy.getLargeur(),this.foxy.getHauteur(),null);
				 else g2.drawImage(this.foxy.saute(), this.foxy.getX()+this.foxy.getLargeur(), this.foxy.getY(), -this.foxy.getLargeur(),this.foxy.getHauteur(),null);
			 }
 		    else{
				if(this.foxy.isVersDroite())g2.drawImage(this.foxy.marche("foxy", 25), this.foxy.getX(), this.foxy.getY(), this.foxy.getLargeur(),this.foxy.getHauteur(), null);
				else g2.drawImage(this.foxy.marche("foxy", 25), this.foxy.getX()+this.foxy.getLargeur(), this.foxy.getY(), -this.foxy.getLargeur(),this.foxy.getHauteur(),null);
			     }
 		}else{g2.drawImage(this.foxy.meurt(), this.foxy.getX(), this.foxy.getY(), null);}
 				 
	    
	    // Mise a jour du score(nombre de gems trouvees)
	    g2.drawString(this.score.getNbreGems() + " gem(s) trouvée(s) sur " + this.score.getNBRE_TOTAL_GEMS(), 460, 25);
	    
	    // Fin de partie
	    if(this.finDePartie()){
	    	Font policeFin = new Font("Arial", Font.BOLD, 50);
            g2.setFont(policeFin);
	        if(this.partieGagnee()){g2.drawString("Vous avez gagné !!", 120, 180);}
	        else{g2.drawString("Vous avez perdu...", 120, 180);}
 	    }
 	}


	
	
	
	
	

}
