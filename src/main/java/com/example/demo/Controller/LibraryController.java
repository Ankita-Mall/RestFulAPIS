package com.example.demo.Controller;

import com.example.demo.Entity.Library;
import com.example.demo.Repo.LibraryRepo;
import com.example.demo.Response.AddResponse;
import com.example.demo.Service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    LibraryRepo repo;

    @Autowired
    Library newBoook;

    @Autowired
    AddResponse addResponse;
    @Autowired
    LibraryService ls;

    private static final Logger lf=LoggerFactory.getLogger("LibraryController");
    @PostMapping("/addBook")
    public ResponseEntity addBookImplement(@RequestBody Library book)
    {
       // book.setId(book.getIsbn()+book.getAisle());AtomicLong a=new AtomicLong();
        boolean b=ls.checkBookAlreadyExist(book.getIsbn()+book.getBook_name());
        HttpHeaders headers = new HttpHeaders();
        if(b) {
           newBoook.setId(book.getIsbn() + book.getBook_name());
           newBoook.setAisle(book.getAisle());
           newBoook.setAuthor(book.getAuthor());
           newBoook.setBook_name(book.getBook_name());
           newBoook.setIsbn(book.getIsbn());
           repo.save(newBoook);
           addResponse.setMessage("Sucessfull");
           addResponse.setId(book.getIsbn() + book.getBook_name());
           headers.add("unique", book.getIsbn());
           // return addResponse;
           return new ResponseEntity(addResponse, headers, HttpStatus.CREATED);
       }else
       {
           addResponse.setMessage("Already exist");
           addResponse.setId(book.getIsbn()+book.getBook_name());
           return new ResponseEntity(addResponse, headers, HttpStatus.ALREADY_REPORTED);

       }
    }

    @GetMapping("/getbyauthor/{author}")
    List<Library> getByAuthor(@PathVariable(value = "author") String author ){
       List<Library> lb=repo.findAllByauthor(author);
        return lb;
    }


}
