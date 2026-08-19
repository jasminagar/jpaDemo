package app.dao;

import app.config.HibernateConfig;
import app.entities.Course;
import app.entities.Person;
import app.exceptions.ApiException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CourseDao {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public void createCourse(Course course){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            em.close();
        } catch (ApiException e){
            e.getLocalizedMessage();
        }
    }

    public void updateCourseInformation(int id, String newName) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Course course = em.find(Course.class, id);

            if(course != null){
                course.setName(newName);
            }

            em.getTransaction().commit();
            em.close();
        } catch (ApiException e) {
            e.getCode();
        }
    }
}
