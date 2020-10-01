package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.ui.Ui;

public class DeleteCommand extends Command{

    public static final String COMMAND_DELETE = "delete";

    private int toDelete;

    /**
     * DoneCommand constructor using int values.
     * @param tasksIndex : task index to set as done
     */
    public DeleteCommand(int tasksIndex){
        toDelete = tasksIndex;
    }

    /**
     * Execute Delete command: Delete a task from tasklist
     * Print task deleted Message, print error message when task not within list
     * Update save file
     * @param tasks : TaskList object with list available function
     * @param ui : ui user interaction/interface related function (printing messages)
     * @param storage : Storage manager to update save file
     */
    @Override
    public void execute(TaskList tasks, Ui ui, StorageManager storage){

        try {
            String toString = tasks.get(toDelete).toString();
            tasks.deleteTask(toDelete);
            Ui.printTaskDeleteMessage(toString, tasks.size(), tasks.getCompletedTask());
            storage.save(tasks.toString());
        }catch (IndexOutOfBoundsException e){
            Ui.printIndexOutError("Delete");
        }
    }
}
