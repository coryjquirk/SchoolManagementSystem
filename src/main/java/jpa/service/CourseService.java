package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

//implements jpa.dao.CourseDAO
//will be used to interact with Courses DB table
public class CourseService implements CourseDAO {
    //getAllCourses input None returns List<Course>

    @Override
    public List<Course> getAllCourses(){
        //–This method takes no parameter and returns every
        //Course in the table
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "From Course";
        TypedQuery typedQuery = session.createQuery(hql);
        typedQuery.getResultList();
        List<Course> courses = typedQuery.getResultList();

        System.out.println("courses: ");
        int COURSE_ID;
        for (int i=0; i < courses.size(); i++){
            COURSE_ID = (i+1);
            Course courseprinter = session.load(Course.class, COURSE_ID);
            System.out.println("-------------");
            System.out.println(courseprinter.getcId());
            System.out.println(courseprinter.getcName());
            System.out.println(courseprinter.getcInstructorName());
        }
        //now later we know we can access elements of Course by using typedQuery.getResultList().

        factory.close();
        session.close();
        return courses;
    }
}
