package com.adoyo.soap_web_services.soap;

import com.adoyo.soap_web_services.bean.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDetailsService {

    private static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1," Spring","Wonderful framework"));
        courses.add(new Course(2,"Spring Boot","Worth learning"));
        courses.add(new Course(3,"Soap","A lot of XML"));
    }
}
