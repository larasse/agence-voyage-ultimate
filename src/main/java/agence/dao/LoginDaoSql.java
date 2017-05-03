package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;









import agence.model.Passager;

import agence.model.Adresse;
import agence.model.Login;

public class LoginDaoSql implements LoginDao {

	@Override
	 public List<Login> findAll()
    {
        // Initialiser ma liste d'adresses
        List<Login> listeLogin = new ArrayList<>();
        try
        {
            /*
             * Etape 0 : chargement du pilote
             */
            Class.forName("com.mysql.jdbc.Driver");

            /*
             * Etape 1 : se connecter à la BDD
             */
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/agence", "user", "password");

            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM login");

            /*
             * Etape 4 : Parcours des résultats
             */
            while (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet adresse
                Login login = new Login();
                // appel des mutateurs
                login.setId(resultSet.getInt("id"));
               login.setLogin(resultSet.getString("login"));
                login.setMotDePasse(resultSet.getString("motdepasse"));
                login.setAdmin(resultSet.getInt("admin"));
                
                // j'ajoute l'objet adresse ainsi muté à la liste des adresses
                listeLogin.add(login);
            }

            /*
             * Etape 5 : je ferme la connexion à la BDD
             */
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Impossible de charger le pilote JDBC.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // Je retourne la liste des adresses de la BDDonnéys
        return listeLogin;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findById(java.lang.Object)
     */

	@Override
	public Login findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
