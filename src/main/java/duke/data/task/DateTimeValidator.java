package duke.data.task;

import java.text.SimpleDateFormat;

public interface DateTimeValidator {
    SimpleDateFormat stringToDate = new SimpleDateFormat("dd/MM/yyyy HHmm");
    SimpleDateFormat dateToString = new SimpleDateFormat("dd MMM yyyy hh:mmaa");

    public void parseToDate(String input);

}
