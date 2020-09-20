package duke.data;

import duke.data.storage.StorageManager;
import duke.data.task.Deadline;
import duke.data.task.Event;
import duke.data.task.Task;
import duke.data.task.Todo;
import duke.ui.Ui;

import java.util.ArrayList;
import java.util.Collections;

public class TaskList {
    /* Task Collection using ArrayList */
    public  ArrayList<Task> tasks ;

    /***
     * Create Tasklist with saved TaskList
     * @param tasks
     */
    public TaskList(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    /***
     * Create empty TaskList
     */
    public TaskList(){
        this.tasks = new ArrayList<>();
    }

    /***
     * Delete a task from TaskList
     * @param tasksIndex
     */
    public void deleteTask(int tasksIndex){
        tasks.remove(tasksIndex);
    }

    /***
     * Set task with TaskIndex in Tasklist as done
     * @param tasksIndex
     */
    public void setTaskDone(int tasksIndex){
        tasks.get(tasksIndex).markAsDone();
    }

    /***
     * Add a Task object into TaskList
     * @param task : To-do/Deadline/Event
     */
    public void addTaskToList(Task task){
        tasks.add(task);
    }

    /***
     * Size of the TaskList
     * @return
     */
    public int size(){
        return tasks.size();
    }

    /***
     * Get the Task object form the TaskList
     * @param index : TaskIndex of the TaskList
     * @return
     */
    public Task get(int index){
        return tasks.get(index);
    }

    /***
     * toString function to convert TaskList into Savable dataItems
     * @return full save file content
     */
    @Override
    public String toString(){
        String saveContent = "";
        for(Task task: tasks){
            String taskSaveFormat= "";
            int isDone = (task.isDone()) ? 1 : 0;
            if (task instanceof Todo) {
                taskSaveFormat = StorageManager.SYMBOL_TODO + StorageManager.PARAM_DELIMIT_SAVE + isDone + StorageManager.PARAM_DELIMIT_SAVE + task.getDescription();
            } else if (task instanceof Deadline) {
                taskSaveFormat = StorageManager.SYMBOL_DEADLINE + StorageManager.PARAM_DELIMIT_SAVE + isDone + StorageManager.PARAM_DELIMIT_SAVE + task.getDescription()
                        + StorageManager.PARAM_DELIMIT_SAVE +((Deadline) task).getBy();
            } else if (task instanceof Event) {
                taskSaveFormat = StorageManager.SYMBOL_EVENT + StorageManager.PARAM_DELIMIT_SAVE + isDone + StorageManager.PARAM_DELIMIT_SAVE + task.getDescription()
                        + StorageManager.PARAM_DELIMIT_SAVE +((Event) task).getAt();
            }
//            System.out.println("\t "+ taskSaveFormat);
            taskSaveFormat = taskSaveFormat + System.lineSeparator();
            saveContent += taskSaveFormat;
        }
        return saveContent;
    }

    /***
     * Return list with task that description have search phrase
     * @param search : Keyword to search for in description
     * @return
     */
    public ArrayList<Task> find(String search){
        ArrayList<Task> searchList = new ArrayList<>();

        for (int i = 0, j = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getDescription().contains(search)) {
                searchList.add(task);
            }
        }
        return searchList;
    }

}
