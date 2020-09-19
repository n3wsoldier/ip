package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.ui.Ui;

public abstract class Command {

    /**
     * Executes the command and returns the result.
     * This method is to be implemented by child classed
     */
    public abstract void execute(TaskList tasks, Ui ui, StorageManager storage);

    /***
     * isExit return boolean to check if the program is exiting
     * False by default but override by ExitCommand
     * @return
     */
    public boolean isExit(){
        return false;
    };

}
