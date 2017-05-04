package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import agence.model.Login;


public class LoginDaoSql extends DaoSQL implements LoginDao
{

    @Override
    public List<Login> findAll()
    {
        // Liste des clients que l'on va retourner
        List<Login> ListLogin = new ArrayList<Login>();

        try
        {

            /*
             * Connexion à la BDD
             */
            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM login");

            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet Client
                Login objLogin = new Login(tuple.getInt("id"));

                objLogin.setLogin(tuple.getString("login"));
                objLogin.setMotDePasse(tuple.getString("motDePasse"));
                objLogin.setAdmin(tuple.getBoolean("admin"));

                // Ajout du nouvel objet Client créé à la liste des clients
                ListLogin.add(objLogin);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de toutes les clients
        return ListLogin;
    }

    @Override
    public Login findById(Integer id)
    {
        // Déclaration d'un objet Client
        Login objLogin = null;

        try
        {
            // Connexion à la BDD
            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM login WHERE id=?");
            // Cherche l'idVill voulu dans la BDD
            ps.setInt(1, id);

            // Récupération des résultats de la requête
            ResultSet tuple = ps.executeQuery();

            if (tuple.next())
            {
                objLogin = new Login(tuple.getInt("id"));
                objLogin.setLogin(tuple.getString("login"));
                objLogin.setMotDePasse(tuple.getString("motDePasse"));
                objLogin.setAdmin(tuple.getBoolean("admin"));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return objLogin;
    }

	@Override
	public void create(Login login) {
		// TODO Auto-generated method stub
		Connection conn = null;
		 try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

	            PreparedStatement ps = conn
	                    .prepareStatement("insert into login (id,login,motDePasse,admin) VALUES(?,?,?,?)");
	            ps.setInt(1, login.getIdLog());
	            ps.setString(2, login.getLogin());
	            ps.setString(3, login.getMotDePasse());
	            ps.setBoolean(4, login.isAdmin());
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
	public Login update(Login login) {
		// TODO Auto-generated method stub
		  Connection conn = null;
		    try
		    {
		        Class.forName("com.mysql.jdbc.Driver");
		        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

		        PreparedStatement ps = conn
		                .prepareStatement("update login set login=?,motDePasse=?,admin=? where id = ?");

		        
	            ps.setString(1, login.getLogin());
	            ps.setString(2, login.getMotDePasse());
	            ps.setBoolean(3, login.isAdmin());
		        ps.setInt(4, login.getIdLog());
		     
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

		    return login;
		}
	

	@Override
	public void delete(Login login) {
		// TODO Auto-generated method stub
		Connection conn = null;
	    try
	    {
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

	        PreparedStatement ps = conn.prepareStatement("delete from login where id = ?");

	        ps.setInt(1, login.getIdLog());
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
