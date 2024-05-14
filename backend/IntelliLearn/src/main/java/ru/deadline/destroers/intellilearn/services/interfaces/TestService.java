package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Result;
import ru.deadline.destroers.intellilearn.entities.Test;

import java.util.List;

public interface TestService {
    Test createTest(Test test);

    void pinTestToUser(String userId, String testId);

    void unpinTestFromUser();

    void deleteTest(String testId);

    TestSolution checkTest(String testId, TestSolution testSolution);

    List<Result> results(String testSolutionId);
}
