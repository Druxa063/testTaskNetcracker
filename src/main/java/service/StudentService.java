package service;

import model.Group;
import model.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    Student create(Student student);

    Student update(Student student);

    void delete(int id);

    Student get(int id);

    Group getGroup(String group);

    List<Student> getAll();

    List<Student> search(String param, LocalDate startDate, LocalDate endDate);
}
