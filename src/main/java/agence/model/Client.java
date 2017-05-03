package agence.model;

public abstract class Client {

	private int idClient;
	private String nom;
	private String prenom;
	private String numTel;
	private int numFax;
	private String eMail;
	private int siret;
	private int idAdd;
	private int idLog;
	
	 public Client(int idClient)
	    {
	        this.idClient = idClient;
	    }
	 public Client()
	    {
	    }

	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public int getNumFax() {
		return numFax;
	}
	public void setNumFax(int numFax) {
		this.numFax = numFax;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public int getSiret() {
		return siret;
	}
	public void setSiret(int siret) {
		this.siret = siret;
	}
	public int getIdAdd() {
		return idAdd;
	}
	public void setIdAdd(int idAdd) {
		this.idAdd = idAdd;
	}
	public int getIdLog() {
		return idLog;
	}
	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}
	
}
