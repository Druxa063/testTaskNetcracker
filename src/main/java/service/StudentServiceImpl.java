package service;

import dao.StudentDAO;
import model.Group;
import model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.Util;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static util.Util.*;

@Service
public class StudentServiceImpl implements StudentService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentDAO dao;

    @Override
    public Student create(Student student) {
        log.debug("create {}", student);
        return dao.save(student);
    }

    @Override
    public Student update(Student student) {
        log.debug("update {}", student);
        return dao.save(student);
    }

    @Override
    public void delete(int id) {
        log.debug("delete {}", id);
        dao.delete(id);
    }

    @Override
    public Student get(int id) {
        log.debug("get {}", id);
        return dao.get(id);
    }

    @Override
    public Group getGroup(String group) {
        log.debug("get group {}", group);
        return dao.getGroup(group);
    }

    @Override
    public List<Student> getAll() {
        log.debug("getAll");
        return dao.getAll();
    }

    @Override
    public List<Student> search(String param, LocalDate startDate, LocalDate endDate) {
        log.debug("search {}", param);
        List<Student> search = dao.search(param).stream()
                .filter(s -> isBetween(s.getDateAdmission(), orElse(startDate, LocalDate.of(1, 1, 1)), orElse(endDate, LocalDate.of(3000, 1, 1))))
                .collect(Collectors.toList());
        return search;
    }
}
