package org.example.borrow_book.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BorrowTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 5)
    private String borrowCode;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private boolean returned;
}
