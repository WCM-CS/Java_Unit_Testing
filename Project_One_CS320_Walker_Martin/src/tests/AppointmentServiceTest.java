package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import appointmentService.Appointment;
import appointmentService.AppointmentService;

class AppServiceTest {

	AppointmentService apps = new AppointmentService();   
	
	//Add Appointment
	@Test
	void testAddAppointment() {
		Appointment app = apps.addAppointment(02, 23, 2026, "Test Appointment");
		Assert.assertEquals("Test Appointment", app.getDescription());
		assertTrue(apps.getApp(app.getId()) == app);
	}
	
	//Delete Appointment
	@Test
	void testDeleteAppointment() {
		Appointment app = apps.addAppointment(02, 23, 2026, "Test Appointment");
		assertTrue(apps.getApps().size()==1);
		apps.deleteAppointment(app.getId());
		assertTrue(apps.getApps().size()==0);
	}
	
	//Delete All Appointments
	@Test
	void testDeleteAllAppointments() {
		for(int i=0; i<10;i++) {
			apps.addAppointment(02, 23, 2026, "Test Appointment");
		}
		assertTrue(apps.getApps().size()==10);
		apps.deleteAllTasks();
		assertTrue(apps.getApps().size()==0);
	}
	
	//Unique ID
	@Test
	void testThatIDIsUnique() {
		for(int i=0; i<10;i++) {
			apps.addAppointment(02, 23, 2026, "Test Appointment");
		}
		assertTrue(apps.getApps().size()==10);
		assertTrue(apps.isUnique(apps.getApps()));
	}
}

