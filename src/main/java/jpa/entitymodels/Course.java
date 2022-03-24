package jpa.entitymodels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @Column(name="id", unique = true, nullable = false)
    private int cId;
    @Column(name="name", length = 50, nullable = false)
    private String cName;
    @Column(name="instructor", length = 50, nullable = false)
    private String cInstructorName;

    public Course() {
        this.cId = 1;
        this.cName = "";
        this.cInstructorName = "";
    }

    public Course(int cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }


    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }
}
