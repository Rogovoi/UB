package userbase.service;

public interface SecurityLoginServise {

    String findLoggedInLogin();

    void autoLogin(String login, String password);
}
