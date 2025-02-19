import java.util.Arrays;

class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(int value) {
        rear = (rear + 1) % size;
        buffer[rear] = value;
        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size; // Overwrite oldest element
        }
    }

    public int[] getBuffer() {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = buffer[(front + i) % size];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // [1, 2, 3]
        
        cb.enqueue(4); // Overwrites 1
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // [2, 3, 4]
    }
}
