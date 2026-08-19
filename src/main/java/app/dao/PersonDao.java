package app.dao;

import app.config.HibernateConfig;
import app.entities.Person;
import app.exceptions.ApiException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PersonDao {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public void createPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            em.close();
        } catch (ApiException e) {
            e.getLocalizedMessage();
        }
    }

    public void updateStudentInformation(int id, int newAge, String newName) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Person person = em.find(Person.class, id);

            if(person != null){
                person.setAge(newAge);
                person.setName(newName);
            }

            em.getTransaction().commit();
            em.close();
        } catch (ApiException e) {
            e.getCode();
        }
    }
}
