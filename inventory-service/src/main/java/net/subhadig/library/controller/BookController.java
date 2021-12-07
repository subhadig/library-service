package net.subhadig.library.controller;

import com.mongodb.lang.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import net.subhadig.library.entity.Book;
import net.subhadig.library.repository.BookRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/book")
@ExecuteOn(TaskExecutors.IO)
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<Book> list() {
        return bookRepository.list();
    }

    @Post
    @Status(HttpStatus.CREATED)
    public void save(@NotNull @NonNull @Valid Book book) {
        bookRepository.save(book);
    }
}
