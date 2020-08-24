package com.example.demo.service;


import com.example.demo.model.Book;
import com.example.demo.model.BookResponseDto;
import com.example.demo.model.BookSaveRequestDto;
import com.example.demo.model.BookUpdateRequestDto;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;




    @Transactional
    public  Long save(BookSaveRequestDto requestDto){
        return bookRepository.save(requestDto.toEntity()).getDataNo();
    }

    @Transactional
    public Long update(Long id, BookUpdateRequestDto requestDto){

        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = "+ id));


        book.update(requestDto.getTitle(), requestDto.getContent());


        return id;


    }

    public BookResponseDto findById (Long id){
        Book entity = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new BookResponseDto(entity);
    }

}
