
CREATE TABLE IF NOT EXISTS Access
(
  id        INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version   INTEGER     NOT NULL,
  login     VARCHAR(20) NOT NULL,
  password  VARCHAR(20),
  name      VARCHAR(50) NOT NULL,
  is_active BOOLEAN     NOT NULL
);

CREATE INDEX IX_Access_Id ON Access (id);

CREATE TABLE IF NOT EXISTS Organization
(
  id        INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version   INTEGER     NOT NULL,
  name      VARCHAR(50) NOT NULL,
  full_name VARCHAR(50) NOT NULL,
  inn       VARCHAR(12) NOT NULL,
  kpp       VARCHAR(9)  NOT NULL,
  address   VARCHAR(50) NOT NULL,
  phone     VARCHAR(15) NOT NULL,
  is_active BOOLEAN     NOT NULL
);

CREATE INDEX IX_Organization_Id ON Organization (id);

CREATE TABLE IF NOT EXISTS Office
(
  id        INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version   INTEGER     NOT NULL,
  org_id    INTEGER,
  name      VARCHAR(50) NOT NULL,
  address   VARCHAR(50) NOT NULL,
  phone     VARCHAR(15) NOT NULL,
  is_active BOOLEAN     NOT NULL,
  FOREIGN KEY (org_id) REFERENCES Organization (id)
);

CREATE INDEX IX_Office_Id ON Office (id);
CREATE INDEX IX_Office_Org_Id ON Office (org_id);

CREATE TABLE IF NOT EXISTS Doc_Type
(
  id      INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version INTEGER     NOT NULL,
  code    VARCHAR(3)  NOT NULL,
  name    VARCHAR(60) NOT NULL
);

CREATE INDEX IX_Doc_Type_Id ON Doc_Type (id);

CREATE TABLE IF NOT EXISTS Country
(
  id      INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version INTEGER     NOT NULL,
  code    VARCHAR(3)  NOT NULL,
  name    VARCHAR(60) NOT NULL
);

CREATE INDEX IX_Country_Id ON Country (id);

CREATE TABLE IF NOT EXISTS User
(
  id            INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version       INTEGER     NOT NULL,
  doc_type_id   INTEGER,
  country_id    INTEGER,
  office_id     INTEGER,
  first_name    VARCHAR(50) NOT NULL,
  middle_name   VARCHAR(50) NOT NULL,
  second_name   VARCHAR(50) NOT NULL,
  position      VARCHAR(20) NOT NULL,
  phone         VARCHAR(15) NOT NULL,
  doc_number    VARCHAR(10) NOT NULL,
  doc_date      VARCHAR(15) NOT NULL,
  is_identified BOOLEAN     NOT NULL,
  FOREIGN KEY (doc_type_id) REFERENCES Doc_Type (id),
  FOREIGN KEY (country_id) REFERENCES Country (id),
  FOREIGN KEY (office_id) REFERENCES Office (id),
);

CREATE INDEX IX_User_Id ON User (id);
CREATE INDEX IX_User_Doc_Type_Id ON User (doc_type_id);
CREATE INDEX IX_User_Country_Id ON User (country_id);
CREATE INDEX IX_User_Office_Id ON User (office_id);