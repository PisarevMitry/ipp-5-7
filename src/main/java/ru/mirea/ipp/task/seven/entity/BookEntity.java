package ru.mirea.ipp.task.seven.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table
@RequiredArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String bookName;

    private String genre;

    private String authorName;

    public BookEntity(String bookName, String genre, String authorName) {
        this.bookName = bookName;
        this.genre = genre;
        this.authorName = authorName;
    }
}
