package duke.data.task;

import java.text.ParseException;
import java.util.Date;

public class Event extends Task implements DateTimeValidator{
    protected String at;
    protected boolean isDateString;
    protected Date atDate;

    /***
     * Deadline constructor, use Task constructor
     * @param description : Description of task
     * @param at : Due date of task
     */
    public Event(String description, String at){
        super(description , TaskType.Event);
        isDateString = false;
        atDate = null;
        this.at = at;
        parseToDate(at);
    }

    /***
     * Return the due date (at)
     * @return
     */
    public String getAt(){
        return at;
    }

    /***
     * Modify the due date (at)
     * @param at
     */
    public void setAt(String at){
        this.at = at;
    }

    /***
     * Get due date
     * @return
     */
    public Date getDate(){
        return this.atDate;
    }

    /***
     * Format the way to print Event task
     * @return
     */
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
