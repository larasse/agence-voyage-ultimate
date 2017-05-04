/**
 * 
 */
package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import agence.model.Client;
import agence.model.ClientPhysique;

/**
 * @author Seme
 */
public class ClientPhysiqueDaoSql extends ClientDaoSql
{
    public List<Client> findAll()
    {
        // Liste des clients que l'on va retourner
        List<Client> listeClients = new ArrayList<Client>();
        AdresseDaoSql adresseDAO = new AdresseDaoSql();
        LoginDaoSql loginDAO = new LoginDaoSql();

        try
        {

            /*
             * Connexion à la BDD
             */
            PreparedStatement ps = connexion.prepareStatement(
                    "SELECT * FROM client WHERE siret IS NULL");

            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet Client
                Client objClient = new ClientPhysique(tuple.getInt("idClient"));

                objClient.setNom(tuple.getString("nom"));
                ((ClientPhysique) objClient)
                        .setPrenom(tuple.getString("prenom"));
                objClient.setNumeroTel(tuple.getString("numTel"));
                objClient.setNumeroFax(tuple.getString("numFax"));
                objClient.setEmail(tuple.getString("eMail"));

                objClient
                        .setAdresse(adresseDAO.findById(tuple.getInt("idAdd")));
                objClient.setLogin(loginDAO.findById(tuple.getInt("idLog")));

                // Ajout du nouvel objet Client créé à la liste des clients
                listeClients.add(objClient);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de toutes les clients
        return listeClients;
    }

    @Override
    public Client findById(Integer idCli)
    {
        // Déclaration d'un objet Client
        Client objClient = null;
        AdresseDaoSql adresseDAO = new AdresseDaoSql();
        LoginDaoSql loginDAO = new LoginDaoSql();

        try
        {
            // Connexion à la BDD
            PreparedStatement ps = connexion.prepareStatement(
                    "SELECT * FROM client WHERE idClient=? AND siret IS NULL");
            // Cherche l'idVill voulu dans la BDD
            ps.setInt(1, idCli);

            // Récupération des résultats de la requête
            ResultSet tuple = ps.executeQuery();

            if (tuple.next())
            {
                objClient = new ClientPhysique(tuple.getInt("idClient"));
                objClient.setNom(tuple.getString("nom"));
                ((ClientPhysique) objClient)
                        .setPrenom(tuple.getString("prenom"));
                objClient.setNumeroTel(tuple.getString("numTel"));
                objClient.setNumeroFax(tuple.getString("numFax"));
                objClient.setEmail(tuple.getString("eMail"));

                objClient
                        .setAdresse(adresseDAO.findById(tuple.getInt("idAdd")));
                objClient.setLogin(loginDAO.findById(tuple.getInt("idLog")));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return objClient;
    }

	@Override
	public void create(Client client) {
		// TODO Auto-generated method stub
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

            PreparedStatement ps = conn
                    .prepareStatement("insert into client (idClient,nom,prenom,numtel,numfax,email,idAdd, idLog) VALUES(?,?,?,?,?,?,?,?)");
            ps.setInt(1, client.getIdCli());
            ps.setString(2, client.getNom());
            ps.setString(3, ((ClientPhysique) client).getPrenom());
            ps.setString(4, client.getNumeroTel());
            ps.setString(5, client.getNumeroFax());
            ps.setString(6, client.getEmail());
            ps.setInt(7, client.getAdresse().getIdAdd());
            
            if(client.getLogin() != null){
            	ps.setInt(8, client.getLogin().getIdLog());
            }
           
            else {
				ps.setNull(8, java.sql.Types.BIGINT);
			}
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
	public Client update(Client client) {
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

            PreparedStatement ps = conn
                    .prepareStatement("update client set nom=?,prenom=?,numtel=?, numfax=?,email=?,idAdd=? where idClient = ?");
            
            ps.setInt(7, client.getIdCli());
            
            ps.setString(1, client.getNom());
            ps.setString(2, ((ClientPhysique) client).getPrenom());
            ps.setString(3, client.getNumeroTel());
            ps.setString(4, client.getNumeroFax());
            ps.setString(5, client.getEmail());
            ps.setInt(6, client.getAdresse().getIdAdd());
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

        return client;		
	}

	@Override
	public void delete(Client client) {
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

            PreparedStatement ps = conn.prepareStatement("delete from client where idClient = ?");

            ps.setInt(1, client.getIdCli());
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
