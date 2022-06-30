package pl.sda.arppl4.hibernate;

import pl.sda.arppl4.hibernate.dao.StudentDao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDao studentDao = new StudentDao();
        Parser parser = new Parser(scanner, studentDao);
        parser.start();

//        //tworzymy narzedzie do konfiguracji hibernate
//
//        Student student = new Student(null, "Pawel", "Gawel", "123", LocalDate.now());
//
//        StudentDao dao = new StudentDao();
//        dao.addStudent(student);
//        List<Student> list = dao.returnStudentsList();
//        System.out.println("Studenci" + list);
//
//        for (Student students : list) {
//            if (students.getId() == 4){
//                dao.removeStudent(students);
//                break;
//            }
//        }
//
//        Optional<Student> optionalStudent = dao.returnStudent(5L);
//        if (optionalStudent.isPresent()) {
////            Student studentUpdate = new Student(3L, "Gawełek", "Pawełek", "555", LocalDate.now());
//            Student studentUpdate = optionalStudent.get();
//            studentUpdate.setName("Gawełek");
//            studentUpdate.setSurname("Pawełek");
//            studentUpdate.setIndexNumber("555");
//
//            dao.updateStudent(studentUpdate);
//        }
    }
}
