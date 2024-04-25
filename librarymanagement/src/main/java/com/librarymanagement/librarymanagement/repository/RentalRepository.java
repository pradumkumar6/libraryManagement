package com.librarymanagement.librarymanagement.repository;

import com.librarymanagement.librarymanagement.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByBookIdAndReturnDateIsNull(Long bookId);
}
