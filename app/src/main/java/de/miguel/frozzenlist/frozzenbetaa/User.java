package de.miguel.frozzenlist.frozzenbetaa;

import java.io.Serializable;

public class User implements Serializable {


    private String userName;
    private String passwort;
    private String email;


    public User( String userName, String passwort, String email) {

        this.userName = userName;
        this.passwort= passwort;
        this.email= email;
    }
    public User(String passwort,String email){
        this.passwort=passwort;
        this.email=email;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort=passwort;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String inputEmail){
        this.email=inputEmail;
    }
    public void changePasswort(String input)
    {
        this.passwort= input;
    }

}
