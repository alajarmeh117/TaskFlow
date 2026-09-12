import java.time.LocalDateTime;

public class Task {

	private int id;
	private User owner;              // Task -- Owner --> User .
	private String title;
	private LocalDateTime dueDate;   // localDateTime --> Return [ Date + Time ] -->  .
	private PriorityLevel priority;  // you have fix data - > the best use enum -- enum priorityLevel
	private TaskStatus status;       // you have fix data - > the best use enum -- enum TaskStatues

	public enum PriorityLevel {
		LOW, MEDIUM, HIGH
	}

	public enum TaskStatus {
		TODO, IN_PROGRESS, DONE, OVERDUE
	}
	
	

}
