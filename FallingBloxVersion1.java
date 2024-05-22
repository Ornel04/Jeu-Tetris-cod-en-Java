/**
 * 
 */
package fr.eseo.e3.poo.projet.blox;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

/**
 * 
 */
public class FallingBloxVersion1 {
	/**
	 * @param args
	 */
	private FallingBloxVersion1() {} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame fenetre = new JFrame();
		fenetre.setTitle("Falling Blox");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(true);

		int nbElements;
		int nbLignes;
		Tas tas;
		Puits puits = new Puits();

		switch (args.length) {
		case 1:
			nbElements = Integer.parseInt(args[0]);
			tas = new Tas(puits, nbElements); 
			puits.setTas(tas);
			break; 
		case 2:
			nbElements = Integer.parseInt(args[0]);
			nbLignes = Integer.parseInt(args[1]);
			tas = new Tas(puits, nbElements, nbLignes);
			puits.setTas(tas);
		default:
			break;
		} 

		UsineDePiece.setMode(UsineDePiece.CYCLIC);

		VuePuits vuePuits = new VuePuits(puits);
		@SuppressWarnings("unused")
		Gravite gravite = new Gravite(vuePuits);
		PanneauInformation panneauInformation = new PanneauInformation(puits);

		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.setPieceSuivante(UsineDePiece.genererTetromino());

		JPanel plateau = new JPanel(new BorderLayout());
		plateau.add(vuePuits, BorderLayout.CENTER);
		plateau.add(panneauInformation, BorderLayout.EAST);

		fenetre.setContentPane(plateau);
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);

	}
}
