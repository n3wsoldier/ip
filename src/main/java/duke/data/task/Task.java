package duke.data.task;


public class Task {
    protected String description;
    protected boolean isDone;
    public TaskType taskType;



    public Task(String description, TaskType taskType) {
        this.description = description;
        this.isDone = false;
        this.taskType = taskType;
    }


    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone(){
        isDone = true;
    }

    public boolean isDone(){
        return this.isDone;
    }

    public String getDescription(){
        return description;
    }

    public boolean isDateTime(){
        return false;
    }
    
    @Override
    public String toString() {
        return "["+ this.getStatusIcon()+"] " + this.getDescription();
    }
}