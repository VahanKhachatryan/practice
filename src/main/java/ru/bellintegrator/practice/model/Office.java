package ru.bellintegrator.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create  class - Office
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Office {
    private int id;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;
    private Organization organization;


    /**
     * Create another class inside our class - Builder
     */
    public static class Builder {
        private Office newOffice;

        public Builder() {
            newOffice = new Office();
        }


        public Office.Builder withId(int id) {
            newOffice.id = id;
            return this;
        }

        public Office.Builder withName(String name) {
            newOffice.name = name;
            return this;
        }

        public Office.Builder withAddress(String address) {
            newOffice.address = address;
            return this;
        }

        public Office.Builder withPhone(String phone) {
            newOffice.phone = phone;
            return this;
        }

        public Office.Builder withIsActive(Boolean isActive) {
            newOffice.isActive = isActive;
            return this;
        }

        public Office.Builder withOrganization(Organization org) {
            newOffice.organization = org;
            return this;
        }

        public Office build() {
            return newOffice;
        }
    }

}
