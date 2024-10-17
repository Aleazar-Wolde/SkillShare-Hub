// src/main/java/com/yourname/skillsharehub/repository/RoleRepository.java
package com.yourname.skillsharehub.repository;

import com.yourname.skillsharehub.model.Role;
import com.yourname.skillsharehub.model.Role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
