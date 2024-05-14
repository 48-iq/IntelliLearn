package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Course;

import java.util.List;

public interface CoursesService {
    Course getCourse(Long id);
    Course createCourse(Course course);
    Course updateCourse(Course course);
    void deleteCourse(Long id);
    Course getCourseByName(String name);
    List<Course> getAllCourses();
}