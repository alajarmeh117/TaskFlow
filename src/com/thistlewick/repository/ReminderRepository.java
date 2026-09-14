package com.thistlewick.repository;
import jakarta.persistence.*;
import java.util.List;

import com.thistlewick.domain.Reminder;

public class ReminderRepository implements Repository<Reminder, Integer> {

    private EntityManager em;

    public ReminderRepository(EntityManager em) {
        this.em = em;
    }
    

    @Override
    public void save(Reminder entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public Reminder findById(Integer id) {
        return em.find(Reminder.class, id);
    }

    @Override
    public List<Reminder> findAll() {
        TypedQuery<Reminder> query = em.createQuery("SELECT r FROM Reminder r", Reminder.class);
        return query.getResultList();
    }

    @Override
    public void update(Reminder entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        Reminder reminder = findById(id);
        if (reminder != null) {
            em.getTransaction().begin();
            em.remove(reminder);
            em.getTransaction().commit();
        }
    }
}