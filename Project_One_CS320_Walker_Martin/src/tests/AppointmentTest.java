package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import appointmentService.Appointment;



class AppTest { 

	@Test
	public void testValidAppointment() {
		
	    Calendar cal = Calendar.getInstance(); 
	    cal.set(2025, Calendar.MAY, 5); 
	    Date date = cal.getTime();
	    Appointment appointment = new Appointment("12345", date, "Doctor Visit");
		
		Assert.assertEquals("12345", appointment.getId());
		Assert.assertEquals(date, appointment.getDate());
		Assert.assertEquals("Doctor Visit", appointment.getDescription());
	} 
	
    @Test
    public void testInvalidId() {
        Date date = new Date();
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, date, "Important meeting"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", date, "Important meeting"));
    }
    
    @Test
    public void testInvalidDate() {
        Date cur = new Date();
        Date date = new Date(cur.getTime() - 24 * 60 * 60 * 1000); // yesterday
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", date, "Important meeting"));
    }
    
    @Test
    public void testInvalidDescription() {
        Date date = new Date();
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", date, null));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", date, "l5oA6tK9uQ2xE3cR1iNbhjv7gH8mP0bD4fW6zL3yJ5hU1vT7jS8kZ9"));
    }
}
