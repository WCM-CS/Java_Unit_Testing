package appointmentService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AppointmentService {

	private List<Appointment> apps;
	private Random random;
	
	public AppointmentService() {
		apps = new ArrayList<Appointment>();
		random = new Random();
	}
	
	public List<Appointment> getApps() {
        return apps; 
    }
	
	public Appointment getApp(String id) {
		Iterator<Appointment> itr = apps.iterator();
		while(itr.hasNext()) {
			Appointment app = itr.next();
			if (app.getId().equals(id)) {
				return app;
			}
		}
		return null;
	}
	
	public String generateUniqueId() {
        String id = String.format("%010d", random.nextInt(1000000000));
        for (Appointment app : apps) {
            if (app.getId().equals(id)) {
                return generateUniqueId();
            }
        }
        return id; 
    }
	
	//Month is 0-11; Jan 0, Dec 11
	public Appointment addAppointment(int month, int date, int year, String description) {
		String id = generateUniqueId();
		Calendar temp = Calendar.getInstance();
		temp.set(Calendar.MONTH, month); 
		temp.set(Calendar.DATE,  date);
		temp.set(Calendar.YEAR, year);
		Date app = temp.getTime();
		Appointment appointment = new Appointment(id, app, description);
		apps.add(appointment);
		return appointment;
	}
	
	public boolean deleteAppointment(String appId) {
		if (appId != null && !appId.isEmpty()) {
            for (Appointment app : apps) {
                if (app.getId().equals(appId)) {
                    apps.remove(app);
                    return true;
                }
            }
        }
        return false;
	}
	
	public void deleteAllTasks() {
    	Iterator<Appointment> itr = apps.iterator();
		while(itr.hasNext()) {
			itr.next();
			itr.remove();
		}
    }
	
	public boolean isUnique(List<Appointment> x) {
    	return x.stream().distinct().count() == x.size();
    }
}
