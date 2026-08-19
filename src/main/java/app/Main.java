package app;

import app.dao.CourseDao;
import app.dao.PersonDao;
import app.entities.Course;
import app.entities.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        CourseDao courseDao = new CourseDao();

//        Person person1 = new Person("karen", 43);
//        personDao.createPerson(person1);
//
//   Person person2 = new Person("karen", 44);
//personDao.createPerson(person2);

       List<Person> allPersons = personDao.findAllPersons();
    System.out.println(allPersons);

    }
}