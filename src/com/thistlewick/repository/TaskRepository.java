package com.thistlewick.repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.thistlewick.domain.Task;

public class TaskRepository implements Repository<Task, Integer> {

    // EntityManager هو الأداة الرئيسية للتخاطب مع قاعدة البيانات (H2)
    private EntityManager em;
    
    // متطلب الـ Cache: ذاكرة مؤقتة نحتفظ فيها بمهام اليوم لتقليل الاستعلامات من قاعدة البيانات
    private List<Task> todayTasksCache;

    public TaskRepository(EntityManager em) {
        this.em = em;
        this.todayTasksCache = new ArrayList<>();
    }

    @Override
    public void save(Task entity) {
        // 1. نبدأ الـ Transaction لأننا سنقوم بتعديل (إضافة) على قاعدة البيانات
        em.getTransaction().begin();
        
        // 2. نحفظ المهمة في قاعدة البيانات
        em.persist(entity);
        
        // 3. نؤكد العملية ونغلق الاتصال
        em.getTransaction().commit();
        
        // 4. تحديث الـ Cache: إذا كانت المهمة تاريخها اليوم، نضيفها للذاكرة المؤقتة
        if (entity.getDueDate() != null && entity.getDueDate().toLocalDate().equals(LocalDate.now())) {
            todayTasksCache.add(entity);
        }
    }

    @Override
    public Task findById(Integer id) {
        // دالة جاهزة في JPA تبحث عن المهمة عن طريق الـ ID (الـ Primary Key)
        return em.find(Task.class, id);
    }

    @Override
    public List<Task> findAll() {
        // نكتب استعلام JPQL (يشبه SQL لكنه يتعامل مع الكلاسات بدل الجداول) لجلب كل المهام
        TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t", Task.class);
        return query.getResultList();
    }

    @Override
    public void update(Task entity) {
        // التحديث يحتاج Transaction
        em.getTransaction().begin();
        
        // دالة merge تقوم بالبحث عن المهمة، وإذا وجدتها تقوم بتحديث بياناتها بالبيانات الجديدة
        em.merge(entity);
        
        em.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        // 1. أولاً نبحث عن المهمة لنتأكد أنها موجودة
        Task task = findById(id);
        
        if (task != null) {
            em.getTransaction().begin();
            
            // 2. نحذف المهمة من قاعدة البيانات
            em.remove(task);
            
            em.getTransaction().commit();
            
            // 3. نزيلها من الكاش إذا كانت موجودة فيه ليبقى الكاش محدثاً
            todayTasksCache.remove(task);
        }
    }

    // دالة إضافية لجلب مهام اليوم من الكاش مباشرة (تطبيق لمتطلب in-memory feature)
    public List<Task> getTodayTasksFromCache() {
        return todayTasksCache;
    }
}