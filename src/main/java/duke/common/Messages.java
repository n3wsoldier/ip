package duke.common;

public class Messages {


    public static final String LS = System.lineSeparator();
    public static final String MESSAGE_INTRO = " What can I do for you?";
    /* Predetermined Message List */
    public static final String MESSAGE_LOGO = "  ____        _        "+LS
            + " |  _ \\ _   _| | _____ "+ "\t   //"+LS
            + " | | | | | | | |/ / _ \\"+ "\t  ('>"+LS
            + " | |_| | |_| |   <  __/"+ "\t  /rr" +LS
            + " |____/ \\__,_|_|\\_\\___|"+ "\t *\\))_"+LS;
    public static final String MESSAGE_EXIT = " Bye. Hope to see you again soon!";
    public static final String MESSAGE_DONE = " Nice! I've marked this task as done:";
    public static final String MESSAGE_ALREADY_DONE = " Hmmm! The task have already been completed:";
    public static final String MESSAGE_TASK_ADDED = " Got it. I've added this task:";
    public static final String MESSAGE_LIST = " Here are the tasks in your list:";
    public static final String MESSAGE_FIND = " Here are the tasks with";
    public static final String MESSAGE_LINE = "___________________________________________________________________"
                    +"_______________________";
    public static final String MESSAGE_DELETE = " Noted. I've removed this task:";
    public static final String MESSAGE_LOAD_ERROR =" Loading error! Saved file does not exists.";
    public static final String MESSAGE_EMPTY_FILE =" Loading error! Saved file as it is empty.";
    public static final String MESSAGE_LOADING =" Loading save file...";
    public static final String MESSAGE_LOADED = " tasks have been loaded from saved file.";
    public static final String MESSAGE_DESCRIPTION_EMPTY =" ☹ OOPS!!! Missing Something?" + LS
                    + " Delete/Done requires a task index. While Todo/Deadline/Event requires descriptions."+LS
                    +" Use the \"help\" command for more information";
    public static final String MESSAGE_DESCRIPTION_INVALID = " ☹ OOPS!!! The Deadline/Event task cannot be without "+
            "due time"
            +LS
            +" Use the \"help\" command for more information";
    public static final String MESSAGE_INVALID_COMMAND_ERROR = "\t ☹ OOPS!!! I'm sorry,"
            +" but I don't know what that means :-("+LS
            +" Use the \"help\" command for more information";
    public static final String MESSAGE_HELP = " Command:"
            + LS + " list:                                     list all the Tasks"
            + LS + " done [Task Index]:                        Complete the task in the Task Manager"
            + "            e.g. done 2"
            + LS + " todo [Description]:                       Add a Todo type task into the Task Manager"
            + "       e.g. todo read book"
            + LS + " deadline [Description] /by [Deadline]:    Add a Deadline type task into the Task Manager"
            + "   e.g. deadline return book /by June 6th"
            + LS + " event [Description] /at [Event time]:     Add an Event type task into the Task Manager"
            + "     e.g. event project meeting /at Aug 6th 2-4pm"
            + LS + " delete [Task Index]:                      Delete the task"
            + "                                  e.g. delete 3"
            + LS + " bye:                                      Exit the program *we do not save for you on exit";
}
