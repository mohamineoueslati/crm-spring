package com.moh.crmspring.repositories;

import com.moh.crmspring.entities.Activity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @EntityGraph(value = "Activity.participants")
    List<Activity> findAll();

    @EntityGraph(value = "Activity.participants")
    Optional<Activity> findById(Long id);
}
