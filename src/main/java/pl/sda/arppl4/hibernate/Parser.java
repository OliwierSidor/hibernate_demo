package pl.sda.arppl4.hibernate;

import lombok.AllArgsConstructor;
import pl.sda.arppl4.hibernate.dao.StudentDao;
import pl.sda.arppl4.hibernate.model.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@AllArgsConstructor
public class Parser {
    private Scanner scanner;
    private StudentDao dao;

    public void start() {
        String text;
        do {
            System.out.println("Wpisz komendę: dodaj/usun/zmien/zwroc");
            text = scanner.next();
            if (text.equals("dodaj")) {
                System.out.println("Podaj imię");
                String name = scanner.next();
                System.out.println("Podaj nazwisko");
                String surname = scanner.next();
                System.out.println("Podaj numer indexu");
                String indexNumber = scanner.next();
                Student student = new Student(null, name, surname, indexNumber, LocalDate.now());
                dao.addStudent(student);
            } else if (text.equals("usun")) {
                System.out.println("Podaj ID studenta którego checsz usunąć");
                Long idStudent = scanner.nextLong();
                Optional<Student> studentOptional = dao.returnStudent(idStudent);
                if (studentOptional.isPresent()) {
                    dao.removeStudent(studentOptional.get());
                }
            } else if (text.equals("zmien")) {
                System.out.println("Podaj ID studenta którego checsz zmienić");
                Long idStudent = scanner.nextLong();
                Optional<Student> studentOptional = dao.returnStudent(idStudent);
                if (studentOptional.isPresent()) {
                    Student student  = studentOptional.get();
                    System.out.println("Podaj imię");
                    String name = scanner.next();
                    System.out.println("Podaj nazwisko");
                    String surname = scanner.next();
                    System.out.println("Podaj numer indexu");
                    String indexNumber = scanner.next();
                    student.setName(name);
                    student.setSurname(surname);
                    student.setIndexNumber(indexNumber);
                    dao.updateStudent(student);
                }
            } else if (text.equals("zwroc")) {
                List<Student> studentList = dao.returnStudentsList();
                for (Student student : studentList) {
                    System.out.println(student);
                }
            } else {
                System.out.println("wpisales cos glupiego");
            }
            System.out.println("Jeśli chcesz zakończyć program wpisz 'koniec'");

        } while (!text.equals("koniec"));
    }
}
