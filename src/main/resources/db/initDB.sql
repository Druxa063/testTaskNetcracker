DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS groups;

CREATE TABLE groups
(
  id                INTEGER PRIMARY KEY AUTO_INCREMENT,
  number_group      VARCHAR(255) NOT NULL,
  faculty           VARCHAR(255) NOT NULL
)ENGINE=INNODB;

CREATE TABLE students
(
  id                INTEGER PRIMARY KEY AUTO_INCREMENT,
  group_id          INTEGER NULL,
  lastName          VARCHAR(255) NOT NULL,
  firstName         VARCHAR(255) NOT NULL,
  dateAdmission     DATE NOT NULL,
  FOREIGN KEY (group_id) REFERENCES groups(id)
)ENGINE=INNODB;