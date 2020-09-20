package duke.data.task;

import java.text.ParseException;
import java.util.Date;

public class Deadline extends Task implements DateTimeValidator {
    protected String by;
    protected boolean isDateString;
    protected Date byDate;

    public Deadline(String description, String by){
        super(description, TaskType.Deadline);
        isDateString = false;
        byDate = null;
        this.by = by;
        parseToDate(by);
    }

    public String getBy(){
        return by;
    }

    public void setBy(String by){
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + (isDateTime() ? dateToString.format(byDate) : by) + ")";
    }


    @Override
    public void parseToDate(String input) {
        try {
            byDate = stringToDate.parse(input);
            isDateString=  true;
        } catch (ParseException e) {
            isDateString=  false;
        }

    }

    @Override
    public boolean isDateTime(){
        return isDateString;
    }
}
