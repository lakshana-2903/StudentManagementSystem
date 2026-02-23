package com.school.dao;
import java.util.List;
import com.school.model.Student;
public interface StudentDAO {
    void addStudent(Student student);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
}
