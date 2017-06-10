package userbase.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class SecurityLoginServiseImplementation implements SecurityLoginServise{
    private Logger logger = LoggerFactory.getLogger(SecurityLoginServiseImplementation.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String findLoggedInLogin() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails){
           return ((UserDetails) userDetails).getUsername();
        }
        return null;
    }

    @Override
    public void autoLogin(String login, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(login);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(authenticationToken);

        if (authenticationToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            logger.info("Successfully % auto logged in: " + login);
        }
    }
}
