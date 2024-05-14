package ru.deadline.destroers.intellilearn.services.interfaces;

public interface GradeStatisticService {
    StudentStatistics getStudentStatistic(String userId);

    SubjectGroupStatistics getSubjectGroupStatistic(String groupId, String subjectId);

    SubjectStudentServiceStatistics getSubjectStudentService(String userId, String subjectId);
}
