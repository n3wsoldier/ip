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
    * [Delete a Task: `delete`](#delete-a-task-delete)
    * [Find Task `find`](#find-task-find)
        * [Find by Keyword](#find-by-keyword)
        * [Find by Date](#find-by-date)
        * [Find between Dates](#find-between-dates)
    * [Exit the program `bye`](#exit-the-program-bye)
    * [Viewing Help `help`](#viewing-help-help)
* [Command Summary](#command-summary)
* [FAQ](#faq)

## Quick Start
1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest `Duke.jar` from [here.]()
3. Copy the file to the folder you want to use as the home folder for your Duke.
4. Use command prompt to run the `Duke.jar` and you are ready.

```
____________________________________________________________
 Hello from
 ____        _        
 |  _ \ _   _| | _____ 	   //
 | | | | | | | |/ / _ \	  ('>
 | |_| | |_| |   <  __/	  /rr
 |____/ \__,_|_|\_\___|	 *\))_

 What can I do for you?
____________________________________________________________
```

## Features
### Task Management
Manages the creation, deletion and completion of tasks.
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
____________________________________________________________
 Got it. I've added this task:
   [T][✘] Buy groceries
 Now you have 3 tasks in the list.
____________________________________________________________
```

### Add a Deadline task `deadline`
Adds a deadline task to the task list

Format: `deadline [Description] /by [Due Date]`
* Add a Deadline type task into task manager.
* Description is string format and cannot be empty.
* Due date can either be string or date time format following [dd/mm/yyyy hhmm].

Note: Additional search features will apply to due date with proper date format.

Example Input: 
1. `deadline CS2113T IP /by Friday`
2. `deadline CS2113T Userguide /by 2/10/2020 2359`

The expected outcome:
```
____________________________________________________________
 Got it. I've added this task:
   [D][✘] CS2113T IP (by: Friday)
 Now you have 4 tasks in the list.
____________________________________________________________
____________________________________________________________
 Got it. I've added this task:
   [D][✘] CS2113T Userguide (by: 02 Oct 2020 11:59PM)
 Now you have 5 tasks in the list.
____________________________________________________________
```

### Add an Event task `event`
Adds an event task to the task list

Format: `event [Description] /at [Event Date]`
* Add a Event type task into task manager.
* Description is string format and cannot be empty.
* Event date can either be string or date time format following [dd/mm/yyyy hhmm].

Note: Additional search features will apply to event date with proper date format.

Example Input: 
1. `event Sister Birthday /at Next Saturday`
2. `event CS2101 OP2 presentaion /at 25/10/2020 1200`

The expected outcome:
```
____________________________________________________________
 Got it. I've added this task:
   [E][✘] Sister Birthday (at: Next Saturday)
 Now you have 6 tasks in the list.
____________________________________________________________
____________________________________________________________
 Got it. I've added this task:
   [E][✘] CS2101 OP2 presentaion (at: 25 Oct 2020 12:00PM)
 Now you have 7 tasks in the list.
____________________________________________________________
```

### List all Tasks `list`
Shows a list of all tasks in the task manager

Format: `list`

Example Input: `list`

Expected Outcome:
```
____________________________________________________________
 Here are the tasks in your list: 2/7 completed
  1.[T][✓] Read book
  2.[D][✓] Return book (by: Sunday)
  3.[T][✘] Buy groceries
  4.[D][✘] CS2113T IP (by: Friday)
  5.[D][✘] CS2113T Userguide (by: 02 Oct 2020 11:59PM)
  6.[E][✘] Sister Birthday (at: Next Saturday)
  7.[E][✘] CS2101 OP2 presentaion (at: 25 Oct 2020 12:00PM)
____________________________________________________________
```

### Complete a Task `done`
Marks a task in task manager as completed

Format: `done [Task Index]`
* Set the Task in task manager with the index as done.
* Task Index is an integer and cannot be empty.
* Task Index should between 1 and the Number of tasks.
* Task Index should not be a task that have been completed.

Example Input: `done 3`

The expected outcome:
```
____________________________________________________________
 Nice! I've marked this task as done:
   [T][✓] Buy groceries
 You have completed: 3/7. 4 left :)
____________________________________________________________
```

### Delete a Task `delete`
Deletes a task from the task list

Format: `delete [Task Index]`
* Delete the task at Task Index
* Task Index is an integer and cannot be empty.
* Task Index should between 1 and the Number of tasks.

Example Input: `delete 3`

The expected outcome:
```
____________________________________________________________
 Noted. I've removed this task:
   [T][✓] Buy groceries
 Now you have 2/6 completed tasks in the list.
____________________________________________________________
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
____________________________________________________________
 Here are the tasks with "CS2113T": 2 found
  1.[D][✘] CS2113T Userguide (by: 02 Oct 2020 11:59PM)
  2.[D][✘] CS2113T IP (by: Friday)
____________________________________________________________
```

#### Find by Date
Searches and prints all tasks that has the specified date and time

Format: `find [DateTime]`
* Find all task with Date and Time.
* DateTime follows [dd/mm/yyyy hhmm] formatting and cannot be empty.

Example Input: `find  25/10/2020 1200`

The expected outcome:
```
____________________________________________________________
 Here are the tasks with "25 Oct 2020 12:00PM": 1 found
  1.[E][✘] CS2101 OP2 presentaion (at: 25 Oct 2020 12:00PM)
____________________________________________________________
```

#### Find between Dates
Searches and prints all tasks that falls between the start and end date with time

Format: `find [Start DateTime] /to [End DateTime]`
* Find all task between start date time and end date time.
* Both DateTime follows [dd/mm/yyyy hhmm] formatting and cannot be empty.

Tip: To find all task on a specific date `2/10/2020`, search for tasks between `2/10/2020 0000` to `2/10/2020 2359`

Example Input: `find 02/10/2020 2359 /to 25/10/2020 2359`

The expected outcome:
```
____________________________________________________________
 Here are the tasks with "02 Oct 2020 11:59PM" to "25 Oct 2020 11:59PM": 2 found
  1.[D][✘] CS2113T Userguide (by: 02 Oct 2020 11:59PM)
  2.[E][✘] CS2101 OP2 presentaion (at: 25 Oct 2020 12:00PM)
____________________________________________________________
```

### Exit the program `bye`
Terminates the program gracefully

Format: `bye`

Example Input: `bye`

The expected outcome:
```
____________________________________________________________
 Bye. Hope to see you again soon!
____________________________________________________________
```

### Viewing Help: `help`
This command will provide the details of all available commands and their usage. 
This is done by displaying the ‘Command Summary’ as listed below to the user.

Format: `help`

## Command Summary

|Action | Format with Example|
|---    |---|
| Add a ToDo task               | `todo [Description]` <br> Example: <br> `todo Read Book` |
| Add a Deadline task           | `deadline [Description] /by [Due Date]` <br> Example: <br> `deadline CS2113T IP /by Friday`<br> `deadline CS2113T Userguide /by 2/10/2020 2359` |
| Add an Event task             | `event [Description] /at [Event Date]` <br> Example: <br>`event Sister Birthday /at Next Saturday` <br> `event CS2101 OP2 presentaion /at 25/10/2020 1200` |
| List all tasks                | `list` |
| Complete a task               | `done [Task Index]` |
| Delete a task                 | `delete [Task Index]` |
| Find by Keyword               | `find [Search Phrase]` <br> Example: <br> `find CS2113T` |
| Find by Date                  | `find [DateTime]` <br> Example: <br> `find  25/10/2020 1200` |
| Find between Dates            | `find [Start DateTime] /to [End DateTime]` <br> Example: <br> `find 02/10/2020 2359 /to 25/10/2020 2359`  |
| Exit                          | `bye` | 
| Help                          | `help` | 

## FAQ
Q: Where does Duke store my save file?
A: It will create a data/duke.txt in the directory that duke is running.

Q: How to export and import saved file?
A: Find the saved file data/duke.txt and copy it out. To import, simply place the duke.txt back in the data folder.
