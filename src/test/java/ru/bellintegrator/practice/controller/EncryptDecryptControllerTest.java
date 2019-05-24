//package ru.bellintegrator.practice.controller;
//
//import com.wolterskluwer.fsi.link.LinkResolverApplication;
//import com.wolterskluwer.fsi.link.model.InputOutput;
//import org.apache.commons.lang3.time.StopWatch;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//
//@RunWith(SpringRunner.class)
//@TestPropertySource("classpath:test-application.properties")
//@SpringBootTest(classes = LinkResolverApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class EncryptDecryptControllerTest {
//
//    private static final Logger log = LoggerFactory.getLogger(EncryptDecryptControllerTest.class);
//
//
//    @LocalServerPort
//    private int port;
//
//    private StopWatch watch = new StopWatch();
//    private TestRestTemplate restTemplate = new TestRestTemplate();
//    private HttpEntity<InputOutput> entity;
//    private InputOutput inputOutput;
//    private final String clearText = "/?UserGroupID=C56D939D485C425E8804B939DA1CD643&TemplateGroupID=A28CBC1A72A34737B849ED88E0D74C0B&TemplateID=F265CA14ED5F47DE92CBBF43BAA848E7&locale=en&FixedValues&embedded=OEM&preview";
//    private final String cypherText = "/?link=AYADePIG9iagI3HEC5qV1mPZCLMAXwABABVhd3MtY3J5cHRvLXB1YmxpYy1rZXkAREFrYkFyRnhaRUliNlZaZzVIVWlTRWJDUnVUMXJMVGN6b3FTNG5pWSthSmR1ZmlNNjM2b3M4OUVNaE43WWFvWWtQdz09AAEAB2F3cy1rbXMATmFybjphd3M6a21zOmV1LWNlbnRyYWwtMTozMjc2MTYyMzk5NDg6a2V5LzZlNWRmY2VlLWQ4ZWMtNDUzMC04YTk5LWI5NmZiNTE2N2ZmOAC4AQIBAHj7JHv0VfXSob9fOUyQSbSuqCImz%252Fu3SQP9mTKUZQkEAQGc28ShsY%252F3EHBHr4%252F7jVkrAAAAfjB8BgkqhkiG9w0BBwagbzBtAgEAMGgGCSqGSIb3DQEHATAeBglghkgBZQMEAS4wEQQMXeE9%252FKVoIAZ0gQ8nAgEQgDu505O39A4VRR3YxHE06mewQnEnsA%252FuBz619L9KXixRQpp6iN3%252B71rq1nei264dh5zjwrO8z0MSfodJnQIAAAAADAAAEAAAAAAAAAAAAAAAAADf998Jlc7yWsBb7aSju2ds%252F%252F%252F%252F%252FwAAAAEAAAAAAAAAAAAAAAEAAAC0RyexiQBIk7droPIgQBzMedN5F%252BreCC5pqQwF2079JJNQOLM24rIqfFNRnTLgzg%252BYfo08PWA53ZX7mxo4%252F1L7Gkv7jhso6FNQ9abXfnFY%252BUg2iUx%252B9Sm4AXp7s3KzPLxpmrjgFdbH74rKjwbLwJHZbx67r3FXPmTeML6Dk5LWAp6Jr%252Fve4bqJnndsYYQe88WhxNzEcQPcSOC4yuYfL1utohzR1rhC%252BPOX6MyivH6ZjmVqVvtYVUPU%252FYt5CUihN3tFhmZVWQBnMGUCMQDwBww766RtduUSkIJtiwp9Ari9TfWGc4p%252F%252BJyetpViPh7KK1I9CFJEkX0ZkTTGvH8CMFb0FYF4OBMRM0LfK6aWQT9Qzbc5rFoBGtGIV4wiwa%252FGTQwn3Ir27Gppw4F8Yq%252BLCw%253D%253D";
//
//
//    @Before
//    public void setUp() {
//        inputOutput = new InputOutput();
//        entity = new HttpEntity<>(inputOutput);
//    }
//
//    @Test
//    public void postEncryptTestCase() {
//
//        inputOutput.setClearText(createURLWithPort(clearText));
//        watch.start();
//        ResponseEntity<InputOutput> response = restTemplate.exchange(
//                createURLWithPort("/encrypt/"),
//                HttpMethod.POST, entity, InputOutput.class);
//        watch.stop();
//        log.info("First encryption request time: {}", watch.getTime());
//
//        assertNotNull(response);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertNotNull(response.getBody().getCypherText());
//
//        watch.reset();
//
//        watch.start();
//        restTemplate.exchange(
//                createURLWithPort("/encrypt/"),
//                HttpMethod.POST, entity, InputOutput.class);
//        watch.stop();
//        log.info("Second encryption request time: {}", watch.getTime());
//
//        watch.reset();
//
//        watch.start();
//        restTemplate.exchange(
//                createURLWithPort("/encrypt/"),
//                HttpMethod.POST, entity, InputOutput.class);
//        watch.stop();
//        log.info("Third encryption request time: {}", watch.getTime());
//
//    }
//
//    @Test
//    public void postDecryptTestCase() {
//        inputOutput.setCypherText(createURLWithPort(cypherText));
//        watch.start();
//        ResponseEntity<InputOutput> response = restTemplate.exchange(
//                createURLWithPort("/decrypt/"),
//                HttpMethod.POST, entity, InputOutput.class);
//        watch.stop();
//        log.info("First decryption request time: {}", watch.getTime());
//
//        assertNotNull(response);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertNotNull(response.getBody().getClearText());
//
//        watch.reset();
//
//        watch.start();
//        restTemplate.exchange(
//                createURLWithPort("/decrypt/"),
//                HttpMethod.POST, entity, InputOutput.class);
//        watch.stop();
//        log.info("Second decryption request time: {}", watch.getTime());
//
//        watch.reset();
//
//        watch.start();
//        restTemplate.exchange(
//                createURLWithPort("/decrypt/"),
//                HttpMethod.POST, entity, InputOutput.class);
//        watch.stop();
//        log.info("Third decryption request time: {}", watch.getTime());
//
//    }
//
//
//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + uri;
//    }
//
//
//}
