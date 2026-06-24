package objet;



import javax.swing.ImageIcon;

public class Rock extends Objet {
	
	
	public Rock(int x, int y)
	{
		super(x,y,60,57);
		
		super.icoObjet=new ImageIcon(getClass().getResource("/images/rock.png"));
		super.imgObjet=this.icoObjet.getImage();
		
		
	}




	
	
	
	
	
	
	

}
