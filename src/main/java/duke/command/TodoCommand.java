package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.data.task.Todo;
import duke.ui.Ui;

public class TodoCommand extends Command{

    public static final String COMMAND_TODO = "todo";

    private Todo  toAdd;

    /**
     * TodoCommand constructor using string values.
     * @param description : description of task
     */
    public TodoCommand(String description){
        this.toAdd = new Todo(description);
    }

    /**
     * Execute To-do command: Add to-do tasktype into tasklist
     * Print to-do added Message
     * Update save file
     * @param tasks : TaskList object with list available function
     * @param ui : ui user interaction/interface related function (printing messages)
     * @param storage : Storage manager to update save file
     */
    @Override
    public void execute(TaskList tasks, Ui ui, StorageManager storage){
        tasks.addTaskToList(toAdd);
        ui.printTaskAddedMessage(toAdd.toString(), tasks.size());
        storage.save(tasks.toString());
    }
}
