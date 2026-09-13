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
		this();
		this.owner = owner;
		this.title = title;
		this.dueDate = dueDate;
		this.priority = priority;
	}
	
	public void  start() throws InvalidTaskStateException{ //  To change the status from TODO to IN_PROGRESS
		 if (status == TaskStatus.TODO )
		    status = TaskStatus.IN_PROGRESS ; 
		 
		 else 
			 throw new InvalidTaskStateException("--------------");
	}
	 
	public void complete() throws InvalidTaskStateException {  // To change the status from IN_PROGRESS  to DONE
		if (status == TaskStatus.IN_PROGRESS)
			status = TaskStatus.DONE ; 
		else 
			throw new InvalidTaskStateException("-----------------");
		
	}
	
	public void markOverdue() { // The mission time ended before it was completed ( DONE ) .  == > Statues + date
        if ((status == TaskStatus.TODO || status == TaskStatus.IN_PROGRESS) && (LocalDateTime.now()).isAfter(dueDate))
        	 status = TaskStatus.OVERDUE ;     	
	}
	

}

