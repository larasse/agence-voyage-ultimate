/**
 * 
 */
package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import agence.model.Adresse;
import agence.model.Passager;

/**
 * @author Seme
 */
public class PassagerDaoSql extends DaoSQL implements PassagerDao
{
    AdresseDao adresseDao = new AdresseDaoSql();

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findAll()
     */
    @Override
    public List<Passager> findAll()
    {
        // Initialiser ma liste de passagers
        List<Passager> listePassagers = new ArrayList<>();
        try
        {
            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM passager");

            /*
             * Etape 4 : Parcours des résultats
             */
            while (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet passager
                Passager passager = new Passager();
                // appel des mutateurs
                passager.setIdPas(resultSet.getInt("idPassager"));
                passager.setNom(resultSet.getString("nom"));
                passager.setPrenom(resultSet.getString("prenom"));
                passager.setAdresse(
                        adresseDao.findById(resultSet.getInt("idAdd")));
                // j'ajoute l'objet passager ainsi muté à la liste des passagers
                listePassagers.add(passager);
            }

        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // Je retourne la liste des passagers de la BDDonnéys
        return listePassagers;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findById(java.lang.Object)
     */
    @Override
    public Passager findById(Integer id)
    {
        // Initialiser mon passager
        Passager passager = null;
        try
        {
            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM passager WHERE idPassager = " + id);

            /*
             * Etape 4 : Parcours des résultats
             */
            if (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet métier
                passager = new Passager();
                // appel des mutateurs
                passager.setIdPas(resultSet.getInt("idPassager"));
                passager.setNom(resultSet.getString("nom"));
                passager.setPrenom(resultSet.getString("prenom"));
                passager.setAdresse(
                        adresseDao.findById(resultSet.getInt("idAdd")));
            }

        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // Je retourne l'objet métier
        return passager;
    }

	@Override
	public void create(Passager passager) {
		// TODO Auto-generated method stub
				Connection conn = null;
				 try
			        {
			            Class.forName("com.mysql.jdbc.Driver");
			            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

			            PreparedStatement ps = conn
			                    .prepareStatement("insert into passager (idPassager,nom,prenom,idAdd) VALUES(?,?,?,?)");
			            ps.setInt(1, passager.getIdPas());
			            ps.setString(2, passager.getNom());
			            ps.setString(3, passager.getPrenom());
			            ps.setInt(4, passager.getAdresse().getIdAdd());
			            ps.executeUpdate();
			        }
			            catch (ClassNotFoundException e)
				        {
				            e.printStackTrace();
				        }
				        catch (SQLException e)
				        {
				            e.printStackTrace();
				        }
				        finally
				        {
				            try
				            {
				                conn.close();
				            }
				            catch (SQLException e)
				            {
				                e.printStackTrace();
				            }
				        }
				    }


	@Override
	public Passager update(Passager passager) {
		// TODO Auto-generated method stub
		  Connection conn = null;
		    try
		    {
		        Class.forName("com.mysql.jdbc.Driver");
		        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

		        PreparedStatement ps = conn
		                .prepareStatement("update passager set nom=?,prenom=?, idAdd=? where idPassager = ?");

		        
		        
	            ps.setString(1, passager.getNom());
	            ps.setString(2, passager.getPrenom());
	            ps.setInt(3, passager.getAdresse().getIdAdd());
	            ps.setInt(4, passager.getIdPas());
	            ps.executeUpdate();
		    }
		    catch (ClassNotFoundException e)
		    {
		        e.printStackTrace();
		    }
		    catch (SQLException e)
		    {
		        e.printStackTrace();
		    }
		    finally
		    {
		        try
		        {
		            conn.close();
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		    }

		    return passager;
		}
	

	@Override
	public void delete(Passager passager) {
		// TODO Auto-generated method stub
				Connection conn = null;
			    try
			    {
			        Class.forName("com.mysql.jdbc.Driver");
			        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

			        PreparedStatement ps = conn.prepareStatement("delete from login where idPassager = ?");

			        ps.setInt(1, passager.getIdPas());
			        ps.executeUpdate();

			    }
			    catch (ClassNotFoundException e)
			    {
			        e.printStackTrace();
			    }
			    catch (SQLException e)
			    {
			        e.printStackTrace();
			    }
			    finally
			    {
			        try
			        {
			            conn.close();
			        }
			        catch (SQLException e)
			        {
			            e.printStackTrace();

			       }
			        
			}
			    
			 
			    }

		}