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
        Person person2 = new Person("hanne", 2, 22232222, "mail", "adres", "taber", LocalDate.now(), LocalDate.now());
        Course course2 = new Course("");
        personDao.createPerson(person2);
        courseDao.createCourse(course2);
        courseDao.addCouseToPerson(person2, course2);
        System.out.println(courseDao.courseByPerson(person2));

        List<Person> students = courseDao.studentsByCourse(course2);

        System.out.println(students);

    }
}