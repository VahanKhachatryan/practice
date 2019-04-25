package ru.bellintegrator.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create  class - Document
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Document {


    private int id;
    private String code;
    private String name;
    private String date;

    /**
     * Create another class inside our class - Builder
     */
    public static class Builder {
        private Document newDocument;

        public Builder() {
            newDocument = new Document();
        }


        public Document.Builder withId(int id) {
            newDocument.id = id;
            return this;
        }

        public Document.Builder withCode(String code) {
            newDocument.code = code;
            return this;
        }

        public Document.Builder withName(String name) {
            newDocument.name = name;
            return this;
        }


        public Document.Builder withDate(String date) {
            newDocument.date = date;
            return this;
        }

        public Document build() {
            return newDocument;
        }
    }

}
