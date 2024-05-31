public class Task {
    private static int idCounter = 1;

    private int taskId;
    private String taskTitle;
    private String taskText;

    public Task(String taskTitle, String taskText) {
        this.taskId = idCounter++;
        this.taskTitle = taskTitle;
        this.taskText = taskText;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Title: " + taskTitle + ", Text: " + taskText;
    }
}