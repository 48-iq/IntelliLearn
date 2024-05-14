package ru.deadline.destroers.intellilearn.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Course;
import ru.deadline.destroers.intellilearn.repositories.CourseRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.CoursesService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CoursesService {
    private final CourseRepository courseRepository;


    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseRepository.findByName(name)
                .orElseThrow();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
