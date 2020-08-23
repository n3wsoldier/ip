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
                    System.out.println("\t " + (i+1) +".["+ tasks[i].getStatusIcon()+"] " + tasks[i].getDescription());
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
                    System.out.println("\t   ["+ tasks[tasksIndex].getStatusIcon()+"] "
                            + tasks[tasksIndex].getDescription());
                    System.out.println("\t____________________________________________________________");
                }else {
                    tasks[Task.getNumberOfTasks()] = new Task(input);
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tadded: " + input);
                    System.out.println("\t____________________________________________________________");
                }
            }

        }



        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }
}
