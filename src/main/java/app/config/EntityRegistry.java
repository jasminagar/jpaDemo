package app.config;

import app.entities.Course;
import app.entities.Person;
import app.entities.Teacher;
import org.hibernate.cfg.Configuration;

final class EntityRegistry {

    private EntityRegistry() {}

    static void registerEntities(Configuration configuration) {
       // configuration.addAnnotatedClass(Study.class);
        // TODO: Add more entities here...
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Teacher.class);
    }
}