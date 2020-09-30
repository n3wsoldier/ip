package duke.ui;

import duke.common.Messages;
import duke.data.TaskList;
import duke.data.task.Task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Ui {

    private final Scanner SCANNER = new Scanner(System.in);
    private static SimpleDateFormat dateToString = new SimpleDateFormat("dd MMM yyyy hh:mmaa");

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
        System.out.println(" Hello from"+ Messages.LS + Messages.MESSAGE_LOGO);
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
        System.out.println(" "+tasksSize+ Messages.MESSAGE_LOADED);
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
    public void printTaskAddedMessage(String taskToString, int numberOfTasks){
        System.out.println(Messages.MESSAGE_TASK_ADDED);
        System.out.println("   "+ taskToString);
        System.out.println(" Now you have "+ numberOfTasks +" tasks in the list.");
    }

    /***
     * list the task within the task manager
     */
    public void printTaskList(TaskList tasks, int totalTask, int completedTask){
        System.out.println(Messages.MESSAGE_LIST +" "+ completedTask + "/" +totalTask +" completed");
        for(int i = 0; i < tasks.size(); i++){
            System.out.println("  " + (i+1)+"." + tasks.get(i).toString());
        }
    }

    /***
     * Print task done message
     * @param taskToString: toString of the task
     */
    public static void printTaskDoneMessage(String taskToString, int totalTask, int completedTask){
        System.out.println(Messages.MESSAGE_DONE);
        System.out.println("   "+ taskToString);
        System.out.println(" You have completed: "+ completedTask + "/" + totalTask + ". "+
                (totalTask - completedTask) + " left :)" );
    }

    /***
     * Print task done message
     * @param taskToString: toString of the task
     */
    public static void printTaskAlreadyDoneMessage(String taskToString, int totalTask, int completedTask){
        System.out.println(Messages.MESSAGE_ALREADY_DONE);
        System.out.println("   "+ taskToString);
        System.out.println(" Currently completed: "+ completedTask + "/" + totalTask + ". "+
                (totalTask - completedTask) + " left :)" );
    }

    /***
     * Print delete message
     * @param size : remaining size
     * @param toString : the task to be deleted
     */
    public static void printTaskDeleteMessage( String toString, int completedTask, int totalTask){
        System.out.println(Messages.MESSAGE_DELETE);
        System.out.println("   "+toString);
        System.out.println(" Now you have "+ completedTask +"/"+ totalTask +" completed tasks in the list.");
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
     * print invalid number for commands like done and delete
     */
    public void printInvalidNumber(){
        System.out.println(Messages.MESSAGE_NUMBER_INVALID);
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

    public static void printIndexOutError(String command){
        System.out.println(" Your \""+command+ "\" command failed.");
        System.out.println(" That task does not exist... O.O");
    }


    /***
     * list the task within the task manager with search phrase
     */
    public static void printFindList(TaskList tasks, String toFind){
        ArrayList<Task> findList = tasks.find(toFind);
        System.out.println(Messages.MESSAGE_FIND +" \""+ toFind+"\": "+findList.size() +" found");
        int findIndex = 1;
        for(Task t : findList){
            System.out.println("  " + findIndex +"." + t.toString());
            findIndex++;
        }
    }

    /***
     * list the task within the task manager with specific date
     */
    public static void printFindList(TaskList tasks, Date dateTime){
        ArrayList<Task> findList = tasks.find(dateTime);
        System.out.println(Messages.MESSAGE_FIND + " \""+ dateToString.format(dateTime) +"\": "+findList.size() +" found");
        int findIndex = 1;
        for(Task t : findList){
            System.out.println("  " + findIndex +"." + t.toString());
            findIndex++;
        }
    }

    /***
     * list the task within the task manager between startDate and endDate
     */
    public static void printFindList(TaskList tasks, Date startDate, Date endDate){
        ArrayList<Task> findList = tasks.find(startDate, endDate);
        System.out.println(Messages.MESSAGE_FIND + " \""+ dateToString.format(startDate) +"\" to \""
                + dateToString.format(endDate) +"\": "+findList.size() +" found");
        int findIndex = 1;
        for(Task t : findList){
            System.out.println("  " + findIndex +"." + t.toString());
            findIndex++;
        }
    }
}
