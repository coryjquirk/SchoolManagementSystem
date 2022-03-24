package jpa.entitymodels;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "validateStudent", query = "SELECT s FROM Student s WHERE s.sEmail = :email AND s.sPass = :password")
public class Student {
    @Column(name = "email", length = 50, unique = true, nullable = false)
    @Id
    private String sEmail;
    @Column(name = "name", length = 50, nullable = false)
    private String sName;
    @Column(name = "password", length = 50, nullable = false)
    private String sPass;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
    }
    public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.sCourses = sCourses;
    }

    public String getStudentEmail() {
        return sEmail;
    }

    public void setStudentEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getStudentName() {
        return sName;
    }

    public void setStudentName(String sName) {
        this.sName = sName;
    }

    public String getPassword() {
        return sPass;
    }

    public void setPassword(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getCourses() {
        return sCourses;
    }

    public void setCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }
}
