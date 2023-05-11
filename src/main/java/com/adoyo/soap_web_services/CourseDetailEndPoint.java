package com.adoyo.soap_web_services;

import com.adoyo.soap_web_services.bean.Course;
import com.adoyo.soap_web_services.soap.CourseDetailsService;
import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.GetCourseDetailRequest;
import com.in28minutes.courses.GetCourseDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailEndPoint {

    @Autowired
    CourseDetailsService service;

    @PayloadRoot(namespace = "http://in28minutes.com/courses",localPart = "GetCourseDetailRequest")
    @ResponsePayload
    public GetCourseDetailResponse processCourseDetailsResponse(@RequestPayload GetCourseDetailRequest request) {
        Course course = service.findCourseById(request.getId());


        return mapCourse(course);
    }

    private static GetCourseDetailResponse mapCourse(Course course) {
        GetCourseDetailResponse response = new GetCourseDetailResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());

        response.setCourseDetails(courseDetails);

        return response;
    }
}
