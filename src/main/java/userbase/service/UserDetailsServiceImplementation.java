package userbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import userbase.dao.SecurityUserDao;
import userbase.models.Role;
import userbase.models.SecurityUser;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImplementation implements UserDetailsService{

    @Autowired
    private SecurityUserDao securityUserDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
        SecurityUser securityUser = securityUserDao.findUserByLogin(login);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for(Role role : securityUser.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(securityUser.getLogin(), securityUser.getPassword(), grantedAuthorities);
    }

}
