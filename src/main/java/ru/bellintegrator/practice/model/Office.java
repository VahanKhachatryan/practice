package ru.bellintegrator.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Create  class - Office
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "OFFICE")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Version
    private int version;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phone;
    @Column(name = "is_active")
    private Boolean isActive;

//    @ManyToMany(mappedBy = "offices")
//    @JoinTable(
//            name = "OFFICE_ORGANIZATION",
//            joinColumns = {@JoinColumn(name = "office_id")},
//            inverseJoinColumns = {@JoinColumn(name = "organization_id")})
//    Set<Organization> organizations = new HashSet<>();


}
