package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);

//            queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);
            
//            updateStudent(studentDAO);

            deleteTheStudent(studentDAO);
        };
    }

    private void deleteTheStudent(StudentDAO studentDAO) {
        int studentId = 3;

        studentDAO.deleteStudent(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve the student based on id

        int studentId = 1;

        Student myStudent = studentDAO.findById(studentId);

        //change first name

        System.out.println("Updating student.....");
        myStudent.setFirstName("Scooby");

        //update student
        studentDAO.updateStudent(myStudent);

        //display updated student
        System.out.println(myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of Student

        List<Student> theStudents = studentDAO.findByLastName("k");
        System.out.println("The Seach reults is");

        // display list of students
        for (Student tempStudent: theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        //get a list of all the students

        List<Student> theStudents = studentDAO.findAll();


        //and the display the students

        for (Student tempStudent: theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void readStudent(StudentDAO studentDAO) {

        //create new student object

        System.out.println("Creating a new Student....");

        Student tempStudent = new Student("Dhoni", "M S","msd@gmail.com");


        //save the student

        studentDAO.save(tempStudent);

        //display the id of the student

        int myStudentId = tempStudent.getId();
        System.out.println("Student Id is "+ myStudentId);


        //retrieve student based on id: primary key

        System.out.println("Retreiving the Student by ID");
        Student myStudent = studentDAO.findById(1);

        //display student
        System.out.println("Id again "+ myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        System.out.println("Creating a 3 new student....");

        var tempStudent2 = new Student("Aby","K","abyk@gmail.com");
        var tempStudent3 = new Student("Krish","Roy","krishroy@gmail.com");
        var tempStudent4 = new Student("Ravi","K","ravik@gmail.com");

        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
        studentDAO.save(tempStudent4);

    }

    private void createStudent(StudentDAO studentDAO) {

        //create a student object

        System.out.println("Creating a new student....");

        var tempStudent = new Student("John","Doe","johndoe@gmail.com");

        //save the student object

        System.out.println("Saving the Student");
        studentDAO.save(tempStudent);



        //display id of the saved student
        System.out.println("Student id is " + tempStudent.getId());
    }


}
