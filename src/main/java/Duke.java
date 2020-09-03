import java.util.Scanner;

public class Duke {
    private static final String LS = System.lineSeparator();

    /* Predetermined Message List */
    private static final String MESSAGE_LOGO = " ____        _        "+LS
            + "|  _ \\ _   _| | _____ "+LS
            + "| | | | | | | |/ / _ \\"+LS
            + "| |_| | |_| |   <  __/"+LS
            + "|____/ \\__,_|_|\\_\\___|"+LS;
    private static final String MESSAGE_INTRO = "\tHello! I'm Duke"
            + LS +"\tWhat can I do for you?";
    private static final String MESSAGE_EXIT = "\tBye. Hope to see you again soon!";
    private static final String MESSAGE_DONE = "\t Nice! I've marked this task as done:";
    private static final String MESSAGE_TASK_ADDED = "\t Got it. I've added this task:";
    private static final String MESSAGE_LIST = "\tHere are the tasks in your list:";
    private static final String MESSAGE_LINE = "\t____________________________________________________________";


    /* Command List */
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_EXIT = "bye";

    /* Command Separator Parameter List */
    private static final String PARAM_DELIMIT_BY = "/by";
    private static final String PARAM_DELIMIT_AT = "/at";
    private static final int PARAM_DELIMIT_LIMIT = 2;

    private static Task[] tasks = new Task[100];

    /*
     * This variable is declared for the whole class (instead of declaring it
     * inside the readUserCommand() method to facilitate automated testing using
     * the I/O redirection technique. If not, only the first line of the input
     * text file will be processed.
     */
    private static final Scanner SCANNER = new Scanner(System.in);


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
        //inputs[2] = arguments
        String[] inputs = userCommand.split(" ", PARAM_DELIMIT_LIMIT);
        String command = inputs[0];
        switch (command){
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
        }
    }

    /***
     * list the task within the task manager
     */
    private static void listTasks(){
        System.out.println(MESSAGE_LINE);
        System.out.println(MESSAGE_LIST);
        for(int i = 0; i < Task.getNumberOfTasks(); i++){
            System.out.println("\t " + (i+1)+"." +tasks[i].toString());
        }
        System.out.println(MESSAGE_LINE);
    }

    /***
     * Add a Todo class into tasks list
     * @param input: Description of todo task
     */
    private static void addTodo(String input){
        int currentTask = Task.getNumberOfTasks();
        tasks[currentTask] = new Todo(input);
        printTaskAddedMessage(tasks[currentTask].toString(), Task.getNumberOfTasks());
    }

    /***
     * Add a Event class into tasks list
     * Split the input to description and event time (delimit using /at)
     * @param input: unprocessed description with event time
     */
    private static void addEvent(String input){
        String[] inputParts = input.split(" "+ PARAM_DELIMIT_AT +" ");
        int currentTask = Task.getNumberOfTasks();
        tasks[currentTask] = new Event(inputParts[0] , inputParts[1]);
        printTaskAddedMessage(tasks[currentTask].toString(), Task.getNumberOfTasks());
    }

    /***
     * Add a deadline class into tasks list
     * Split the input to description and deadline time (delimit using /by)
     * @param input: unprocessed description with deadline
     */
    private static void addDeadline(String input){
        String[] inputParts = input.split(" "+ PARAM_DELIMIT_BY +" ");
        int currentTask = Task.getNumberOfTasks();
        tasks[currentTask] = new Deadline(inputParts[0] , inputParts[1]);
        printTaskAddedMessage(tasks[currentTask].toString(), Task.getNumberOfTasks());
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

    /***
     * Set specified task index as done and printTaskDoneMessage
     * @param input: task index to complete
     */
    private static void setTaskDone(String input){
        int tasksIndex = Integer.parseInt(input) -1;
        tasks[tasksIndex].markAsDone();
        printTaskDoneMessage(tasks[tasksIndex].toString());
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
     * Print message when a new task is added into task manager
     * @param taskToString: toString of of task
     * @param numberOfTasks: the Task.numberOfTasks
     */
    private static void printTaskAddedMessage(String taskToString, int numberOfTasks){
        System.out.println(MESSAGE_LINE);
        System.out.println(MESSAGE_TASK_ADDED);
        System.out.println("\t   "+ taskToString);
        System.out.println("\t Now you have "+ numberOfTasks +" tasks in the list.");
        System.out.println(MESSAGE_LINE);
    }

}
