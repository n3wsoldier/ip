public class Todo extends Task {

    public Todo(String description) {
        super(description, Type.Todo);
        isDone = false;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString() ;
    }
}
