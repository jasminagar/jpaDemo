package app.dao;

import app.config.HibernateConfig;
import app.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class PersonDao {

    private final EntityManagerFactory emf =
            HibernateConfig.getEntityManagerFactory();


    public void createPerson(Person person) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }

    public void updateStudentInformation(int id, int newAge, String newName) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Person person = em.find(Person.class, id);

            if (person != null) {
                person.setAge(newAge);
                person.setName(newName);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }

    public void deleteStudent(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Person person = em.find(Person.class, id);

            if (person != null) {
                em.remove(person);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }

    public List<Person> findAllPersons() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT p FROM Person p",
                    Person.class
            ).getResultList();

        } finally {
            em.close();
        }
    }
}