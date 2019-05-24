/*
 * This is an 'ORGANIZATION' table.
 * The table has a connection with the table 'OFFICE_ORGANIZATION'
 * */
CREATE TABLE IF NOT EXISTS Organization
(
  "id"        INTEGER     NOT NULL COMMENT 'Unique organization identifier' PRIMARY KEY AUTO_INCREMENT,
  "version"   INTEGER     NOT NULL COMMENT 'Service field hibernate',
  "name"      VARCHAR(50) NOT NULL COMMENT 'Organization name',
  "full_name" VARCHAR(50) NOT NULL COMMENT 'Organization full name',
  "inn"       VARCHAR(12) NOT NULL COMMENT 'Organization inn',
  "kpp"       VARCHAR(9)  NOT NULL COMMENT 'Organization kpp',
  "address"   VARCHAR(50) NOT NULL COMMENT 'Organization address',
  "phone"     VARCHAR(15) NOT NULL COMMENT 'Organization phone',
  "is_active" BOOLEAN     NOT NULL COMMENT 'Organization is Active'
);
COMMENT ON TABLE Organization IS 'Organization table';
CREATE INDEX IX_Organization_Id ON Organization ("id");
-- CREATE SEQUENCE IF NOT EXISTS Organization_sequence START WITH 3;
/*
 * This is an 'OFFICE' table.
 * The table has a connection with the table 'OFFICE_ORGANIZATION'
 * */
CREATE TABLE IF NOT EXISTS Office
(
  "id"        INTEGER     NOT NULL COMMENT 'Unique office identifier' PRIMARY KEY AUTO_INCREMENT,
  "version"   INTEGER     NOT NULL COMMENT 'Service field hibernate',
  "name"      VARCHAR(50) NOT NULL COMMENT 'Office name',
  "address"   VARCHAR(50) NOT NULL COMMENT 'Office address',
  "phone"     VARCHAR(15) NOT NULL COMMENT 'Office phone',
  "is_active" BOOLEAN     NOT NULL COMMENT 'Office is Active',
);
COMMENT ON TABLE Office IS 'Office table';
CREATE INDEX IX_Office_Id ON Office ("id");
-- CREATE SEQUENCE IF NOT EXISTS Office_sequence START WITH 3;
/*
 * This is a many-to-many join table 'OFFICE_ORGANIZATION'.
 * It connects the 'ORGANIZATION' table and 'OFFICE'
 * */
CREATE TABLE IF NOT EXISTS Office_Organization
(
  "office_id"       INTEGER NOT NULL COMMENT 'Office identifier',
  "organization_id" INTEGER NOT NULL COMMENT 'Organization identifier',
  PRIMARY KEY ("office_id", "organization_id"),
  "version"         INTEGER NOT NULL COMMENT 'Service field hibernate',
  FOREIGN KEY ("office_id") REFERENCES OFFICE ("id"),
  FOREIGN KEY ("organization_id") REFERENCES ORGANIZATION ("id"),
);

COMMENT ON TABLE Office_Organization IS 'Office and organization join table';

/*
 * This is an 'Document' table.
 * Table connects one to many  with table 'USER.document_id'
 * */
CREATE TABLE IF NOT EXISTS Document
(
  "id"      INTEGER     NOT NULL COMMENT 'Unique Document identifier' PRIMARY KEY AUTO_INCREMENT,
  "version" INTEGER     NOT NULL COMMENT 'Service field hibernate',
  "code"    VARCHAR(3)  NOT NULL COMMENT 'Document code',
  "name"    VARCHAR(60) NOT NULL COMMENT 'Document name',
  "date"    VARCHAR(15) NOT NULL COMMENT 'Document date'
);

COMMENT ON TABLE Document IS 'Document table';
CREATE INDEX IX_Document_Id ON Document ("id");
-- CREATE SEQUENCE IF NOT EXISTS Document_sequence START WITH 1;

/*
 * This is an 'COUNTRY' table.
 * Table connects one to one with table 'USER.country_id'
 * */
CREATE TABLE IF NOT EXISTS Country
(
  "id"      INTEGER     NOT NULL COMMENT 'Unique Country identifier' PRIMARY KEY AUTO_INCREMENT,
  "version" INTEGER     NOT NULL COMMENT 'Service field hibernate',
  "code"    VARCHAR(3)  NOT NULL COMMENT 'Country code',
  "name"    VARCHAR(60) NOT NULL COMMENT 'Country name'
);

COMMENT ON TABLE Country IS 'Country table';
CREATE INDEX IX_Country_Id ON Country ("id");
-- CREATE SEQUENCE IF NOT EXISTS Country_sequence START WITH 1;

/*
 * This is an 'USER' table.
 *
 * Table connects :
 * many to one with table 'COUNTRY.id'
 * many to one with table 'DOCUMENT.id'
 * many to one with table 'OFFICE.id'
 * */
CREATE TABLE IF NOT EXISTS User
(
  "id"            INTEGER     NOT NULL COMMENT 'Unique User identifier' PRIMARY KEY AUTO_INCREMENT,
  "version"       INTEGER     NOT NULL COMMENT 'Service field hibernate',
  "country_id"    INTEGER COMMENT 'Country identifier',
  "document_id"   INTEGER COMMENT 'Document identifier',
  "office_id"     INTEGER COMMENT 'Office identifier',
  "first_name"    VARCHAR(50) NOT NULL COMMENT 'User first name',
  "middle_name"   VARCHAR(50) NOT NULL COMMENT 'User middle name',
  "second_name"   VARCHAR(50) NOT NULL COMMENT 'User second name',
  "position"      VARCHAR(20) NOT NULL COMMENT 'User position',
  "phone"         VARCHAR(15) NOT NULL COMMENT 'User phone',
  "is_identified" BOOLEAN     NOT NULL COMMENT 'User is identified',

  FOREIGN KEY ("office_id") REFERENCES Office ("id"),
  FOREIGN KEY ("country_id") REFERENCES Country ("id"),
  FOREIGN KEY ("document_id") REFERENCES Document ("id")
);

COMMENT ON TABLE User IS 'User table';
CREATE INDEX IX_User_Id ON User ("id");
CREATE INDEX IX_User_Country_Id ON User ("country_id");
CREATE INDEX IX_User_Document_Id ON User ("country_id");
CREATE INDEX IX_User_Office_Id ON User ("office_id");
-- CREATE SEQUENCE IF NOT EXISTS User_sequence START WITH 1;
