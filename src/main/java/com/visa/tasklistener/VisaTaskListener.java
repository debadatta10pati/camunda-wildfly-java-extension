package com.visa.tasklistener;

import java.util.Date;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class VisaTaskListener implements TaskListener {

	public void notify(DelegateTask delegateTask) {
	
		String destination = (String) delegateTask.getVariable("destination");
			
		Date appointmentDate = (Date) delegateTask.getVariable("appointmentDate");
		
		
	}

}
