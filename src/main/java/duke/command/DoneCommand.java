package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.ui.Ui;

public class DoneCommand extends Command{

    public static final String COMMAND_DONE = "done";

    private int toDone;

    /**
     * DoneCommand constructor using int values.
     * @param doneIndex : task index to set as done
     */
    public DoneCommand(int doneIndex){
        toDone = doneIndex;
    }

    /**
     * Execute Done command: set task as done
     * Print Task done added Message, print error message when task not within list
     * Update save file
     * @param tasks : TaskList object with list available function
     * @param ui : ui user interaction/interface related function (printing messages)
     * @param storage : Storage manager to update save file
     */
    @Override
    public void execute(TaskList tasks, Ui ui, StorageManager storage){
        try{
        boolean success =tasks.setTaskDone(toDone);
        if(success){
            Ui.printTaskDoneMessage(tasks.get(toDone).toString(), tasks.size(), tasks.getCompletedTask() );
            storage.save(tasks.toString());
        }else{
            Ui.printTaskAlreadyDoneMessage(tasks.get(toDone).toString() , tasks.size(), tasks.getCompletedTask() );

        }}catch (IndexOutOfBoundsException e){
            Ui.printIndexOutError("Done");
        }

    }
}
