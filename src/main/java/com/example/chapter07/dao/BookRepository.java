package com.example.chapter07.dao;

import com.example.chapter07.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "bs", collectionResourceRel = "bs", itemResourceRel = "b")
public interface BookRepository extends JpaRepository<Book, Integer> {
    @RestResource(path = "author", rel = "author")
    List<Book> findByAuthorContains(@Param("author") String author);


    @RestResource(path = "name", rel = "name", exported = false)
    Book findByNameEquals(@Param("name") String name);
}
