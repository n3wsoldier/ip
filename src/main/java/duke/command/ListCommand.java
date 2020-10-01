package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.ui.Ui;

public class ListCommand extends Command{

    public static final String COMMAND_LIST = "list";

    /**
     * List task command
     * @param tasks : TaskList object with list available function
     * @param ui : ui user interaction/interface related function (printing messages)
     * @param storage : Storage manager to update save file
     */
    @Override
    public void execute(TaskList tasks, Ui ui, StorageManager storage){
        ui.printTaskList(tasks, tasks.size(), tasks.getCompletedTask());
    }
}
