package agence;

import java.util.List;

import agence.dao.LoginDao;
import agence.dao.LoginDaoSql;
import agence.model.Adresse;
import agence.model.Login;

//Test de Rapahel
public class MainRaphael {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginDao loginDao = new LoginDaoSql();
        // J'appelle la méthode findAll pour récupérer toutes les adresses
        // stockées en BDD
        List<Login> listeLogin = loginDao.findAll();
        Login login = loginDao.findById(1);
        System.out.println(listeLogin);
	}

}
