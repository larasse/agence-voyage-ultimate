package agence.model;

public class ClientPhysique extends Client {

	private String prenom;

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public ClientPhysique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientPhysique(int idClient) {
		super(idClient);
		// TODO Auto-generated constructor stub
	} 
	public ClientPhysique(String prenom) {
		
		// TODO Auto-generated constructor stub
	} 
}
