class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null;

    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int index = 0;
        while (temp.next != head && index < position - 1) {
            temp = temp.next;
            index++;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
        }
    }

    public void removeTaskById(int taskId) {
        if (head == null) return;

        Task temp = head, prev = null;

        do {
            if (temp.taskId == taskId) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTask() {
        if (currentTask == null) currentTask = head;
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName + " | Priority: " + currentTask.priority + " | Due: " + currentTask.dueDate);
            currentTask = currentTask.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + " | Name: " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + " | Name: " + temp.taskName + " | Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks found with priority: " + priority);
    }
}

public class TaskManager {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTaskAtEnd(1, "Complete Project", 2, "2025-02-20");
        scheduler.addTaskAtEnd(2, "Submit Report", 1, "2025-02-15");
        scheduler.addTaskAtBeginning(3, "Schedule Meeting", 3, "2025-02-10");
        scheduler.addTaskAtPosition(4, "Review Code", 2, "2025-02-18", 2);

        System.out.println("All Tasks:");
        scheduler.displayTasks();

        System.out.println("\nView Current Task:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearch by Priority 2:");
        scheduler.searchByPriority(2);

        System.out.println("\nRemoving Task with ID 2");
        scheduler.removeTaskById(2);

        System.out.println("\nTasks after removal:");
        scheduler.displayTasks();
    }
}
