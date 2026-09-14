package com.thistlewick.service;

import com.thistlewick.domain.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskEventManager {
    
    // قائمة المراقبين الذين ينتظرون أي تغيير
    private List<TaskObserver> observers = new ArrayList<>();

    // دالة لإضافة مراقب جديد
    public void subscribe(TaskObserver observer) {
        observers.add(observer);
    }

    // دالة لإزالة مراقب
    public void unsubscribe(TaskObserver observer) {
        observers.remove(observer);
    }

    // إرسال إشعار لجميع المراقبين عند حدوث حدث (مثل: إكمال مهمة)
    public void notifyObservers(Task task, String eventType) {
        for (TaskObserver observer : observers) {
            observer.onLifecycleSignal(task, eventType);
        }
    }
}