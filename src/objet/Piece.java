package objet;

import javax.swing.ImageIcon;

public class Piece extends Objet{
	
	
	
	
	
	public Piece(int x,int y)
	{
		super(x, y, 30, 30);
		
		super.icoObjet=new ImageIcon(getClass().getResource("/images/piece1.png"));
		super.imgObjet=this.icoObjet.getImage();
		
		
		
		
	}

}
