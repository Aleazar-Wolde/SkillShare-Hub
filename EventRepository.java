// src/main/java/com/yourname/skillsharehub/repository/EventRepository.java
package com.yourname.skillsharehub.repository;

import com.yourname.skillsharehub.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Custom query methods can be added here if needed
}
