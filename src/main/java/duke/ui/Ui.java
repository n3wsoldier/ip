package duke.ui;

import duke.common.Messages;
import duke.data.TaskList;

import java.util.Scanner;

public class Ui {

    private final Scanner SCANNER = new Scanner(System.in);

    /***
     * Gets the next line input from the user
     * @return input by the user
     */
    public String readCommand() {
        return SCANNER.nextLine();
    }

    /***
     * Print Intro message
     */
    public void showWelcome(){
        System.out.println("Hello from"+ Messages.LS + Messages.MESSAGE_LOGO);
        System.out.println(Messages.MESSAGE_INTRO);
    }

    /***
     * print loading messages
     */
    public void printLoadingMessage(){
        System.out.println(Messages.MESSAGE_LOADING);
    }

    /***
     * print number of task loaded and loaded message
     * @param tasksSize
     */
    public void printLoadedMessage(int tasksSize){
        System.out.println("\t "+tasksSize+ Messages.MESSAGE_LOADED);
    }

    /***
     * print line of _
     */
    public void showLine(){
        System.out.println(Messages.MESSAGE_LINE);
    }

    /***
     * Print message when a new task is added into task manager
     * @param taskToString: toString of of task
     * @param numberOfTasks: the numberOfTasks
     */
    public static void printTaskAddedMessage(String taskToString, int numberOfTasks){
        System.out.println(Messages.MESSAGE_TASK_ADDED);
        System.out.println("\t   "+ taskToString);
        System.out.println("\t Now you have "+ numberOfTasks +" tasks in the list.");
    }

    /***
     * list the task within the task manager
     */
    public static void printTaskList(TaskList tasks){
        System.out.println(Messages.MESSAGE_LIST);
        for(int i = 0; i < tasks.size(); i++){
            System.out.println("\t " + (i+1)+"." + tasks.get(i).toString());
        }
    }

    /***
     * Print task done message
     * @param taskToString: toString of the task
     */
    public static void printTaskDoneMessage(String taskToString){
        System.out.println(Messages.MESSAGE_DONE);
        System.out.println("\t   "+ taskToString);
    }

    /***
     * Print delete message
     * @param size : remaining size
     * @param toString : the task to be deleted
     */
    public static void printTaskDeleteMessage(int size, String toString){
        System.out.println(Messages.MESSAGE_DELETE);
        System.out.println("\t   "+toString);
        System.out.println("\t Now you have "+ size +" tasks in the list.");
    }

    /***
     * Print help messages with format and example
     */
    public static void printHelpMessage(){
        System.out.println(Messages.MESSAGE_HELP);
    }

    /***
     * Print Exit message
     */
    public static void printExitMessage(){
        System.out.println(Messages.MESSAGE_EXIT);
    }

    /* Error messages */
    /***
     * print invalid command (unknown command)
     */
    public static void printInvalidCommandMessage(){
        System.out.println(Messages.MESSAGE_INVALID_COMMAND_ERROR);
    }

    /***
     * print empty description message (command that requires arguments)
     * Example: done 1, delete 2
     */
    public static void printEmptyDescriptionMessage(){
        System.out.println(Messages.MESSAGE_DESCRIPTION_EMPTY);
    }

    /***
     * print invalid description (command that requires extra argument)
     * Example: Deadline/event which requires due date
     */
    public static void printInvalidDescriptionMessage(){
        System.out.println(Messages.MESSAGE_DESCRIPTION_INVALID);
    }

    /***
     * print file loading error
     */
    public void printLoadingError(){
        System.out.println(Messages.MESSAGE_LOAD_ERROR);
    }

    /***
     * print file empty error
     */
    public void printEmptyFileError(){
        System.out.println(Messages.MESSAGE_EMPTY_FILE);
    }


}
