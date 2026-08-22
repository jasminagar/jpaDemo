package app;

import app.dao.CourseDao;
import app.dao.PersonDao;
import app.entities.Course;
import app.entities.Person;
import app.entities.Teacher;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        CourseDao courseDao = new CourseDao();
        Person person = new Person("hanne", 2, 22222222, "mail", "adres", "taber", LocalDate.now(), LocalDate.now());
        Course course = new Course("h");
        personDao.createPerson(person);
        courseDao.createCourse(course);
        courseDao.addCouseToPerson(person, course);

    }
}