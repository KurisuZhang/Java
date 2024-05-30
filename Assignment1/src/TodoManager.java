import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TodoManager {

    String name;
    ArrayList<String> tasks;
    HashMap<String, Integer> taskCount;
    public TodoManager(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
        this.taskCount = new HashMap<>();
    }

    // Print user's name
    public void printName() {
        System.out.println("User's Name: " + name);
    }

    // add task
    public void addTask(String task) {

        tasks.add(task);

        if (taskCount.containsKey(task)) {
            taskCount.put(task, taskCount.get(task) + 1);
        } else {
            taskCount.put(task, 1);
        }
    }

    // List tasks for the day
    public void listTasks() {
        System.out.println("Tasks for the day:");
        for (String task : tasks) {
            System.out.println(task);
        }
    }

    // Display tasks in order
    public void displayTasksInOrder(boolean ascending) {
        if (ascending) {
            Collections.sort(tasks);
            System.out.println("Tasks in increasing order:");
        } else {
            Collections.sort(tasks, Collections.reverseOrder());
            System.out.println("Tasks in decreasing order:");
        }

        for (String task : tasks) {
            System.out.println(task);
        }
    }

    public void displayRepeatedTasks() {
        
        System.out.println("Repeated tasks:");
        for (String task : taskCount.keySet()) {
            if (taskCount.get(task) > 1) {
                System.out.println(task + " (Repeated " + taskCount.get(task) + " times)");
            }
        }
    }

    public static void main(String[] args) {
        // User's name
        String userName = "Alex";

        TodoManager todoManager = new TodoManager(userName);

        // print name
        todoManager.printName();

        // add task
        todoManager.addTask("Task 1");
        todoManager.addTask("Task 2");
        todoManager.addTask("Task 3");
        todoManager.addTask("Task 4");
        todoManager.addTask("Task 5");
        todoManager.addTask("Task 1");  // Repeated task

        // Listing tasks for the day
        todoManager.listTasks();

        // Display tasks in increasing order
        todoManager.displayTasksInOrder(true);

        // Display tasks in decreasing order
        todoManager.displayTasksInOrder(false);

        // Display repeated tasks
        todoManager.displayRepeatedTasks();
    }
}
