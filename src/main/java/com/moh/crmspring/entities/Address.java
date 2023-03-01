package com.moh.crmspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    public enum Country {
        TUNISIA, ALGERIA, MOROCCO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private Integer zipCode;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Id=" + Id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
