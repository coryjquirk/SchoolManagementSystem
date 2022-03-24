import jpa.dao.StudentDAO;
import jpa.entitymodels.Student;
import jpa.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestGetStudentByEmail {
    private static StudentDAO studentService;

    @BeforeAll
    public static void setup() {
        studentService = new StudentService();
    }

    @Test
    public void testGetStudentByEmail() {
        Student expected = new Student();
        expected.setStudentEmail("cstartin3@flickr.com");
        expected.setStudentName("Clem Startin");
        expected.setPassword("XYHzJ1S");

        Student actual = studentService.getStudentByEmail("cstartin3@flickr.com");

        Assertions.assertEquals(expected.getStudentEmail(), actual.getStudentEmail());
        Assertions.assertEquals(expected.getStudentName(), actual.getStudentName());
        Assertions.assertEquals(expected.getPassword(), actual.getPassword());
    }
}