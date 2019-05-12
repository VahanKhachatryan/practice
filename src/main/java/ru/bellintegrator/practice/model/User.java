package ru.bellintegrator.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Country country;
    @ManyToOne
    private Document document;
    @ManyToOne
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

}

