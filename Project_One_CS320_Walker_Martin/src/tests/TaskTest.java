package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;

class TaskTest {

	@Test
    public void testConstructor() {
        Task task = new Task("1", "Task 1", "This is task 1");
        assertNotNull(task);
        assertEquals("1", task.getID());
        assertEquals("Task 1", task.getName());
        assertEquals("This is task 1", task.getDescription());
    }
	
	@Test
	public void testNullConstructor() {
		Task task = new Task();
    	Assertions.assertNull(task.getID());
    	Assertions.assertNull(task.getName());
    	Assertions.assertNull(task.getDescription());
	}

   @Test
    public void testConstructor_withNullID() {
	   Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Task(null, "Task 1", "This is task 1"));
    }
  
    @Test
    public void testConstructor_withLongID() {
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Task("12345678901234567890a", "Task 1", "This is task 1"));
    }

    @Test
    public void testConstructor_withNullName() {
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Task("1", null, "This is task 1"));
    }

    @Test
    public void testConstructor_withLongName() {
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Task("1", "123456789012345678901", "This is task 1"));
    }

    @Test
    public void testConstructor_withNullDescription() {
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Task("1", "Task 1", null));
    }

    @Test
    public void testConstructor_withLongDescription() {
       Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Task("1", "Task 1", "1234567890123456789012cfghfdhgfdhdfghjdfdfgdfghdjddjddfdgfhdxfhdghddhdydtydhgdgdd3456789012345678901"));
    }
    
    @Test
    public void testSetID() {
        Task task = new Task();
        task.setID("1");
        Assertions.assertEquals("1", task.getID());
    }

    @Test
    public void testSetName() {
        Task task = new Task();
        task.setName("Task 1");
        Assertions.assertEquals("Task 1", task.getName());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task();
        task.setDescription("This is task 1");
        Assertions.assertEquals("This is task 1", task.getDescription());
    }
}