package be.Casani.DAO;

import java.sql.Connection;
import java.util.List;

//Classe DAO générique servant de base aux autres classes DAO et s'adaptant à l'Objet qu'elles traitent
//Les méthodes (prototypes) contenues dans cette classe sont abstraites et redéfinies dans les classes qui héritent de celle-ci
public abstract class DAO<T> {
	
    //protected Connection connection = null;
    protected static Connection connection;

    public DAO(){
    	connection = DBConnection.getInstance();
    }
    
    //Permet de créer un enregistrement dans la base de données avec les valeurs des attributs de l'Objet
    //ENTRÉE : L'Objet à ajouter dans la base de données
    //SORTIE : "true" si la méthode s'est déroulée sans encombre, "false" sinon
    public abstract boolean creer(T obj); 
    
    //Permet de trouver l'enregistrement dans la base de données pour récupérer les valeurs des attributs de l'Objet correspondant
    //ENTRÉE : Identifiant de l'Objet à chercher dans la base de données
    //SORTIE : L'Objet trouvé
    public abstract T rechercher(long id);
    
    //Permet de modifier l'enregistrement dans la base de données pour mettre à jour ses valeurs pour qu'elle correspondent à l'Objet
    //ENTRÉE : L'Objet à modifier dans la base de données
    //SORTIE : "true" si la méthode s'est déroulée sans encombre, "false" sinon
    public abstract boolean modifier(T obj);
    
    //Permet de supprimer l'enregistrement dans la base de données correspondant à l'Objet
    //ENTRÉE : L'Objet à supprimer de la base de données
    //SORTIE : "true" si la méthode s'est déroulée sans encombre, "false" sinon
    public abstract boolean supprimer(T obj);
   
    //Permet de récupérer tous les enregistrements de la base de données pour le type d'Objet dans une liste
    //ENTRÉE : Rien
    //SORTIE : Une liste contenant tous les objets construits en se servant des enregistrements contenus dans la base de données
    public abstract List<T> lister(); 
}