package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.data.task.Event;
import duke.ui.Ui;

public class EventCommand extends Command{

    public static final String COMMAND_EVENT = "event";

    private Event toAdd;

    /**
     * DeadlineCommand constructor using string values.
     * @param description : description of task
     * @param at : deadline of task
     */
    public EventCommand(String description, String at){
        this.toAdd = new Event(description,at);
    }

    /**
     * Execute Event command: Add event tasktype into tasklist
     * Print event added Message
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
