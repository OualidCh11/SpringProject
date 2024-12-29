package Invincibles.gestionrh.repository;

import java.util.Optional;

import Invincibles.gestionrh.model.ERole;
import Invincibles.gestionrh.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
