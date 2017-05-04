/**
 * 
 */
package agence.model;

/**
 * @author Seme
 */
public class ClientMoral extends Client
{
    /**
	 * @param idCli
	 * @param nom
	 * @param numeroTel
	 * @param numeroFax
	 * @param email
	 * @param siret
	 */
	public ClientMoral(int idCli, String nom, String numeroTel, String numeroFax, String email, long siret) {
		super(idCli, nom, numeroTel, numeroFax, email);
		this.siret = siret;
	}

	/**
     * numéro SIRET (15 chiffres)
     */
    private long siret;

    /**
     * @param idCli
     */
    public ClientMoral(int idCli)
    {
        super(idCli);
    }

    /**
     * @return the siret
     */
    public long getSiret()
    {
        return siret;
    }

    /**
     * @param siret
     *            the siret to set
     */
    public void setSiret(long siret)
    {
        this.siret = siret;
    }
}
