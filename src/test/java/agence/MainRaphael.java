package agence;

import java.util.List;
import java.sql.DriverManager;
import agence.dao.LoginDao;
import agence.dao.LoginDaoSql;
import agence.model.Adresse;
import agence.model.Login;
import java.sql.Connection;

//Test de Rapahel
public class MainRaphael {

	public static void main(String[] args) {

		// J'instancie le dao qui va récupérer à ma place les données
		// dans la BDD
		LoginDao loginDao = new LoginDaoSql();
		// Ma liste d'élèves qui va contenir la liste de résultats
		List<Login> listeLogin;
		// je demande au DAO de me trouver tous les élèves de la BDD
		listeLogin = loginDao.findAll();  
		// mettre à jour l'élève n°3, je change sa note
		Login loginAChanger = loginDao.findById(1);
		// je mets à jour au niveau de l'OBJET la note
		loginAChanger.setMotDePasse("j'ai reussi");
		// je mets à jour au niveau BDD !!
		Login loginMisAJour = loginDao.update(loginAChanger);
		// Je supprime l'élève n°5
		Login loginASupprimer = loginDao.findById(2);
		Login login = new Login(3);
		login.setLogin("lolu");
		login.setMotDePasse("yo");
		login.setAdmin(false);
		loginDao.create(login);
		
		 
		loginDao.delete(loginASupprimer);
	}}
		