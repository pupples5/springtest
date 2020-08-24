package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.BookService;
import com.example.demo.service.ExecutiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Api(tags = {"1. Book"})
@RequestMapping(value = "/v1")
@RequiredArgsConstructor
@RestController
public class BookController {


    private final BookService bookService;

    private final ExecutiveService executiveService;

    @Autowired
    Environment environment;
    String name;

//    @GetMapping("/AllBook")
//    public List<Book> getAllBook(){
//        return bookRepository.findAll();
//    }

    @GetMapping("/")
    public String hello() {
        return "Main Page";
    }

    @GetMapping(value = "/hello")
    @ApiOperation(value = "hello, World A nPI", notes = "hello, World를 반환하는 API, Ajax 통신 확인용.")
    public ResponseEntity<ApiResponseMessage> helloWorld() {
        ApiResponseMessage message = new ApiResponseMessage("Success", "Hello, World", "", "");

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/posts")
    public Long save(@RequestBody BookSaveRequestDto requestDto) {
        return bookService.save(requestDto);
    }

    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody BookUpdateRequestDto requestDto) {
        return bookService.update(id, requestDto);
    }

    @GetMapping("/posts/{id}")
    public BookResponseDto findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping(value = "/executive")
    public ArrayList<ExecutiveResponseDto> getAll() {

        return executiveService.getAll();
    }

    @GetMapping("/executive/{executiveId}")
    public ExecutiveResponseDto findByexecutiveId(@PathVariable String executiveId) {
        return executiveService.findByexecutiveId(executiveId);
    }

    @GetMapping("/executivestate")
    public List<ExecutiveState> getAllexecutiveState() {

        System.out.println(environment.getProperty("upload-images"));

        return executiveService.getAllexecutiveState();
    }

    @PutMapping("/executivestate/{executiveid}")
    public Long update(@PathVariable String executiveid, @RequestBody ExecutiveUpdateRequestDto requestDto) {


        System.out.println(requestDto.toString());
        return executiveService.update(executiveid, requestDto);
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> upload(@RequestPart List<MultipartFile> files) throws Exception {
        List<String> list = new ArrayList<>();

        for (MultipartFile file : files) {
            String originalfileName = file.getOriginalFilename();
            File dest = new File(environment.getProperty("upload-images") + originalfileName);
            file.transferTo(dest);
        }
        return list;
    }


}
