package duke.data.task;

import java.text.SimpleDateFormat;

public interface DateTimeValidator {
    SimpleDateFormat stringToDate = new SimpleDateFormat("dd/MM/yyyy HHmm");
    SimpleDateFormat dateToString = new SimpleDateFormat("dd MMM yyyy hh:mmaa");

    /**
     * Function that will be override to parse string to time
     * @param input to be parse to datetime
     */
    public void parseToDate(String input);

}
