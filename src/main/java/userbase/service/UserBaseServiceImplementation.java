package userbase.service;

import userbase.dao.UserBaseDao;
import userbase.models.User;

import javax.transaction.Transactional;
import java.util.List;

public class UserBaseServiceImplementation implements UserBaseService {
    private UserBaseDao userBaseDao;

    public void setUserBaseDao(UserBaseDao userBaseDao) {
        this.userBaseDao = userBaseDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userBaseDao.addUser(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        this.userBaseDao.editUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userBaseDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userBaseDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userBaseDao.listUsers();
    }

    @Override
    @Transactional
    public void changeProfileData(User user) {
        this.userBaseDao.changeProfileData(user);
    }

}
