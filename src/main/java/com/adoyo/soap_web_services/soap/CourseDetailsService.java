package com.adoyo.soap_web_services.soap;

import com.adoyo.soap_web_services.bean.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseDetailsService {

    private static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1," Spring","Wonderful framework"));
        courses.add(new Course(2,"Spring Boot","Worth learning"));
        courses.add(new Course(3,"Soap","A lot of XML"));
    }

    public Course findCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public List<Course> findAllCourses() {
        return courses;
    }

    public int deleteById(int id) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getId() == id) {
                iterator.remove();
                return 1;
            }
        }
        return 0;
    }
}
