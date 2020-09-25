package com.cg.bootcamp.healthcare.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class AppointmentControllerTest {

    RestTemplate template;

    @BeforeEach
    public void setUp() {
        template = new RestTemplate();
    }

    @Test
    void viewAllAppointment() {
        //url
        String url = "http://localhost:9090/appointment/all";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String accessToken = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW0iLCJleHAiOjE2MDEwMjg2MzUsImlhdCI6MTYwMTAxMDYzNX0.nZiBZM9xZ1lX2VqBVQAdW_QGSBHlGxHQo6FBw2wE4E10JaFwQ-z0Stlj_Ac2IWbq5t-njHy0bJKcVPcMCP_rrQ";
        headers.set("Authorization", accessToken);
        // build the request
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = template.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful for viewing all appointments.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed for for viewing all appointments.");
            System.out.println(response.getStatusCode());
        }
    }

    @Test
    void viewAllAppointmentByUser() {
        //url
        String url = "http://localhost:9090/appointment/byuser/13";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String accessToken = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW0iLCJleHAiOjE2MDEwMjg2MzUsImlhdCI6MTYwMTAxMDYzNX0.nZiBZM9xZ1lX2VqBVQAdW_QGSBHlGxHQo6FBw2wE4E10JaFwQ-z0Stlj_Ac2IWbq5t-njHy0bJKcVPcMCP_rrQ";
        headers.set("Authorization", accessToken);
        // build the request
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = template.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful for viewing all appointments by user Id.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed for for viewing all appointments by user Id.");
            System.out.println(response.getStatusCode());
        }
    }

    @Test
    void viewAllAppointmentByDiagnosticCenter() {
        //url
        String url = "http://localhost:9090/appointment/bycenter/8";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String accessToken = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW0iLCJleHAiOjE2MDEwMjg2MzUsImlhdCI6MTYwMTAxMDYzNX0.nZiBZM9xZ1lX2VqBVQAdW_QGSBHlGxHQo6FBw2wE4E10JaFwQ-z0Stlj_Ac2IWbq5t-njHy0bJKcVPcMCP_rrQ";
        headers.set("Authorization", accessToken);
        // build the request
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = template.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful for viewing all appointments by center Id.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed for for viewing all appointments by center Id.");
            System.out.println(response.getStatusCode());
        }
    }

    @Test
    void findAppointment() {
        //url
        String url = "http://localhost:9090/appointment/find/13";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String accessToken = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW0iLCJleHAiOjE2MDEwMjg2MzUsImlhdCI6MTYwMTAxMDYzNX0.nZiBZM9xZ1lX2VqBVQAdW_QGSBHlGxHQo6FBw2wE4E10JaFwQ-z0Stlj_Ac2IWbq5t-njHy0bJKcVPcMCP_rrQ";
        headers.set("Authorization", accessToken);
        // build the request
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = template.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.FOUND) {
            System.out.println("Request Successful for find appointment by Id.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed for find appointment by Id.");
            System.out.println(response.getStatusCode());
        }
    }

    @Test
    void addAppointment() {
        // request url
        String url = "http://localhost:9090/appointment/add";

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String accessToken = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW0iLCJleHAiOjE2MDEwMjg2MzUsImlhdCI6MTYwMTAxMDYzNX0.nZiBZM9xZ1lX2VqBVQAdW_QGSBHlGxHQo6FBw2wE4E10JaFwQ-z0Stlj_Ac2IWbq5t-njHy0bJKcVPcMCP_rrQ";
        headers.set("Authorization", accessToken);
        // request body parameters
        Map<String, Object> map = new HashMap<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("userId", 14);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("centerId", 3);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("testId", 6);
        map.put("user", map1);
        map.put("diagnosticCenter", map2);
        map.put("test", map3);
        map.put("appointmentTime", "2020-09-25T11:00:00.000+00:00");
        map.put("approved", false);
        map.put("appointmentDate", "2020-09-27");

        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        // send POST request
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        // check response
        if (response.getStatusCode() == HttpStatus.CREATED) {
            System.out.println("Request Successful to add a new appointment.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed to add a new appointment.");
            System.out.println(response.getStatusCode());
        }
    }

    @Test
    void deleteAppointment() {
        //url
        String url = "http://localhost:9090/appointment/delete/21";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String accessToken = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW0iLCJleHAiOjE2MDEwMjg2MzUsImlhdCI6MTYwMTAxMDYzNX0.nZiBZM9xZ1lX2VqBVQAdW_QGSBHlGxHQo6FBw2wE4E10JaFwQ-z0Stlj_Ac2IWbq5t-njHy0bJKcVPcMCP_rrQ";
        headers.set("Authorization", accessToken);
        // build the request
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = template.exchange(
                url,
                HttpMethod.DELETE,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful for Deleting appointment by Id.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed for deleting appointment by Id.");
            System.out.println(response.getStatusCode());
        }
    }

    @Test
    void updateAppointment() {
        // request url
        String url = "http://localhost:9090/appointment/update/17";

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String accessToken = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW0iLCJleHAiOjE2MDEwMjg2MzUsImlhdCI6MTYwMTAxMDYzNX0.nZiBZM9xZ1lX2VqBVQAdW_QGSBHlGxHQo6FBw2wE4E10JaFwQ-z0Stlj_Ac2IWbq5t-njHy0bJKcVPcMCP_rrQ";
        headers.set("Authorization", accessToken);
        // request body parameters
        Map<String, Object> map = new HashMap<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("userId", 14);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("centerId", 3);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("testId", 6);
        map.put("user", map1);
        map.put("diagnosticCenter", map2);
        map.put("test", map3);
        map.put("appointmentTime", "2020-10-29T12:00:00.000+00:00");
        map.put("approved", false);
        map.put("appointmentDate", "2020-10-29");

        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        // send POST request
        ResponseEntity<String> response = template.exchange(
                url,
                HttpMethod.PUT,
                entity,
                String.class,
                1
        );
        // check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful updated the appointment.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed to updated the appointment.");
            System.out.println(response.getStatusCode());
        }
    }

    @Test
    void approveAppointment() {
        //url
        String url = "http://localhost:9090/appointment/approve/13";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String accessToken = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW0iLCJleHAiOjE2MDEwMjg2MzUsImlhdCI6MTYwMTAxMDYzNX0.nZiBZM9xZ1lX2VqBVQAdW_QGSBHlGxHQo6FBw2wE4E10JaFwQ-z0Stlj_Ac2IWbq5t-njHy0bJKcVPcMCP_rrQ";
        headers.set("Authorization", accessToken);
        // build the request
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = template.exchange(
                url,
                HttpMethod.PUT,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful for Approving appointment by Id.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed for Approving appointment by Id.");
            System.out.println(response.getStatusCode());
        }
    }
}