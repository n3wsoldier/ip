package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.ui.Ui;

public class DeleteCommand extends Command{

    public static final String COMMAND_DELETE = "delete";

    private int toDelete;

    /***
     * DoneCommand constructor using int values.
     * @param tasksIndex : task index to set as done
     */
    public DeleteCommand(int tasksIndex){
        toDelete = tasksIndex;
    }

    /***
     * Execute Delete command: Delete a task from tasklist
     * Print task deleted Message
     * Update save file
     * @param tasks : TaskList object with list available function
     * @param ui : ui user interaction/interface related function (printing messages)
     * @param storage : Storage manager to update save file
     */
    @Override
    public void execute(TaskList tasks, Ui ui, StorageManager storage){
        Ui.printTaskDeleteMessage(tasks.size()-1,tasks.get(toDelete).toString());
        tasks.deleteTask(toDelete);
        storage.save(tasks.toString());
    }
}
