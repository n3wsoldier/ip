import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Scanner in = new Scanner(System.in);
        Boolean exit = false;
        Task[] tasks = new Task[100];
        int inputsIndex = 0;

        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");

        while(!exit){
            String input = in.nextLine();
            if(input.equals("bye")){
                exit = true;
            }else if(input.equals("list")){
                System.out.println("\t____________________________________________________________");
                System.out.println("\tHere are the tasks in your list:");
                for(int i = 0; i < Task.getNumberOfTasks(); i++){
                    System.out.println("\t " + (i+1)+"." +tasks[i].toString());
                }
                System.out.println("\t____________________________________________________________");
            }else{
                input = input.trim();
                if(input.contains("done ")){
                    //Marks as done for task
                    input = input.replace("done ","");
                    int tasksIndex = Integer.parseInt(input) -1;
                    tasks[tasksIndex].markAsDone();
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\t Nice! I've marked this task as done: ");
                    System.out.println("\t   "+ tasks[tasksIndex].toString());
                    System.out.println("\t____________________________________________________________");
                }else if(input.contains("todo ")){
                    input = input.replace("todo ","");
                    int currentTask = Task.getNumberOfTasks();
                    tasks[currentTask] = new Todo(input);
                    printTaskAddedMessage(tasks[currentTask].toString(), Task.getNumberOfTasks());

                }else if(input.contains("deadline ")){
                    input = input.replace("deadline ","");
                    System.out.println(input);
                    String[] inputParts = input.split("/by");
                    int currentTask = Task.getNumberOfTasks();
                    tasks[currentTask] = new Deadline(inputParts[0] , inputParts[1]);
                    printTaskAddedMessage(tasks[currentTask].toString(), Task.getNumberOfTasks());

                }else if(input.contains("event ")){
                    input = input.replace("event ","");
                    String[] inputParts = input.split("/at");
                    int currentTask = Task.getNumberOfTasks();
                    tasks[currentTask] = new Event(inputParts[0] , inputParts[1]);
                    printTaskAddedMessage(tasks[currentTask].toString(), Task.getNumberOfTasks());
                }
            }

        }



        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }

    public static void printTaskAddedMessage(String taskToString, int numberOfTasks){
        System.out.println("\t____________________________________________________________");
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t   "+ taskToString);
        System.out.println("\t Now you have "+ numberOfTasks +" tasks in the list.");
        System.out.println("\t____________________________________________________________");
    }
    
}
