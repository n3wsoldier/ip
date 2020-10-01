package duke.data.task;


import java.util.Date;

public class Task {
    protected String description;
    protected boolean isDone;
    protected TaskType taskType;


    /**
     * Task Constructor to be called by all subclass
     * Newly created task by default not done
     * @param description : Description of task
     * @param taskType : The type of task
     */
    public Task(String description, TaskType taskType) {
        this.description = description;
        this.isDone = false;
        this.taskType = taskType;
    }

    /**
     * Return tick or x symbols base on isDone value
     * @return
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * maskAsDone to mark task as done using isDone boolean
     */
    public void markAsDone(){
        isDone = true;
    }

    /**
     * return the boolean isDone
     * @return
     */
    public boolean isDone(){
        return this.isDone;
    }

    /**
     * Get the description of a task
     * @return
     */
    public String getDescription(){
        return description;
    }

    /**
     * Return false by default unless deadline and Event have date duedate
     * @return
     */
    public boolean isDateTime(){
        return false;
    }

    /**
     * Return null by default unless deadline and Event have date duedate
     * @return
     */
    public Date getDate(){
        return null;
    }

    /**
     * Get the status icon and description of task
     * Will be build on by subclasses
     * @return
     */
    @Override
    public String toString() {
        return "["+ this.getStatusIcon()+"] " + this.getDescription();
    }
}