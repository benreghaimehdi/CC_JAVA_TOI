package filesys;

import java.util.ArrayList;

/**
 * La classe fichier
 * 
 * @author BENREGHAI && DIMA
 * @version 
 */
public class fichier extends Racine
{
    // instance variables - replace the example below with your own
   private int taille;

    /**
     * Constructor for objects of class fichier
     */
    public fichier(String nom, int taille) throws FichierTailleException, FichierNullException
    {
        // initialise instance variables
        super.setNom(nom);
        if (taille<0)
        {
        	throw new FichierTailleException("La taille est negative");
        }
        if(this== null)
        {
        	throw new FichierNullException("La reference est null");
        }
        this.taille=taille;
    }
    @Override
    public int getTaille()
    {
    return this.taille;
    }
    public void setTaille(int taille)
    {
    this.taille=taille;
    }
    
    @Override
    public String consulter()
    {
    String str= super.getNom();
    str+=" "+taille;
    return str;
    }
	@Override
	public ArrayList<Racine> getContenu() {
		// TODO Auto-generated method stub
		return null;
	}
}

