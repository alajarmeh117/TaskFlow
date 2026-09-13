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
	
	
       //  default constructor 
 	public Task() {       
		this.status = TaskStatus.TODO;
	}

	public Task(User owner, String title, LocalDateTime dueDate, Task.PriorityLevel priority) {
		super();
		this.owner = owner;
		this.title = title;
		this.dueDate = dueDate;
		this.priority = priority;
	}
	
	public void  start() {    //  To change the status from TODO to IN_PROGRESS
		
		
	}
	 
	public void complete() {  // To change the status from IN_PROGRESS  to DONE
		
		
	}
	
	public void markOverdue() { // The mission time ended before it was completed ( DONE ) .

		
	}
	

}

