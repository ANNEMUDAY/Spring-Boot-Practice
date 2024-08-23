
package com.example.book_management_system.controller;

import com.example.book_management_system.entity.Book;
import com.example.book_management_system.repository.BookRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/new")
    public String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookform";
    }

    @PostMapping
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:/books/list";
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deletebooks(@RequestBody Book book){
        bookRepository.delete(book);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.CREATED);
    }
    @PutMapping("update")
    public ResponseEntity<String> updatebook(@RequestBody Book book){
        bookRepository.save(book);
        return new ResponseEntity<>("updated successfully",HttpStatus.CREATED);
    }
    @GetMapping("getbyid/{id}")
    public ResponseEntity<Object> findbyid(@PathVariable Long id, Book book){
        Book b=bookRepository.findById(id).orElse(null);
        System.out.println(b.getAuthor()+" "+b.getPrice());
        return new ResponseEntity<>(b,HttpStatus.CREATED);
    }
//    @GetMapping("getbyid/{postId}")
//    public Book getBook(@PathVariable Long postId) {
//        Book b= bookRepository.findById(postId).orElse(null);
//        System.out.println(b.getAuthor()+" "+b.getPrice());
//        return b;
//    }
//    @PostMapping("add")

//    public void addingbook(Book book){
//        bookRepository.save(book);
//    }
}

