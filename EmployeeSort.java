import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EmployeeSort {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jett", 30, 50000));
        employees.add(new Employee("Lugia", 25, 60000));
        employees.add(new Employee("Waylay", 35, 70000));
        employees.add(new Employee("Harbour", 28, 55000));
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select sorting criteria:\n 1. Name 2. Age 3. Salary");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                employees.sort(Comparator.comparing(e -> e.name));
                System.out.println("Sorted by Name:");
                break;
            case 2:
                employees.sort(Comparator.comparingInt(e -> e.age));
                System.out.println("Sorted by Age:");
                break;
            case 3:
                employees.sort(Comparator.comparingDouble(e -> e.salary));
                System.out.println("Sorted by Salary:");
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        employees.forEach(System.out::println);
    }
}
