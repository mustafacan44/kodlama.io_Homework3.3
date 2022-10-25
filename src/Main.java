import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import core.logging.MailLogger;
import dataAccess.category.HibernateCategoryDao;
import dataAccess.category.JdbcCategoryDao;
import dataAccess.course.HibernateCourseDao;
import dataAccess.course.JdbcCourseDao;
import dataAccess.instructor.HibernateInstructorDao;
import dataAccess.instructor.JdbcInstructorDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Category> categoryList = new ArrayList<Category>();
        categoryList.add(new Category(1, "Programlama"));
        Category category = new Category(1, "Yazılım");

        List<Logger> loggersCategory = new ArrayList<>();
        loggersCategory.add(new DatabaseLogger());
        loggersCategory.add(new FileLogger());
        loggersCategory.add(new MailLogger());

        CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), loggersCategory, categoryList);
        categoryManager.add(category);

        System.out.println("--------------------");

        List<Course> courseList = new ArrayList<Course>();
        courseList.add(new Course(1, "java", 1000));
        Course course = new Course(1, "C#", 100);

        List<Logger> loggersCourse = new ArrayList<Logger>();
        loggersCourse.add(new DatabaseLogger());
        loggersCourse.add(new FileLogger());
        loggersCourse.add(new MailLogger());
        CourseManager courseManager = new CourseManager(new JdbcCourseDao(), courseList, loggersCourse);
        courseManager.add(course);

        System.out.println("--------------------");

        Instructor instructor = new Instructor(1, "Engin", "Demiroğ");
        List<Logger> loggersInstructor = new ArrayList<Logger>();
        loggersInstructor.add(new DatabaseLogger());
        loggersInstructor.add(new FileLogger());
        loggersInstructor.add(new MailLogger());
        InstructorManager instructorManager = new InstructorManager(new JdbcInstructorDao(), loggersInstructor);
        instructorManager.add(instructor);


    }
}
