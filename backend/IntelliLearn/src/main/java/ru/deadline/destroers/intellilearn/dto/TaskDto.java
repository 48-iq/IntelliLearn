package ru.deadline.destroers.intellilearn.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private Integer Id;
    private List<String> nameGroup;
    private String nameTask;
    private List<Date> period;
    private List<QuestionDto> questions;
}
