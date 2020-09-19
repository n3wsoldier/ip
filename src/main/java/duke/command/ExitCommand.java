package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.ui.Ui;

public class ExitCommand extends Command{

    public static final String COMMAND_EXIT = "bye";

    /***
     * Print Exit Message
     * Save the current tasklist
     * @param tasks : TaskList object with list available function
     * @param ui : ui user interaction/interface related function (printing messages)
     * @param storage : Storage manager to update save file
     */
    @Override
    public void execute(TaskList tasks, Ui ui, StorageManager storage){
        ui.printExitMessage();
        storage.save(tasks.toString());
    }

    /***
     * isExit function to set true to exiting
     * @return true to isExit
     */
    @Override
    public boolean isExit(){
        return true;
    };
}
