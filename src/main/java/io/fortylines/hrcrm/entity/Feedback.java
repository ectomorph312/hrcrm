package io.fortylines.hrcrm.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "strengths")
    private String strengths;

    @Column(name = "weaknesses")
    private String weaknesses;

    @Column(name = "comments")
    private String comments;

    @Column(name = "rating_scale")
    private int ratingScale;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public String getCandidateName() {
        return candidate != null ? candidate.getFirstName() + " " + candidate.getLastName() : "<none>";
    }
}
