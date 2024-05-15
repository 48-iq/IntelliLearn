package ru.deadline.destroers.intellilearn.dto;

import java.util.Date;
import java.util.List;

public class TaskDto {
    private List<String> nameGroup;
    private String nameTask;
    private List<Date> period;
    private List<QuestionDto> questions;
}
