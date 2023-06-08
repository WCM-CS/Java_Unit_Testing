package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;

class ContactTest {

	//Validate that correct inputs are valid.
	//Testing proper inputs
	@Test
	void testContact() {
		Contact contact = new Contact("343", "Walker", "Martin", "12345", "My House 22 Rd");
		assertTrue(contact.getId().equals("343"));
		assertTrue(contact.getFirstName().equals("Walker"));
		assertTrue(contact.getLastName().equals("Martin"));
		assertTrue(contact.getNumber().equals("12345"));
		assertTrue(contact.getAddress().equals("My House 22 Rd"));
	}
	
	//Check that improper inputs are indeed throwing errors.
	//Testing id
	@Test
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Walker", "Martin", "12345", "My House 22 Rd");
		}); }
	
	//Testing first name
	@Test
	void testContactFirstNameIsLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("343", "WalkersNameLong", "Martin", "12345", "My House 22 Rd");
		}); }
	
	//Testing last name
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("343", "Walker", null, "12345", "My House 22 Rd");
		}); }
	
	//testing number
	@Test
	void testContactNumberIsLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Walker", "Martin", "12345555555555", "My House 22 Rd");
		}); }
	
	//Testing address
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Walker", "Martin", "12345", null);
		}); }

	//Test the update methods
	@Test
	void testSetMethods() {
		Contact contact = new Contact("343", "Walker", "Martin", "12345", "My House 22 Rd");
		
		contact.setId("ten");
		assertTrue(contact.getId().equals("ten"));
		
		contact.setNumber("22");
		assertTrue(contact.getNumber().equals("22"));
		
		contact.setFirstName("4");
		assertTrue(contact.getFirstName().equals("4"));
		
		contact.setLastName("Wall");
		assertTrue(contact.getLastName().equals("Wall"));
		
		contact.setNumber("768");
		assertTrue(contact.getNumber().equals("768"));
		
		contact.setAddress("House");
		assertTrue(contact.getAddress().equals("House"));
		
	 }
}
	