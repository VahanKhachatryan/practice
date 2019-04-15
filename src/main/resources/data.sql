/*
 * Insert the data to the 'OFFICE' table.
 */
INSERT INTO ORGANIZATION ("id", "version", "name", "full_name", "inn", "kpp", "address", "phone", "is_active")
VALUES (1, 0, 'Oracle', 'Oracle', '111', '111', 'street 1', '111', true);

INSERT INTO ORGANIZATION ("id", "version", "name", "full_name", "inn", "kpp", "address", "phone", "is_active")
VALUES (2, 0, 'IBM', 'International Business Machines', '222', '222', 'street 2', '222', true);

/*
 * Insert the data to the 'OFFICE' table.
 */
INSERT INTO OFFICE ("id", "version","name", "address", "phone", "is_active")
VALUES (1, 0, 'OracleOffice', 'street 1', '111', true);

INSERT INTO OFFICE ("id", "version","name", "address", "phone", "is_active")
VALUES (2, 0,'IBMOffice', 'street 2', '222', true);

/*
 * Insert the data to the 'OFFICE_ORGANIZATION' table.
 */
INSERT INTO OFFICE_ORGANIZATION ("office_id", "organization_id","version")
VALUES (1, 1,0);

INSERT INTO OFFICE_ORGANIZATION ("office_id", "organization_id","version")
VALUES (2, 2,0);


/*
 * Insert the data to the 'DOCUMENT' table.
 */
INSERT INTO DOCUMENT ("id", "version", "code", "name","date")
VALUES (1, 0, '03', 'birth certificate','02.02.2000');

INSERT INTO DOCUMENT ("id", "version", "code", "name","date")
VALUES (2, 0, '07', 'military ID','03.03.2000');

/*
 * Insert the data to the 'COUNTRY' table.
 */
INSERT INTO COUNTRY ("id", "version", "code", "name")
VALUES (1, 0, '643', 'Russian Federation');

INSERT INTO COUNTRY ("id", "version", "code", "name")
VALUES (2, 0, '051', 'Republic of Armenia');


/*
 * Insert the data to the 'USER' table.
 */
INSERT INTO USER("id", "version", "country_id","document_id", "office_id", "first_name", "middle_name", "second_name", "position",
                 "phone", "is_identified")
VALUES (1, 0, 1, 1, 1, 'Aleksandr', 'Aleksandrovich', 'Aleksandrov', 'TeamLead','111', true);


INSERT INTO USER("id", "version", "country_id","document_id", "office_id", "first_name", "middle_name", "second_name", "position",
                 "phone", "is_identified")
VALUES (2, 0, 2, 2, 2, 'Vladimir', 'Vladimirovich', 'Vladimirov', 'Java developer', '222', true);



INSERT INTO USER("id", "version", "country_id","document_id", "office_id", "first_name", "middle_name", "second_name", "position",
                 "phone", "is_identified")
VALUES (3, 0, 1, 1, 2, 'Viktor', 'Viktorovich', 'Viktorov', 'Project Manager', '333', true);



INSERT INTO USER("id", "version", "country_id","document_id", "office_id", "first_name", "middle_name", "second_name", "position",
                 "phone", "is_identified")
VALUES (4, 0, 2, 2, 1, 'Oleg', 'Olegovich', 'Olegov', 'Java developer', '333', true);
