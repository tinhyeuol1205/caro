package caro.Model;

import lombok.Data;
import lombok.Generated;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private int win;
    private int lose;

    public User() {
    }

    public User(String id, String username, String password, int win, int lose) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.win = win;
        this.lose = lose;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }
}
