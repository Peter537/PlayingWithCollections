import java.util.*;

public class PlayingWithCollections {

    public static void main(String[] args) {
        playWithLists();
        playWithSet();
        playWithMaps();
    }

    public static void playWithLists(){
        // Lav en LinkedList med Student-objekter. Fyld den op med objekter ved at kalde fillMyCollection
        LinkedList<Student> list = new LinkedList<>();
        fillMyCollection(list);

        // Print listen ud og læg mærke til rækkefølgen af objekterne
        clearConsole();
        for (Student student : list) {
            System.out.println(student);
        }

        // Tilføj et nyt Student-objekt objekt med metoden add().
        // Hvor i listen tror du, det bliver tilføjet? Test din teori ved at printe listen igen
        clearConsole();
        Student myStudent = new Student("Peter", 6);
        list.add(myStudent); // Tilføjer et nyt objekt til slutningen af listen
        for (Student student : list) {
            System.out.println(student);
        }

        // Hvad sker der hvis vi tilføjer et nyt Student-objekt på index 3?
        // Prøv det af. Tænk over hvad du tror, der vil ske og print så ud for at se om du har ret
        clearConsole();
        list.add(3, new Student("Allan", 7)); // Tilføjer et nyt objekt på index 3
        for (Student student : list) {
            System.out.println(student);
        }

        // Hvad sker der hvis vi tilføjer to ens Student-objekter?
        clearConsole();
        list.add(myStudent); // Tilføjer et nyt objekt til slutningen af listen, man kan godt tilføje to ens objekter
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public static void playWithSet(){
        // Lav et HashSet med Student-objekter. Fyld det op ved at kalde fillMyCollection
        HashSet<Student> set = new HashSet<>();
        fillMyCollection(set);

        // Print listen ud og læg mærke til rækkefølgen af objekterne
        clearConsole();
        for (Student student : set) {
            System.out.println(student);
        }

        // Tilføj et nyt Student-objekt objekt med metoden add().
        // Hvor i settet tror du, det bliver tilføjet? Test din teori ved at printe settet igen
        clearConsole();
        Student myStudent = new Student("Peter", 6); // Det bliver tilføjet et 'random' sted i settet fordi det er baseret på HashCoden
        set.add(myStudent);
        for (Student student : set) {
            System.out.println(student);
            System.out.println(student.hashCode());
        }

        // Hvad sker der hvis vi tilføjer to ens Student-objekter?
        clearConsole();
        set.add(myStudent);
        for (Student student : set) {
            System.out.println(student);
            System.out.println(student.hashCode());
        }
    }

    public static void playWithMaps(){
        // Lav et HashMap() med Student-objekter og Courses, hvor Student er key og Course er value
        // Fyld det op ved at kalde fillMyMap()
        HashMap<Student, Course> map = new HashMap<>();
        fillMyMap(map);

        // Print mappet ud og læg mærke til rækkefølgen af objekterne
        clearConsole();
        for (Map.Entry<Student, Course> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Tilføj et nyt Student-objekt/Course-objekt par med metoden put().
        // Hvor i mappet tror du, det bliver tilføjet? Test din teori ved at printe settet igen
        clearConsole();
        Student myStudent = new Student("Peter", 6);
        Course myCourse = new Course("DAT1");
        map.put(myStudent, myCourse);
        for (Map.Entry<Student, Course> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Hvad sker der hvis vi tilføjer to Student/Course par hvor Student-objekterne er ens?
        clearConsole();
        map.put(myStudent, new Course("DAT2")); // Den overskriver den gamle Course med den nye Course
        for (Map.Entry<Student, Course> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Og hvad sker der hvis vi tilføjer to Student/Course par hvor Course-objekterne er ens?
        clearConsole();
        map.put(new Student("Allan", 7), myCourse); // Det er kun key'en baseret på equals()-metoden der skal være unik, så den tilføjer et nyt Student/Course par
        map.put(new Student("Kalle", 8), myCourse);
        for (Map.Entry<Student, Course> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void fillMyCollection(Collection<Student> c){
        String[] names = {"Sally", "Marley", "Jean-Luc", "Sigfried", "Kurt"};
        for (int i = 0; i < names.length; i++) {
            c.add(new Student(names[i], i+1));
        }
    }

    public static void fillMyMap(Map<Student, Course> c){
        String[] names = {"Sally", "Marley", "Jean-Luc", "Sigfried", "Kurt"};

        for (int i = 0; i < names.length; i++) {
            if(i % 2 == 0) {
                c.put(new Student(names[i], i + 1), new Course("DAT1"));
            } else {
                c.put(new Student(names[i], i + 1), new Course("DAT2"));
            }
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}