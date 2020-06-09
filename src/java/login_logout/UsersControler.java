package login_logout;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mahmud.masri
 */
@Named
// @SessionScoped kapsamlarimizi belerliyoruz * oturum kapsamli
//@SessionScoped
@javax.enterprise.context.SessionScoped

public class UsersControler implements Serializable {

   // private static final long serialVersionUID = 1094801825228386363L;

    private String msg;
    private String uname;
    private String password;
    private String userTuru;
    
    

    public String create() {
        UsersDAO.insert(this.uname, this.password, this.userTuru);
        this.uname = null;
        this.password = null;
        
        return "kulancigirisi";
    }

    public UsersControler() {
       // UsersControler u = new UsersControler();
         // this.clist =new ArrayList();
       // UsersDAO = new UsersDAO();
        this.uname = "";
        this.password = "";
       
    }

    public UsersControler(String msg, String uname, String password, String userTuru) {
        this.msg = msg;
        this.uname = uname;
        this.password = password;
        this.userTuru = userTuru;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserTuru() {
        return userTuru;
    }

    public void setUserTuru(String userTuru) {
        this.userTuru = userTuru;
    }

    //validate login
    public String validateUsernamePasswordAdmin() {
        boolean valid = UsersDAO.validate(uname, password, "admin");
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", uname);
            session.setAttribute("password", password);
            session.setAttribute("admin", "admin");
            return "view?faces-redirect=true";
        }
        valid = UsersDAO.validate(uname, password, "USER");

        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", uname);
            session.setAttribute("password", password);
            session.setAttribute("USER", "USER");
            return "USER/USER?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login?faces-redirect=true";
        }
    }
    //logout event, invalidate session

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }

}
