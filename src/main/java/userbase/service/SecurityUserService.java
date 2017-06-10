package userbase.service;

import userbase.models.SecurityUser;

public interface SecurityUserService {

    void save(SecurityUser user);

    SecurityUser findUserByLogin(String login);
}
