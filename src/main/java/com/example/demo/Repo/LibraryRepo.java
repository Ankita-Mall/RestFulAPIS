package com.example.demo.Repo;

import com.example.demo.Entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends JpaRepository<Library, String> {
    List<Library> findAllByauthor(String authorName);
}
