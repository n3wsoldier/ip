package duke.task;

public class Task {
    protected String description;
    protected boolean isDone;
    protected TaskType taskType;
    private static int numberOfTasks = 0;


    public Task(String description, TaskType taskType) {
        this.description = description;
        this.isDone = false;
        this.taskType = taskType;
        numberOfTasks++;
    }


    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone(){
        isDone = true;
    }

    public String getDescription(){
        return description;
    }

    public static int getNumberOfTasks(){
        return numberOfTasks;
    }
    
    @Override
    public String toString() {
        return "["+ this.getStatusIcon()+"] " + this.getDescription();
    }
}