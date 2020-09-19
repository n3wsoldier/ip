package duke.data.storage;

import duke.common.Messages;
import duke.data.task.Deadline;
import duke.data.task.Event;
import duke.data.task.Task;
import duke.data.task.Todo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class StorageManager {

    public static final String PARAM_DELIMIT_SAVE = " | ";

    /* Symbol */
    public static final String SYMBOL_TODO = "T";
    public static final String SYMBOL_DEADLINE = "D";
    public static final String SYMBOL_EVENT = "E";

    /* Files */
    private static final String RELATIVE_DIR = System.getProperty("user.dir");
    private static final String FILE_SEPARATOR = File.separator;

    private File dataFile;

    /***
     * StorageManager Constructor
     * Check if directory folder exist else create folder
     * Check if data file exist else create file
     * @param fileName
     */
    public StorageManager(String fileName){
        this.dataFile = new File(prepareFile(fileName));
        try{
            if (!dataFile.getParentFile().exists()) {
                dataFile.getParentFile().mkdirs();
            }

            if (!dataFile.exists()) {
                dataFile.createNewFile();
            }
        }catch (IOException e){
            System.out.println("Cannot create file; reason: " + e.getMessage());
        }

    }

    /***
     * Change String into file format
     * @param fileName
     * @return
     */
    private String prepareFile(String fileName){
        return RELATIVE_DIR + fileName.replace("\\",FILE_SEPARATOR).replace("/",FILE_SEPARATOR);
    }

    /***
     * Read file and store into string arraylist
     * Parse the stringCommand into task
     * Keep the task into tasklist and return it
     * @return Tasklist to be loaded on startup
     * @throws IOException : files error
     */
    public ArrayList<Task> load() throws IOException{
        ArrayList<Task> taskList = null;
        try {
            ArrayList<String> dataItems = readFile();
            taskList = parse(dataItems);
        } catch (IOException e) {
            throw e;
        }
        return taskList;
    }

    /***
     * Read file into string arraylist
     * @return Arraylist String data item
     * @throws IOException : throws file empty or file don't exist
     */
    private ArrayList readFile() throws IOException {
        if (!dataFile.exists()) {
            throw new FileNotFoundException();
        }
        if (dataFile.length() == 0) {
            throw new IOException();
        }
        ArrayList<String> dataItems = (ArrayList) Files.readAllLines(dataFile.toPath(), Charset.defaultCharset());

        return dataItems;
    }

    /***
     * Save content provided into save file
     * @param saveContent : Formated task data item
     */
    public void save(String saveContent) {
//        System.out.println("\t Saving to :\""+ fileName +"\""+ Messages.LS);
        try {
            FileWriter fileWriter = new FileWriter( dataFile);
            fileWriter.write(saveContent);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("\t Saving tasks to " + dataFile + " failed.");
        }
    }

    /***
     * Parse command to change saved data item into task object
     * @param dataItems : Arraylist of string data items
     * @return Arraylist <Task>
     */
    private ArrayList<Task> parse(ArrayList<String> dataItems){
        //inputs[0] = command
        //inputs[1] = arguments
        ArrayList<Task> allTasks = new ArrayList<>();

        for(String line : dataItems) {
//            System.out.println("\t " + line);

            String[] inputs = line.split("\\s\\|\\s");
            String command = inputs[0];
            String description = inputs[2];
            Task saveTask = null;
            try {
                switch (command) {
                case StorageManager.SYMBOL_TODO:
                    saveTask = new Todo(description);
                    break;
                case StorageManager.SYMBOL_DEADLINE:
                    String by = inputs[3];
                    saveTask = new Deadline(description, by);
                    break;
                case StorageManager.SYMBOL_EVENT:
                    String at = inputs[3];
                    saveTask = new Event(description, at);
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("null");
            }
            String isDone = inputs[1];
            if (isDone.equals("1")) {
                saveTask.markAsDone();
            }
            allTasks.add(saveTask);
        }
        return allTasks;
    }
}
