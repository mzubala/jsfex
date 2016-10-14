package pl.bottega.jsfex.user.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by maciuch on 23.09.16.
 */
public class User {

    private String avatarUrl;

    @NotNull(groups = StandardValidation.class)
    @Size(min = 1, groups = StandardValidation.class)
    private String firstName;

    @NotNull(groups = StandardValidation.class)
    @Size(min = 1, groups = StandardValidation.class)
    private String lastName;

    @NotNull(groups = MinimalValidation.class)
    @Size(min = 5, groups = {MinimalValidation.class})
    private String login;

    @NotNull(groups = StandardValidation.class)
    @Size(min = 1, groups = StandardValidation.class)
    private String email;

    @NotNull(groups = StandardValidation.class)
    @Size(min = 1, groups = StandardValidation.class)
    private String password;

    @NotNull(groups = StandardValidation.class)
    @Size(min = 1, message = "Please select at least one role", groups = StandardValidation.class)
    private Set<Role> roles;

    public User(String avatarUrl, String firstName, String lastName, String login) {
        this.avatarUrl = avatarUrl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
    }

    public User() {

    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public boolean isAdmin() {
        return login == "admin";
    }

    public boolean sameCredentials(String login, String password) {
        return this.login.equals(login);
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPasswordStrength() {
        if (password != null && password.length() > 0) {
            if(password.length() <= 5)
                return "weak";
            else if(password.length() <= 8)
                return "medium";
            else
                return "strong";
        }
        return null;
    }

}
