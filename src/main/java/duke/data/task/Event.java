package duke.data.task;

import java.text.ParseException;
import java.util.Date;

public class Event extends Task implements DateTimeValidator{
    protected String at;
    protected boolean isDateString;
    protected Date atDate;

    public Event(String description, String at){
        super(description , TaskType.Event);
        isDateString = false;
        atDate = null;
        this.at = at;
        parseToDate(at);
    }

    public String getAt(){
        return at;
    }

    public void setAt(String by){
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + (isDateTime() ? dateToString.format(atDate) : at) + ")";
    }

    @Override
    public void parseToDate(String input) {
        try {
            atDate = stringToDate.parse(input);
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
