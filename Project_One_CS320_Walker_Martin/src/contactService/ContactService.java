package contactService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ContactService {
	
	//Make lists to store unique Id and contact objects
	ArrayList<Contact> contacts1 = new ArrayList<>(); //Contact Array
	ArrayList<String> contacts2 = new ArrayList<String>(); //ID array

	public ArrayList<String> returnArray() { //Array to return the string array
		return contacts2; 
	}
	
	//generate Id
	private String generateId() {
		Random rand = new Random();
		String temp;
		
		long lowerB = 1000000000L;
		long randomLong = rand.nextInt() + lowerB;
		temp = String.valueOf(randomLong);
		contacts2.add(temp);//add ID to array
		return temp;
	}
	
	//Function inputs contact info and assigns a unique Id, contact is added to contact list
	//by calling the constructor with the ID function nested
	public Contact addContact(String firstName, String lastName, String number, String address) {
		Contact contact = new Contact(generateId(), firstName, lastName, number, address);
		contacts1.add(contact);//I added the contacts to the contact array but the
		//ID function adds the ID to the ID array
		return contact;
	}
	
	
	//Function to delete contact from contact list per Unique Id
	public void removeContact(String id) {
		Contact contact = getContact(id);
		contacts1.remove(contact);//remove from contact array
		contacts2.remove(id); //remove from id array
		
	}
	
	//iterator function to search the object array and return the objects with the corresponding id
	public Contact getContact(String id) {
		Iterator<Contact> itr = contacts1.iterator();
		while(itr.hasNext()) {
			Contact contact = itr.next();
			if (contact.getId().equals(id)) {
				return contact;
			}
		}
		return null;
	}
	
	//Function to update contacts variables to an existing object
	public void updateContacts(String id, String firstName, String lastname, String number, String address) {
		Contact contact = getContact(id);
		contact.setFirstName(firstName);
		contact.setLastName(lastname);
		contact.setNumber(number);
		contact.setAddress(address);
	}
}