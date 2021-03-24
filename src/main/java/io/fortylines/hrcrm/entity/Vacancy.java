package io.fortylines.hrcrm.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacancy_id")
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    private String requirements;

    @ElementCollection
    @CollectionTable(name = "vacancy_competencies", joinColumns = @JoinColumn(name = "vacancy_id"))
    @Enumerated(EnumType.STRING)
    private Set<Competencies> competencies;

    @DateTimeFormat(pattern = "yyyy-MM-dd-'T'HH:mm")
    private LocalDateTime created;

    @DateTimeFormat(pattern = "yyyy-MM-dd-'T'HH:mm")
    private LocalDateTime completed;

    @DateTimeFormat(pattern = "yyyy-MM-dd-'T'HH:mm")
    private LocalDateTime modified;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Vacancy() {
    }

    public Vacancy(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getAuthorName() {
        return author != null ? author.getLastName() + " " + author.getFirstName() : "<none>";
    }
}
