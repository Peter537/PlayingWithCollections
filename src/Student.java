public class Student {

    private final int id;
    private final String name;

    public Student(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Student: " + getName() + " (ID: " + getID() + ")";
    }
}