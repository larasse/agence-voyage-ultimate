package agence.model;

public class Login {

	private int id;
	
	private String login;
	
	private String motDePasse;
	
	private int admin ;
	
	
public int getid(){
return id;

}




public void setId(int id) {
	this.id = id;
}


public String getLogin() {
	return login;
}


 
public void setLogin(String login) {
	this.login = login;
}


public String getMotDePasse() {
	return motDePasse;
}


public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
}


public int getAdmin() {
	return admin;
}


public void setadmin(int admin) {
	this.admin = admin;
}
}