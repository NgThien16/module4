package org.example.borrow_book.repository;

import org.example.borrow_book.entity.BorrowTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBorrowTransferRepository extends JpaRepository<BorrowTransfer, Integer> {
    Optional<BorrowTransfer> findByBorrowCode(String borrowCode);
}
