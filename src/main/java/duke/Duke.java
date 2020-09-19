package duke;

import duke.data.TaskList;
import duke.data.storage.StorageManager;
import duke.exception.DescriptionEmptyException;
import duke.exception.DueTimeEmptyException;
import duke.exception.DukeException;
import duke.exception.InvalidCommandException;
import duke.ui.Ui;
import duke.parser.Parser;
import duke.command.Command;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Duke {

    private StorageManager storage;
    private TaskList tasks;
    private Ui ui;

    /***
     * Main Method to initialise Duke and run it
     * @param args
     */
    public static void main(String[] args) {
        new Duke("/data/duke.txt").run();
    }

    /***
     * Loads from save file if exist else create new tasklist
     * @param fileName : file path of saved data
     */
    public Duke(String fileName) {
        ui = new Ui();
        storage = new StorageManager(fileName);
        try {
            ui.printLoadingMessage();
            tasks = new TaskList(storage.load());
            ui.printLoadedMessage(tasks.size());
        } catch (FileNotFoundException e) {
            ui.printLoadingError();
            tasks = new TaskList();
        }catch (IOException e) {
            ui.printEmptyFileError();
            tasks = new TaskList();
        }finally {
            ui.showLine();
        }
    }

    /***
     * Looped to read usercommand
     * parse and execute command
     * Exit when the ExitCommand is executed
     */
    public void run() {
        ui.showWelcome();
        ui.showLine();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = new Parser().executeCommand(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (InvalidCommandException e) {
                ui.printInvalidCommandMessage();
            }catch (DescriptionEmptyException e){
                ui.printEmptyDescriptionMessage();
            }catch (DueTimeEmptyException e){
                ui.printInvalidDescriptionMessage();
            } finally {
                ui.showLine();
            }
        }
    }

}
