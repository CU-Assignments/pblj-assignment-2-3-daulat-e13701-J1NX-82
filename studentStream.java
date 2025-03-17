import java.util.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class studentStream {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Rahul", 85),
            new Student("Jett", 72),
            new Student("Lugia", 90),
            new Student("Waylay", 65),
            new Student("Brimstone", 78)
        );

        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
