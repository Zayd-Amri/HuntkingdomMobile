/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Enteties.User;
import Services.ServiceUser;

/**
 *
 * @author AmineMissaoui
 */
public final class UserSession {

    private static UserSession instance;

    private String username;
    private String birthdate;
    private String userRole;

    private int id;
    private int active;

    private UserSession(User u) {
       
            this.username = u.getUsername();
            this.birthdate = u.getBirthdate();
            this.userRole = u.getRole();
            this.id=u.getId();
            this.active = u.getActive();
        
    }

    public static UserSession setInstance(User u)  {

        if (instance == null) {
            instance = new UserSession(u);
        }
        return instance;
    }
    
    public static UserSession getInstance(){
        return instance;
    }

    public String getUsername() {
        return this.username;
    }
    
    public String getBirthdate() {
        return this.birthdate;
    }
    
    public String getRole() {
        return this.userRole;
    }
    public int getActive() {
        return this.active;
    }
        
    public void clearUserSession() {
        username = "";
    }

    @Override
    public String toString() {
        return "UserSession{" + "username=" + username + '}';
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
