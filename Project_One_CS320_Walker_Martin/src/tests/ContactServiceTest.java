package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

class ContactServiceTest {

	ContactService contacts = new ContactService();
	
	//Testing the Add Contact Function
	@Test
	void testAddContact() {
		Contact contact; 
		contact = contacts.addContact("Walker", "Martin", "12345", "My House 22 Rd");
		assertTrue(contacts.getContact(contact.getId()).getNumber().equals("12345"));
		Assertions.assertTrue(contacts.returnArray().size()==1); //Confirm that the array has a id string thus was added as a contact
	}
	
	@Test
	void testAddContactInvalidFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contacts.addContact(null, "Martin", "12345", "My House 22 Rd");
		});
	}
	
	@Test
	void testAddContactInvalidLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contacts.addContact("Walker", "Martinsqueattica", "12345", "My House 22 Rd");
		});
	}
	
	@Test
	void testAddContactInvalidNumber() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contacts.addContact("Walker", "Martin", null, "My House 22 Rd");
		});
	}
	
	@Test
	void testAddContactInvalidAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contacts.addContact("Walker", "Martin", "12345", "Atlantis1220339443202786g798fgftufd56dd5sjd");
		});
	}
	
	//Testing Delete Contact Function
	@Test
	void testDeleteContact() {
		Contact contact;
		contact = contacts.addContact("Walker", "Martin", "12345", "My House 22 Rd");
		contacts.removeContact(contact.getId());
		Assertions.assertFalse(contacts.returnArray().size()==1);
		Assertions.assertTrue(contacts.returnArray().size()<1);
	}
	
	@Test 
	void testUpdateFunction() {
		Contact contact;
		contact = contacts.addContact("Walker", "Martin", "12345", "My House 22 Rd");
		contacts.updateContacts(contact.getId(), "Kill", "Bill", "777", "Cafe");
		
		assertTrue(contacts.getContact(contact.getId()).getNumber().equals("777"));
		assertTrue(contacts.getContact(contact.getId()).getAddress().equals("Cafe"));
		assertFalse(contacts.getContact(contact.getId()).getFirstName().equals("Walker"));
	}
	
}
