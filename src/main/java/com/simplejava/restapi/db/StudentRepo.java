package com.simplejava.restapi.db;

import com.simplejava.restapi.beans.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepo {

    public static List<Student> getStudents(){
        List<Student> studentList = Arrays.asList(
                new Student(1, "Eugene","Alproviz"),
                new Student(2,"Subha","Singh"),
                new Student(3,"Ashish","Dubey"),
                new Student(4, "vicky","prasad"));

        return studentList;

    }
}
