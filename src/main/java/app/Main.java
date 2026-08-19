package app;

import app.dao.PersonDao;
import app.entities.Person;

public class Main {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person = new Person("Doe", 25);

        personDao.createPerson(person);

    }
}