# SchoolManagementSystem
AD - SBA - Core Java/Hibernate/JUnit

## Usage 
Run the `SMSRunner` class to enter the application. Enter a valid username and password combination to log in.  
In `hibernate.cfg.xml`, please change the following connection string to match the port used for MariaDB:  
`<property name="connection.url">jdbc:mysql://localhost:3306/sms</property>`

## Explanation  
This app uses Hibernate to interact with a SQL database. The file `InitDB` initializes a sample database.

## Testing  
There is a JUnit test in /src/test/java to test the integrity of the `StudentService` class's `getStudentByEmail` method.

## Future development
There are still a few menu navigation bugs I am working out.

## Sample Usage 
```
Please select an option:
1. Student Login
2. Quit
   1
   Log in:
   Enter your email:
   cstartin3@flickr.com
   Enter your password:
   XYHzJ1S
   Welcome, Clem Startin.
   You are not registered to any courses.
   Please select one of the following:
1. Register for course
2. View your courses
3. Quit
   1
   Register for courses:
   All available courses:
   COURSE ID            COURSE NAME                    INSTRUCTOR NAME     
   1                    English                        Anderea Scamaden    
   2                    Mathematics                    Eustace Niemetz     
   3                    Anatomy                        Reynolds Pastor     
   4                    Organic Chemistry              Odessa Belcher      
   5                    Physics                        Dani Swallow        
   6                    Digital Logic                  Glenden Reilingen   
   7                    Object Oriented Programming    Giselle Ardy        
   8                    Data Structures                Carolan Stoller     
   9                    Politics                       Carmita De Maine    
   10                   Art                            Kingsly Doxsey      
   Enter a number to choose register for one of the above:
   5
   What next?
   Please select one of the following:
1. Register for course
2. View your courses
3. Quit
   2
   Your currently enrolled courses:
   COURSE ID            COURSE NAME                    INSTRUCTOR NAME     
   5                    Physics                        Dani Swallow        
   Please select one of the following:
1. Register for course
2. View your courses
3. Quit
```