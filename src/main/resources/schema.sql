/*
 * This is an 'ORGANIZATION' table.
 * The table has a connection with the table 'OFFICE_ORGANIZATION'
 * */
CREATE TABLE IF NOT EXISTS Organization
(
  "id"        INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  "version"   INTEGER     NOT NULL,
  "name"      VARCHAR(50) NOT NULL,
  "full_name" VARCHAR(50) NOT NULL,
  "inn"       VARCHAR(12) NOT NULL,
  "kpp"       VARCHAR(9)  NOT NULL,
  "address"   VARCHAR(50) NOT NULL,
  "phone"     VARCHAR(15) NOT NULL,
  "is_active" BOOLEAN     NOT NULL
);

CREATE INDEX IX_Organization_Id ON Organization ("id");
/*
 * This is an 'OFFICE' table.
 * The table has a connection with the table 'OFFICE_ORGANIZATION'
 * */
CREATE TABLE IF NOT EXISTS Office
(
  "id"        INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  "version"   INTEGER     NOT NULL,
  "name"      VARCHAR(50) NOT NULL,
  "address"   VARCHAR(50) NOT NULL,
  "phone"     VARCHAR(15) NOT NULL,
  "is_active" BOOLEAN     NOT NULL,
);

CREATE INDEX IX_Office_Id ON Office ("id");
/*
 * This is a many-to-many join table 'OFFICE_ORGANIZATION'.
 * It connects the 'ORGANIZATION' table and 'OFFICE'
 * */
CREATE TABLE IF NOT EXISTS Office_Organization
(
  "office_id" INTEGER NOT NULL,
  "organization_id" INTEGER NOT NULL,
  PRIMARY KEY("office_id","organization_id"),
  "version"   INTEGER     NOT NULL,
  FOREIGN KEY ("office_id") REFERENCES OFFICE("id"),
  FOREIGN KEY ("organization_id") REFERENCES ORGANIZATION("id"),
);
/*
 * This is an 'Document' table.
 * Table connects one to many  with table 'USER.document_id'
 * */
CREATE TABLE IF NOT EXISTS Document
(
  "id"      INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  "version" INTEGER     NOT NULL,
  "code"    VARCHAR(3)  NOT NULL,
  "name"    VARCHAR(60) NOT NULL,
  "date"    VARCHAR(15) NOT NULL
);

CREATE INDEX IX_Document_Id ON Document ("id");
/*
 * This is an 'COUNTRY' table.
 * Table connects one to one with table 'USER.country_id'
 * */
CREATE TABLE IF NOT EXISTS Country
(
  "id"      INTEGER     NOT NULL PRIMARY KEY  AUTO_INCREMENT,
  "version" INTEGER     NOT NULL,
  "code"    VARCHAR(3)  NOT NULL,
  "name"    VARCHAR(60) NOT NULL
);

CREATE INDEX IX_Country_Id ON Country ("id");

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
  "id"            INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  "version"       INTEGER     NOT NULL,
  "country_id"    INTEGER,
  "document_id"    INTEGER,
  "office_id"     INTEGER,
  "first_name"    VARCHAR(50) NOT NULL,
  "middle_name"   VARCHAR(50) NOT NULL,
  "second_name"   VARCHAR(50) NOT NULL,
  "position"      VARCHAR(20) NOT NULL,
  "phone"         VARCHAR(15) NOT NULL,
  "is_identified"  BOOLEAN     NOT NULL,

  FOREIGN KEY ("office_id") REFERENCES Office ("id"),
  FOREIGN KEY ("country_id") REFERENCES Country("id"),
  FOREIGN KEY ("document_id") REFERENCES Document("id")
);

CREATE INDEX IX_User_Id ON User ("id");
CREATE INDEX IX_User_Country_Id ON User ("country_id");
CREATE INDEX IX_User_Document_Id ON User ("country_id");
CREATE INDEX IX_User_Office_Id ON User ("office_id");
