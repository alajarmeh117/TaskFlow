import com.thistlewick.domain.Reminder;
import com.thistlewick.domain.Task;
import com.thistlewick.domain.Task.PriorityLevel;
import com.thistlewick.domain.User;
import com.thistlewick.repository.ReminderRepository;
import com.thistlewick.repository.TaskRepository;
import com.thistlewick.repository.UserRepository;
import com.thistlewick.service.ReminderCancellationObserver;
import com.thistlewick.service.ReminderFactory;
import com.thistlewick.service.TaskAnalytics;
import com.thistlewick.service.TaskEventManager;
import com.thistlewick.service.TaskSorter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
       
    }
}