package io.fortylines.hrcrm.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "vacancies")
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
    private List<Competencies> competencies;

    @DateTimeFormat(pattern = "yyyy-MM-dd-'T'HH:mm")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd-'T'HH:mm")
    private LocalDateTime updatedAt;

    @Column(name = "is_on_instagram")
    private boolean isOnInstagram;

    @Column(name = "is_on_telegram")
    private boolean isOnTelegram;

    @Column(name = "is_on_jobkg")
    private boolean isOnJobkg;

    @Column(name = "is_on_facebook")
    private boolean isOnFacebook;

    @Column(name = "is_on_diesel")
    private boolean isOnDiesel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Vacancy() {
    }

    public String getAuthorName() {
        return author != null ? author.getLastName() + " " + author.getFirstName() : "<none>";
    }
}
