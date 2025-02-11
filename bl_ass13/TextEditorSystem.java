class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextState head, tail, current;
    private int maxHistory;
    private int size;

    public TextEditor(int maxHistory) {
        this.head = this.tail = this.current = null;
        this.maxHistory = maxHistory;
        this.size = 0;
    }

    public void addState(String content) {
        TextState newState = new TextState(content);

        if (current != null && current.next != null) {
            current.next = null; // Clear redo history
        }

        if (head == null) {
            head = tail = current = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
        }

        if (size < maxHistory) {
            size++;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo available.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No content available.");
        }
    }
}

public class TextEditorSystem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        editor.addState("Hello");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! How");
        editor.addState("Hello, World! How are");
        editor.addState("Hello, World! How are you?");

        editor.displayCurrentState(); // "Hello, World! How are you?"

        editor.undo();
        editor.undo();
        editor.displayCurrentState(); // "Hello, World! How"

        editor.redo();
        editor.displayCurrentState(); // "Hello, World! How are"

        editor.redo();
        editor.redo(); // No more redo available
    }
}
