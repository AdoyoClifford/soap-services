package com.adoyo.soap_web_services;

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


    @PayloadRoot(namespace = "http://in28minutes.com/courses",localPart = "GetCourseDetailRequest")
    @ResponsePayload
    public GetCourseDetailResponse processCourseDetailsResponse(@RequestPayload GetCourseDetailRequest request) {
        GetCourseDetailResponse response = new GetCourseDetailResponse();

        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(request.getId());
        courseDetails.setName("Microservices Course");
        courseDetails.setDescription("That would be a wonderful course!");

        response.setCourseDetails(courseDetails);

        return response;
    }
}
