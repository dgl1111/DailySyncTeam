package com.dailySync.controller;

import com.dailySync.dto.BookReqDto;
import com.dailySync.dto.BookResDto;
import com.dailySync.repository.BookRepository;
import com.dailySync.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class BookController {
    final private BookService bookService;

    @PostMapping("book/create")
    public ResponseEntity<?> createBook(@ModelAttribute BookReqDto reqDto){
        return ResponseEntity.ok(bookService.CreateBook(reqDto));
    }

    @GetMapping("book")
    public ResponseEntity<?> getAllBook(){
        List<BookResDto> list = bookService.getAllBook();
        return ResponseEntity.ok(list);
    }

    @GetMapping("book/{id}")
    public ResponseEntity<?> getBookId(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @DeleteMapping("book/delete/{id}")
    public ResponseEntity<?> getDeleteId(@PathVariable Long id){
        bookService.postDeleteById(id);
        return ResponseEntity.ok().build();
    }
}