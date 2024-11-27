package hexlet.code;

public class DifferValue {
    private String state;
    private Object oldValue;
    private Object newValue;

    public String getState() {
        return state;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public DifferValue(String state, Object oldValue, Object newValue) {
        this.state = state;
        this.oldValue = oldValue;
        this.newValue = newValue;

    }
}
