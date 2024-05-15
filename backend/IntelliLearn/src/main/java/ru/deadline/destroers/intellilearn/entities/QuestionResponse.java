package ru.deadline.destroers.intellilearn.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class QuestionResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String responseText;

    @ManyToOne
    @JoinColumn(name = "quection_id", referencedColumnName = "id")
    private Question question;
}
