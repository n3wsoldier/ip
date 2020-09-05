package task;

public class Todo extends Task {

    public Todo(String description) {
        super(description, TaskType.Todo);
        isDone = false;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString() ;
    }
}
