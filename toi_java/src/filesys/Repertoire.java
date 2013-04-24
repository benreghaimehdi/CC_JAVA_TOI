package filesys;

import java.util.List ;
import java.util.ArrayList ;
/**
 * la classe Repertoire.
 * 
 * @author BENREGHAI && DIMA 
 * @version 
 */
public class Repertoire extends Racine
{
	private ArrayList<Racine> contenu = new ArrayList<Racine>();
    private String nom;
    private List<Racine> liste;
    /**
     * Constructeur des objects de la classe Repertoire
     */
    public Repertoire(String nom)
        {
            super.setNom(nom);
            this.liste=new ArrayList<Racine>();
        }
    public void add(Racine racine) throws NomExistePasException, IsInHimselfException
    {
    	
    	if (nomExistePas(racine.getNom())== false)
    	{
    		throw new NomExistePasException("On ne peut pas ajouter dans un répertoire un élément qui a le même nom qu'un élément déjà dans le répertoire");
    	}
    	if (isInHimself(racine))
    	{
    		throw new IsInHimselfException("Un répertoire ne peut pas être un sous-répertoire de lui-même");

    	}
    	
     contenu.add(racine);
    }
    /**
     * Retourne "true" si le repertoire est un sous-répertoire de lui-même
     * @return booleen indiquant si le repertoire est dans lui-meme ou non
     */
    public boolean isInHimself(Racine racine)
    {
    	Repertoire r = null;
    	boolean res=false;
    	
    	if (racine.getType().equals("R"))
    	{
    		r = (Repertoire) racine;
    		if (r.equals(this))
    		{
    			res=true;
    		}
    		else
    		{
    			for (Racine racine2 : racine.getContenu())
    			{
    				if (isInHimself(racine2))
    					res=true;
    			}
    		}
    	}
    	
    	
    	return res;
    }
    
    /**
     * Methode retournant true si le nom en parametre est celui d'une Entite presente dans le repertoire
     * @return boolen indiquant si le nom est deja existant ou non
     */
    public boolean nomExistePas(String nom)
    {
    	boolean b = true;
    	for (Racine racine : contenu)
    	{
    		if(nom.equals(racine.getNom()))
    			b = false;
    	}
    	
    	return b;
    }
    /**
     * Retourne la taille totale des fichiers et repertoires contenus dans ce repertoire
     * @return la taille du repertoire
     */
    public int getTaille()
    {
       int taille=0; 

       for(Racine racine : contenu)
       {
       taille+=racine.getTaille(); 
       }
        
       return taille;
    }

    public void AjouterFichier(Racine entite)
        {
            liste.add(entite);
        }
    /*@Override
    public int getTaille()
        {
            int tailleRep=0;
            for(Racine entite:liste)
            {
            tailleRep+=entite.getTaille();
            }
            return tailleRep;
        }*/
    @Override
    public String consulter()
    {
        String str=super.getNom();
        return str;
    }
    public String Arborescence()
        {
            String str="Voici la liste des fichiers / sous repertoires de ce repertoire \n";
            for(Racine entite:liste)
                {
                    str+=" "+entite.consulter()+" "+entite.getTaille()+" ";
                }
                return str;
        }
    public ArrayList<Racine> getContenu()
    {
    	return contenu;
    }
    
}
