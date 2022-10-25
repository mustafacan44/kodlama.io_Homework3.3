package dataAccess.instructor;

import entities.Instructor;

public class JdbcInstructorDao implements InstructorDao {
    @Override
    public void add(Instructor instructor) {
        System.out.println("JDBC ie eğitmen veritabanına eklendi");
    }
}
