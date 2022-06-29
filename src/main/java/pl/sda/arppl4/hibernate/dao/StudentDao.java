package pl.sda.arppl4.hibernate.dao;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.arppl4.hibernate.model.Student;
import pl.sda.arppl4.hibernate.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDao implements IStudentDao {

    @Override
    public void addStudent(Student student) {
        // Create
        SessionFactory factory = HibernateUtil.INSTANCE.getSessionFactory();

        Transaction transaction = null;
        // Try with resources
        try (Session session = factory.openSession()) {
            //      ACID
            // - ATOMICITY
            // - CONSISTENCY
            // - ISOLATION
            // - DURABILITY

            transaction = session.beginTransaction();
            session.save(student);

            transaction.commit();
        } catch (SessionException se) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeStudent(Student student) {

    }

    @Override
    public Optional<Student> returnStudent(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Student> returnStudentsList() {
        // Tworzymy pusta liste. Pozniej dodamy do niej obiekty, jesli baza zwroci obiekty.
        List<Student> studentList = new ArrayList<>();

        SessionFactory factory = HibernateUtil.INSTANCE.getSessionFactory();
        try (Session session = factory.openSession()) {
            TypedQuery <Student> question = session.createQuery("from Student", Student.class);
            List<Student> resultOfQuestion = question.getResultList();

            studentList.addAll(resultOfQuestion);
        } catch (SessionException se) {
            System.err.println("Błąd wczytywania danych");
        }
        return studentList;
    }

    @Override
    public void updateStudent(Student student) {

    }
}
