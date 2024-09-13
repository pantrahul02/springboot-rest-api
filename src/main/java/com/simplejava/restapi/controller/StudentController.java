package com.simplejava.restapi.controller;

import com.simplejava.restapi.beans.Student;
import com.simplejava.restapi.db.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1, "Rene", "Cruze");
        return student;
    }

    // http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = StudentRepo.getStudents();
        return students;
    }

    //Spring Boot Rest API with PathVariable
    // {id} - URI template variable
    //  http://localhost:8080/student/1
    @GetMapping("/student/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId) {
        return new Student(studentId, "zinpangi", "morpha");
    }

    //REST API to handle multiple path variable

    @GetMapping("/student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    // REST API with query param
    // http://localhost:8080/student/query?id=1&firstName=Eugene&lastName=Aproviz
    @GetMapping("/student/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student studentRequestBodyMapping(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PutMapping("/student/{id}/update")
    public Student studentPostMapping(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @DeleteMapping("/student/{id}/delete")
    public String studentDeleteMapping(@PathVariable int id) {
        return "Student having ID " + id + " deleted successfully!!";
    }
}
