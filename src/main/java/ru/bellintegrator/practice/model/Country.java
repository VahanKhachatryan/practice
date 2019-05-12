package ru.bellintegrator.practice.model;

import javax.persistence.*;

/**
 * Create  class - Country
 */
@Entity
@Table(name = "COUNTRY")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Version
    private int version;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
