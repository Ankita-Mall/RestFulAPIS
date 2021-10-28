package com.example.demo.Repo;

import com.example.demo.Entity.Library;

import java.util.List;

public interface LibraryRepositoryCustom {
    List<Library> findAllByauthor(String authorName);
}
