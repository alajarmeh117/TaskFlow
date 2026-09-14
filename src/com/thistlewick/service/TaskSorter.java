package com.thistlewick.service;

import com.thistlewick.domain.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskSorter {

    // Big-O: O(n log n) Time Complexity, O(n) Space Complexity.
    // تم اختيار Merge Sort لأنه يضمن أداءً مستقراً (Stable) وهو الأفضل لترتيب الكائنات،
    // حيث يحافظ على الترتيب الأصلي للعناصر المتساوية، مما يسهل الفرز الثانوي (حسب الأولوية).
    public static void reorderByDueDate(List<Task> tasks) {
        if (tasks == null || tasks.size() <= 1) {
            return; // حالة التوقف الأساسية (Base Case)
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

            // 1. الفرز الأساسي: حسب تاريخ الانتهاء (الأقرب أولاً)
            int dateComparison = t1.getDueDate().compareTo(t2.getDueDate());
            
            if (dateComparison < 0) {
                result.set(k++, left.get(i++));
            } else if (dateComparison > 0) {
                result.set(k++, right.get(j++));
            } else {
                // 2. الفرز الثانوي: إذا تساوى التاريخ، نفرز حسب الأولوية (HIGH ثم MEDIUM ثم LOW)
                // الـ Enum ترتبيها الافتراضي (LOW=0, MEDIUM=1, HIGH=2)، لذا نعكس المقارنة لجلب الأهم أولاً
                int priorityComparison = t2.getPriority().compareTo(t1.getPriority());
                if (priorityComparison <= 0) {
                    result.set(k++, left.get(i++));
                } else {
                    result.set(k++, right.get(j++));
                }
            }
        }

        // تفريغ باقي العناصر إن وجدت
        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }
}