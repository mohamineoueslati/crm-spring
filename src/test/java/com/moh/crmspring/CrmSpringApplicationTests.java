package com.moh.crmspring;

import com.moh.crmspring.dto.ContactDto;
import com.moh.crmspring.entities.Activity;
import com.moh.crmspring.entities.Address;
import com.moh.crmspring.entities.Contact;
import com.moh.crmspring.repositories.ActivityRepository;
import com.moh.crmspring.repositories.ContactRepository;
import com.moh.crmspring.services.ActivityService;
import com.moh.crmspring.services.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class CrmSpringApplicationTests {
    private final ContactRepository contactRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public CrmSpringApplicationTests(ContactRepository contactRepository, ActivityRepository activityRepository) {
        this.contactRepository = contactRepository;
        this.activityRepository = activityRepository;
    }

    @Test
    public void testFindAllContacts() {
        List<Contact> contacts = contactRepository.findAll();

        contacts.forEach(System.out::println);
    }

    @Test
    public void testAddContact1() {
        Address address = new Address();
        address.setAddress("rue anter cité hached");
        address.setCity("Mohamedia");
        address.setCountry(Address.Country.TUNISIA);
        address.setZipCode(1145);
        address.setState("Ben Arous");

        Contact contact = new Contact();
        contact.setFirstName("Mohamed Amine");
        contact.setLastName("Oueslati");
        contact.setEmail("moh@gmail.com");
        contact.setPhone("+21652038057");
        contact.setCompany("ADS");
        contact.setJobTitle(Contact.JobTitle.SOFTWARE_ENGINEER);
        contact.setAddress(address);
        address.setContact(contact);

        contactRepository.save(contact);
    }

    @Test
    public void testAddContact2() {
        Contact contact = new Contact();
        contact.setFirstName("Ghassen");
        contact.setLastName("Kaabar");
        contact.setEmail("ghassen@gmail.com");
        contact.setPhone("+21690000000");
        contact.setCompany("ADS");
        contact.setJobTitle(Contact.JobTitle.CEO);

        contactRepository.save(contact);
    }

    @Test
    public void testAddActivity() {
        Contact amine = contactRepository.findById(1L).orElse(null);
        Contact ghassen = contactRepository.findById(2L).orElse(null);

        Activity activity = new Activity();

        activity.setDate(new Date());
        activity.setActivityType(Activity.ActivityType.REUNION);
        activity.setSubject("Reunion");
        activity.setNote("Reunion");
        activity.addParticipant(amine);
        activity.addParticipant(ghassen);

        activityRepository.save(activity);
    }
}
