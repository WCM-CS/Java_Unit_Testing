package taskService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskService {
	private List<Task> tasks;
    private Random random;

    public TaskService(){
        tasks = new ArrayList<Task>();
        random = new Random();
    }
    
    //Return tasks object list
    public List<Task> getTasks() {
        return tasks;
    }
    
    //return a specific object from the list based on it's ID
	public Task getTask(String id) {
		Iterator<Task> itr = tasks.iterator();
		while(itr.hasNext()) {
			Task task = itr.next();
			if (task.getID().equals(id)) {
				return task;
			}
		}
		return null;
	}

	//Generate unique ID to use in constructor 
    public String generateUniqueId() {
        String id = String.format("%010d", random.nextInt(1000000000));
        for (Task task : tasks) {
            if (task.getID().equals(id)) {
                return generateUniqueId();
            }
        }
        return id;
    }
    
    //Uses constructor to create new and add tasks to the object list
    public Task addTask(String name, String description){
    	String id = generateUniqueId();
        Task task = new Task(id, name, description);
        tasks.add(task);
        return task;
    }
    
	//Removes task from the list based on it's ID
    public boolean deleteTask(String taskId) {
        if (taskId != null && !taskId.isEmpty()) {
            for (Task task : tasks) {
                if (task.getID().equals(taskId)) {
                    tasks.remove(task);
                    return true;
                }
            }
        }
        return false;
    }
    
    //This function removes all tasks from the task list
    public void deleteAllTasks() {
    	Iterator<Task> itr = tasks.iterator();
		while(itr.hasNext()) {
			itr.next();
			itr.remove();
		}
    }
    
    //Updates an existing objects name
    public void updateTaskName(String taskId, String newName){
    	// if(newName == null || newName.length() > 20)
            // throw new IllegalArgumentException("Name can't be null and should be less than 20 characters");
    	//if (taskId != null && !taskId.isEmpty() && newName != null && !newName.isEmpty()) {
           for (Task task : tasks) {
        	   if (task.getID().equals(taskId)) {
        		   task.setName(newName);
                }
            }
       // }
       // return false;
    }
    
    //updates a tasks description based on it's ID
    public void updateTaskDescription(String taskId, String newDescription){
    	for (Task task : tasks) {
    		if (task.getID().equals(taskId)) {
    			task.setDescription(newDescription);
    		}  
    	}
    }
    
    //Method ensures that all objects in task list are unique
    //I Tested adding objects with the same name and description
    //Therefore the ID were the only variable causing the objects to be unique 
    public boolean isUnique(List<Task> tasks) {
    	return tasks.stream().distinct().count() == tasks.size();
    }
}
