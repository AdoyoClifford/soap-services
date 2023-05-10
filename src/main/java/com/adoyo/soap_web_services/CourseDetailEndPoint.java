package com.adoyo.soap_web_services;

import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.GetCourseDetailRequest;
import com.in28minutes.courses.GetCourseDetailResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailEndPoint {

    @PayloadRoot(namespace = "http://in28minutes.com/courses",localPart = "GetCourseDetailRequest")
    @ResponsePayload
    public GetCourseDetailResponse processCourseDetailsResponse(@RequestPayload GetCourseDetailRequest courseDetailRequest) {
        GetCourseDetailResponse response = new GetCourseDetailResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(courseDetailRequest.getId());
        courseDetails.setName("Microservces");
        courseDetails.setDescription("That is a wonderful course");
        return response;
    }
}
