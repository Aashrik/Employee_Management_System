
import Modules.Employee;

import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();

                    Employee newEmployee = new Employee();
                    newEmployee.setName(name);
                    newEmployee.setPosition(position);
                    newEmployee.setSalary(salary);

                    employeeDAO.addEmployee(newEmployee);
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    List<Employee> allEmployees = employeeDAO.getAllEmployees();
                    System.out.println("Employee List:");
                    for (Employee emp : allEmployees) {
                        System.out.println(emp.getId() + " | " + emp.getName() + " | " + emp.getPosition() + " | " + emp.getSalary());
                    }
                    break;

                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

}
