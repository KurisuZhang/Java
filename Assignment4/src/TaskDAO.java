import java.util.Arrays;

public class TaskDAO {
    private Task[] tasks = new Task[10];
    private int taskCount = 0;

    public boolean addTask(Task task) {
        if (taskCount >= tasks.length) {
            return false;
        }
        tasks[taskCount++] = task;
        return true;
    }

    public boolean updateTask(int taskId, String title, String text, String assignedTo) {
        Task taskToUpdate = getTaskById(taskId);

        if (taskToUpdate == null) {
            return false;
        }

        taskToUpdate.setTaskTitle(title);
        taskToUpdate.setTaskText(text);
        taskToUpdate.setAssignedTo(assignedTo);

        return true;
    }

    public boolean deleteTask(int taskId) {
        int taskIndex = -1;
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskId() == taskId) {
                taskIndex = i;
                break;
            }
        }

        if (taskIndex == -1) {
            return false;
        }

        for (int i = taskIndex; i < taskCount - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        tasks[--taskCount] = null;
        return true;
    }

    public Task[] searchTask(String query) {
        Task[] result = new Task[taskCount];
        int resultCount = 0;

        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskTitle().contains(query) || tasks[i].getTaskText().contains(query) || tasks[i].getAssignedTo().contains(query)) {
                result[resultCount++] = tasks[i];
            }
        }

        return resultCount > 0 ? Arrays.copyOf(result, resultCount) : new Task[0];
    }

    public Task[] getTasksAssignedTo(String username) {
        Task[] result = new Task[taskCount];
        int resultCount = 0;

        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getAssignedTo().equals(username)) {
                result[resultCount++] = tasks[i];
            }
        }

        return resultCount > 0 ? Arrays.copyOf(result, resultCount) : new Task[0];
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
