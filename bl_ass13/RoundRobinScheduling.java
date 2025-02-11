import java.util.LinkedList;
import java.util.Queue;

class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head;
    private Process tail;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head; // Circular linking
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular structure
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;

        Process temp = head;
        Process prev = null;

        do {
            if (temp.processId == processId) {
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

    public void executeProcesses() {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        Queue<Integer> waitingTimes = new LinkedList<>();
        Queue<Integer> turnaroundTimes = new LinkedList<>();
        int totalTime = 0;
        Process current = head;

        while (true) {
            boolean allDone = true;
            Process temp = head;

            do {
                if (temp.burstTime > 0) {
                    allDone = false;

                    int executedTime = Math.min(temp.burstTime, timeQuantum);
                    temp.burstTime -= executedTime;
                    totalTime += executedTime;

                    if (temp.burstTime == 0) {
                        int turnaroundTime = totalTime;
                        int waitingTime = turnaroundTime - executedTime;
                        waitingTimes.add(waitingTime);
                        turnaroundTimes.add(turnaroundTime);

                        System.out.println("Process " + temp.processId + " completed execution.");
                        removeProcess(temp.processId);
                    }
                }
                temp = temp.next;
            } while (temp != head);

            if (allDone) break;
            displayProcesses();
        }

        calculateAverageTimes(waitingTimes, turnaroundTimes);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.println("Processes in queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    private void calculateAverageTimes(Queue<Integer> waitingTimes, Queue<Integer> turnaroundTimes) {
        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        int count = waitingTimes.size();

        while (!waitingTimes.isEmpty()) {
            totalWaitingTime += waitingTimes.poll();
            totalTurnaroundTime += turnaroundTimes.poll();
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / count));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / count));
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3);

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 2);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        System.out.println("\nExecuting Round Robin Scheduling:");
        scheduler.executeProcesses();
    }
}
