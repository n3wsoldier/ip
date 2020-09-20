package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.data.task.Todo;
import duke.ui.Ui;

public class FindCommand extends Command{
    public static final String COMMAND_FIND = "find";

    private String toFind;

    /***
     * FindCommand constructor using string values.
     * @param search : description of task
     */
    public FindCommand(String search){
        this.toFind = search;
    }
    /***
     * Print task with search phrase
     * @param tasks : TaskList object with list available function
     * @param ui : ui user interaction/interface related function (printing messages)
     * @param storage : Storage manager to update save file
     */
    @Override
    public void execute(TaskList tasks, Ui ui, StorageManager storage){
        ui.printFindList(tasks, toFind);
    }
}
