package ru.bellintegrator.practice.util;

import ru.bellintegrator.practice.model.*;

/**
 * Fake data for models
 */
public class MockDataUtil {
    /**
     * Data for Document
     */
    public static Document getDocument() {
        return new Document.Builder()
                .withId(1)
                .withCode("558")
                .withName("id military")
                .withDate("15/12/2019")
                .build();
    }

    /**
     * Data for Country
     */
    public static Country getCountry() {
        return new Country.Builder()
                .withId(1)
                .withCode("254")
                .withName("Russia")
                .build();

    }

    /**
     * Data for Organization
     */
    public static Organization getOrganization() {
        return new Organization.Builder()
                .withId(1)
                .withName("IBM")
                .withFullName("International Business Machines")
                .withInn("584")
                .withKpp("5847")
                .withAddress("Str 5")
                .withPhone("55666")
                .withIsActive(true)
                .build();

    }

    /**
     * Data for Office
     */
    public static Office getOffice() {
        return new Office.Builder()
                .withId(1)
                .withName("Bell Integrator")
                .withAddress("Str 5")
                .withPhone("55555")
                .withIsActive(true)
                .withOrganization(getOrganization())
                .build();
    }

    /**
     * Data for User
     */
    public static User getUser() {
        return new User.Builder()
                .withId(1)
                .withCountry(getCountry())
                .withDocument(getDocument())
                .withOffice(getOffice())
                .withFirstName("Vagan")
                .withMiddleName("Khachatryan")
                .withSecondName("Ashotovich")
                .withPosition("Java Developer")
                .withPhone("987775555")
                .withIsIdentified(true)
                .build();
    }


}
