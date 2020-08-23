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
        String[] inputs = new String[100];
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
                for(int i = 0; i < inputsIndex; i++){
                    System.out.println("\t " + (i+1) +". "+ inputs[i]);
                }
                System.out.println("\t____________________________________________________________");
            }else{
                inputs[inputsIndex] = input;
                inputsIndex++;
                System.out.println("\t____________________________________________________________");
                System.out.println("\tadded: "+input);
                System.out.println("\t____________________________________________________________");
            }

        }



        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }
}
