package userbase.service;

import userbase.models.User;

import java.util.List;

public interface UserBaseService {

    public void addUser(User user);

    public void editUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> listUsers();
}
