package be.Casani.DAO;

import java.sql.Connection;
import java.util.List;

//Classe DAO g�n�rique servant de base aux autres classes DAO et s'adaptant � l'Objet qu'elles traitent
//Les m�thodes (prototypes) contenues dans cette classe sont abstraites et red�finies dans les classes qui h�ritent de celle-ci
public abstract class DAO<T> {
	
    //protected Connection connection = null;
    protected static Connection connection;

    public DAO(){
    	connection = DBConnection.getInstance();
    }
    
    //Permet de cr�er un enregistrement dans la base de donn�es avec les valeurs des attributs de l'Objet
    //ENTR�E : L'Objet � ajouter dans la base de donn�es
    //SORTIE : "true" si la m�thode s'est d�roul�e sans encombre, "false" sinon
    public abstract boolean creer(T obj); 
    
    //Permet de trouver l'enregistrement dans la base de donn�es pour r�cup�rer les valeurs des attributs de l'Objet correspondant
    //ENTR�E : Identifiant de l'Objet � chercher dans la base de donn�es
    //SORTIE : L'Objet trouv�
    public abstract T rechercher(long id);
    
    //Permet de modifier l'enregistrement dans la base de donn�es pour mettre � jour ses valeurs pour qu'elle correspondent � l'Objet
    //ENTR�E : L'Objet � modifier dans la base de donn�es
    //SORTIE : "true" si la m�thode s'est d�roul�e sans encombre, "false" sinon
    public abstract boolean modifier(T obj);
    
    //Permet de supprimer l'enregistrement dans la base de donn�es correspondant � l'Objet
    //ENTR�E : L'Objet � supprimer de la base de donn�es
    //SORTIE : "true" si la m�thode s'est d�roul�e sans encombre, "false" sinon
    public abstract boolean supprimer(T obj);
   
    //Permet de r�cup�rer tous les enregistrements de la base de donn�es pour le type d'Objet dans une liste
    //ENTR�E : Rien
    //SORTIE : Une liste contenant tous les objets construits en se servant des enregistrements contenus dans la base de donn�es
    public abstract List<T> lister(); 
}