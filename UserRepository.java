// src/main/java/com/yourname/skillsharehub/repository/UserRepository.java
package com.yourname.skillsharehub.repository;

import com.yourname.skillsharehub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
