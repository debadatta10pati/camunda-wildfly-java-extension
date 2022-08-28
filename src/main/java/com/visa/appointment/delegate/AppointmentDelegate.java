package com.visa.appointment.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppointmentDelegate implements JavaDelegate {

	private final Logger LOGGER = LoggerFactory.getLogger(AppointmentDelegate.class.getName());


	public void execute(DelegateExecution execution) throws Exception {

		String destination = (String) execution.getVariable("destination");
		String govtId = (String) execution.getVariable("govtId");
		long payment = 0;

		if (destination.equals("Thailand"))

		{
			payment = 40;
		} else if (destination.equals("USA"))

		{
			payment = 160;
		} else if (destination.equals("Schengen"))

		{
			payment = 100;
		} else if (destination.equals("Indonesia"))

		{
			payment = 20;
		}
		execution.setVariable("payment", payment);

		System.out.println(
				"Payment of " + payment + " USD made for govtId = " + govtId + " for destination = " + destination);

	}

}
