package ru.deadline.destroers.intellilearn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "test_tasks")
public class TestTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String answer;
    @OneToMany(mappedBy = "testTask", cascade = CascadeType.ALL)
    private List<AnswerValue> answerValues;


    public void chooseAnswer(AnswerValue answerValue) {
        answerValue.setTestTask(this);
        if (!this.answerValues.contains(answerValue)) {
            this.answerValues.add(answerValue);
        }
    }

    public void removeAnswer(Long answerValueId) {
        answerValues.removeIf(av -> av.getId().equals(answerValueId));
    }
}
