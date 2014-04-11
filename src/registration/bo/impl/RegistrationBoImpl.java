package registration.bo.impl;

import org.springframework.stereotype.Service;
 
/**
 * Registration Business Object implementation.
 * @author itcuties
 *
 */
@Service
public class RegistrationBoImpl {
	
	private String teste="Mamuska";
 
    public void registerUser(String firstname, String lastname, String email) {
        // Output some info
        System.out.println("RegistrationBoImpl:: Registering user " + firstname + " " + lastname + ", with email " + email);
         
        // TODO: Contact your database here
        // ...
    }

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}
}