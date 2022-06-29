package pl.sda.arppl4.hibernate;

import pl.sda.arppl4.hibernate.dao.StudentDao;
import pl.sda.arppl4.hibernate.model.Student;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //tworzymy narzedzie do konfiguracji hibernate

        Student student = new Student(null, "Pawel", "Gawel", "123", LocalDate.now());

        StudentDao dao = new StudentDao();
        dao.addStudent(student);
        List<Student> list = dao.returnStudentsList();
        System.out.println("Studenci" + list);
    }
}
