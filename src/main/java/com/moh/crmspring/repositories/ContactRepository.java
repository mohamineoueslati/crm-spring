package com.moh.crmspring.repositories;

import com.moh.crmspring.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("select distinct c from Contact c " +
            "left join fetch c.address " +
            "left join fetch c.contactOwner")
    List<Contact> findAll();

    @Query("select distinct c from Contact c " +
            "left join fetch c.address " +
            "left join fetch c.contactOwner " +
            "where c.id in :ids")
    List<Contact> findAllById(Iterable<Long> ids);

    @Query("select distinct c from Contact c " +
            "left join fetch c.address " +
            "left join fetch c.contactOwner " +
            "where c.id = :id")
    Optional<Contact> findById(Long id);

    boolean existsByEmail(String email);

    @Query("select c.email from Contact c where c.id = :id")
    String selectContactEmail(Long id);

    @Modifying
    @Query(value = "update Contact c set c.contactOwner = null where c.contactOwner.id = :id")
    void setContactOwnerToNull(Long id);
}
