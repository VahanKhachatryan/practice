package ru.bellintegrator.practice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bellintegrator.practice.PracticeApplication;
import ru.bellintegrator.practice.model.Organization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
@SpringBootTest(classes = PracticeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class OrganizationControllerTest {


    private TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    private int port;


    @Test
    public void organizations() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/organization/list?name=Oracle&inn=111&isActive=true"),
                HttpMethod.POST, null, Organization.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());


    }

    @Test
    public void orgById() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/organization/{id}"),
                HttpMethod.GET, null, Organization.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());
    }
    @Test
    public void save() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/organization/save"),
                HttpMethod.POST, null, Organization.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());
    }
    @Test
    public void update() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/organization/update"),
                HttpMethod.PUT, null, Organization.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}