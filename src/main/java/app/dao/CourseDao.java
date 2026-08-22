package app.dao;

import app.config.HibernateConfig;
import app.entities.Course;
import app.entities.Person;
import app.exceptions.ApiException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CourseDao {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public List<Course> courseByPerson(Person person) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                            "select c from Person p join p.courses c where p.id = :personId",
                            Course.class
                    )
                    .setParameter("personId", person.getId())
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public void addCouseToPerson(Person person1, Course course1){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Person person = em.find(Person.class, person1.getId());
            Course course = em.find(Course.class, course1.getId());
            person.getCourses().add(course);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

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

    public void deleteCourse(int id){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Course course = em.find(Course.class, id);
            em.remove(course);
            em.close();
        } catch (ApiException e){
            e.getLocalizedMessage();
        }
    }

    public List<Course> findAllCourses(){
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("select c from Course c", Course.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
