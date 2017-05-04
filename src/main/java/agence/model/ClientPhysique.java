/**
 * 
 */
package agence.model;

/**
 * @author Seme
 */
public class ClientPhysique extends Client
{
    /**
     * Prénom
     */
    private String prenom;

    /**
	 * @param idCli
	 * @param nom
	 * @param numeroTel
	 * @param numeroFax
	 * @param email
	 * @param prenom
	 */
	public ClientPhysique(int idCli, String nom, String numeroTel, String numeroFax, String email, String prenom) {
		super(idCli, nom, numeroTel, numeroFax, email);
		this.prenom = prenom;
	}

	/**
     * @param idCli
     */
    public ClientPhysique(int idCli)
    {
        super(idCli);
    }

    /**
     * @return the prenom
     */
    public String getPrenom()
    {
        return prenom;
    }

    /**
     * @param prenom
     *            the prenom to set
     */
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }
}
