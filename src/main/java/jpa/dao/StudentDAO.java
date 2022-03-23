package jpa.dao;

import jpa.entitymodels.*;
import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    Student getStudentByEmail(String sEmail);
    Boolean validateStudent(String sEmail, String sPassword);
    void registerStudentToCourse(String sEmail, int cId);
    List<Course> getStudentCourses(String sEmail);
}
