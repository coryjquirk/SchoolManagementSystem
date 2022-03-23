package jpa.entitymodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENTS")
public class Student {
    private String sEmail;
    private String sName;
    private String sPass;
    private List<Course> sCourses;

    public Student() {
        this.sEmail = "";
        this.sName = "";
        this.sPass = "";
        this.sCourses = new ArrayList<>();
    }

    public Student(String sEmail, String sName, String sPass) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.sCourses = sCourses;
    }

    @Column(name = "email", length = 50, unique = true, nullable = false)
    @Id
    public String getStudentEmail() {
        return sEmail;
    }

    public void setStudentEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    @Column(name = "name", length = 50, nullable = false)
    public String getStudentName() {
        return sName;
    }

    public void setStudentName(String sName) {
        this.sName = sName;
    }

    @Column(name = "password", length = 50, nullable = false)
    public String getPassword() {
        return sPass;
    }

    public void setPassword(String sPass) {
        this.sPass = sPass;
    }

    //will write join here `@ManyToMany` etc
    public List<Course> getCourses() {
        return sCourses;
    }

    public void setCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }
}
