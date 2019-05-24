//package ru.bellintegrator.practice.controller;
//
//
//import com.wolterskluwer.fsi.da.util.TestProperties;
//import com.wolterskluwer.fsi.link.LinkResolverApplication;
//import com.wolterskluwer.fsi.link.model.InputOutput;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.nio.charset.StandardCharsets;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@TestPropertySource(locations = {"classpath:test-application.properties", "classpath:test.properties"})
//@ContextConfiguration(classes = TestProperties.class)
//@SpringBootTest(classes = LinkResolverApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class LinkResolverControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    TestProperties testProperties;
//
//    private String baseUrl = "/resolve/?link=";
//    private TestRestTemplate restTemplate = new TestRestTemplate();
//    private InputOutput inputOutput;
//    private HttpEntity<InputOutput> entity;
//
//    @Before
//    public void setUp() {
//        inputOutput = new InputOutput();
//        entity = new HttpEntity<>(inputOutput);
//    }
//
//    @Test
//    public void resolveEncryptedLinkOK() throws UnsupportedEncodingException {
//        final String params = "/?LinkType=3&UserGroupID=" + testProperties.getUserGroupId() + "&TemplateGroupID="
//                + testProperties.getTemplateGroupId() + "&TemplateID=" + testProperties.getTemplateId()
//                + "&locale=en&FixedValues&embedded=OEM&preview";
//        inputOutput.setClearText(createURLWithPort(params));
//
//        ResponseEntity<InputOutput> encryptedResponse = restTemplate.exchange(
//                createURLWithPort("/encrypt/"),
//                HttpMethod.POST, entity, InputOutput.class);
//
//        assertNotNull(encryptedResponse.getBody());
//        final String encryptedParams = encryptedResponse.getBody().getCypherText();
//        final String linkParam = encryptedParams.substring(encryptedParams.indexOf("=") + 1);
//        final String decodeLinkParam = URLDecoder.decode(linkParam, StandardCharsets.UTF_8.name());
//
//        final ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort(baseUrl + decodeLinkParam),
//                HttpMethod.GET, null, String.class);
//
//        assertNotNull(response);
//        assertEquals(HttpStatus.FOUND, response.getStatusCode());
//    }
//
//    @Test
//    public void resolveEncryptedLinkKOUnknownLinkType() throws UnsupportedEncodingException {
//        final String params = "/?UserGroupID=" + testProperties.getUserGroupId() + "&TemplateGroupID="
//                + testProperties.getTemplateGroupId() + "&TemplateID=" + testProperties.getTemplateId()
//                + "&locale=en&FixedValues&embedded=OEM&preview";
//
//        inputOutput.setClearText(createURLWithPort(params));
//        ResponseEntity<InputOutput> encryptedResponse = restTemplate.exchange(
//                createURLWithPort("/encrypt/"),
//                HttpMethod.POST, entity, InputOutput.class);
//
//        assertNotNull(encryptedResponse.getBody());
//
//        final String encryptedParams = encryptedResponse.getBody().getCypherText();
//        final String linkParam = encryptedParams.substring(encryptedParams.indexOf("=") + 1);
//        final String decodeLinkParam = URLDecoder.decode(linkParam, StandardCharsets.UTF_8.name());
//
//        final ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort(baseUrl + decodeLinkParam),
//                HttpMethod.GET, null, String.class);
//
//        assertNotNull(response);
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//    }
//
//    @Test
//    public void resolveEncryptedLinkKOPlatformLinkTypeInvalidToken() throws UnsupportedEncodingException {
//        final String params = "/?LinkType=2&UserGroupID=" + testProperties.getUserGroupId() + "&TemplateGroupID="
//                + testProperties.getTemplateGroupId() + "&TemplateID=" + testProperties.getTemplateId()
//                + "&locale=en&FixedValues&embedded=OEM&preview";
//
//        inputOutput.setClearText(createURLWithPort(params));
//        ResponseEntity<InputOutput> encryptedResponse = restTemplate.exchange(
//                createURLWithPort("/encrypt/"),
//                HttpMethod.POST, entity, InputOutput.class);
//
//        assertNotNull(encryptedResponse.getBody());
//
//        final String encryptedParams = encryptedResponse.getBody().getCypherText();
//        final String linkParam = encryptedParams.substring(encryptedParams.indexOf("=") + 1);
//        final String decodeLinkParam = URLDecoder.decode(linkParam, StandardCharsets.UTF_8.name());
//
//        final ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort(baseUrl + decodeLinkParam),
//                HttpMethod.GET, null, String.class);
//
//        //TODO change when will have IdP redirection
//        assertNotNull(response);
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//    }
//
//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + uri;
//    }
//
//}
