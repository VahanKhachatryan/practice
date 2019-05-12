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
import org.springframework.util.Assert;
import ru.bellintegrator.practice.PracticeApplication;
import ru.bellintegrator.practice.model.Country;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
@SpringBootTest(classes = PracticeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountryControllerTest {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    private int port;

    @Test
    public void countries() {
        String urlWithPort = createURLWithPort("/api/countries");

        final ResponseEntity<Country[]> response = restTemplate.exchange(
                urlWithPort,
                HttpMethod.GET, null, Country[].class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Country[] body = response.getBody();
        assertNotNull(body[0]);
        Assert.isInstanceOf(Country.class, body[0]);

    }

    private String createURLWithPort(String url) {
        return "http://localhost:" + port + url;
    }

}