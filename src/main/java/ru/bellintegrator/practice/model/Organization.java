package ru.bellintegrator.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create  class - Organization
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Organization {
    private int id;
    private String name;
    private String fullName;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private Boolean isActive;

    /**
     * Create another class inside our class - Builder
     */
    public static class Builder {
        private Organization newOrganization;

        public Builder() {
            newOrganization = new Organization();
        }


        public Organization.Builder withId(int id) {
            newOrganization.id = id;
            return this;
        }

        public Organization.Builder withName(String name) {
            newOrganization.name = name;
            return this;
        }

        public Organization.Builder withFullName(String fullName) {
            newOrganization.fullName = fullName;
            return this;
        }


        public Organization.Builder withInn(String inn) {
            newOrganization.inn = inn;
            return this;
        }


        public Organization.Builder withKpp(String kpp) {
            newOrganization.kpp = kpp;
            return this;
        }

        public Organization.Builder withAddress(String address) {
            newOrganization.address = address;
            return this;
        }

        public Organization.Builder withPhone(String phone) {
            newOrganization.phone = phone;
            return this;
        }

        public Organization.Builder withIsActive(Boolean isActive) {
            newOrganization.isActive = isActive;
            return this;
        }


        public Organization build() {
            return newOrganization;
        }
    }

}
