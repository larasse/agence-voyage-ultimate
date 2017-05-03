package agence.model;

public class ClientPhysique extends Client {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "ClientPhysique [prenom=" + prenom + "]";
	}
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
		this.prenom = prenom;
		// TODO Auto-generated constructor stub
	} 
}
