package com.jg.book.book;

import org.hibernate.annotations.ManyToAny;

import com.jg.book.common.BaseEntity;
import com.jg.book.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseEntity{
    
    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private Boolean archived;
    private Boolean shareable;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

}
