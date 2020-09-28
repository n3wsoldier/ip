# User Guide
Duke is an offline desktop app for managing tasks via a Command Line Interface (CLI).

## Table of Contents
* [Quick Start](#quick-start)
* [Features](#features)
    * [Task Management](#task-management)
    * [Search Task](#search-task)
    * [Persistent Storage](#persistent-storage)
* [Usage](#usage)
    * [Add a ToDo task `todo`](#add-a-todo-task-todo)
    * [Add a Deadline task: `deadline`](#add-a-deadline-task-deadline)
    * [Add an Event task: `event`](#add-an-event-task-event)
    * [List all Tasks `list`](#list-all-tasks-list)
    * [Complete a Task `done`](#complete-a-task-done)
    * [Delete a task: `delete`](#delete-a-task-delete)
    * [Find Task `find`](#find-task-find)
        * [Find by Keyword](#find-by-keyword)
        * [Find by Date](#find-by-date)
        * [Find between Dates](#find-between-dates)
    * [Exit the program `bye`](#exit-the-program-bye)


## Quick Start
1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest `Duke.jar` from [here.]()
3. Copy the file to the folder you want to use as the home folder for your Duke.
4. Use command prompt to run the `Duke.jar` and you are ready.

```
__________________________________________________________________________________________
 Hello from
 ____        _        
 |  _ \ _   _| | _____ 	   //
 | | | | | | | |/ / _ \	  ('>
 | |_| | |_| |   <  __/	  /rr
 |____/ \__,_|_|\_\___|	 *\))_

 What can I do for you?
__________________________________________________________________________________________
```
## Features
### Task Management
Duke can manage three type of tasks:
* Todo: tasks with only description
* Deadline: tasks with description that need to be done before a specific date time
* Event: tasks with description that start at a specific date time

Duke supports the creation, deletion and completion of a task.
### Search Task
Built-in search features that aids in finding tasks with given description or due dates.
### Persistent Storage
Automatically saves changes made to task list and preload task list of previous session.

## Usage
### Add a ToDo task `todo`
Adds a todo task to the task list

Format: `todo [Description]`
* Add a Todo type task into task manager.
* Description is string format and cannot be empty.

Example Input: `todo Buy groceries`

The expected outcome:
```
__________________________________________________________________________________________
 Got it. I've added this task:
   [T][✘] Buy groceries
 Now you have 3 tasks in the list.
__________________________________________________________________________________________
```


### Add a Deadline task `deadline`
Adds a deadline task to the task list

Format: `deadline [Description] /by [Due Date]`
* Add a Deadline type task into task manager.
* Description is string format and cannot be empty.
* Due date can either be string or date format following [dd/mm/yyyy hhmm].

Note: Additional search features will apply to due date with proper date format.

Example Input: 
1. `deadline CS2113T IP /by Friday`
2. `deadline CS2113T Userguide /by 2/10/2020 2359`

The expected outcome:
```
__________________________________________________________________________________________
 Got it. I've added this task:
   [D][✘] CS2113T IP (by: Friday)
 Now you have 4 tasks in the list.
__________________________________________________________________________________________
__________________________________________________________________________________________
 Got it. I've added this task:
   [D][✘] CS2113T Userguide (by: 02 Oct 2020 11:59PM)
 Now you have 5 tasks in the list.
__________________________________________________________________________________________
```

### Add an Event task `event`
Adds an event task to the task list

Format: `event [Description] /at [Event Date]`
* Add a Event type task into task manager.
* Description is string format and cannot be empty.
* Event date can either be string or date format following [dd/mm/yyyy hhmm].

Note: Additional search features will apply to event date with proper date format.

Example Input: 
1. `event Sister Birthday /at Next Saturday`
2. `event CS2101 OP2 presentaion /at 25/10/2020 1200`

The expected outcome:
```
__________________________________________________________________________________________
 Got it. I've added this task:
   [E][✘] Sister Birthday (at: Next Saturday)
 Now you have 6 tasks in the list.
__________________________________________________________________________________________
__________________________________________________________________________________________
 Got it. I've added this task:
   [E][✘] CS2101 OP2 presentaion (at: 25 Oct 2020 12:00PM)
 Now you have 7 tasks in the list.
__________________________________________________________________________________________
```

### List all Tasks `list`
Shows a list of all tasks in the task manager

Format: `list`

Example Input: `list`

Expected Outcome:
```
__________________________________________________________________________________________
 Here are the tasks in your list: 2/7 completed
  1.[T][✓] Read book
  2.[D][✓] Return book (by: Sunday)
  3.[T][✘] Buy groceries
  4.[D][✘] CS2113T IP (by: Friday)
  5.[D][✘] CS2113T Userguide (by: 02 Oct 2020 11:59PM)
  6.[E][✘] Sister Birthday (at: Next Saturday)
  7.[E][✘] CS2101 OP2 presentaion (at: 25 Oct 2020 12:00PM)
__________________________________________________________________________________________
```

### Complete a Task `done`
Marks a task in task manager as completed

Format: `done [Task Index]`
* Set the Task in task manager with the index as done.
* Task Index is an integer and cannot be empty.
* Task Index should within 1 to Number of tasks.
* Task Index should not be a task that have been completed.

Example Input: `done 3`

The expected outcome:
```
__________________________________________________________________________________________
 Nice! I've marked this task as done:
   [T][✓] Buy groceries
 You have completed: 3/7. 4 left :)
__________________________________________________________________________________________
```

### Delete a Task `delete`
Deletes a task from the task list

Format: `delete [Task Index]`
* Delete the task at Task Index
* Task Index is an integer and cannot be empty.
* Task Index should within 1 to Number of tasks.

Example Input: `delete 3`

The expected outcome:
```
__________________________________________________________________________________________
 Noted. I've removed this task:
   [T][✓] Buy groceries
 Now you have 2/6 completed tasks in the list.
__________________________________________________________________________________________
```

### Find Task `find`
#### Find by Keyword
Searches and prints all tasks that has the search string in the task description

Format: `find [Search Phrase]`
* Find all task with description containing search phrase.
* Search Phrase is string and cannot be empty.

Example Input: `find CS2113T`

The expected outcome:
```
__________________________________________________________________________________________
 Here are the tasks with "CS2113T": 2 found
  1.[D][✘] CS2113T Userguide (by: 02 Oct 2020 11:59PM)
  2.[D][✘] CS2113T IP (by: Friday)
__________________________________________________________________________________________
```

#### Find by Date
Searches and prints all tasks that has the specified date

Format: `find [Date]`
* Find all task with Date.
* Date follows [dd/mm/yyyy hhmm] formatting and cannot be empty.

Example Input: `find  25/10/2020 1200`

The expected outcome:
```
__________________________________________________________________________________________
 Here are the tasks with "25 Oct 2020 12:00PM": 1 found
  1.[E][✘] CS2101 OP2 presentaion (at: 25 Oct 2020 12:00PM)
__________________________________________________________________________________________
```

#### Find between Dates
Searches and prints all tasks that falls between the start date and end date

Format: `find [Start Date] /to [End date]`
* Find all task between start date and end date.
* Both dates follows [dd/mm/yyyy hhmm] formatting and cannot be empty.

Example Input: `find 02/10/2020 2359 /to 25/10/2020 2359`

The expected outcome:
```
__________________________________________________________________________________________
 Here are the tasks with "02 Oct 2020 11:59PM" to "25 Oct 2020 11:59PM": 2 found
  1.[D][✘] CS2113T Userguide (by: 02 Oct 2020 11:59PM)
  2.[E][✘] CS2101 OP2 presentaion (at: 25 Oct 2020 12:00PM)
__________________________________________________________________________________________
```

### Exit the program `bye`
Terminates the program gracefully

Format: `bye`

Example Input: `bye`

The expected outcome:
```
__________________________________________________________________________________________
 Bye. Hope to see you again soon!
__________________________________________________________________________________________
```
