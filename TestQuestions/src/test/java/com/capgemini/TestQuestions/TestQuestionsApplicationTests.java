package com.capgemini.TestQuestions;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.TestQuestions.entity.Question;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestQuestionsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestQuestionsApplicationTests {

	 @Autowired
     private TestRestTemplate restTemplate;

	 
	 
	
     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void addQuestion()
	{
		Question question=new Question();
		BigInteger questionId=new BigInteger("10");
		question.setQuestionId(questionId);
		question.setChoosenAnswer(0);
		question.setMarksScored(0);
		question.setQuestionAnswer(2);
		question.setQuestionMarks(10);
		 ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/testquestions/addQuestion/1",question, String.class);
         assertNotNull(postResponse);
         assertNotNull(postResponse.getBody());
		
		
	}
	
	@Test
	public void updateQuestion()
	{
		Question question=new Question();
		BigInteger questionId=new BigInteger("10");
		question.setQuestionId(questionId);
		question.setChoosenAnswer(0);
		question.setMarksScored(0);
		question.setQuestionAnswer(3);
		question.setQuestionMarks(20);
		 ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/testquestions/UpdateQuestion/1",question, String.class);
         assertNotNull(postResponse);
         assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void deleteQuestion()
	{
		Question question=new Question();
		BigInteger questionId=new BigInteger("10");
		question.setQuestionId(questionId);
		question.setChoosenAnswer(0);
		question.setMarksScored(0);
		question.setQuestionAnswer(3);
		question.setQuestionMarks(20);
		 ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/testquestions/deleteQuestion/1",question, String.class);
         assertNotNull(postResponse);
         assertNotNull(postResponse.getBody());
	}

}
