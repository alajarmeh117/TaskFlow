package com.thistlewick.repository;
import jakarta.persistence.*;
import java.util.List;

import com.thistlewick.domain.User;

public class UserRepository implements Repository<User, Integer> {

    private EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(User entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public User findById(Integer id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public void update(User entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        User user = findById(id);
        if (user != null) {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }
    }
}