package duke.command;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.data.task.DateTimeValidator;
import duke.parser.Parser;
import duke.ui.Ui;

import java.text.ParseException;
import java.util.Date;

public class FindCommand extends Command implements DateTimeValidator {
    public static final String COMMAND_FIND = "find";
    private final String PARAM_DELIMIT_TO = " /to ";
    private String toFind;
    private int isDateString;
    private Date startDate;
    private Date endDate;

    /**
     * FindCommand constructor using string values.
     * @param search : description of task
     */
    public FindCommand(String search){
        isDateString = 0;
        parseToDate(search);
        this.toFind = search;
    }



    /**
     * Print task with search phrase
     * @param tasks : TaskList object with list available function
     * @param ui : ui user interaction/interface related function (printing messages)
     * @param storage : Storage manager to update save file
     */
    @Override
    public void execute(TaskList tasks, Ui ui, StorageManager storage){
        if(isDateString == 0){
            ui.printFindList(tasks, toFind);
        }else if(isDateString == 1){
            ui.printFindList(tasks, startDate);
        }else if(isDateString == 2){
            ui.printFindList(tasks, startDate, endDate);
        }

    }

    /**
     * Parse the toFind string if possible
     * @param input
     */
    @Override
    public void parseToDate(String input) {
        try {
            if(input.contains(PARAM_DELIMIT_TO)){
                String[] dates = Parser.splitInput(input, PARAM_DELIMIT_TO);
                startDate = stringToDate.parse(dates[0].trim());
                endDate = stringToDate.parse(dates[1].trim());
                isDateString=  2;
            }else{
                startDate = stringToDate.parse(input.trim());
                isDateString=  1;
            }

        } catch (ParseException e) {
            isDateString=  0;
        }

    }


}
