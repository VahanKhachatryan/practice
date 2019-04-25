package ru.bellintegrator.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create  class - Country
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Country {
    private int id;
    private String code;
    private String name;

    /**
     * Create another class inside our class - Builder
     */
    public static class Builder {
        private Country newCountry;

        public Builder() {
            newCountry = new Country();
        }

        public Builder withId(int id) {
            newCountry.id = id;
            return this;
        }

        public Builder withCode(String code) {
            newCountry.code = code;
            return this;
        }

        public Builder withName(String name) {
            newCountry.name = name;
            return this;
        }

        public Country build() {
            return newCountry;
        }
    }
}
