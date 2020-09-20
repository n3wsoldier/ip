package duke.data.task;

public class Todo extends Task {

    /***
     * Todo constructor, use Task constructor
     * @param description : Description of task
     */
    public Todo(String description) {
        super(description, TaskType.Todo);
    }

    /***
     * Format the way to print Event task
     * @return
     */
    @Override
    public String toString() {
        return "[T]" + super.toString() ;
    }
}
