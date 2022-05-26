package businessLayer;

import java.util.Objects;

public class User {
    private int idUser;
    private String username;
    private String password;
    private int type;

    // 0 pentru admin, 1 pentru angajat, 2 pentru client
    public User(int idClient, String username, String password, int type) {
        this.idUser = idClient;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public int hashCode() {
        return Objects.hash(idUser, username, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser && username.equals(user.username) && password.equals(user.password);
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
