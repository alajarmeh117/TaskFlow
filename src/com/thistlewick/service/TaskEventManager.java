package com.thistlewick.service;

import com.thistlewick.domain.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskEventManager {
    
    private List<TaskObserver> observers = new ArrayList<>();

    // دالة لإضافة مراقب جديد
    public void subscribe(TaskObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(TaskObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Task task, String eventType) {
        for (TaskObserver observer : observers) {
            observer.onLifecycleSignal(task, eventType);
        }
    }
}