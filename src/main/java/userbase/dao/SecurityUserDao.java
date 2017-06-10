package userbase.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import userbase.models.SecurityUser;

public interface SecurityUserDao extends JpaRepository<SecurityUser, Long> {
    SecurityUser findUserByLogin(String login);
}
