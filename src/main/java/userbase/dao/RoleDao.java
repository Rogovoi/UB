package userbase.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import userbase.models.Role;

public interface RoleDao extends JpaRepository<Role, Long>{
}
