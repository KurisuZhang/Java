public class TaskService {
    private TaskDAO taskDAO = new TaskDAO();

    public void addTask(String title, String text, String assignedTo) {
        Task task = new Task(title, text, assignedTo);
        taskDAO.addTask(task);
    }

    public void updateTask(int taskId, String title, String text, String assignedTo) {
        taskDAO.updateTask(taskId, title, text, assignedTo);
    }

    public void deleteTask(int taskId) {
        taskDAO.deleteTask(taskId);
    }

    public void searchTask(String query) {
        taskDAO.searchTask(query);
    }
}
