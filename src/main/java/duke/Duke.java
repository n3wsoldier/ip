package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;


import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


public class Duke {
    private static final String LS = System.lineSeparator();

    /* Predetermined Message List */
    private static final String MESSAGE_LOGO = " ____        _        "+LS
            + "|  _ \\ _   _| | _____ "+LS
            + "| | | | | | | |/ / _ \\"+LS
            + "| |_| | |_| |   <  __/"+LS
            + "|____/ \\__,_|_|\\_\\___|"+LS;
    private static final String MESSAGE_INTRO = "\t Hello! I'm Duke"
            + LS +"\t What can I do for you?";
    private static final String MESSAGE_EXIT = "\t Bye. Hope to see you again soon!";
    private static final String MESSAGE_DONE = "\t Nice! I've marked this task as done:";
    private static final String MESSAGE_TASK_ADDED = "\t Got it. I've added this task:";
    private static final String MESSAGE_LIST = "\t Here are the tasks in your list:";
    private static final String MESSAGE_LINE = "\t__________________________________________________________________________________________";
    private static final String MESSAGE_INVALID_COMMAND_ERROR = "\t ☹ OOPS!!! I'm sorry, but I don't know what that means :-(";


    /* Command List */
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_EXIT = "bye";
    private static final String COMMAND_DELETE = "delete";
    private static final String COMMAND_SAVE = "save";
    private static final String COMMAND_LOAD = "load";

    /* Symbol */
    private static final String SYMBOL_TODO = "T";
    private static final String SYMBOL_DEADLINE = "D";
    private static final String SYMBOL_EVENT = "E";

    /* Command Separator Parameter List */
    private static final String PARAM_DELIMIT_BY = " /by ";
    private static final String PARAM_DELIMIT_AT = " /at ";
    private static final String PARAM_DELIMIT_SAVE = " | ";
    private static final int PARAM_DELIMIT_LIMIT = 2;

    /* Task Collection using ArrayList */
    private static final ArrayList<Task> TASKS = new ArrayList<>();
//    private static Task[] tasks = new Task[100];

    /*
     * This variable is declared for the whole class (instead of declaring it
     * inside the readUserCommand() method to facilitate automated testing using
     * the I/O redirection technique. If not, only the first line of the input
     * text file will be processed.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /* Files */
    private static final String RELATIVE_DIR = System.getProperty("user.dir");
    private static final String DATA_FOLDER = "data";
    private static final String FILE_SEPARATOR = File.separator;
    private static final String FILE_DIRECTORY = RELATIVE_DIR + FILE_SEPARATOR + DATA_FOLDER + FILE_SEPARATOR;
    private static final File FOLDER = new File(DATA_FOLDER);

    public static void main(String[] args) {
        printIntroMessage();
        while(true){
            String userCommand = getUserInput();
            executeCommand(userCommand);
        }
    }

    /***
     * Gets the next line input from the user
     * @return input by the user
     */
    private static String getUserInput() {
        return SCANNER.nextLine();
    }

    /***
     * Execute command base on the command of the user
     * Command is determined by the first word in an input line
     * @param userCommand: raw input line from user
     */
    private static void executeCommand(String userCommand){
        //inputs[0] = command
        //inputs[1] = arguments
        String[] inputs = splitInput(userCommand, " ");
        String command = inputs[0];
        try {
            switch (command) {
            case COMMAND_LIST:
                listTasks();
                break;
            case COMMAND_TODO:
                addTodo(inputs[1]);
                break;
            case COMMAND_DEADLINE:
                addDeadline(inputs[1]);
                break;
            case COMMAND_EVENT:
                addEvent(inputs[1]);
                break;
            case COMMAND_DONE:
                setTaskDone(inputs[1]);
                break;
            case COMMAND_EXIT:
                printExitMessage();
                System.exit(0);
                break;
            case COMMAND_SAVE:
                writeToFile(inputs[1]);
                break;
            case COMMAND_LOAD:

                break;
            default:
                printInvalidCommandMessage();
                break;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            printEmptyDescriptionMessage(command);
        }
    }

    /* Command Related Function Start */
    /***
     * list the task within the task manager
     */
    private static void listTasks(){
        System.out.println(MESSAGE_LINE);
        System.out.println(MESSAGE_LIST);
        for(int i = 0; i < Task.getNumberOfTasks(); i++){
            System.out.println("\t " + (i+1)+"." +TASKS.get(i).toString());
        }
        System.out.println(MESSAGE_LINE);
    }

    /***
     * Add a Todo class into tasks list
     * @param input: Description of todo task
     */
    private static void addTodo(String input){
        int currentTask = Task.getNumberOfTasks();
        TASKS.add( new Todo(input));
        printTaskAddedMessage(TASKS.get(currentTask).toString(), Task.getNumberOfTasks());
    }

    /***
     * Add a Event class into tasks list
     * Split the input to description and event time (delimit using /at)
     * @param input: unprocessed description with event time
     */
    private static void addEvent(String input){

        try {
            String[] inputParts = splitInput(input, PARAM_DELIMIT_AT);
            int currentTask = Task.getNumberOfTasks();
            TASKS.add( new Event(inputParts[0] , inputParts[1]));
            printTaskAddedMessage(TASKS.get(currentTask).toString(), Task.getNumberOfTasks());
        }catch (ArrayIndexOutOfBoundsException e){
            printInvalidDescriptionMessage("event", "event time");
        }
    }

    /***
     * Add a deadline class into tasks list
     * Split the input to description and deadline time (delimit using /by)
     * @param input: unprocessed description with deadline
     */
    private static void addDeadline(String input){

        try {
            String[] inputParts = splitInput(input, PARAM_DELIMIT_BY);
            int currentTask = Task.getNumberOfTasks();
            TASKS.add( new Deadline(inputParts[0], inputParts[1]));
            printTaskAddedMessage(TASKS.get(currentTask).toString(), Task.getNumberOfTasks());
        }catch (ArrayIndexOutOfBoundsException e){
            printInvalidDescriptionMessage("deadline", "deadline");
        }

    }

    /***
     * Set specified task index as done and printTaskDoneMessage
     * @param input: task index to complete
     */
    private static void setTaskDone(String input){
        int tasksIndex = Integer.parseInt(input) -1;
        TASKS.get(tasksIndex).markAsDone();
        printTaskDoneMessage(TASKS.get(tasksIndex).toString());
    }

    private static String[] splitInput(String input, String delimiter){
        String[] inputParts = input.split(delimiter,PARAM_DELIMIT_LIMIT);
        return inputParts;
    }
    /* Command Related Function End */

    /* Print related Function Start */
    /***
     * Print message when a new task is added into task manager
     * @param taskToString: toString of of task
     * @param numberOfTasks: the numberOfTasks
     */
    private static void printTaskAddedMessage(String taskToString, int numberOfTasks){
        System.out.println(MESSAGE_LINE);
        System.out.println(MESSAGE_TASK_ADDED);
        System.out.println("\t   "+ taskToString);
        System.out.println("\t Now you have "+ numberOfTasks +" tasks in the list.");
        System.out.println(MESSAGE_LINE);
    }

    /***
     * Print task done message
     * @param taskToString: toString of the task
     */
    private static void printTaskDoneMessage(String taskToString){
        System.out.println(MESSAGE_LINE);
        System.out.println(MESSAGE_DONE);
        System.out.println("\t   "+ taskToString);
        System.out.println(MESSAGE_LINE);
    }

    /***
     * Print Intro message
     */
    private static void printIntroMessage(){
        System.out.println("Hello from"+ LS + MESSAGE_LOGO);
        System.out.println(MESSAGE_LINE);
        System.out.println(MESSAGE_INTRO);
        System.out.println(MESSAGE_LINE);
    }

    /***
     * Print Exit message
     */
    private static void printExitMessage(){
        System.out.println(MESSAGE_LINE);
        System.out.println(MESSAGE_EXIT);
        System.out.println(MESSAGE_LINE);
    }

    private static void printInvalidCommandMessage(){
        System.out.println(MESSAGE_LINE);
        System.out.println(MESSAGE_INVALID_COMMAND_ERROR);
        System.out.println(MESSAGE_LINE);
    }

    private static void printEmptyDescriptionMessage(String command){
        System.out.println(MESSAGE_LINE);
        System.out.println("\t ☹ OOPS!!! The description of a "+command+" cannot be empty.");
        System.out.println(MESSAGE_LINE);
    }

    private static void printInvalidDescriptionMessage(String command, String timeType){
        System.out.println(MESSAGE_LINE);
        System.out.println("\t ☹ OOPS!!! The description of " + command + " task cannot be without " + timeType + ".");
        System.out.println(MESSAGE_LINE);
    }
    /* Print related Function End */

    /* Files related Function Start */
    /***
     *
     * @param fileName
     * @return
     */
    public static void readFromFile(String fileName){
        File file = new File( fileName);
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String data = sc.nextLine();

            }


            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println(MESSAGE_LINE);
            System.out.println("\t Unable to read " + file+ " as it does not exists.");
            System.out.println(MESSAGE_LINE);
        }

    }

    public static void listSavedFiles(){
        String[] pathnames = FOLDER.list();

        for (String pathname : pathnames) {
            System.out.println(pathname);
        }
    }

    public static void writeToFile(String fileName) {
        System.out.println(FILE_DIRECTORY + fileName);
        if (!FOLDER.exists()) {
            FOLDER.mkdir();
        }
        try {
            FileWriter fileWriter = new FileWriter( FILE_DIRECTORY + fileName);

            for(Task task: TASKS){
                String taskSave= "";
                int isDone = (task.isDone()) ? 1 : 0;
                if (task instanceof Todo) {
                    taskSave = SYMBOL_TODO + PARAM_DELIMIT_SAVE + isDone + PARAM_DELIMIT_SAVE + task.getDescription();
                } else if (task instanceof Deadline) {
                    taskSave = SYMBOL_TODO + PARAM_DELIMIT_SAVE + isDone + PARAM_DELIMIT_SAVE + task.getDescription()
                            + PARAM_DELIMIT_SAVE +((Deadline) task).getBy();
                } else if (task instanceof Event) {
                    taskSave = SYMBOL_TODO + PARAM_DELIMIT_SAVE + isDone + PARAM_DELIMIT_SAVE + task.getDescription()
                            + PARAM_DELIMIT_SAVE +((Event) task).getAt();
                }
                taskSave = taskSave + System.lineSeparator();
                fileWriter.write(taskSave);
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(MESSAGE_LINE);
            System.out.println("\t Saving tasks to " + fileName + " failed.");
            System.out.println(MESSAGE_LINE);
        }
    }

    private static void loadSaveCommand(String userCommand){
        //inputs[0] = command
        //inputs[1] = arguments
        String[] inputs = splitInput(userCommand, " ");
        String command = inputs[0];
        try {
            switch (command) {
            case COMMAND_LIST:
                listTasks();
                break;
            case COMMAND_TODO:
                addTodo(inputs[1]);
                break;
            case COMMAND_DEADLINE:
                addDeadline(inputs[1]);
                break;
            case COMMAND_EVENT:
                addEvent(inputs[1]);
                break;
            case COMMAND_DONE:
                setTaskDone(inputs[1]);
                break;
            case COMMAND_EXIT:
                printExitMessage();
                System.exit(0);
                break;
            case COMMAND_SAVE:
                writeToFile(inputs[1]);
                break;
            case COMMAND_LOAD:

                break;
            default:
                printInvalidCommandMessage();
                break;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            printEmptyDescriptionMessage(command);
        }
    }
    /* Files related Function End */
}
