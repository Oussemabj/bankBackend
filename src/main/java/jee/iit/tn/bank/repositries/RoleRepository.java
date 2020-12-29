package jee.iit.tn.bank.repositries;

import java.util.Optional;

import jee.iit.tn.bank.models.ERole;
import jee.iit.tn.bank.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
