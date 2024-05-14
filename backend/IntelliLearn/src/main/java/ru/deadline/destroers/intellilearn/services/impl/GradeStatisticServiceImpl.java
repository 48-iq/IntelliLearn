package ru.deadline.destroers.intellilearn.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.TaskResult;
import ru.deadline.destroers.intellilearn.entities.TestResult;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.repositories.UserRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.GradeStatisticService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeStatisticServiceImpl implements GradeStatisticService {

    private final UserRepository userRepository;

    @Override
    public List<Statistic> getStudentStatistic(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        double totalScore = 0;
        int count = 0;

        for (TestResult result : user.getTestResults()) {
            totalScore += result.getScore();
            count++;
        }

        for (TaskResult result : user.getTaskResults()) {
            totalScore += result.getScore();
            count++;
        }

        return ;
    }

    @Override
    public Statistic getSubjectStudentStatistic(Long userId, Long subjectId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        double totalScore = 0;
        int count = 0;

        for (TestResult result : user.getTestResults()) {
            if (result.getSubject().getId().equals(subjectId)) { // Предполагаем, что у TestResult есть поле subject
                totalScore += result.getScore();
                count++;
            }
        }

        for (TaskResult result : user.getTaskResults()) {
            if (result.getSubject().getId().equals(subjectId)) { // Аналогично предполагается наличие поля subject
                totalScore += result.getScore();
                count++;
            }
        }

        return new Statistic(user.getId(), totalScore / count);
    }

}
