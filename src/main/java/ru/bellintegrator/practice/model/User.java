package ru.bellintegrator.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * Create  class - User
 */
public class User {
    private int id;
    private Country country;
    private Document document;
    private Office office;
    private String firstName;
    private String middleName;
    private String secondName;
    private String position;
    private String phone;
    private Boolean isIdentified;

    /**
     * Create another class inside our class - Builder
     */
    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }


        public User.Builder withId(int id) {
            newUser.id = id;
            return this;
        }


        public User.Builder withCountry(Country country) {
            newUser.country = country;
            return this;
        }


        public User.Builder withDocument(Document document) {
            newUser.document = document;
            return this;
        }

        public User.Builder withOffice(Office office) {
            newUser.office = office;
            return this;
        }


        public User.Builder withFirstName(String firstName) {
            newUser.firstName = firstName;
            return this;
        }


        public User.Builder withMiddleName(String middleName) {
            newUser.middleName = middleName;
            return this;
        }


        public User.Builder withSecondName(String secondName) {
            newUser.secondName = secondName;
            return this;
        }

        public User.Builder withPosition(String position) {
            newUser.position = position;
            return this;
        }

        public User.Builder withPhone(String phone) {
            newUser.phone = phone;
            return this;
        }

        public User.Builder withIsIdentified(Boolean isIdentified) {
            newUser.isIdentified = isIdentified;
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}

