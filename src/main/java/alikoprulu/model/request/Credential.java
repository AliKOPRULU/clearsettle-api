package alikoprulu.model.request;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Ali on 30.11.2016.
 */
public class Credential {//MERCHANT LOGIN

    @Email
    @NotEmpty
    @Size(max = 128)
    private String email;

    @Size(max = 32)
    private String password;

    public Credential() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
