package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.ui.Ui;

public class DoneCommand extends Command{

    public static final String COMMAND_DONE = "done";

    private int toDone;

    /***
     * DoneCommand constructor using int values.
     * @param doneIndex : task index to set as done
     */
    public DoneCommand(int doneIndex){
        toDone = doneIndex;
    }

    /***
     * Execute Done command: set task as done
     * Print Task done added Message
     * Update save file
     * @param tasks : TaskList object with list available function
     * @param ui : ui user interaction/interface related function (printing messages)
     * @param storage : Storage manager to update save file
     */
    @Override
    public void execute(TaskList tasks, Ui ui, StorageManager storage){
        tasks.setTaskDone(toDone);
        Ui.printTaskDoneMessage(tasks.get(toDone).toString());
        storage.save(tasks.toString());
    }
}
