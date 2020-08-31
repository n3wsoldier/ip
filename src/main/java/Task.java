public class Task {
    protected String description;
    protected boolean isDone;
    protected Type type;
    private static int numberOfTasks = 0;


    public Task(String description, Type type) {
        this.description = description;
        this.isDone = false;
        this.type = type;
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