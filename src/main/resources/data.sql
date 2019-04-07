INSERT INTO Access (id, version, login, password, name, is_active)
VALUES (1, 0, 'Vagan18', 'vagan228', 'Vagan', true);

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (1, 0, 'Oracle', 'Oracle', '111', '111', 'street 1', '111', true);

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (2, 0, 'IBM', 'International Business Machines', '222', '222', 'street 2', '222', true);


INSERT INTO Office (id, version, org_id, name, address, phone, is_active)
VALUES (1, 0, 1, 'OracleOffice', 'street 1', '111', true);

INSERT INTO Office (id, version, org_id, name, address, phone, is_active)
VALUES (2, 0, 2, 'IBMOffice', 'street 2', '222', true);



INSERT INTO Doc_Type (id, version, code, name)
VALUES (1, 0, '03', '	Свидетельство о рождении');

INSERT INTO Doc_Type (id, version, code, name)
VALUES (2, 0, '07', 'Военный билет');


INSERT INTO Country (id, version, code, name)
VALUES (1, 0, '643', 'Российская Федерация');

INSERT INTO Country (id, version, code, name)
VALUES (2, 0, '051', 'Республика Армения');



INSERT INTO User (id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position,
                  phone, doc_number, doc_date, is_identified)
VALUES (1, 0, 1, 1, 1, 'Aleksandr', 'Aleksandrovich', 'Aleksandrov', 'TeamLead', '111', '111', '25.05.1999', true);

INSERT INTO User (id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position,
                  phone, doc_number, doc_date, is_identified)
VALUES (2, 0, 2, 2, 2, 'Vladimir', 'Vladimirovich', 'Vladimirov', 'Java developer', '222', '222', '20.05.1999', true);



INSERT INTO User (id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position,
                  phone, doc_number, doc_date, is_identified)
VALUES (3, 0, 1, 1, 2, 'Viktor', 'Viktorovich', 'Viktorov', 'Project Manager', '333', '333', '18.05.1999', true);



INSERT INTO User (id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position,
                  phone, doc_number, doc_date, is_identified)
VALUES (4, 0, 2, 2, 1, 'Oleg', 'Olegovich', 'Olegov', 'Java developer', '333', '333', '15.05.1999', true);
