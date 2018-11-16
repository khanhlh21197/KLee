/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servercaro;

/**
 *
 * @author klee211
 */
public class User {
    private int ID;
    private String username;
    private String password;
    private String fullname;
    private String birthday;
    private String email;
    private int scores;
    private int matches;

    public User(int ID, String username, String password, String fullname, String birthday, String email, int scores, int matches) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.birthday = birthday;
        this.email = email;
        this.scores = scores;
        this.matches = matches;
    }

    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }
    
    public Object[] toObject(){
        return new Object[]{ID, username, fullname, birthday, email, scores, matches};
    }
    
}
