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
import ru.bellintegrator.practice.model.Office;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
@SpringBootTest(classes = PracticeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class OfficeControllerTest {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    private int port;

    @Test
    public void offices() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/office/list?name=OracleOffice&phone=111&isActive=true"),
                HttpMethod.POST, null, Office.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());
    }

    @Test
    public void officeById() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/office/{id}"),
                HttpMethod.GET, null, Office.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());
    }
    @Test
    public void save() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/office/save"),
                HttpMethod.POST, null, Office.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());
    }
    @Test
    public void update() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/office/update"),
                HttpMethod.PUT, null, Office.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}