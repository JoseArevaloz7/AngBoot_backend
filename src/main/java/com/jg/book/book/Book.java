package com.jg.book.book;

import java.beans.Transient;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.jg.book.common.BaseEntity;
import com.jg.book.user.User;
import com.jg.book.feedback.Feedback;
import com.jg.book.history.BookTransactionHistory;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;

    @Transient
    public double getRate() {
        if(feedbacks == null || feedbacks.isEmpty()) {
            return 0.0;
        }
        var rate = this.feedbacks.stream()
            .mapToDouble(Feedback::getNote)
            .average()
            .orElse(0.0);
        
        double roundRate = Math.round(rate * 10) / 10;

        return roundRate;
    }
}
