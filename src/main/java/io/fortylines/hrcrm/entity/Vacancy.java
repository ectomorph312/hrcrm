package io.fortylines.hrcrm.entity;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Vacancy() {
    }

    public Vacancy(String title, String description) {
        this.title = title;
        this.description = description;
    }

//    public String getAuthorName() {
//        return author != null ? author.getLastName() + author.getFirstName() : "<none>";
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getCompleted() {
        return completed;
    }

    public void setCompleted(LocalDateTime completed) {
        this.completed = completed;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Set<Competencies> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(Set<Competencies> competencies) {
        this.competencies = competencies;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", completed=" + completed +
                ", author=" + author +
                '}';
    }
}
