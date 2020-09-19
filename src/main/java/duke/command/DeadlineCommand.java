package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.data.task.Deadline;
import duke.ui.Ui;

public class DeadlineCommand extends Command{

    public static final String COMMAND_DEADLINE = "deadline";

    private Deadline toAdd;

    /***
     * DeadlineCommand constructor using string values.
     * @param description : description of task
     * @param by : deadline of task
     */
    public DeadlineCommand(String description, String by){
        this.toAdd = new Deadline(description,by);
    }

    /***
     * Execute Deadline command: Add deadline tasktype into tasklist
     * Print Deadline added Message
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
