package homework9;

import java.util.List;

/**
 * Java Core. Homework 9
 *
 * @author Vitalii Luzhnov
 * @version 30.03.2022
 */
public class Student implements Students{

    private final String name;
    private final List<Course> courseList;

    public Student(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
