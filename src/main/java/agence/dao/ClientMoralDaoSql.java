package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import agence.model.Client;
import agence.model.ClientMoral;
import agence.model.ClientPhysique;

public class ClientMoralDaoSql implements ClientDao {

	private AdresseDao adresseDao = new AdresseDaoSql();
	private LoginDao loginDao = new LoginDaoSql();
	private ReservationDao reservationDao = new ReservationDaoSql();
	
	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub

		// Initialiser ma liste de clients
		List<Client> listeClients = new ArrayList<>();
		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * Etape 1 : se connecter à la BDD
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");

			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM client WHERE siret IS NOT NULL");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet client
				Client clientMoral = new ClientMoral(resultSet.getString("siret"));
				// appel des mutateurs
				clientMoral.setIdClient(resultSet.getInt("idClient"));
				clientMoral.setNom(resultSet.getString("nom"));
				clientMoral.setNumeroTel(resultSet.getString("numTel"));
				clientMoral.setNumeroFax(resultSet.getString("numFax"));
				clientMoral.setEmail(resultSet.getString("eMail"));

				clientMoral.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));
				clientMoral.setLogin(loginDao.findById(resultSet.getInt("idLog")));

				clientMoral.setListReservations(reservationDao.findByClient(clientMoral));
				// j'ajoute l'objet client ainsi muté à la liste des passagers
				listeClients.add(clientMoral);
			}

			/*
			 * Etape 5 : je ferme la connexion à la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// Je retourne la liste des clients de la BDDonnéys
		return listeClients;
	}

	@Override
	public Client findById(Integer id) {
		// TODO Auto-generated method stub

		// Initialiser mon client
		Client clientMoral = null;
		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * Etape 1 : se connecter à la BDD
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");

			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM client WHERE siret IS NOT NULL AND idClient = " + id);

			/*
			 * Etape 4 : Parcours des résultats
			 */
			if (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet client
				clientMoral = new ClientMoral(resultSet.getString("siret"));
				// appel des mutateurs
				clientMoral.setIdClient(resultSet.getInt("idClient"));
				clientMoral.setNom(resultSet.getString("nom"));

				clientMoral.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));
				clientMoral.setLogin(loginDao.findById(resultSet.getInt("idLog")));

				clientMoral.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));
				clientMoral.setLogin(loginDao.findById(resultSet.getInt("idLog")));

				clientMoral.setListReservations(reservationDao.findByClient(clientMoral));
			}
			/*
			 * Etape 5 : je ferme la connexion à la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// Je retourne l'objet métier
		return clientMoral;
	}

}
