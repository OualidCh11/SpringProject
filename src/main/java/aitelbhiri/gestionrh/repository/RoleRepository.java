package aitelbhiri.gestionrh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aitelbhiri.gestionrh.model.ERole;
import aitelbhiri.gestionrh.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
