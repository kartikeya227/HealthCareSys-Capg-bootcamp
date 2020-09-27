package com.cg.bootcamp.healthcare.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Time;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class AppointmentControllerTest {

    String jwtTokenUser = "Bearer "+"eyJhbGciOiJIUzUxMiJ9.eyJSb2xlIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV0sInN1YiI6InNoYW0iLCJleHAiOjE2MDEyMjE2NzksImlhdCI6MTYwMTIwMzY3OX0.tXPm_4P1kQFaXcJz2IOVFAeb9V9mfsHQmKgRhC59qXjAY8aqZlMrCrzLxqgi7qnPaukIfGr5omtUOk_zOJe0EQ";
    String jwtTokenAdmin = "Bearer "+"eyJhbGciOiJIUzUxMiJ9.eyJSb2xlIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJzdWIiOiJyYW0iLCJleHAiOjE2MDEyMjE4MzIsImlhdCI6MTYwMTIwMzgzMn0.6up_8z8y1UDOudl1iARroErYyMQUL1x97yOWi4UIcBRP6q-_W0tKdTKKgrHfpnXM0Z5QY9YQMtgn0TSEEPBsYw";
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
        headers.set("Authorization", jwtTokenAdmin);
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
        String url = "http://localhost:9090/appointment/byuser/2";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", jwtTokenUser);
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
        String url = "http://localhost:9090/appointment/bycenter/5";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", jwtTokenAdmin);
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
        String url = "http://localhost:9090/appointment/find/10";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", jwtTokenAdmin);
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
        headers.set("Authorization", jwtTokenUser);
        // request body parameters
        Map<String, Object> map = new HashMap<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("userId", 1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("centerId", 3);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("testId", 7);
        map.put("user", map1);
        map.put("diagnosticCenter", map2);
        map.put("test", map3);
        map.put("timestamp", "2020-9-27 15:30:00");
        map.put("approved", false);

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
        String url = "http://localhost:9090/appointment/delete/15";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", jwtTokenAdmin);
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
        String url = "http://localhost:9090/appointment/update/13";

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", jwtTokenUser);
        // request body parameters
        Map<String, Object> map = new HashMap<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("userId", 1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("centerId", 3);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("testId", 7);
        map.put("user", map1);
        map.put("diagnosticCenter", map2);
        map.put("test", map3);
        map.put("timestamp", "2020-09-27 15:30:00");
        map.put("approved", false);

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
        String url = "http://localhost:9090/appointment/approve/10";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", jwtTokenAdmin);
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