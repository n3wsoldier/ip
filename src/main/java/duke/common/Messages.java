package duke.common;

public class Messages {


    public static final String LS = System.lineSeparator();
    public static final String MESSAGE_INTRO = "\t Hello! I'm Duke"
                    + LS +"\t What can I do for you?";
    /* Predetermined Message List */
    public static final String MESSAGE_LOGO = " ____        _        "+LS
            + "|  _ \\ _   _| | _____ "+LS
            + "| | | | | | | |/ / _ \\"+LS
            + "| |_| | |_| |   <  __/"+LS
            + "|____/ \\__,_|_|\\_\\___|"+LS;
    public static final String MESSAGE_EXIT = "\t Bye. Hope to see you again soon!";
    public static final String MESSAGE_DONE = "\t Nice! I've marked this task as done:";
    public static final String MESSAGE_TASK_ADDED = "\t Got it. I've added this task:";
    public static final String MESSAGE_LIST = "\t Here are the tasks in your list:";
    public static final String MESSAGE_LINE = "\t___________________________________________________________________"
                    +"_______________________";
    public static final String MESSAGE_DELETE = "\t Noted. I've removed this task:";
    public static final String MESSAGE_LOAD_ERROR ="\t Loading error! Saved file does not exists.";
    public static final String MESSAGE_EMPTY_FILE ="\t Loading error! Saved file as it is empty.";
    public static final String MESSAGE_LOADING ="\t Loading save file...";
    public static final String MESSAGE_LOADED = " tasks have been loaded from saved file.";
    public static final String MESSAGE_DESCRIPTION_EMPTY ="\t ☹ OOPS!!! Missing Something?" + LS
                    + "\t Delete/Done requires a task index. While Todo/Deadline/Event requires descriptions."+LS
                    +"\t Use the \"help\" command for more information";
    public static final String MESSAGE_DESCRIPTION_INVALID = "\t ☹ OOPS!!! The Deadline/Event task cannot be without "+
            "due time"
            +LS
            +"\t Use the \"help\" command for more information";
    public static final String MESSAGE_INVALID_COMMAND_ERROR = "\t ☹ OOPS!!! I'm sorry,"
            +" but I don't know what that means :-("+LS
            +"\t Use the \"help\" command for more information";
    public static final String MESSAGE_HELP = "\t Command:"
            + LS + "\t list:                                     list all the Tasks"
            + LS + "\t done [Task Index]:                        Complete the task in the Task Manager"
            + "            e.g. done 2"
            + LS + "\t todo [Description]:                       Add a Todo type task into the Task Manager"
            + "       e.g. todo read book"
            + LS + "\t deadline [Description] /by [Deadline]:    Add a Deadline type task into the Task Manager"
            + "   e.g. deadline return book /by June 6th"
            + LS + "\t event [Description] /at [Event time]:     Add an Event type task into the Task Manager"
            + "     e.g. event project meeting /at Aug 6th 2-4pm"
            + LS + "\t delete [Task Index]:                      Delete the task"
            + "                                  e.g. delete 3"
            + LS + "\t bye:                                      Exit the program *we do not save for you on exit";
}
