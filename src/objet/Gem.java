package objet;

import javax.swing.ImageIcon;

public class Gem extends Objet{
	
	
	
	
	
	public Gem(int x, int y)
	{
		super(x, y, 30, 30);
		
		super.icoObjet=new ImageIcon(getClass().getResource("/images/gem.png"));
		super.imgObjet=this.icoObjet.getImage();
		
		
		
		
	}

}
