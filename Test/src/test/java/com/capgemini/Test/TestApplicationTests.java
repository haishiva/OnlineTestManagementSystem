package com.capgemini.Test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.capgemini.Test.entity.Question;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestApplicationTests {

	 @Autowired
     private TestRestTemplate restTemplate;

	 
	 
	
     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }
     
     @Test
     public void getQuestionById() {
    	
    	    
         ResponseEntity<Question> postResponse = restTemplate.getForEntity(getRootUrl() + "/test/getquestions/55", Question.class);
         assertNotNull(postResponse);
         assertNotNull(postResponse.getBody());
     }
     
     @Test
     public void assignTest()
     {
    	 
    	  ResponseEntity<String> postResponse = restTemplate.getForEntity(getRootUrl() + "/test/assignTest/1/alpha1",String.class);
          assertNotNull(postResponse);
          assertNotNull(postResponse.getBody());
     }
     
     @Test
     public void testDetails()
     {
    	 HttpHeaders headers = new HttpHeaders();
         HttpEntity<String> entity = new HttpEntity<String>(null, headers);
         ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/test/testdetails",
         HttpMethod.GET, entity, String.class);  
         assertNotNull(response.getBody());
     }
     
     @Test
     public void getTestById()
     {

    	 HttpHeaders headers = new HttpHeaders();
         HttpEntity<String> entity = new HttpEntity<String>(null, headers);
         ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/test/getTest/1",
         HttpMethod.GET, entity, String.class);  
         assertNotNull(response.getBody());
     }
     
     }
