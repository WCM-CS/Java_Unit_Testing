package appointmentService;
import java.util.Date;

public class Appointment {

	private String id;
	private Date date;
	private String description;
	
	public Appointment(String id, Date date, String description) {
		setId(id);
		setDate(date);
		setDescription(description);
	}

	public void setId(String id) {
		if(id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.id = id;
	}

	public void setDate(Date date) {
		Date cur = new Date();
		if(date == null || date.before(cur)){
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.date = date;
	}

	public void setDescription(String description) {
		if(description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.description = description;
	}

	public String getId() { return id;}

	public Date getDate() { return date;}

	public String getDescription() { return description;}
}
