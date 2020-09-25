package duke.parser;

import duke.exception.DescriptionEmptyException;
import duke.exception.DueTimeEmptyException;
import duke.command.*;
import duke.exception.InvalidCommandException;

public class Parser {

    private static final int PARAM_DELIMIT_LIMIT = 2;
    private final String PARAM_DELIMIT_BY = " /by ";
    private final String PARAM_DELIMIT_AT = " /at ";

    /***
     * executeCommand to parse user input to command and arguments
     * Call different prepare method further parse the arguments
     * @param userCommand
     * @return Command object that can be executed
     * @throws InvalidCommandException
     * @throws DescriptionEmptyException
     * @throws DueTimeEmptyException
     */
    public Command executeCommand(String userCommand) throws InvalidCommandException,
            DescriptionEmptyException, DueTimeEmptyException{
        //inputs[0] = command
        //inputs[1] = arguments
        String[] inputs = splitInput(userCommand.trim(), " ");
        String command = inputs[0];
        try {
            switch (command) {
            case ListCommand.COMMAND_LIST:
                return new ListCommand();
            case TodoCommand.COMMAND_TODO:
                return new TodoCommand(inputs[1]);
            case DeadlineCommand.COMMAND_DEADLINE:
                return prepareDeadlineCommand(inputs[1]);
            case EventCommand.COMMAND_EVENT:
                return prepareEventCommand(inputs[1]);
            case DoneCommand.COMMAND_DONE:
                return prepareDoneCommand(inputs[1]);
            case DeleteCommand.COMMAND_DELETE:
                return prepareDeleteCommand(inputs[1]);
            case ExitCommand.COMMAND_EXIT:
                return new ExitCommand();
            case HelpCommand.COMMAND_HELP:
                return new HelpCommand();
            case FindCommand.COMMAND_FIND:
                return new FindCommand(inputs[1]);
            default:
                throw new InvalidCommandException();
            }
        }catch (DueTimeEmptyException e){
            throw new DueTimeEmptyException();
        }catch (ArrayIndexOutOfBoundsException e){
            throw new DescriptionEmptyException();
        }
    }

    /***
     * Parse the deadline arguments into description and by
     * Which is use to initialise DeadlineCommand
     * @param args
     * @return
     * @throws DueTimeEmptyException : Deadline/Event missing due time
     */
    private Command prepareDeadlineCommand(String args) throws DueTimeEmptyException{
        try {
            String[] inputParts = splitInput(args, PARAM_DELIMIT_BY);
            return new DeadlineCommand(inputParts[0].trim(), inputParts[1].trim());
        }catch (ArrayIndexOutOfBoundsException e){
            throw new DueTimeEmptyException();
        }
    }

    /***
     * Parse the event arguments into description and by
     * Which is use to initialise EventCommand
     * @param args
     * @return
     * @throws DueTimeEmptyException : Deadline/Event missing due time
     */
    private Command prepareEventCommand(String args) throws DueTimeEmptyException{
        try{
            String[] inputParts = splitInput(args, PARAM_DELIMIT_AT);
            return new EventCommand(inputParts[0].trim(), inputParts[1].trim());
        }catch (ArrayIndexOutOfBoundsException e){
            throw new DueTimeEmptyException();
        }
    }

    /***
     * Parse the argument into index format (int -1)
     * which is use to initialise DoneCommand
     * @param args
     * @return
     */
    private Command prepareDoneCommand(String args) {
        int tasksIndex = Integer.parseInt(args) -1;
        return new DoneCommand(tasksIndex);
    }

    /***
     * Parse the argument into index format (int -1)
     * which is use to initialise DoneCommand
     * @param args
     * @return
     */
    private Command prepareDeleteCommand(String args) {
        int tasksIndex = Integer.parseInt(args) -1;
        return new DeleteCommand(tasksIndex);
    }

    /***
     * Split input using delimiter
     * @param input : arguments to split
     * @param delimiter : what to split by
     * @return
     */
    public static String[] splitInput(String input, String delimiter){
        String[] inputParts = input.split(delimiter, PARAM_DELIMIT_LIMIT);
        return inputParts;
    }
}
