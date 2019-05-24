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
import ru.bellintegrator.practice.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
@SpringBootTest(classes = PracticeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    private int port;

    @Test
    public void userByParamenters() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/user/list?officeId=1&firstName=Aleksandr&lastName=" +
                        "Aleksandrovich&middleName=Aleksandrov&position=TeamLead&docCode=03&countryCode=643"),
                HttpMethod.POST, null, User.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());


    }

    @Test
    public void userById() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/user/{id}"),
                HttpMethod.GET, null, User.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());
    }

    @Test
    public void save() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/user/save"),
                HttpMethod.POST, null, User.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());
    }

    @Test
    public void update() {
        final ResponseEntity response = restTemplate.exchange(
                createURLWithPort("/api/user/update"),
                HttpMethod.PUT, null, User.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getClass().getName());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}