package com.thistlewick.service;

import com.thistlewick.domain.Reminder;
import com.thistlewick.domain.Task;
import java.time.LocalDateTime;

public class ReminderFactory {

    public static Reminder createReminder(Task task, LocalDateTime triggerTime) {
        Reminder.DeliveryChannel channel;

        switch (task.getPriority()) {
            case HIGH:
                channel = Reminder.DeliveryChannel.PUSH; 
                break;
            case MEDIUM:
                channel = Reminder.DeliveryChannel.SMS ;
                break;
            case LOW:
            default:
                channel = Reminder.DeliveryChannel.EMAIL; 
                break;
        }

        return new Reminder(task, triggerTime, channel);
    }
}