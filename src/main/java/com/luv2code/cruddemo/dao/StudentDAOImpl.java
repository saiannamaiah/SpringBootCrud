package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for Entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
    entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        //create a Query

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query Results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        //create Query

        TypedQuery<Student> theQuery =
                entityManager.createQuery("From Student WHERE lastName=:theData",Student.class);

        // set query Parameters

        theQuery.setParameter("theData",theLastName);

        //return query results


        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
    entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {

        // retrieve student first

        Student theStudent = entityManager.find(Student.class, id);

        // delete the student with id
        entityManager.remove(theStudent);
    }


}
