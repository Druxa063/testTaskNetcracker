package dao;

import model.Group;
import model.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentDAO {
    Student save(Student student);
    void delete(int id);
    Student get(int id);
    Group getGroup(String group);
    List<Student> getAll();
    List<Student> search(String param);
}
