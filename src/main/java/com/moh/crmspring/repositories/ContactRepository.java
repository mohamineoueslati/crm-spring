package com.moh.crmspring.repositories;

import com.moh.crmspring.entities.Contact;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @EntityGraph(value = "Contact.address")
    List<Contact> findAll();
}
