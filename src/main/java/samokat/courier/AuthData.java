package samokat.courier;

public class AuthData {

    private String login;
    private String password;

    public AuthData() {
    }

    public AuthData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static AuthData from(Courier courier) {
        return new AuthData(courier.getLogin(), courier.getPassword());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
