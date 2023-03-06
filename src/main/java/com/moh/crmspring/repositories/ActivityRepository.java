package com.moh.crmspring.repositories;

import com.moh.crmspring.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @Query("select distinct a " +
            "from Activity a left join fetch a.participants p left join fetch p.activities left join fetch p.address")
    List<Activity> findAll();

    @Query("select distinct a " +
            "from Activity a " +
            "left join fetch a.participants p left join fetch p.activities left join fetch p.address where a.id = :id")
    Optional<Activity> findById(Long id);

    @Query("select distinct a " +
            "from Activity a " +
            "left join fetch a.participants p left join fetch p.activities left join fetch p.address where a.id in :ids")
    List<Activity> findAllById(Iterable<Long> ids);
}
