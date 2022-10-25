package business;

import core.logging.Logger;
import dataAccess.instructor.InstructorDao;
import entities.Instructor;

import java.util.List;

public class InstructorManager {
    private InstructorDao instructorDao;
    private List<Logger> loggerList;

    public InstructorManager(InstructorDao instructorDao, List<Logger> loggerList) {
        this.instructorDao = instructorDao;
        this.loggerList = loggerList;
    }

    public void add(Instructor instructor) {
        instructorDao.add(instructor);

        for (Logger logger : loggerList) {
            logger.add(instructor.getName());

        }
    }
}
