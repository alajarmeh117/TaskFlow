package com.thistlewick.service;
import com.thistlewick.domain.Task;

public interface TaskObserver {
	void onLifecycleSignal(Task task, String eventType);

}
