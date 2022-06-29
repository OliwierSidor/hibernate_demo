package pl.sda.arppl4.hibernate.dao;
import pl.sda.arppl4.hibernate.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentDao {
    // Create
    public void addStudent(Student student);
    // Delete
    public void removeStudent(Student student);
    // Read
    public Optional<Student> returnStudent (Long id);
    // Read
    public List<Student> returnStudentsList();
    //Update (update student s set ... where ...)
    public void updateStudent (Student student);
}
