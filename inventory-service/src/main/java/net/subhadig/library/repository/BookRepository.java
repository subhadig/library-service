package net.subhadig.library.repository;

import com.mongodb.lang.NonNull;
import net.subhadig.library.entity.Book;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface BookRepository {

    @NotNull
    List<Book> list();

    void save(@NotNull @NonNull @Valid Book book);
}
