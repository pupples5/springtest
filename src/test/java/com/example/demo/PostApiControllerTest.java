package com.example.demo;


import com.example.demo.model.Book;
import com.example.demo.model.BookSaveRequestDto;
import com.example.demo.repository.BookRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {

   @LocalServerPort
    private int port;

   @Autowired
    private TestRestTemplate restTemplate;

   @Autowired
    private BookRepository bookRepository;

   @After
    public void tearDown()throws Exception{
       bookRepository.deleteAll();
   }

   @Test
    public void Book_등록()  throws Exception{

       String title = "title";
       String content = "content";

       BookSaveRequestDto requestDto = BookSaveRequestDto.builder()
               .title(title)
               .content(content)
               .build();

       String url = "http://localhost" + port + "/posts";

       ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);


       assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

       assertThat(responseEntity.getBody()).isGreaterThan(0L);

       List<Book> all = bookRepository.findAll();

       assertThat(all.get(0).getTitle()).isEqualTo(title);
       assertThat(all.get(0).getContent()).isEqualTo(content);


   }


}
