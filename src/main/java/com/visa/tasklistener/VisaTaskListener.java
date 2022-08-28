package com.visa.tasklistener;

import java.util.Date;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class VisaTaskListener implements TaskListener {

	final static String DB_URL = "jdbc:mysql://localhost:3306/applicationdb";

	public void insertOrUpdateData(String taskId, String status, String processInstanceId, String govtId) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, "root", "Hello2022");

			String sql = "insert into camundataskdata (taskId,taskstatus,govtId,processInstanceId)" + "values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, taskId);
			pstmt.setString(2, status);
			pstmt.setString(3, govtId);
			pstmt.setString(4, processInstanceId);

			int rowAffected = pstmt.executeUpdate();

			if (rowAffected == 1) {
				System.out.println(" One row inserted ");
			}
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void notify(DelegateTask delegateTask) {

		String govtId = (String) delegateTask.getVariable("govtId");

		

	}

}
