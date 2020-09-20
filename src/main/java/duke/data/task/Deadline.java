package duke.data.task;

public class Deadline extends Task {
    protected String by;

    /***
     * Deadline constructor, use Task constructor
     * @param description : Description of task
     * @param by : Due date of task
     */
    public Deadline(String description, String by){
        super(description, TaskType.Deadline);
        this.by = by;
        this.toString();

    }

    /***
     * Return the due date (by)
     * @return
     */
    public String getBy(){
        return by;
    }

    /***
     * Modify the due date (by)
     * @param by
     */
    public void setBy(String by){
        this.by = by;
    }

    /***
     * Format the way to print Deadline task
     * @return
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
