/**
 * 
 */
package agence;

import java.util.List;
import java.util.Scanner;

import agence.dao.AdresseDao;
import agence.dao.AdresseDaoSql;
import agence.dao.ClientDao;
import agence.dao.ClientMoralDaoSql;
import agence.dao.ClientPhysiqueDaoSql;
import agence.dao.PassagerDao;
import agence.dao.PassagerDaoSql;
import agence.dao.ReservationDao;
import agence.dao.ReservationDaoSql;
import agence.model.Adresse;
import agence.model.Client;
import agence.model.Passager;
import agence.model.Reservation;

/**
 * Classe principale de test de récupération de données via la BDD
 * 
 * @author Seme
 */
public class MainDB
{

    /**
     * Méthode principale qui va faire appel à toutes les méthodes de
     * récupération
     * de mes DAO SQL :
     * - findAll
     * - findById
     * 
     * @param args
     *            Arguments passés en paramètres d'entrée
     */
    public static void main(String[] args)
    {
    	Scanner scanner = new Scanner(System.in);
        // J'instancie le dao SQL des adresses

        AdresseDao adresseDao = new AdresseDaoSql();
        // J'appelle la méthode findAll pour récupérer toutes les adresses
        // stockées en BDD
    	System.out.println("Test 1 : On recupere toutes les adresses dans la BDD");
        List<Adresse> listeAdresses = adresseDao.findAll();
        System.out.println(listeAdresses);
        System.out.println("Appuyez sur une touche pour continuer");
        scanner.nextLine();

        
        System.out.println("Test 2 : On recupere l'adresse avec l'identifiant #1 dans la BDD");
        Adresse adresse = adresseDao.findById(1);
        System.out.println(adresse);
        System.out.println("Appuyez sur une touche pour continuer");
        scanner.nextLine();
        
        // J'instancie le dao SQL de l'objet métier à récupérer
        PassagerDao passagerDao = new PassagerDaoSql();
        // J'appelle la méthode findAll pour récupérer tous les BO de ce type de
        // la BDD
        System.out.println("Test 3 : On recupere tous les passagers dans la BDD");
        List<Passager> listePassagers = passagerDao.findAll();
        System.out.println(listePassagers);
        System.out.println("Appuyez sur une touche pour continuer");
        scanner.nextLine();       
        
        System.out.println("Test 4 : On recupere le passager avec l'identifiant #1 dans la BDD");
        Passager passager = passagerDao.findById(1);
        System.out.println(passager);
        System.out.println("Appuyez sur une touche pour continuer");
        scanner.nextLine();
        
        // J'instancie le dao SQL de l'objet métier à récupérer
        ReservationDao reservationDao = new ReservationDaoSql();
        // J'appelle la méthode findAll pour récupérer tous les BO de ce type de
        // la BDD
        
        System.out.println("Test 5 : On recupere toutes les reservations dans la BDD");
        List<Reservation> listeReservations = reservationDao.findAll();
        System.out.println(listeReservations);
        System.out.println("Appuyez sur une touche pour continuer");
        scanner.nextLine();

        System.out.println("Test 6 : On recupere la reservation avec l'identifiant #10 dans la BDD");
        Reservation reservation = reservationDao.findById(10);
        System.out.println(reservation);
        System.out.println("Appuyez sur une touche pour continuer");
        scanner.nextLine();
        
        System.out.println("Test 7 : On recupere les reservations liees avec le passager #1 dans la BDD");
        listeReservations = reservationDao.findByPassager(passager);
        System.out.println(listeReservations);
        System.out.println("Appuyez sur une touche pour continuer");
        scanner.nextLine();
        
        ClientDao clientPhysiqueDao = new ClientPhysiqueDaoSql();
        ClientDao clientMoralDao = new ClientMoralDaoSql();
        

        List<Client> clientsMoraux = clientMoralDao.findAll();
        
        Client clientPhysique = clientPhysiqueDao.findById(50);
        
        System.out.println("Test 8 : On recupere tous les clients moraux");
        System.out.println(clientsMoraux);
        System.out.println("Appuyez sur une touche pour continuer");
        scanner.nextLine();
        
        System.out.println("Test 9 : On recupere le client physique #50");
        System.out.println(clientPhysique);
        System.out.println("Appuyez sur une touche pour continuer");
        scanner.nextLine();
        scanner.close();

        System.out.println("Fin de tests");
    }

}
