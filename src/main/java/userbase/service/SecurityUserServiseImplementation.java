package userbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import userbase.dao.SecurityUserDao;
import userbase.dao.RoleDao;
import userbase.models.Role;
import userbase.models.SecurityUser;

import java.util.Set;
import java.util.HashSet;

@Service
public class SecurityUserServiseImplementation implements SecurityUserService{

        @Autowired
        private SecurityUserDao securityUserDao;

        @Autowired
        private RoleDao roleDao;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(SecurityUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        securityUserDao.save(user);
    }

    @Override
    public SecurityUser findUserByLogin(String login) {
        return securityUserDao.findUserByLogin(login);
    }


}
