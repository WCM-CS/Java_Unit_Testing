package contactService;

public class Contact {

	//Making variables for contact data
	private String id;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	//Make constructor for contacts 
	public Contact(String id, String firstName, String lastName, String number, String address) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		setAddress(address);
	}
	
	//Functions to update the variables
	public void setId(String id) {
		if(id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.lastName = lastName;
	}
	
	public void setNumber(String number) {
		if(number == null || number.length()>10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		this.number = number;
	}
	
	public void setAddress(String address) {
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
	
	//Functions to return the corresponding contact data 
	public String getId() {
		return id; 
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getNumber() {
		return number;
	}
	public String getAddress() {
		return address;
	}
}