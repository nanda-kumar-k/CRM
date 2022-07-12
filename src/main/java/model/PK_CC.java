package model;

import java.io.Serializable;
import java.util.Objects;

public class PK_CC implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String client_username;
    private String company_username;

    public PK_CC()
    {}

    public PK_CC(String client_username, String company_username) {
        this.client_username = client_username;
        this.company_username = company_username;
    }

	@Override
	public int hashCode() {
		return Objects.hash(client_username, company_username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PK_CC other = (PK_CC) obj;
		return Objects.equals(client_username, other.client_username)
				&& Objects.equals(company_username, other.company_username);
	}

}