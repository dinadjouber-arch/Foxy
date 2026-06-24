package Jeu;
import javax.swing.*;


public class Main {
	
	
	public static Scene scene;

	public static void main(String[] args) {


		// Message de bienvenue
		    JOptionPane.showMessageDialog(null, "Bienvenue dans Foxy Race !\n\nUtilise les flèches pour avancer et ESPACE pour sauter.\nRamasse toutes les pièces et atteins le drapeau !", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);



		//creation de la fenetre du jeu

			JFrame fenetre=new JFrame("Jeu style Foxy");

			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			fenetre.setSize(700,360);

			fenetre.setLocationRelativeTo(null);

			fenetre.setResizable(false);

			fenetre.setAlwaysOnTop(true);

			

			//objet scene

			scene=new Scene();

			

			

			fenetre.setContentPane(scene);//associer scene a la fenetre

			fenetre.setVisible(true);



		}

	}

