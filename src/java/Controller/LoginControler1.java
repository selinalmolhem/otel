/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.personelDao;
import Dao.userdao;
import Entity.User;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Selin almolhem
 */
@ManagedBean
@Named
@SessionScoped
public class LoginControler1 implements Serializable {

  private static final long serialVersionUID = 1520318172495977648L;
  
  public String redirectToLogin(){
      return "/login.xhtml?faces-redirect=true";
  }
      public String toLogin(){
          return"/login.xhtml";
      }
  public String redirectToInfo(){
  return"/index.xhtml?faces-redirect=true";
  }
  public String toInfo(){
      return"/index.xhtml";
  }    
  public String redirectTowelcome(){
      return"/USER/USER.xhtml?faces-redirect=true";
  }
  public String toWelcome(){
      return"/USER/USER.xhtml";
  }
  }
  

