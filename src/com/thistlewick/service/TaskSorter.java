package com.thistlewick.service;

import com.thistlewick.domain.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskSorter {

    public static void reorderByDueDate(List<Task> tasks) {
        if (tasks == null || tasks.size() <= 1) {
            return; 
        }
        
        int mid = tasks.size() / 2;
        List<Task> left = new ArrayList<>(tasks.subList(0, mid));
        List<Task> right = new ArrayList<>(tasks.subList(mid, tasks.size()));

        reorderByDueDate(left);
        reorderByDueDate(right);

        merge(tasks, left, right);
    }

    private static void merge(List<Task> result, List<Task> left, List<Task> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            Task t1 = left.get(i);
            Task t2 = right.get(j);

            int dateComparison = t1.getDueDate().compareTo(t2.getDueDate());
            
            if (dateComparison < 0) {
                result.set(k++, left.get(i++));
            } else if (dateComparison > 0) {
                result.set(k++, right.get(j++));
            } else {
                int priorityComparison = t2.getPriority().compareTo(t1.getPriority());
                if (priorityComparison <= 0) {
                    result.set(k++, left.get(i++));
                } else {
                    result.set(k++, right.get(j++));
                }
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }
}