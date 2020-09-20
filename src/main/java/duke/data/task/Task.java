package duke.data.task;


public class Task {
    protected String description;
    protected boolean isDone;
    public TaskType taskType;
    private static int numberOfTasks = 0;

    /***
     * Task Constructor to be called by all subclass
     * Newly created task by default not done
     * @param description : Description of task
     * @param taskType : The type of task
     */
    public Task(String description, TaskType taskType) {
        this.description = description;
        this.isDone = false;
        this.taskType = taskType;
        numberOfTasks++;
    }

    /***
     * Return tick or x symbols base on isDone value
     * @return
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /***
     * maskAsDone to mark task as done using isDone boolean
     */
    public void markAsDone(){
        isDone = true;
    }

    /***
     * return the boolean isDone
     * @return
     */
    public boolean isDone(){
        return this.isDone;
    }

    /***
     * Get the description of a task
     * @return
     */
    public String getDescription(){
        return description;
    }


    public static int getNumberOfTasks(){
        return numberOfTasks;
    }

    /***
     * Get the status icon and description of task
     * Will be build on by subclasses
     * @return
     */
    @Override
    public String toString() {
        return "["+ this.getStatusIcon()+"] " + this.getDescription();
    }
}