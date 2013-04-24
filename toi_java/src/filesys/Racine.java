package filesys;

import java.util.ArrayList;

/**
 *La classe abstraire mère Racine
 * 
 * @author BENREGHAI && DIMA
 * @version 
 */
public abstract class Racine {
	// instance variables - replace the example below with your own
	private String nom;
	private String type;
	/**
	 * Constructor for objects of class Racine
	 */

	public String getNom() {
		return this.nom;
		
	}
	 public String getType()
	    {
	    	return type;
	    }
	 
	public void setNom(String nom) {
		this.nom = nom;
	}

	public abstract String consulter();

	
    public abstract int getTaille();
    public abstract ArrayList<Racine> getContenu();
	public static void main(String[] args) throws FichierTailleException, FichierNullException {
		Repertoire racine = new Repertoire("repertoire racine");
		Repertoire rep = new Repertoire("un repertoire");
		fichier fichier1 = new fichier("document", 130);
		fichier fichier2 = new fichier("un fichier", 15);
		fichier fichier3 = new fichier("image", 200);

		System.out.println(fichier1.consulter());
		System.out.println(fichier2.consulter());
		System.out.println(fichier3.consulter());

		racine.AjouterFichier(fichier1);
		racine.AjouterFichier(fichier2);
		rep.AjouterFichier(fichier3);
		racine.AjouterFichier(rep);

		System.out.println(racine.consulter() + " " + racine.getTaille());

	}
}
