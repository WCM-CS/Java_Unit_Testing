package taskService;

public class Task {
	private String ID;
    private String name;
    private String description;
    
    
 //Null Constructor For testing purposes not uses in TaskService functions
    public Task() { 
    	this.ID = null;
    	this.name = null;
    	this.description = null;
    }
//Constructor
    public Task(String ID, String name, String description) {
        if(ID == null || ID.length() > 10)
            throw new IllegalArgumentException("ID can't be null and should be less than 10 characters");
        if(name == null || name.length() > 20)
            throw new IllegalArgumentException("Name can't be null and should be less than 20 characters");
        if(description == null || description.length() > 50)
            throw new IllegalArgumentException("Description can't be null and should be less than 50 characters");
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        if(ID == null || ID.length() > 10)
            throw new IllegalArgumentException("ID can't be null and should be less than 10 characters");
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.length() > 20)
            throw new IllegalArgumentException("Name can't be null and should be less than 20 characters");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description == null || description.length() > 50)
            throw new IllegalArgumentException("Description can't be null and should be less than 50 characters");
        this.description = description;
    }
}
