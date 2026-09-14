package com.thistlewick.service;

import com.thistlewick.domain.Task;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskAnalytics {

	public static Map<Task.PriorityLevel, Long> getOverdueTasksCountByPriority(List<Task> tasks) {
		return tasks.stream().filter(t -> t.getStatus() == Task.TaskStatus.OVERDUE) // تصفية المهام المتأخرة فقط
				.collect(Collectors.groupingBy(Task::getPriority, Collectors.counting())); // تجميع وعدّ
	}

	public static Map<String, Long> getCompletedTasksPerUser(List<Task> tasks) {
		
		return tasks.stream().filter(t -> t.getStatus() == Task.TaskStatus.DONE)
				.collect(Collectors.groupingBy(t -> t.getOwner().getName(), Collectors.counting()));
	}

	public static Map<Task.TaskStatus, Long> getTaskDistributionByStatus(List<Task> tasks) {
		return tasks.stream().collect(Collectors.groupingBy(Task::getStatus, Collectors.counting()));
	}
}	