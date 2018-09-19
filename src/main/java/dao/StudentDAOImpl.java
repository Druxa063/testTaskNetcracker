package dao;

import model.Group;
import model.Student;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
@Transactional(readOnly = true)
@SuppressWarnings("JpaQlInspection")
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Student save(Student student) {
        if(student.isNew()) {
            em.persist(student);
        } else {
            return em.merge(student);
        }
        return student;
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.createQuery("DELETE FROM Student s WHERE s.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Student get(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public Group getGroup(String group) {
        List<Group> list = em.createQuery("SELECT g FROM Group g WHERE g.numberGroup=:group", Group.class)
                .setParameter("group", group)
                .getResultList();
        return DataAccessUtils.singleResult(list);
    }

    @Override
    public List<Student> getAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public List<Student> search(String param) {
        List<Student> studentList = em.createQuery("SELECT s FROM Student s WHERE s.lastName LIKE :param OR s.firstName LIKE :param OR" +
                " s.group.numberGroup LIKE :param OR s.group.faculty LIKE :param", Student.class)
                .setParameter("param", "%" + param + "%")
                .getResultList();
        return studentList;
    }
}
