package duke.data.task;

import java.text.ParseException;
import java.util.Date;

public class Deadline extends Task implements DateTimeValidator {
    protected String by;
    protected boolean isDateString;
    protected Date byDate;

    /***
     * Deadline constructor, use Task constructor
     * @param description : Description of task
     * @param by : Due date of task
     */
    public Deadline(String description, String by){
        super(description, TaskType.Deadline);
        isDateString = false;
        byDate = null;
        this.by = by;
        parseToDate(by);
    }

    /***
     * Return the due date (by)
     * @return
     */
    public String getBy(){
        return by;
    }

    /***
     * Modify the due date (by)
     * @param by
     */
    public void setBy(String by){
        this.by = by;
    }

    /***
     * Get due date
     * @return
     */
    public Date getDate(){
        return this.byDate;
    }

    /***
     * Format the way to print Deadline task
     * @return
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + (isDateTime() ? dateToString.format(byDate) : by) + ")";
    }

    /***
     * Parse the at time field to date if possible
     * else set isDateString to false;
     * @param input
     */
    @Override
    public void parseToDate(String input) {
        try {
            byDate = stringToDate.parse(input);
            isDateString=  true;
        } catch (ParseException e) {
            isDateString=  false;
        }

    }

    /***
     * Return true if the the due date is proper date format
     * @return
     */
    @Override
    public boolean isDateTime(){
        return isDateString;
    }
}
