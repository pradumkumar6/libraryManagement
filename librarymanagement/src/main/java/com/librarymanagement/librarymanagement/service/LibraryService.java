package com.librarymanagement.librarymanagement.service;

import com.librarymanagement.librarymanagement.model.Book;
import com.librarymanagement.librarymanagement.repository.BookRepository;
import com.librarymanagement.librarymanagement.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private BookRepository bookRepository;

    // Fetch all books from the repository
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    // Save a new book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Find a book by ID
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Update an existing book
    public Optional<Book> updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
            book.setPublicationYear(bookDetails.getPublicationYear());
            return bookRepository.save(book);
        });
    }

    // Delete a book
    public boolean deleteBook(Long id) {
        return bookRepository.findById(id).map(book -> {
            bookRepository.delete(book);
            return true;
        }).orElse(false);
    }

    // Find books by author
    public List<Book> findBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }
}
