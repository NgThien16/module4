package org.example.blog.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private String author;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishedDate;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @PrePersist
    public void onCreate() {
        publishedDate = LocalDate.now();
    }

}
