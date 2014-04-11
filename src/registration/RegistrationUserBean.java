package registration;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import registration.bo.impl.RegistrationBoImpl;
 
/**
 * Registration user JSF bean.
 *
 * @author itcuties
 *
 */
@Component
@ManagedBean
@SessionScoped
public class RegistrationUserBean {
     
    // This is going to be injected by Spring framework
    @Autowired
    RegistrationBoImpl registrationBo;
     
    private String firstname;
    private String lastname;
    private String email;
     
    /**
     * Method registers user
     */
    public void register() {
        // Output some info
        System.out.println("RegistrationUserBean:: Registering user " + firstname + " " + lastname + ", with email " + email);
         
        // Call the business object to register the user
        registrationBo.registerUser(firstname, lastname, email);
         
        // Set the message here
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration success", "success"); 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public String getFirstname() {
        return firstname;
    }
     
    public RegistrationBoImpl getRegistrationBo() {
		return registrationBo;
	}

	public void setRegistrationBo(RegistrationBoImpl registrationBo) {
		this.registrationBo = registrationBo;
	}

	public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
     
    public String getLastname() {
        return lastname;
    }
     
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
     
    public String getEmail() {
        return email;
    }
     
    public void setEmail(String email) {
        this.email = email;
    }
}