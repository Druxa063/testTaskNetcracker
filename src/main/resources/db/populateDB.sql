DELETE FROM students;
DELETE FROM groups;

INSERT INTO groups (number_group, faculty) VALUES
  ('---', '---'),
  ('A1', 'IT'),
  ('B1', 'IT'),
  ('C1', 'IT');

INSERT INTO students (group_id, lastName, firstName, dateAdmission) VALUES
  (2, 'StudentLastName1', 'StudentFirstName1', '2018-06-30'),
  (2, 'StudentLastName2', 'StudentFirstName2', '2018-06-30'),
  (3, 'StudentLastName3', 'StudentFirstName3', '2018-06-30'),
  (3, 'StudentLastName4', 'StudentFirstName4', '2018-06-30'),
  (4, 'StudentLastName5', 'StudentFirstName5', '2018-06-30'),
  (4, 'StudentLastName6', 'StudentFirstName6', '2018-06-30'),
  (1, 'StudentLastName7', 'StudentFirstName7', '2018-06-30'),
  (1, 'StudentLastName8', 'StudentFirstName8', '2018-06-30');