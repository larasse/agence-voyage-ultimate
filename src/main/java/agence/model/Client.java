package agence.model;

import java.util.List;

public abstract class Client {

	/*
	 * id du client
	 */
	private int idClient;
	
	/*
	 * Nom du client
	 */
	private String nom;
	/*
	 * numero de telephone du client
	 */
	private String numeroTel;
	/*
	 * numero de fax du client
	 */
	private String numeroFax;
	/*
	 * email du client
	 */
	private String email;
	/*
	 * adresse du client
	 */
	private Adresse adresse;
	/*
	 * login du client
	 */
	private Login login;
	
	/*
	 * Reservations du client
	 */
	private List<Reservation> listReservations;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", numeroTel=" + numeroTel + ", numeroFax=" + numeroFax
				+ ", email=" + email + ", adresse=" + adresse + ", login=" + login + ", listReservations="
				+ listReservations + "]";
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @return the listReservations
	 */
	public List<Reservation> getListReservations() {
		return listReservations;
	}

	/**
	 * @param listReservations the listReservations to set
	 */
	public void setListReservations(List<Reservation> listReservations) {
		this.listReservations = listReservations;
	}

	/**
	 * @param idClient
	 */
	public Client(int idClient) {
		this.idClient = idClient;
	}
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idClient
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the numeroTel
	 */
	public String getNumeroTel() {
		return numeroTel;
	}

	/**
	 * @param numeroTel the numeroTel to set
	 */
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	/**
	 * @return the numeroFax
	 */
	public String getNumeroFax() {
		return numeroFax;
	}

	/**
	 * @param numeroFax the numeroFax to set
	 */
	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	

		
}
