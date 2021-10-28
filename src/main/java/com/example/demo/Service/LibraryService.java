package com.example.demo.Service;

import com.example.demo.Entity.Library;
import com.example.demo.Repo.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LibraryService {
    @Autowired
    LibraryRepo repo;
    public boolean checkBookAlreadyExist(String id){

        if(repo.findById(id).isPresent()){
            return false;
        }
        return true;
    }
}
