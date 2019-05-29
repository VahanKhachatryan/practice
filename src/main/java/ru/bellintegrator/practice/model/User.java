package ru.bellintegrator.practice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


/**
 * Create  class - User
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Version
    private int version;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "office_id")
    private Office office;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "second_name")
    private String secondName;
    @Column
    private String position;
    @Column
    private String phone;
    @Column(name = "is_identified")
    private Boolean isIdentified;

    public User(Country country, Document document, Office office, String firstName, String middleName, String secondName, String position, String phone, Boolean isIdentified) {
        this.country = country;
        this.document = document;
        this.office = office;
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
    }

    public User() {
    }

    public User(Country country, Document document, Office office, String firstName, String middleName, String secondName, String position) {
        this.country = country;
        this.document = document;
        this.office = office;
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean identified) {
        isIdentified = identified;
    }

}

