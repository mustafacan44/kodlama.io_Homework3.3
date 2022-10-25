package business;

import core.logging.Logger;
import dataAccess.course.CourseDao;
import entities.Course;

import java.util.List;

public class CourseManager {
    private CourseDao courseDao;
    private List<Course> courseList;
    private List<Logger> loggers;

    public CourseManager(CourseDao courseDao, List<Course> courseList, List<Logger> loggers) {
        this.courseDao = courseDao;
        this.courseList = courseList;
        this.loggers = loggers;
    }

    public void add(Course course) throws Exception {

        for (Course course1 : courseList) {
            if (course.getName().equals(course1.getName())) {
                throw new Exception("Aynı isimde kurs olamaz");
            }
        }

        if (course.getPrice() < 0) {
            throw new Exception("Kursun fiyatı 0 dan küçük olamaz.");
        }

        courseList.add(course);
        courseDao.add(course);

        for (Logger logger : loggers) {
            logger.add(course.getName());
        }

    }
}
