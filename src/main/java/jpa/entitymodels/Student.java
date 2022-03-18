package jpa.entitymodels;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {
    private String sEmail;
    private String sName;
    private String sPass;

    public Student() {
    }

    public Student(String sEmail, String sName, String sPass) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
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
}
