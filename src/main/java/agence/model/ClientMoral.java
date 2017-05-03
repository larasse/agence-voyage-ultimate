package agence.model;

public class ClientMoral extends Client {
	
	private String siret;
	
	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public ClientMoral() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientMoral(int idClient) {
		super(idClient);
		// TODO Auto-generated constructor stub
	}


	
}
