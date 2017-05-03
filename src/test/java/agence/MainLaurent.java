package agence;

import java.util.List;

import agence.dao.AdresseDao;
import agence.dao.AdresseDaoSql;
import agence.dao.ClientDao;
import agence.dao.ClientPhysiqueDaoSql;
import agence.dao.PassagerDao;
import agence.dao.PassagerDaoSql;
import agence.dao.ReservationDao;
import agence.dao.ReservationDaoSql;
import agence.model.Adresse;
import agence.model.Client;
import agence.model.Passager;
import agence.model.Reservation;

//Tests de Laurent
public class MainLaurent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // J'instancie le dao SQL des adresses
        AdresseDao adresseDao = new AdresseDaoSql();
        // J'appelle la méthode findAll pour récupérer toutes les adresses
        // stockées en BDD
        List<Adresse> listeAdresses = adresseDao.findAll();
        Adresse adresse = adresseDao.findById(1);

        // J'instancie le dao SQL de l'objet métier à récupérer
        PassagerDao passagerDao = new PassagerDaoSql();
        // J'appelle la méthode findAll pour récupérer tous les BO de ce type de
        // la BDD
        List<Passager> listePassagers = passagerDao.findAll();
        Passager passager = passagerDao.findById(1);

        // J'instancie le dao SQL de l'objet métier à récupérer
        ReservationDao reservationDao = new ReservationDaoSql();
        // J'appelle la méthode findAll pour récupérer tous les BO de ce type de
        // la BDD
        List<Reservation> listeReservations = reservationDao.findAll();
        Reservation reservation = reservationDao.findById(10);
        listeReservations = reservationDao.findByPassager(passager);
        
        ClientDao clientPhysiqueDao = new ClientPhysiqueDaoSql();
        
        List<Client> clientsPhysiques = clientPhysiqueDao.findAll();
        Client clientPhysique = clientPhysiqueDao.findById(50);
        
        System.out.println(clientsPhysiques);
        System.out.println(clientPhysique);
        
        
	}

}
