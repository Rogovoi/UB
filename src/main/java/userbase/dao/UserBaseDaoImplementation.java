package userbase.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userbase.models.User;

import java.util.List;

public class UserBaseDaoImplementation implements UserBaseDao{
    private Logger logger = LoggerFactory.getLogger(UserBaseDao.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved");
    }

    @Override
    public void editUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully updated");
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if (user != null){
            session.delete(user);
        }
        logger.info("User successfully removed. User details: " + user);
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User successfully loaded. User details: " + user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userlist = session.createQuery("from User").list();

        for(User user: userlist){
            logger.info("User list: " + user);
        }
        return userlist;
    }


    /*
    * ---------change_profile---------------
    */
    @Override
    public void changeProfileData(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("Profile successfully updated");
    }
}
