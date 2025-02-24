import java.lang.reflect.Method;

class SampleTask {
    public void quickTask() {
        for (int i = 0; i < 1000; i++);
    }

    public void longTask() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class MethodExecutionTimer {
    public static void main(String[] args) throws Exception {
        SampleTask task = new SampleTask();
        measureExecutionTime(task, "quickTask");
        measureExecutionTime(task, "longTask");
    }

    public static void measureExecutionTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();
        System.out.println(methodName + " executed in " + (endTime - startTime) + " nanoseconds");
    }
}
