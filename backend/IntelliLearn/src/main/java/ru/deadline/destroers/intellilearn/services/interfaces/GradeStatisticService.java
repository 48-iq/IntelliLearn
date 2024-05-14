package ru.deadline.destroers.intellilearn.services.interfaces;

import java.util.List;

public interface GradeStatisticService {
    List<Statistic> getStudentStatistic(Long userId);

    Statistic getSubjectStudentStatistic(Long userId, Long subjectId);
}
