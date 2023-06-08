package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;
import taskService.TaskService;

class TaskServiceTest {

	TaskService tasks = new TaskService();

	//Test addSingleTask
	@Test
	void testAddSingleTask() {
		Task task;
		task = tasks.addTask("Walker Martin", "CS Major and lifter and gamer");
		assertTrue(tasks.getTask(task.getID()).getName().equals("Walker Martin"));
		assertTrue(tasks.getTask(task.getID()).getDescription().equals("CS Major and lifter and gamer"));
		Assertions.assertTrue(tasks.getTasks().size()==1);
	}
	//long name
	@Test
	void testAddTask_withLongName() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> { tasks.addTask("WALKERSNAMEISTOOLONG000000", "Duck");
			});
	}
	
	//Null Name
	@Test
	void testAddTask_withNullName() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> { tasks.addTask(null, "Duck");
			});
	}
	
	//Long Desc
	@Test
	void testAddTask_withLongDescription() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> { tasks.addTask("Walker", "Duckdfdfjhhgjhfjghbjfgslgbfdgbdfslgbhsdfhgsdfhgbfdlgufvhghbgvubvslbvslvbdfhjvbdfugbvlfsdbvsvb");
			});
	}
	
	//Null Desc
	@Test
	void testAddTask_withNullDescription() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> { tasks.addTask("Walker",null);
			});
	}
	
	//TestAddMultpleTasks
	@Test
	void testAddMultipleTasks() {
		for(int i = 0; i < 10; i++) {
			tasks.addTask("Walker", "code red");
		}
		Assertions.assertTrue(tasks.getTasks().size()==10);
		Assertions.assertFalse(tasks.getTasks().size()==11);
	}
	
	//Test Delete Task
	@Test
	void testSingleDeleteTask() {
		Task task;
		task = tasks.addTask("Walker Martin","CS Major and lifter and gamer");
		Assertions.assertTrue(tasks.getTasks().size()==1);
		assertTrue(tasks.getTask(task.getID()).getName().equals("Walker Martin"));
		assertFalse(tasks.getTask(task.getID()).getDescription().equals(null));
		tasks.deleteTask(task.getID());
		Assertions.assertTrue(tasks.getTasks().size()==0);
	}
	
	@Test
	void testMultipleDeleteTask() {
		for(int i = 0; i < 10; i++) {
			tasks.addTask("Walker", "code red");
		}
		Assertions.assertTrue(tasks.getTasks().size()==10);
		tasks.deleteAllTasks();
		Assertions.assertTrue(tasks.getTasks().size()==0);
	}
	
	//TestUpdateName
	@Test
	void testUpdateName() {
		Task task;
		task = tasks.addTask("Walker Martin", "CS Major and lifter and gamer");
		assertTrue(tasks.getTask(task.getID()).getName().equals("Walker Martin"));
		assertTrue(tasks.getTask(task.getID()).getDescription().equals("CS Major and lifter and gamer"));
		tasks.updateTaskName(task.getID(), "Duck");
		assertTrue(tasks.getTask(task.getID()).getName().equals("Duck"));
	}
	
	//TestUpdateDescription
	@Test
	void testUpdateDesc() {
		Task task;
		task = tasks.addTask("Walker Martin", "CS Major and lifter and gamer");
		assertTrue(tasks.getTask(task.getID()).getName().equals("Walker Martin"));
		assertTrue(tasks.getTask(task.getID()).getDescription().equals("CS Major and lifter and gamer"));
		tasks.updateTaskDescription(task.getID(), "Enigmatic");
		assertTrue(tasks.getTask(task.getID()).getDescription().equals("Enigmatic"));
	}
	
	//NullUpdateName
	@Test
	void tastUpdateName_withNullName() {
		Task task;
		task = tasks.addTask("Walker Martin", "CS Major and lifter and gamer");
		Assertions.assertThrows(IllegalArgumentException.class, 
	            () -> tasks.updateTaskName(task.getID(), null));
	}
	
	//long name update
	@Test
	void tastUpdateName_withLongName() {
		Task task;
		task = tasks.addTask("Walker Martin", "CS Major and lifter and gamer");
		Assertions.assertThrows(IllegalArgumentException.class, 
	            () -> tasks.updateTaskName(task.getID(), "jhdfjghsgfaljgalhsgfhasdjgfashjfgashjkf"));
	}
	
	//null desc update
	@Test
	void tastUpdateDesc_withNullDesc() {
		Task task;
		task = tasks.addTask("Walker Martin", "CS Major and lifter and gamer");
		Assertions.assertThrows(IllegalArgumentException.class, 
	            () -> tasks.updateTaskDescription(task.getID(), null));
	}
	
	//update long description
	@Test
	void tastUpdateDesc_withLongDesc() {
		Task task;
		task = tasks.addTask("Walker Martin", "CS Major and lifter and gamer");
		Assertions.assertThrows(IllegalArgumentException.class, 
	            () -> tasks.updateTaskName(task.getID(), "1234567890123456789012cfghfdhgfdhdfghjdfdfgdfghdjddjddfdgfhdxfhdghddhdydtydhgdgdd3456789012345678901"));
	}
	
	//Test That multiple tasks have unique Id's 
	//isUnique checks that each object has a unique Id
	@Test
	void testUniqueStrings() {
		for(int i = 0; i < 10; i++) {
			tasks.addTask("Walker", "code red");
		}
		assertTrue(tasks.isUnique(tasks.getTasks()));
	}
	
	//Note that the generate unique ID function iterates through the object list checking their
	//unique Id so that is a duplicate occurs the generate unique ID function is called again
	//There is no manual input for unique Id with functions in TaskService, just the task constructor
}
