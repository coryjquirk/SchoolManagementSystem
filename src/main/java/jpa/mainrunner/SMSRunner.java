package jpa.mainrunner;

import jpa.service.CourseService;

public class SMSRunner {

    private static CourseService courseService;

    public static void main(String[] args) {
        courseService = new CourseService();

        //just a first method to test out some output from the database.
        courseService.getAllCourses();

        //main -
        //-This method displays and prompts the user to select one of the
        //following with the option:
        //1. Student: which allows the user to enter his/her email and
        //password and check whether or not those credentials are valid,
        //in order to log in. If the credentials are invalid the program
        //should end with an appropriate message to the student.
        //If the credentials are valid, the student is logged in and all the
        //classes the Student is registered to should be displayed.
        //Displays and prompt the student to select one of the following
        //two additional numeric (1 or 2) options that are available:

        // 1) Register to Class: Which displays all the courses in the
        //database and allows the student to select a course in which the
        //student wished to be registered. If the Student is already
        //registered in that course, display the message "You are already
        //registered in that course!", otherwise, register the student to that
        //course and save this result in your database. Also, show the
        //updated registered courses list for that student. After that end
        //the program with an appropriate message.
        // 2) Logout: Which ends the program with an appropriate
        //message.
        // 2. quit: which ends the program with an appropriate message.
    }
}
