package duke.data.task;

public class Event extends Task {
    protected String at;

    /***
     * Deadline constructor, use Task constructor
     * @param description : Description of task
     * @param at : Due date of task
     */
    public Event(String description, String at){
        super(description , TaskType.Event);
        this.at = at;
    }

    /***
     * Return the due date (at)
     * @return
     */
    public String getAt(){
        return at;
    }

    /***
     * Modify the due date (at)
     * @param at
     */
    public void setAt(String at){
        this.at = at;
    }

    /***
     * Format the way to print Event task
     * @return
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

}
