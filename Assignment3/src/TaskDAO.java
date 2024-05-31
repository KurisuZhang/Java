public class TaskDAO {
    private Task[] tasks = new Task[10];
    private int taskCount = 0;

    public void addTask(Task task) {
        if (taskCount >= tasks.length) {
            System.out.println("Task list is full! Cannot add more tasks.");
            return;
        }
        tasks[taskCount++] = task;
        System.out.println("Task added successfully.");
    }

    public void updateTask(int taskId, String title, String text, String assignedTo) {
        Task taskToUpdate = getTaskById(taskId);

        if (taskToUpdate == null) {
            System.out.println("Task with the given ID not found.");
            return;
        }

        taskToUpdate.setTaskTitle(title);
        taskToUpdate.setTaskText(text);
        taskToUpdate.setAssignedTo(assignedTo);

        System.out.println("Task updated successfully.");
    }

    public void deleteTask(int taskId) {
        int taskIndex = -1;
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskId() == taskId) {
                taskIndex = i;
                break;
            }
        }

        if (taskIndex == -1) {
            System.out.println("Task with the given ID not found.");
            return;
        }

        for (int i = taskIndex; i < taskCount - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        tasks[--taskCount] = null;
        System.out.println("Task deleted successfully.");
    }

    public void searchTask(String query) {
        boolean found = false;

        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskTitle().contains(query) || tasks[i].getTaskText().contains(query) || tasks[i].getAssignedTo().contains(query)) {
                System.out.println(tasks[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tasks found matching the search query.");
        }
    }

    private Task getTaskById(int taskId) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskId() == taskId) {
                return tasks[i];
            }
        }
        return null;
    }
}
