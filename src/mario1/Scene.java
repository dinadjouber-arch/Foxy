package mario1;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import affichage.Score;
import personnage.Champi;
import personnage.Mario;
import personnage.Tortue;
import objet.TuyauRouge;
import objet.Bloc;
import objet.Objet;
import objet.Piece;

@SuppressWarnings("serial")
public class Scene extends JPanel{
	
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;  //pour mettre l'image de fond deux fois bout a bout
	
	
	private ImageIcon icoChateau;
	private Image imgChateau;
	
	private ImageIcon icoDepart;
	private Image imgDepart;
	
	
	private ImageIcon icoDrapeau;
	private Image imgDrapeau;
	
	private ImageIcon icoChateauFin;
	private Image imgChateauFin;
	
	private boolean ok;
	
	
	
	private int xFond;
	private int xFond2;
	
	
	private int dx=0;//deplacement de la scene
	
	
	
	private int xPos; //la position absolue (aide pour que le chateau ne suive pas mario)
	
	
	
	private int ySol;        //hauteur du sol
	private int hauteurPlafond;    //hauteur du plafond
	
	
	
	public Mario mario;
	
	
	
	public TuyauRouge tuyauRouge1;
	public TuyauRouge tuyauRouge2;
	public TuyauRouge tuyauRouge3;
	public TuyauRouge tuyauRouge4;
	public TuyauRouge tuyauRouge5;
	public TuyauRouge tuyauRouge6;
	public TuyauRouge tuyauRouge7;
	public TuyauRouge tuyauRouge8;
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	public Bloc bloc11;
	public Bloc bloc12;
	
	
	public Piece piece1;
	public Piece piece2;
	public Piece piece3;
	public Piece piece4;
	public Piece piece5;
	public Piece piece6;
	public Piece piece7;
	public Piece piece8;
	public Piece piece9;
	public Piece piece10;
	
	
	
	public Champi champ1;
	public Champi champ2;
	public Champi champ3;
	public Champi champ4;
	
	public Tortue tortue1;
	public Tortue tortue2;
	public Tortue tortue3;
	

	
	
	

	
	ArrayList<Objet> tabObjets= new ArrayList<Objet>();
	ArrayList<Piece> tabPieces= new ArrayList<Piece>();
	private ArrayList<Champi> tabChamps; // tableau qui enregistre tous les champignons du jeu 
	private ArrayList<Tortue> tabTortues; // tableau qui enregistre toutes les tortues du jeu
	

	private Score score;
	
	
	
	Scene()
	{
		super();
		this.xFond=-50;
		this.xFond2=750;
		
		this.xPos=-1;
		
		
		this.hauteurPlafond=0;
		this.ySol=293;
		
		
		icoFond=new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		this.imgFond1=this.icoFond.getImage();
		this.imgFond2=this.icoFond.getImage();
		
		
		
		icoChateau=new ImageIcon(getClass().getResource("/images/chateau1.png"));
		this.imgChateau=this.icoChateau.getImage();
		
		icoDepart=new ImageIcon(getClass().getResource("/images/depart.png"));
		this.imgDepart=this.icoDepart.getImage();
		
		icoChateauFin=new ImageIcon(getClass().getResource("/images/chateauFin.png"));
		this.imgChateauFin=this.icoChateauFin.getImage();
		
		icoDrapeau=new ImageIcon(getClass().getResource("/images/drapeau.png"));
		this.imgDrapeau=this.icoDrapeau.getImage();
		
		
		this.mario=new Mario(300,245);
		
		
		
		tuyauRouge1 = new TuyauRouge(600, 230);
		tuyauRouge2 = new TuyauRouge(1000, 230);
		tuyauRouge3 = new TuyauRouge(1600, 230);
		tuyauRouge4 = new TuyauRouge(1900, 230);
		tuyauRouge5 = new TuyauRouge(2500, 230);
		tuyauRouge6 = new TuyauRouge(3000, 230);
		tuyauRouge7 = new TuyauRouge(3800, 230);
		tuyauRouge8 = new TuyauRouge(4500, 230);
		
		bloc1 = new Bloc(400, 180);
		bloc2 = new Bloc(1200, 180);
		bloc3 = new Bloc(1270, 170);
		bloc4 = new Bloc(1340, 160);
		bloc5 = new Bloc(2000, 180);
		bloc6 = new Bloc(2600, 160);
		bloc7 = new Bloc(2650, 180);
		bloc8 = new Bloc(3500, 160);
		bloc9 = new Bloc(3550, 140);
		bloc10 = new Bloc(4000, 170);
		bloc11 = new Bloc(4200, 200);
		bloc12 = new Bloc(4300, 210);
		
		
		piece1 = new Piece(402, 145);
		piece2 = new Piece(1202, 140);
		piece3 = new Piece(1272, 95);
		piece4 = new Piece(1342, 40);
		piece5 = new Piece(1650, 145);
		piece6 = new Piece(2650, 145);
		piece7 = new Piece(3000, 135);
		piece8 = new Piece(3400, 125);
		piece9 = new Piece(4200, 145);
		piece10 = new Piece(4600, 40);
		
		
		champ1 = new Champi(800, 263);
		champ2 = new Champi(1100, 263);
		champ3 = new Champi(2100, 263);
		champ4 = new Champi(2400, 263);
	
		
		tortue1 = new Tortue(950, 243);
		tortue2 = new Tortue(1500, 243);
		tortue3 = new Tortue(3100, 243);
		
		
		
		 tabObjets = new ArrayList<Objet>();	
			this.tabObjets.add(this.tuyauRouge1);
			this.tabObjets.add(this.tuyauRouge2);
			this.tabObjets.add(this.tuyauRouge3);
			this.tabObjets.add(this.tuyauRouge4);
			this.tabObjets.add(this.tuyauRouge5);
			this.tabObjets.add(this.tuyauRouge6);
			this.tabObjets.add(this.tuyauRouge7);
			this.tabObjets.add(this.tuyauRouge8);
			
			this.tabObjets.add(this.bloc1);
			this.tabObjets.add(this.bloc2);
			this.tabObjets.add(this.bloc3);
			this.tabObjets.add(this.bloc4);
			this.tabObjets.add(this.bloc5);
			this.tabObjets.add(this.bloc6);
			this.tabObjets.add(this.bloc7);
			this.tabObjets.add(this.bloc8);
			this.tabObjets.add(this.bloc9);
			this.tabObjets.add(this.bloc10);
			this.tabObjets.add(this.bloc11);
			this.tabObjets.add(this.bloc12);
		
	
			
		tabPieces = new ArrayList<Piece>();			
			this.tabPieces.add(this.piece1);
			this.tabPieces.add(this.piece2);
			this.tabPieces.add(this.piece3);
			this.tabPieces.add(this.piece4);
			this.tabPieces.add(this.piece5);
			this.tabPieces.add(this.piece6);
			this.tabPieces.add(this.piece7);
			this.tabPieces.add(this.piece8);
			this.tabPieces.add(this.piece9);
			this.tabPieces.add(this.piece10);
		
		
		
		
			tabChamps = new ArrayList<Champi>();	
			this.tabChamps.add(this.champ1);
			this.tabChamps.add(this.champ2);
			this.tabChamps.add(this.champ3);
			this.tabChamps.add(this.champ4);
			
			
			tabTortues = new ArrayList<Tortue>();
			this.tabTortues.add(this.tortue1);
			this.tabTortues.add(this.tortue2);
			this.tabTortues.add(this.tortue3);
			
			
			
			
		
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
	

	
	
	
	public void deplacementFond() { // Deplacement du fond lorsque mario se d�place
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
 		for(int i = 0; i < this.tabObjets.size(); i++){this.tabObjets.get(i).deplacement();}
 		for(int i = 0; i < this.tabChamps.size(); i++){this.tabChamps.get(i).deplacement();}
 		for(int i = 0; i < this.tabTortues.size(); i++){this.tabTortues.get(i).deplacement();}
 		for(int i = 0; i < this.tabPieces.size(); i++){this.tabPieces.get(i).deplacement();}
	}
	
	private boolean partieGagnee(){		
			if((this.mario.isVivant())&&(this.xPos > 4400)){
						if(this.ok == true){
							this.ok = false;
						}
						return true;
					}else{return false;}				
	}
	
	private boolean partiePerdue(){
		if(this.mario.isVivant() == false){return true;}
		else{return false;}
	}
		
	public boolean finDePartie(){
		if(this.partieGagnee() == true || this.partiePerdue() == true){ return true;}
		else{return false;}
	}
	
	
	


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
 		Graphics g2 = (Graphics2D) g; // Graphics2D donne un meilleur rendu graphique		
 
 		// Detections des contacts avec des objets
 		for(int i = 0; i < this.tabObjets.size(); i++){
 		    // mario
 		    if(this.mario.proche(this.tabObjets.get(i))){this.mario.contact(this.tabObjets.get(i));}
 		    // champignons
 		    
 		    for(int j = 0; j < this.tabChamps.size(); j++){
 			  if(this.tabChamps.get(j).proche(this.tabObjets.get(i))){this.tabChamps.get(j).contact(this.tabObjets.get(i));} 
 		    }
 		    // tortues
 		    for(int j = 0; j < this.tabTortues.size(); j++){
 			  if(this.tabTortues.get(j).proche(this.tabObjets.get(i))){this.tabTortues.get(j).contact(this.tabObjets.get(i));} 
 			  }
 			  
 		    
 		}
 		
 	    // Detections des contacts des champignons avec les personnages (hors mario)
 		
 		for(int i = 0; i < this.tabChamps.size(); i++){ 
 			// champignons
 			for(int j = 0; j < this.tabChamps.size(); j++){
 				if(j != i){ 					 				
 	 			  if(this.tabChamps.get(j).proche(this.tabChamps.get(i))){this.tabChamps.get(j).contact(this.tabChamps.get(i));}
 				}
 	 		}
 			// tortues
 			for(int j = 0; j < this.tabTortues.size(); j++){
	 		    if(this.tabTortues.get(j).proche(this.tabChamps.get(i))){this.tabTortues.get(j).contact(this.tabChamps.get(i));}
	 		}
 		}

 	    // Detections des contacts des tortues avec les personnages (hors mario)
 	 	for(int i = 0; i < this.tabTortues.size(); i++){  
 	 	    // champignons
 	 		for(int j = 0; j < this.tabChamps.size(); j++){
 	 	 	    if(this.tabChamps.get(j).proche(this.tabTortues.get(i))){this.tabChamps.get(j).contact(this.tabTortues.get(i));} 
 	 	 	}
 	 	    // tortues
 	 		for(int j = 0; j < this.tabTortues.size(); j++){
 				if(j != i){
 		 		    if(this.tabTortues.get(j).proche(this.tabTortues.get(i))){this.tabTortues.get(j).contact(this.tabTortues.get(i));} 
 				}
 			}
 	 	}    
 	 	
 	 	// Detection des contacts de mario avec des personnages
 	 	for(int i = 0; i < this.tabChamps.size(); i++){ 
 			if(this.mario.proche(this.tabChamps.get(i)) && this.tabChamps.get(i).isVivant() == true){
 				this.mario.contact(this.tabChamps.get(i));
 				}	 			  				
 			}
 	 	
 	 	for(int i=0; i < this.tabTortues.size(); i++){
 	 		if(this.mario.proche(this.tabTortues.get(i)) && this.tabTortues.get(i).isVivant() == true){
 	 			this.mario.contact(this.tabTortues.get(i));
 	 			}	 				 	 			 	 		
 	 		}
 	 	
 	 	
    	// Detection des contacts de mario avec des pieces
 	 	for(int i = 0; i < this.tabPieces.size(); i++){
 	 	    if(this.mario.proche(this.tabPieces.get(i))){
 	 	        if(this.mario.contactPiece(this.tabPieces.get(i))){
 	 	            this.tabPieces.remove(i);
 	 	            this.score.setNbrePieces(this.score.getNbrePieces() + 1);
 	 	            i--; //  on recule pour ne rien sauter
 	 	        }
 	 	    }
 	 	}
 	 	
 		// Deplacement de tous les objets "fixes" du jeu et des personnages (hors mario)
 		this.deplacementFond();
 		
 	    // Image de fond
 		g2.drawImage(this.imgFond1, this.xFond, 0, null);
 		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
 		// Image du chateau du depart
 		g2.drawImage(imgChateau, 10 - this.xPos, 95, null);
 		// Image du panneau de d�part
 		g2.drawImage(imgDepart, 220 - this.xPos, 234, null); 
 		// Image du drapeau d'arrivee
 		g2.drawImage(imgDrapeau, 4650 - this.xPos, 115, null);
 		// Image du chateau d'arrivee
	  	g2.drawImage(imgChateauFin, 5000 - this.xPos, 145, null);
 		
 		// Images des objets
 		for(int i = 0; i < this.tabObjets.size(); i++){
 			g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
 		}
 				
 		// Images des champignons
 		
 		for(int i = 0; i < this.tabChamps.size(); i++){
 		    if(this.tabChamps.get(i).isVivant() == true){
 		        g2.drawImage(this.tabChamps.get(i).marche("champ", 45), this.tabChamps.get(i).getX(), this.tabChamps.get(i).getY(), null);
 		    }else{
 		        g2.drawImage(this.tabChamps.get(i).meurt(), this.tabChamps.get(i).getX(), this.tabChamps.get(i).getY() + 20, null);
 		        if(this.tabChamps.get(i).getCompteur() > 100){
 		            this.tabChamps.remove(i);
 		            i--; 
 		        }
 		    }
 		} 		
 	    // Images des tortues
 	// Images des tortues
 		for(int i = 0; i < this.tabTortues.size(); i++){
 		    if(this.tabTortues.get(i).isVivant() == true){
 		        g2.drawImage(this.tabTortues.get(i).marche("tortue", 50), this.tabTortues.get(i).getX(), this.tabTortues.get(i).getY(), null);
 		    }else{
 		        g2.drawImage(this.tabTortues.get(i).meurt(), this.tabTortues.get(i).getX(), this.tabTortues.get(i).getY() + 30, null);
 		        if(this.tabTortues.get(i).getCompteur() > 100){
 		            this.tabTortues.remove(i);
 		            i--; // on recule pour ne pas sauter l'élément suivant
 		        }
 		    }
 		}
 		
 		// Images des pieces
 		for(int i = 0; i < this.tabPieces.size(); i++){
 			g2.drawImage(this.tabPieces.get(i).getImgObjet(), this.tabPieces.get(i).getX(), this.tabPieces.get(i).getY(), null);
 		}
 		
 		// Image de mario
 		if(Main.scene.mario.isVivant() == true){
 		    if(this.mario.isSaut()){g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);}
 		    else{g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);}
 		}else{g2.drawImage(this.mario.meurt(), this.mario.getX(), this.mario.getY(), null);}
 				 
	    
	    // Mise a jour du score
	    g2.drawString(this.score.getNbrePieces() + " pièce(s) trouvée(s) sur " + this.score.getNBRE_TOTAL_PIECES(), 460, 25);
	    
	    // Fin de partie
	    if(this.finDePartie() == true){
	    	Font policeFin = new Font("Arial", Font.BOLD, 50);
            g2.setFont(policeFin);
	        if(this.partieGagnee() == true){g2.drawString("Vous avez gagné !!", 120, 180);}
	        else{g2.drawString("Vous avez perdu...", 120, 180);}
 	    }
 	}


	
	
	
	
	

}
