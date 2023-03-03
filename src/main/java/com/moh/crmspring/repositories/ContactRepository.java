package com.moh.crmspring.repositories;

import com.moh.crmspring.entities.Contact;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @EntityGraph(value = "Contact")
    List<Contact> findAll();

    @EntityGraph(value = "Contact")
    List<Contact> findAllById(Iterable<Long> ids);

    @EntityGraph(value = "Contact")
    Optional<Contact> findById(Long id);

    @Modifying
    @Query(value = "update Contact c set c.contactOwner = null where c.contactOwner.id = :id")
    void setContactOwnerToNull(Long id);
}
