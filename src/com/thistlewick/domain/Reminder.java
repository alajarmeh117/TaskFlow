package com.thistlewick.domain;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="reminders")
public class Reminder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ; 
	@ManyToOne
	private Task task;
	private LocalDateTime triggerTime;
	@Enumerated(EnumType.STRING)
	private DeliveryChannel deliveryChannel;
	
	   protected Reminder() {
	}
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
