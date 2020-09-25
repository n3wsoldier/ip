package duke.data;

import duke.command.Command;
import duke.data.storage.StorageManager;
import duke.data.task.Deadline;
import duke.data.task.Event;
import duke.data.task.Task;
import duke.data.task.Todo;
import duke.ui.Ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class TaskList {
    /* Task Collection using ArrayList */
    public  ArrayList<Task> tasks ;
    private int completedTask;

    /***
     * Create Tasklist with saved TaskList
     * @param tasks
     */
    public TaskList(ArrayList<Task> tasks){
        this.tasks = tasks;
        this.completedTask = countCompletedTask();
    }

    /***
     * Create empty TaskList
     */
    public TaskList(){
        this.tasks = new ArrayList<>();
        completedTask = 0;
    }

    /***
     * Count the number of completed task
     * @return completeTask
     */
    public int countCompletedTask(){
        int completeTask = 0;
        for(Task task: tasks){
            if(task.isDone()){
                completeTask += 1;
            }
        }
        return completeTask;
    }

    /***
     * Get completed task
     * @return completedTask
     */
    public int getCompletedTask(){
        return completedTask;
    }

    /***
     * Delete a task from TaskList
     * @param tasksIndex
     */
    public void deleteTask(int tasksIndex){
        completedTask--;
        tasks.remove(tasksIndex);
    }

    /***
     * Set task with TaskIndex in Tasklist as done
     * @param tasksIndex
     */
    public boolean setTaskDone(int tasksIndex){
        if(tasks.get(tasksIndex).isDone()){
            return false;
        }else{
            tasks.get(tasksIndex).markAsDone();
            completedTask++;
            return true;
        }
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

    /***
     * Return list with task that due date have the search date
     * @param searchDate : Keyword to search for in description
     * @return
     */
    public ArrayList<Task> find(Date searchDate){
        ArrayList<Task> searchList = new ArrayList<>();

        for (int i = 0, j = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.isDateTime() && task.getDate().equals(searchDate)) {
                searchList.add(task);
            }
        }
        return searchList;
    }

    /***
     * Return list with task that due date is after the start date and before the end date
     * or either of the date
     * @param startDate : Keyword to search for in description
     * @param endDate : Keyword to search for in description
     * @return
     */
    public ArrayList<Task> find(Date startDate, Date endDate){
        ArrayList<Task> searchList = new ArrayList<>();

        for (int i = 0, j = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.isDateTime() && task.getDate().after(startDate) && task.getDate().before(endDate) ) {
                searchList.add(task);
            }else if(task.isDateTime()){
                if(task.getDate().equals(startDate) || task.getDate().equals(endDate)){
                    searchList.add(task);
                }
            }
        }
        return searchList;
    }
}
