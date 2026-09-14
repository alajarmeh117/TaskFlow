import java.time.LocalDateTime;

public class Reminder {
	private Task task;
	private LocalDateTime triggerTime;
	private DeliveryChannel deliveryChannel;
	
	   public Reminder(Task task, LocalDateTime triggerTime, DeliveryChannel deliveryChannel) {
		this.task = task;
		this.triggerTime = triggerTime;
		this.deliveryChannel = deliveryChannel;
	}
	   public enum DeliveryChannel {
		   EMAIL ,
		   SMS ,
		   PUSH 
	   }
	   
	   public Task getTask() {
		   return task;
	   }
	   public LocalDateTime getTriggerTime() {
		   return triggerTime;
	   }
	   public DeliveryChannel getDeliveryChannel() {
		   return deliveryChannel;
	   }   
	   
}
