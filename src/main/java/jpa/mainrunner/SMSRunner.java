package jpa.mainrunner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.InitDB;
import jpa.service.CourseService;
import jpa.service.StudentService;

import javax.persistence.NoResultException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SMSRunner {
    private static CourseService courseDAO;
    private static StudentService studentDAO;
    private static Scanner mySc = new Scanner(System.in);
    private static String startInterface = "Please select an option: \n1. Student Login \n2. Quit";

    public static void main(String[] args) {
        InitDB initDB = new InitDB();
        initDB.InitializeDatabase();
        courseDAO = new CourseService();
        studentDAO = new StudentService();
        //just a first call of the method to test out some output from the database.
        courseDAO.getAllCourses();
        System.out.println("-------------------");
        runStart();
    }

    public static void runStart() {
        System.out.println(startInterface);
        int startOption = 0;
        try {
            startOption = Integer.parseInt(mySc.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Enter an integer to choose an option.");
        }
        switch (startOption) {
            case 1:
                System.out.println("Log in: ");
                runLogin();
                break;
            case 2:
                System.out.println("Quitting program - Good bye.");
                return;
            default:
                System.out.println("Please try again.");
                runStart();
        }
    }

    public static void runLogin() {

        System.out.println("Enter your email: ");
        String loginEmail = mySc.next();

        System.out.println("Enter your password: ");

        String loginPassword = mySc.next();
        try {
            if (studentDAO.validateStudent(loginEmail, loginPassword)) {
                Student verifiedStudent = studentDAO.getStudentByEmail(loginEmail);
                System.out.println("Welcome, " + verifiedStudent.getStudentName() + ".");
                findCurrentCourses(verifiedStudent);
                runClassMenu(verifiedStudent);
            } else {
                System.out.println("Something's not right, let's try again.");
                runStart();
            }
        } catch (NoResultException nre) {
            System.out.println("No match found, please try again.");
            runLogin();
        }
    }

    public static void runClassMenu(Student verifiedStudent) throws InputMismatchException, NumberFormatException{
        int classMenuSelection = 0;
        System.out.println("Please select one of the following: ");
        System.out.print("1. Register for course \n2. View your courses \n3. Quit\n");
        try {
            classMenuSelection = mySc.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter an integer to choose an option.");
            runClassMenu(verifiedStudent);
        }
        switch (classMenuSelection) {
            case 1:
                System.out.println("Register for courses: ");
                runCourseRegistration(verifiedStudent);
                break;
            case 2:
                findCurrentCourses(verifiedStudent);
            case 3:
                System.out.println("Quitting ");
                System.exit(classMenuSelection);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                runClassMenu(verifiedStudent);
        }
    }

    private static void findCurrentCourses(Student verifiedStudent) {
        if (studentDAO.getStudentCourses(verifiedStudent.getStudentEmail()).size() > 0) {
            List<Course> getCoursesList = studentDAO.getStudentCourses(verifiedStudent.getStudentEmail());
            System.out.println("Your currently enrolled courses: ");
            System.out.printf("%-20s %-30s %-20s%n", "COURSE ID", "COURSE NAME", "INSTRUCTOR NAME");
            getCoursesList.forEach(Course -> System.out.printf("%-20s %-30s %-20s%n", Course.getcId(), Course.getcName(), Course.getcInstructorName()));
            runClassMenu(verifiedStudent);
        } else {
            System.out.println("You are not registered to any courses.");
            runClassMenu(verifiedStudent);
        }
    }

    private static void runCourseRegistration(Student verifiedStudent) {
        int courseSelection;
        List<Course> courseList = courseDAO.getAllCourses();
        System.out.println("All available courses: ");
        System.out.printf("%-20s %-30s %-20s%n", "COURSE ID", "COURSE NAME", "INSTRUCTOR NAME");
        courseList.forEach(Course -> System.out.printf("%-20s %-30s %-20s%n", Course.getcId(), Course.getcName(), Course.getcInstructorName()));
        System.out.println("Enter a number to choose register for one of the above: ");
        try {
            courseSelection = mySc.nextInt();
            studentDAO.registerStudentToCourse(verifiedStudent.getStudentEmail(), courseSelection);
            System.out.println("What next?");
            runClassMenu(verifiedStudent);
        } catch (NoResultException nre) {
            System.out.println("Sorry, no course with that ID number. Please enter another.");
            runCourseRegistration(verifiedStudent);
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter an integer between 1 and 10.");
            runCourseRegistration(verifiedStudent);
        }
    }
}
