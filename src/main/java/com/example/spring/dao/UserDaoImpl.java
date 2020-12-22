package com.example.spring.dao;


import com.example.spring.model.Role;
import com.example.spring.model.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByName(String name) {
        Query query = (Query) entityManager.createQuery
                ("SELECT usName FROM User usName WHERE usName.name = :name2");
        query.setParameter("name2", name);
        return (User) query.getSingleResult();
    }

    @Override
    public User getUserByEmail(String name) {
        Query query = (Query) entityManager.createQuery
                ("SELECT usName FROM User usName WHERE usName.email = :name2");
        query.setParameter("name2", name);
        return (User) query.getSingleResult();
    }

    @Override
    public Role getRole(String role) {
        Query query = (Query) entityManager.createQuery
                ("SELECT usRole FROM Role usRole WHERE usRole.role = :name2");
        query.setParameter("name2", role);
        return (Role) query.getSingleResult();
    }

    @Override
    public List index() {
        return entityManager.createQuery("SELECT us FROM User us").getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User updateUser) {
        entityManager.merge(updateUser);
    }


    @Override
    public void delete(int id) {
        User userDelete = (User) show(id);
        entityManager.remove(userDelete);
    }
}

