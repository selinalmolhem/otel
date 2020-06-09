 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Entity.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import login_logout.UsersDAO;

/**
 *
 * @author Selin almolhem
 */
@Named
@SessionScoped
public class LoginControler implements Serializable {

    private User user;
    private UsersDAO user1;

    public UsersDAO getUser1() {
        if (this.user1 == null) {
            this.user1 = new UsersDAO();
        }
      
        return user1;
    }

    public void setUser1(UsersDAO user1) {
        this.user1 = user1;
    }
    public String login() {
        if (this.user.getUserName().equals("selin") && this.user.getPassword().equals("123") || this.user.getUserName().equals("beyan") && this.user.getPassword().equals("741") ) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
            return "view";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatali bilgiler"));
            return "login";
        }
    }
public String login1() {
        if (this.getUser1().validate(user.getUserName(), user.getPassword())==true) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
            return "view";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatali bilgiler"));
            return "login";
        }
    }
    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
